import myclasses.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        CustomerManager customerManager = new CustomerManager();
        OrderManager orderManager = new OrderManager();

        while (true) {
            System.out.println("\nE-Commerce Application");
            System.out.println("1. Add a new product");
            System.out.println("2. Remove a product");
            System.out.println("3. View all products");
            System.out.println("4. Add a new customer");
            System.out.println("5. Remove a customer");
            System.out.println("6. View all customers");
            System.out.println("7. Create a new order");
            System.out.println("8. View all orders");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product id: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter product description: ");
                    String productDescription = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double productPrice = scanner.nextDouble();
                    System.out.print("Enter product stock quantity: ");
                    int productStock = scanner.nextInt();
                    productManager.addProduct(new Product(productId, productName, productDescription, productPrice, productStock));
                    break;
                case 2:
                    System.out.print("Enter product id to remove: ");
                    int productIdToRemove = scanner.nextInt();
                    productManager.removeProduct(productIdToRemove);
                    break;
                case 3:
                    productManager.viewAllProducts();
                    break;
                case 4:
                    System.out.print("Enter customer id: ");
                    int customerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter customer email: ");
                    String customerEmail = scanner.nextLine();
                    System.out.print("Enter customer address: ");
                    String customerAddress = scanner.nextLine();
                    customerManager.addCustomer(new Customer(customerId, customerName, customerEmail, customerAddress));
                    break;
                case 5:
                    System.out.print("Enter customer id to remove: ");
                    int customerIdToRemove = scanner.nextInt();
                    customerManager.removeCustomer(customerIdToRemove);
                    break;
                case 6:
                    customerManager.viewAllCustomers();
                    break;
                case 7:
                    System.out.print("Enter order id: ");
                    int orderId = scanner.nextInt();
                    System.out.print("Enter customer id for the order: ");
                    int orderCustomerId = scanner.nextInt();  // we have to ensure if we have this customer id
                    Customer orderCustomer = null;
                    for (Customer customer : customerManager.getCustomerList()) {
                        if (customer.getId() == orderCustomerId) {
                            orderCustomer = customer;
                            break;
                        }
                    }
                    if (orderCustomer == null) {
                        System.out.println("Customer not found!");
                        break;
                    }

                    List<Product> orderProducts = new ArrayList<>(); // to store the ordered items in it
                    while (true) {
                        System.out.print("Enter product id to add to order (or -1 to finish): ");
                        int orderProductId = scanner.nextInt();
                        if (orderProductId == -1) {
                            break;
                        }

                        Product productNumber=null;  // also we have to check if the asked product is available
                        for (Product product : productManager.getProductList()){
                            if (product.getId() == orderProductId) {
                                productNumber = product;
                                break;
                            }
                        }
                        if (productNumber == null) {
                            System.out.println("product not found!");
                            break;
                        }

                        for (Product product : productManager.getProductList()) {
                            if (product.getId() == orderProductId) {
                                orderProducts.add(product);
                                break;
                            }
                        }
                    }
                    orderManager.addOrder(new Order(orderId, orderCustomer, orderProducts)); // take Order as parameter
                    break;
                case 8:
                    orderManager.viewAllOrders();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }


    }
}

