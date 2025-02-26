import java.util.UUID;
public class Product {

    private UUID productId ;
    private String name;
    private double price;
    private int stockLevel;
    private int reorderThreshold;

    //constructer
    public Product(String name, double price,  int stockLevel, int reorderThreshold) {
        this.productId = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.stockLevel = stockLevel;
        this.reorderThreshold = reorderThreshold;
    }

    //getter & setter

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getReorderThreshold() {
        return reorderThreshold;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public void setReorderThreshold(int reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
    //methods
    //display product details
    public void displayProduct() {
        System.out.println("\nProduct ID" + productId +
                "\nname: " + name + "\nprice: " + price +
                "\nstock Level" +stockLevel+"\nreorder threshold: "
                + reorderThreshold+"\n----------------------------");
    }
}
