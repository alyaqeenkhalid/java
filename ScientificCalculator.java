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
                    case 2:
                        performSubtraction(scanner);
                        break;
                    case 3:
                        performMultiplication(scanner);
                        break;
                    case 4:
                        performDivision(scanner);
                        break;
                    case 5:
                        performSquareRoot(scanner);
                        break;
                    case 6:
                        performPower(scanner);
                        break;
                    case 7:
                        performSine(scanner);
                        break;
                    case 8:
                        performCosine(scanner);
                        break;
                    case 9:
                        performTangent(scanner);
                        break;
                    case 10:
                        performNaturalLogarithm(scanner);
                        break;
                    case 11:
                        performLogarithmBase10(scanner);
                        break;
                    case 12:
                        performAbsoluteValue(scanner);
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
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Square Root");
        System.out.println("6. Power");
        System.out.println("7. Sine (degrees)");
        System.out.println("8. Cosine (degrees)");
        System.out.println("9. Tangent (degrees)");
        System.out.println("10. Natural Logarithm (ln)");
        System.out.println("11. Base-10 Logarithm (log10)");
        System.out.println("12. Absolute Value");
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
    private static void performSubtraction(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Result: " + (num1 - num2));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values.");
            scanner.nextLine();
        }
    }
    private static void performMultiplication(Scanner scanner) {
        try {
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Result: " + (num1 * num2));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }
    private static void performDivision(Scanner scanner) {
        try {
            System.out.print("Enter numerator: ");
            double num1 = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter denominator: ");
            double num2 = scanner.nextDouble();
            scanner.nextLine();
            if (num2 == 0) {
                System.out.println("Cannot divide by zero.");
            } else {
                System.out.println("Result: " + (num1 / num2));
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }
    private static void performSquareRoot(Scanner scanner) {
        try {
            System.out.print("Enter a number: ");
            double num = scanner.nextDouble();
            scanner.nextLine();
            if (num < 0) {
                System.out.println("Cannot take square root of negative number.");
            } else {
                System.out.println("Result: " + Math.sqrt(num));
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }
    private static void performPower(Scanner scanner) {
        try {
            System.out.print("Enter base: ");
            double base = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter exponent: ");
            double exponent = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Result: " + Math.pow(base, exponent));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }
    private static void performSine(Scanner scanner) {
        try {
            System.out.print("Enter angle in degrees: ");
            double degrees = scanner.nextDouble();
            scanner.nextLine();
            double radians = Math.toRadians(degrees);
            System.out.println("Result: " + Math.sin(radians));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }
    private static void performCosine(Scanner scanner) {
        try {
            System.out.print("Enter angle in degrees: ");
            double degrees = scanner.nextDouble();
            scanner.nextLine();
            double radians = Math.toRadians(degrees);
            System.out.println("Result: " + Math.cos(radians));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
            scanner.nextLine();
        }
    }
    private static void performTangent(Scanner scanner) {
        try {
            System.out.print("Enter angle in degrees: ");
            double degrees = scanner.nextDouble();
            scanner.nextLine();

            // Tangent undefined at 90 + k*180 degrees (like 90, 270, 450,...)
            double modAngle = degrees % 180;
            if (Math.abs(modAngle - 90) < 1e-10) { // Allow tiny floating-point error
                System.out.println("Tangent undefined at " + degrees + " degrees.");
            } else {
                double radians = Math.toRadians(degrees);
                System.out.println("Result: " + Math.tan(radians));
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
            scanner.nextLine();
        }
    }
    private static void performNaturalLogarithm(Scanner scanner) {
        try {
            System.out.print("Enter a positive number: ");
            double num = scanner.nextDouble();
            scanner.nextLine();
            if (num <= 0) {
                System.out.println("Error: Input must be positive for natural logarithm.");
            } else {
                System.out.println("Result: " + Math.log(num));
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
            scanner.nextLine();
        }
    }
    private static void performLogarithmBase10(Scanner scanner) {
        try {
            System.out.print("Enter a positive number: ");
            double num = scanner.nextDouble();
            scanner.nextLine();
            if (num <= 0) {
                System.out.println("Error: Input must be positive for base-10 logarithm.");
            } else {
                System.out.println("Result: " + Math.log10(num));
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
            scanner.nextLine();
        }
        private static void performAbsoluteValue(Scanner scanner) {
            try {
                System.out.print("Enter a number: ");
                double num = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Result: " + Math.abs(num));
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.nextLine();
            }
        }
}
