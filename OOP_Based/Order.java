import java.util.*;
class Customer {
    String customerName;
    String customerId;
    public Customer(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }
    @Override
    public String toString() {
        return "----- Customer " + customerId + " -----\n"
               + "Customer Name: " + customerName + "\n";

    }
}
public class Order {
    Customer customer;
    List<String> items;
    public Order(Customer customer, List<String> items) {
        this.customer = customer;
        this.items = items;
    }
    @Override
    public String toString() {
        return customer+"----- Items List -----\n" + items;
    }
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("apple");
        items.add("bread");
        Customer customer = new Customer("Ritwik", "1234");
        Order order = new Order(customer,items);
        System.out.println(order);
    }
}
