import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + category + "): $" + price;
    }
}

public class hard {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.00),
            new Product("Smartphone", "Electronics", 800.00),
            new Product("Tablet", "Electronics", 400.00),
            new Product("Chair", "Furniture", 150.00),
            new Product("Table", "Furniture", 300.00),
            new Product("Sofa", "Furniture", 700.00)
        );

        // Grouping products by category
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        // Finding the most expensive product in each category
        Map<String, Product> mostExpensiveProduct = groupedByCategory.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().stream()
                    .max(Comparator.comparing(Product::getPrice))
                    .orElse(null)
            ));

        // Calculating the average price of all products
        double averagePrice = products.stream()
            .collect(Collectors.averagingDouble(Product::getPrice));

        // Output results
        System.out.println("Most Expensive Products by Category:");
        mostExpensiveProduct.forEach((category, product) -> 
            System.out.println(category + ": " + product));

        System.out.println("\nAverage Price of All Products: $" + averagePrice);
    }
}
