import java.util.*;
import java.util.concurrent.*;
//comment from main
public class OrderManager {

    public Map<UUID, Order> orders;
    private ExecutorService executorService;

    public OrderManager() {
        orders = new HashMap<>();
        executorService = Executors.newFixedThreadPool(3); // Using a thread pool to simulate real-time processing
    }

    // Method to create and add a new order
    public void createOrder(String customerName, UUID productId, int quantity) {
        Order newOrder = new Order(customerName, productId, quantity);
        orders.put(newOrder.getOrderId(), newOrder);
        System.out.println("New order created: " + newOrder);
    }

    // Method to update the status of an order (this will be done using multithreading)
    public void updateOrderStatus(UUID orderId, Order.OrderStatus newStatus) {
        executorService.submit(() -> {
            Order order = orders.get(orderId);
            if (order != null) {
                order.setOrderStatus(newStatus);
                logOrderUpdate(order);
            } else {
                System.out.println("Order not found: " + orderId);
            }
        });
    }

    // Method to log order status updates
    private void logOrderUpdate(Order order) {
        // Simple logging, could be expanded to use a proper logging framework like Log4j
        System.out.println("Order update - " + order);
    }

    // Method to view all orders (for testing purposes)
    public void viewOrders() {
        for (Order order : orders.values()) {
            System.out.println(order);
        }
    }

    // Method to shutdown the executor service
    public void shutdown() {
        executorService.shutdown();
    }
}
