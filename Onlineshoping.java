import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public List<Product> getItems() {
        return items;
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }
}

public class Onlineshoping {
    public static void main(String[] args) {
        Product laptop = new Product("Laptop", 999.99);
        Product phone = new Product("Smartphone", 599.99);

        ShoppingCart cart = new ShoppingCart();

        // Simple user interface
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Product to Cart");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available Products:");
                    System.out.println("1. " + laptop.getName() + " - $" + laptop.getPrice());
                    System.out.println("2. " + phone.getName() + " - $" + phone.getPrice());
                    System.out.print("Enter product number to add to cart: ");
                    int productChoice = scanner.nextInt();

                    if (productChoice == 1) {
                        cart.addProduct(laptop);
                        System.out.println("Added " + laptop.getName() + " to cart.");
                    } else if (productChoice == 2) {
                        cart.addProduct(phone);
                        System.out.println("Added " + phone.getName() + " to cart.");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 2:
                    System.out.println("Your Cart:");
                    displayCart(cart);
                    System.out.print("Enter product number to remove from cart: ");
                    int removeChoice = scanner.nextInt();

                    if (removeChoice > 0 && removeChoice <= cart.getItems().size()) {
                        Product removedProduct = cart.getItems().get(removeChoice - 1);
                        cart.removeProduct(removedProduct);
                        System.out.println("Removed " + removedProduct.getName() + " from cart.");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 3:
                    System.out.println("Your Cart:");
                    displayCart(cart);
                    break;

                case 4:
                    System.out.println("Checkout - Total: $" + cart.calculateTotal());
                    System.out.println("Thank you for shopping!");
                    System.exit(0);

                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayCart(ShoppingCart cart) {
        List<Product> items = cart.getItems();
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (int i = 0; i < items.size(); i++) {
                Product product = items.get(i);
                System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());
            }
            System.out.println("Total: $" + cart.calculateTotal());
        }
    }
}
