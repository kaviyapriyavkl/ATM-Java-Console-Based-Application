import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private static Scanner scanner = new Scanner(System.in);
    private static double balance = 0;
    private static int userPin = 1234; 
    private static int adminPin = 4321; 
    private static List<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("-------------------------------------------------");
            System.out.println("Welcome to ATM Machine! How can I help you?");
            System.out.println("1. User Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            

            int choice = scanner.nextInt();
            System.out.println("-------------------------------------------------");
        
            switch (choice) {
                case 1:
                    userLogin();
                    break;
                case 2:
                    adminLogin();
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Thank you for using the ATM Machine!");
    }

    private static void userLogin() {
        System.out.print("Enter user PIN: ");
        int enteredPin = scanner.nextInt();
        if (enteredPin == userPin) {
            userMenu();
        } else {
            System.out.println("Incorrect PIN.");
        }
    }

    private static void adminLogin() {
        System.out.print("Enter admin PIN: ");
        int enteredPin = scanner.nextInt();
        if (enteredPin == adminPin) {
            adminMenu();
        } else {
            System.out.println("Incorrect PIN.");
        }
    }

    private static void userMenu() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("-------------------------------------------------");
            System.out.println("User Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Mini Statement");
            System.out.println("5. Change PIN");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            

            int choice = scanner.nextInt();
            System.out.println("-------------------------------------------------");
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    miniStatement();
                    break;
                case 5:
                    changeUserPIN();
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void adminMenu() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("-------------------------------------------------");
            System.out.println("Admin Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Total Bank History");
            System.out.println("5. Change User PIN");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            

            int choice = scanner.nextInt();
            System.out.println("-------------------------------------------------");
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    viewTotalBankHistory();
                    break;
                case 5:
                    changeUserPIN();
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void checkBalance() {
        System.out.println("Current balance is: " + balance);
    }

    private static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposit: +" + amount);
            System.out.println("" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrawal: -" + amount);
            System.out.println("" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private static void miniStatement() {
        System.out.println("Mini Statement:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private static void viewTotalBankHistory() {
        System.out.println("Total Bank Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private static void changeUserPIN() {
        System.out.print("Enter current user PIN: ");
        int currentPIN = scanner.nextInt();
        if (currentPIN == userPin) {
            System.out.print("Enter new user PIN: ");
            int newPIN = scanner.nextInt();
            System.out.print("Confirm new user PIN: ");
            int confirmPIN = scanner.nextInt();
            if (newPIN == confirmPIN) {
                userPin = newPIN;
                System.out.println("User PIN changed successfully.");
            } else {
                System.out.println("New PINs do not match.");
            }
        } else {
            System.out.println("Incorrect PIN.");
        }
    }
}