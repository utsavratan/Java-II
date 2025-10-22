// CalculatorApp.java
// Calculator Application using Method Overloading
// Assignment 2 (Java Programming)
// By : Utsav Ratan
// ---------------------------------------------

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorApp {

    // ========== Calculator Logic ==========
    static class Calculator {

        // Overloaded add methods
        public int add(int a, int b) {
            return a + b;
        }

        public double add(double a, double b) {
            return a + b;
        }

        public int add(int a, int b, int c) {
            return a + b + c;
        }

        // Subtraction
        public int subtract(int a, int b) {
            return a - b;
        }

        // Multiplication
        public double multiply(double a, double b) {
            return a * b;
        }

        // Division (with exception handling)
        public double divide(int a, int b) {
            if (b == 0) throw new ArithmeticException("❌ Division by zero is not allowed!");
            return (double) a / b;
        }

        // Additional Functions
        public double power(double base, double exponent) {
            return Math.pow(base, exponent);
        }

        public double modulus(int a, int b) {
            if (b == 0) throw new ArithmeticException("❌ Modulus by zero is not allowed!");
            return a % b;
        }

        public double squareRoot(double number) {
            if (number < 0) throw new ArithmeticException("❌ Cannot calculate square root of negative number!");
            return Math.sqrt(number);
        }
    }

    // ========== User Interface Logic ==========
    static class UserInterface {

        private final Scanner scanner = new Scanner(System.in);
        private final Calculator calculator = new Calculator();

        // Addition
        public void performAddition() {
            try {
                System.out.print("Enter number of operands (2 or 3): ");
                int count = scanner.nextInt();

                if (count == 2) {
                    System.out.print("Enter first number: ");
                    double a = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    double b = scanner.nextDouble();
                    System.out.println("✅ Result: " + calculator.add(a, b));
                } else if (count == 3) {
                    System.out.print("Enter first number: ");
                    int a = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    int b = scanner.nextInt();
                    System.out.print("Enter third number: ");
                    int c = scanner.nextInt();
                    System.out.println("✅ Result: " + calculator.add(a, b, c));
                } else {
                    System.out.println("❌ Invalid number of operands! Please enter 2 or 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter numeric values only.");
                scanner.nextLine();
            }
        }

        // Subtraction
        public void performSubtraction() {
            try {
                System.out.print("Enter first integer: ");
                int a = scanner.nextInt();
                System.out.print("Enter second integer: ");
                int b = scanner.nextInt();
                System.out.println("✅ Result: " + calculator.subtract(a, b));
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter integer values only.");
                scanner.nextLine();
            }
        }

        // Multiplication
        public void performMultiplication() {
            try {
                System.out.print("Enter first number: ");
                double a = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double b = scanner.nextDouble();
                System.out.println("✅ Result: " + calculator.multiply(a, b));
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter numeric values.");
                scanner.nextLine();
            }
        }

        // Division
        public void performDivision() {
            try {
                System.out.print("Enter dividend (integer): ");
                int a = scanner.nextInt();
                System.out.print("Enter divisor (integer): ");
                int b = scanner.nextInt();
                System.out.println("✅ Result: " + calculator.divide(a, b));
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter integer values.");
                scanner.nextLine();
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }

        // Power
        public void performPower() {
            try {
                System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter exponent: ");
                double exp = scanner.nextDouble();
                System.out.println("✅ Result: " + calculator.power(base, exp));
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter numeric values.");
                scanner.nextLine();
            }
        }

        // Modulus
        public void performModulus() {
            try {
                System.out.print("Enter first integer: ");
                int a = scanner.nextInt();
                System.out.print("Enter second integer: ");
                int b = scanner.nextInt();
                System.out.println("✅ Result: " + calculator.modulus(a, b));
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter integer values.");
                scanner.nextLine();
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }

        // Square Root
        public void performSquareRoot() {
            try {
                System.out.print("Enter number: ");
                double n = scanner.nextDouble();
                System.out.println("✅ Result: " + calculator.squareRoot(n));
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter numeric value.");
                scanner.nextLine();
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }

        // Main Menu
        public void mainMenu() {
            int choice = 0;
            do {
                System.out.println("\n==============================================");
                System.out.println("     🧮 Welcome to the Advanced Calculator     ");
                System.out.println("==============================================");
                System.out.println("1. Add Numbers");
                System.out.println("2. Subtract Numbers");
                System.out.println("3. Multiply Numbers");
                System.out.println("4. Divide Numbers");
                System.out.println("5. Power (x^y)");
                System.out.println("6. Modulus (%)");
                System.out.println("7. Square Root (√)");
                System.out.println("8. Exit");
                System.out.print("👉 Enter your choice: ");

                try {
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> performAddition();
                        case 2 -> performSubtraction();
                        case 3 -> performMultiplication();
                        case 4 -> performDivision();
                        case 5 -> performPower();
                        case 6 -> performModulus();
                        case 7 -> performSquareRoot();
                        case 8 -> System.out.println("👋 Thank you for using the Calculator!");
                        default -> System.out.println("❌ Invalid choice! Please select 1–8.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("❌ Invalid input! Please enter a valid choice (1–8).");
                    scanner.nextLine();
                }
            } while (choice != 8);
        }
    }

    // Main Method
    public static void main(String[] args) {
        new UserInterface().mainMenu();
    }
}
