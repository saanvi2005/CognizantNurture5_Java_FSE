import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int id, String name, int qty, double p) {
        productId = id;
        productName = name;
        quantity = qty;
        price = p;
    }

    public String toString() {
        return "ID: " + productId + " | Name: " + productName + " | Qty: " + quantity + " | Price: " + price;
    }
}

public class InventorySystem {

    static HashMap<Integer, Product> inventory = new HashMap<>();

    static void addProduct(Product p) {
        inventory.put(p.productId, p);
        System.out.println("Added: " + p.productName);
    }

    static void updateProduct(int id, int newQty, double newPrice) {
        if (inventory.containsKey(id)) {
            inventory.get(id).quantity = newQty;
            inventory.get(id).price = newPrice;
            System.out.println("Updated product " + id);
        } else {
            System.out.println("Product not found");
        }
    }

    static void deleteProduct(int id) {
        if (inventory.remove(id) != null) {
            System.out.println("Deleted product " + id);
        } else {
            System.out.println("Not found");
        }
    }

    static void showAll() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        addProduct(new Product(1, "Laptop", 10, 999.99));
        addProduct(new Product(2, "Mouse", 50, 25.0));
        addProduct(new Product(3, "Keyboard", 30, 45.0));

        System.out.println("\nAll products:");
        showAll();

        updateProduct(1, 8, 949.99);
        System.out.println("\nAfter update:");
        showAll();

        deleteProduct(2);
        System.out.println("\nAfter delete:");
        showAll();
    }
}
