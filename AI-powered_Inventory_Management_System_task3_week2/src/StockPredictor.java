import java.util.ArrayList;
import java.util.Scanner;

public class StockPredictor {
    private ArrayList<Integer> avgDailySales;
    private Scanner scanner = new Scanner(System.in);

    //constructor
    public StockPredictor() {
        avgDailySales = new ArrayList<>();
    }

    //getter & setter
    public ArrayList<Integer> getAvgDailySales() {
        return avgDailySales;
    }

    public void setAvgDailySales(ArrayList<Integer> avgDailySales) {
        this.avgDailySales = avgDailySales;
    }

    //methods
    //

    public void displayPredictsAndSuggestionForProducts(){
        ProductManger manger = new ProductManger();
        ArrayList<Product> products=manger.getProducts();
        if(products.isEmpty()){
            System.out.println("No products found.");
        }
        else {
            for(Product product:products){
                System.out.println("Enter average daily sales for"+product.getName()+": ");
                int input =  scanner.nextInt();
                scanner.nextLine();
                avgDailySales.add(input);

            }
            for (Product product : products) {
                product.displayProduct();
            }
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                int dailySales = avgDailySales.get(i);
                int reminingDays =predictDays(product.getStockLevel(), product.getReorderThreshold(),dailySales);
                System.out.println("Stock Prediction for"+product.getName()+":");
                System.out.println("Days until stock out: " + reminingDays );
                System.out.println("Restock Suggestion:"+getRestockSuggestion(reminingDays) );
            }
        }

    }

    private int predictDays(int stocklevel, int reorderThreshold,int sales){
        int daysRemaining = (stocklevel - reorderThreshold) / sales;
        return daysRemaining;
    }
    // Method to generate restock suggestion based on days remaining
    private String getRestockSuggestion(int daysRemaining) {
        if (daysRemaining <= 3) {
            return "High: Urgent restocking needed!";
        } else if (daysRemaining <= 7) {
            return "Moderate: Consider restocking soon.";
        } else {
            return "Low: No immediate restocking needed.";
        }
    }

}
