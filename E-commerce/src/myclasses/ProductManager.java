package myclasses;

/**
 * Author: @ Mohamed Waheed
 * DATE: 5/19/2024
 * PROJECT NAME: E-commerce
 */
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> productList;

    public ProductManager() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(int productId) {
        productList.removeIf(product -> product.getId() == productId);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void viewAllProducts() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void updateStock(int productId, int newStock) {
        for (Product product : productList) {
            if (product.getId() == productId) {
                product.setStockQuantity(newStock);
                break;
            }
        }
    }
}


