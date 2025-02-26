import java.util.ArrayList;
import java.util.Scanner;
public class ProductManger {
    private ArrayList<Product> products = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    StockPredictor stockpr=new StockPredictor();
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void start() {
        while (true) {
            System.out.println("--Welcome product manager--" +
                    "\n1.Add product\n2.Remove Product" +
                    "\n3.Search Product\n4.Display product\n5.prediction\n6.Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1 -> addProduct();
                case 2 -> removeProduct();
                case 3 -> searchProduct();
                case 4 -> viewProducts();
                case 5 -> stockpr.displayPredictsAndSuggestionForProducts();
                case 6 -> {
                    System.out.println("Goodbye! Exiting Product Manager..");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
    private void addProduct() {
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter product stockLevel: ");
        int stockLevel = scanner.nextInt();
        System.out.println("Enter product reorderThreshold: ");
        int reorderThreshold = scanner.nextInt();

        products.add(new Product(name, price,stockLevel,reorderThreshold));
        System.out.println("Product added successfully.");
    }

    private void removeProduct() {
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        boolean removed=products.removeIf(product -> product.getName().equalsIgnoreCase(name));

        if (removed) {
            System.out.println("Product removed successfully.");
        }
        else {
            System.out.println("Product not found.");
        }
    }
    private void searchProduct() {
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                product.displayProduct();
                return;
            }

        }
        System.out.println("Product not found.");
    }

    private void viewProducts() {
        if(products.isEmpty()){
            System.out.println("No products found.");
        }
        else {
            for (Product product : products) {
                product.displayProduct();
            }
        }

    }
}
