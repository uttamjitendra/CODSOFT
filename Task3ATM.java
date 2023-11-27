import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient balance or invalid amount
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processTransaction() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Withdraw
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    boolean withdrawalResult = userAccount.withdraw(withdrawAmount);
                    if (withdrawalResult) {
                        System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                    } else {
                        System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
                    }
                    break;

                case 2:
                    // Deposit
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
                    break;

                case 3:
                    // Check Balance
                    System.out.println("Current Balance: " + userAccount.getBalance());
                    break;

                case 4:
                    System.out.println("Exiting. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }

        } while (choice != 4);
    }
}

public class Task3ATM {
    public static void main(String[] args) {
        // Create a user's bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        // Create an ATM instance and connect it with the user's bank account
        ATM atm = new ATM(userAccount);

        // Process transactions using the ATM
        atm.processTransaction();
    }
}