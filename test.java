import java.util.*;

class Product {
    private String name;
    private String description;
    private int quantity;
    private double price;
    private double weight;
    private boolean isDigital;
    private String message;

    public Product(String name, String description, int quantity, double price, boolean isDigital) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.isDigital = isDigital;
    }

    public Product(String name, String description, int quantity, double price, double weight, boolean isDigital) {
        this(name, description, quantity, price, isDigital);
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isDigital() {
        return isDigital;
    }

    public boolean isPhysical() {
        return !isDigital;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        String productType = isDigital ? "DIGITAL" : "PHYSICAL";
        return productType + " - " + name;
    }
}

class ShoppingCart implements Comparable<ShoppingCart> {
    private Set<String> products;
    private double totalWeight;

    public ShoppingCart() {
        products = new HashSet<>();
    }

    public boolean addItem(String productName, Map<String, Product> productCatalog) {
        if (products.contains(productName)) {
            System.out.println("This product is already in the cart.");
            return false;
        }
        Product product = productCatalog.get(productName);
        if (product == null) {
            System.out.println("Product not found.");
            return false;
        }
        if (product.getQuantity() == 0) {
            System.out.println("Product not available.");
            return false;
        }
        products.add(productName);
        productCatalog.get(productName).quantity--;
        if (product.isPhysical()) {
            totalWeight += product.getWeight();
        }
        System.out.println("Product added to cart.");
        return true;
    }

    public boolean removeItem(String productName, Map<String, Product> productCatalog) {
        if (!products.contains(productName)) {
            System.out.println("Product not in cart.");
            return false;
        }
       
