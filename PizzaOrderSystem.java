     import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Define the Pizza class
class Pizza {
    private String name;
    private double price;

    public Pizza(String name, double price) {
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

// Define the Order class
class Order {
    private List<Pizza> pizzas;

    public Order() {
        pizzas = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public double calculateTotal() {
        double total = 0;
        for (Pizza pizza : pizzas) {
            total += pizza.getPrice();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("Order Details:");
        for (Pizza pizza : pizzas) {
            System.out.println(pizza.getName() + " - $" + pizza.getPrice());
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

// Main class to run the Pizza ordering system
public class PizzaOrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define some pizza options
        Pizza margherita = new Pizza("Margherita", 8.99);
        Pizza pepperoni = new Pizza("Pepperoni", 10.99);
        Pizza veggie = new Pizza("Vegetarian", 9.99);

        // Display menu
        System.out.println("Pizza Menu:");
        System.out.println("1. Margherita - $8.99");
        System.out.println("2. Pepperoni - $10.99");
        System.out.println("3. Vegetarian - $9.99");

        // Create an order
        Order order = new Order();

        // Take user input for pizza selection
        char choice;
        do {
            System.out.print("Enter the number of the pizza you want to order (0 to finish): ");
            int pizzaChoice = scanner.nextInt();

            switch (pizzaChoice) {
                case 1:
                    order.addPizza(margherita);
                    break;
                case 2:
                    order.addPizza(pepperoni);
                    break;
                case 3:
                    order.addPizza(veggie);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid pizza number.");
            }

            System.out.print("Do you want to order another pizza? (y/n): ");
            choice = scanner.next().charAt(0);
        } while (choice != 'n');

        // Display the order
        order.displayOrder();

        // Close the scanner
        scanner.close();
    }
}

