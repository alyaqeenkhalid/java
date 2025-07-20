import java.util.InputMismatchException;
import java.util.Scanner;

public class ScientificCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // Clear newline left by nextInt()

                switch (choice) {
                    case 1:
                        performAddition(scanner);
                        break;
                    case 0:
                        running = false;
                        System.out.println("Exiting calculator. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number (e.g., 1, 2, or 0).");
                scanner.nextLine(); // Clear invalid input
            }
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n=== Scientific Calculator ===");
        System.out.println("1. Add");
        System.out.println("0. Exit");
    }

    private static void performAddition(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            scanner.nextLine();  // Clear newline
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            scanner.nextLine();  // Clear newline
            System.out.println("Result: " + (num1 + num2));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values.");
            scanner.nextLine();
        }
    }




}
