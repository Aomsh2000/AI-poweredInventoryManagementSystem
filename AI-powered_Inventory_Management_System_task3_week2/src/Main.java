//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.UUID;
public class Main {
    public static void main(String[] args) {
        //Inventory Management System
        ProductManger manger = new ProductManger();
        manger.start();

        // Cloud-Ready Order Processing System
        OrderManager orderManager = new OrderManager();
        // Creating new orders
        orderManager.createOrder("John Doe", UUID.randomUUID(), 2);
        orderManager.createOrder("Jane Smith", UUID.randomUUID(), 5);

        // Simulate order status updates using multithreading
        UUID orderId1 = orderManager.orders.keySet().iterator().next(); // Get the first order ID
        orderManager.updateOrderStatus(orderId1, Order.OrderStatus.SHIPPED);

        // Simulate another order status update
        UUID orderId2 = orderManager.orders.keySet().iterator().next(); // Get the second order ID
        orderManager.updateOrderStatus(orderId2, Order.OrderStatus.DELIVERED);

        // Shutdown the OrderManager
        orderManager.shutdown();
    }

}