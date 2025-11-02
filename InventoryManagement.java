import java.util.*;

class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    public void displayProduct() {
        System.out.printf("%-10d %-20s %-10d %-10.2f%n", id, name, quantity, price);
    }
}

public class InventorySystem {
    private static final ArrayList<Product> inventory = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Inventory Management Menu =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Stock");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewProducts();
                case 3 -> updateProduct();
                case 4 -> deleteProduct();
                case 5 -> System.out.println("Exiting System...");
                default -> System.out.println("Invalid choice. Try again!");
            }
        } while (choice != 5);
    }

    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        Product newProduct = new Product(id, name, quantity, price);
        inventory.add(newProduct);
        System.out.println("Product added successfully!");
    }

    private static void viewProducts() {
        System.out.println("\nID        Name                Quantity   Price");
        for (Product p : inventory) {
            p.displayProduct();
        }
    }

    private static void updateProduct() {
        System.out.print("Enter Product ID to Update: ");
        int id = sc.nextInt();
        for (Product p : inventory) {
            if (p.getId() == id) {
                System.out.print("Enter new quantity: ");
                p.setQuantity(sc.nextInt());
                System.out.print("Enter new price: ");
                p.setPrice(sc.nextDouble());
                System.out.println("Product updated successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    private static void deleteProduct() {
        System.out.print("Enter Product ID to Delete: ");
        int id = sc.nextInt();
        inventory.removeIf(p -> p.getId() == id);
        System.out.println("Product deleted successfully!");
    }
}
