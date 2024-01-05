                 /* WELCOME TO THE ATM INTERFACE PROJECT
                              CREATED BY - MRUNMAYEE PAWAR */


import java.util.ArrayList;
import java.util.Scanner;

/*the following class represents atm system which performs basic functions like
displaying transaction history
withdrawing
depositing
transfering
quit
*/
public class ATM {
    // Initial balance in the account
    private static double balance = 1000.0;
    //creating a new static ArrayList of Strings called transactionHistory
    private static ArrayList<String> transactionHistory = new ArrayList<>();


    public static void main(String[] args) { // main class
        // Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Scanner for user input
        while (true) {
            System.out.println(" WELCOME TO THE ATM INTERFACE");
            System.out.println("\n PRESS 1 FOR Transactions History");
            System.out.println("\n PRESS 2 FOR Withdrawing");
            System.out.println("\n PRESS 3 FOR Depositing");
            System.out.println("\n PRESS 4 FOR Transfering");
            System.out.println("\n PRESS 5 TO Quit");

            // Prompt user for choice
            System.out.print("\n Enter your choice: ");
            int choice = sc.nextInt();//this will get user input
            sc.nextLine(); // Consume the newline character

            // Switch case for user choice
            switch (choice) {
                case 1:
                    displayTransactionHistory();
                    // Option 1: Display transaction history
                    break;
                case 2:
                    // Option 2: Withdrawing money
                    System.out.print("\n Enter the to be withdrawed amount : ₹");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    // Option 3: Depositing money
                    System.out.print("\n Enter the amount to be deposited : ₹");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;
                case 4:
                    // Option 4: Transfering money
                    System.out.print("\nEnter the amount to be transfered: ₹");
                    double transferAmount = sc.nextDouble();
                    sc.nextLine(); // Consume the newline character

                    System.out.print("\n Enter the account number of recipient : ");
                    String recipientAccount = sc.nextLine();
                    transfer(transferAmount, recipientAccount);
                    break;
                case 5:
                    // Option 5: Quit the program
                    System.out.println("\n Thank you for using the ATM. SEE YOU AGAIN!");
                    System.exit(0);
                default:
                    // Invalid choice
                    System.out.println("\n Invalid choice. Please try once again.");
            }
        }
    }

    // Display transaction history
    private static void displayTransactionHistory() {
        System.out.println("\n Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Withdrawing money from the account
    private static void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            // Update balance and add withdrawal transaction
            balance -= amount;
            String transaction = "Withdrawal: -₹" + amount;
            transactionHistory.add(transaction);
            System.out.println("\n Withdrawal successful. Current balance: ₹" + balance);
        } else {
            // Invalid withdrawal amount or insufficient funds
            System.out.println("\n Invalid withdrawal amount or insufficient funds.");
        }
    }

    private static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String transaction = "Deposit: +₹" + amount;
            transactionHistory.add(transaction);
            System.out.println("\n Deposit successful. Current balance: ₹" + balance);
        } else {
            System.out.println("\n Invalid deposit amount.");
        }
    }

    // Depositing money into the account
    private static void transfer(double amount, String recipientAccount) {
        if (amount > 0 && amount <= balance) {
            // Update balance and add deposit transaction
            balance -= amount;
            String transaction = "Transfer to " + recipientAccount + ": -₹" + amount;
            transactionHistory.add(transaction);
            System.out.println("\n Transfer successful!. Current balance: ₹" + balance);
        } else {
            // Invalid deposit amount
            System.out.println("\n INSUFFICIENT BALANCE ");
        }
    }
}
