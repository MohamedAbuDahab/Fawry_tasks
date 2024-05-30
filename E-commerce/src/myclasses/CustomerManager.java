package myclasses;

/**
 * Author: @ Mohamed Waheed
 * DATE: 5/19/2024
 * PROJECT NAME: E-commerce
 */
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customerList;

    public CustomerManager() {
        customerList = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public void removeCustomer(int customerId) {
        customerList.removeIf(customer -> customer.getId() == customerId);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void viewAllCustomers() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }
}


