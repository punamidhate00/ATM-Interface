import java.util.Scanner;

public class ATM {
    private double balance;
    private String userPin;

    public ATM(String pin) {
        this.balance = 0.0;
        this.userPin = pin;
    }

    // Method to display menu
    public void displayMenu() {
        System.out.println("\n==== ATM MENU ====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    // Method to check balance
    public void checkBalance() {
        System.out.printf("Your current balance is: $%.2f\n", balance);
    }

    // Method to deposit money
    public void depositMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("You have successfully deposited $%.2f.\n", amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    // Method to withdraw money
    public void withdrawMoney(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("You have successfully withdrawn $%.2f.\n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    // Main method to simulate ATM operations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome...");
        System.out.print("Set your PIN: ");
        String pin = scanner.nextLine();
        ATM atm = new ATM(pin);

        System.out.print("Enter your PIN to access the ATM: ");
        String enteredPin = scanner.nextLine();

        if (!enteredPin.equals(atm.userPin)) {
            System.out.println("Incorrect PIN. Access denied.");
            return;
        }

        boolean exit = false;

        while (!exit) {
            atm.displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.depositMoney(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdrawMoney(withdrawAmount);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
