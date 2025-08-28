import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static double balance = 5000.00;

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to the ATM Machine.");
        System.out.println("Please enter your account number");
        Scanner scanner = new Scanner(System.in);
        String accountNumber = scanner.next();
        System.out.println("Please enter your pin");
        String pin = scanner.next();
        System.out.println("Account Number: " + accountNumber + " Pin: " + pin);

        atmOperationLoop:
        while (true) {
            displayOptions();
            int action  = scanner.nextInt();
            switch (action) {
                case 1:
                    printBalance();
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw");
                    double withdrawalAmount  = scanner.nextDouble();
                    try {
                        withdraw(withdrawalAmount);
                        System.out.println("New balance is $"+ balance);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter amount to Deposit");
                    double depositAmount = scanner.nextDouble();
                    try {
                        deposit(depositAmount);
                        System.out.println("New balance is: $" + balance);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Have a nice day!");
                    break atmOperationLoop;
                default:
                    throw new Exception("Invalid Action");

            }
        }
        scanner.close();
    }

    static void displayOptions() {
        System.out.println("Select action");
        System.out.println("1: View Account Balance");
        System.out.println("2: Withdraw");
        System.out.println("3: Deposit");
        System.out.println("4: Exit");
    }

    static void printBalance() {
        BigDecimal bd = new BigDecimal(balance).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Balance: " + bd);
    }

    static void withdraw(double withdrawalAmount) throws Exception {
        if (withdrawalAmount <= 0) {
            throw new Exception("Amount must be greater than 0");
        }
        if (withdrawalAmount > balance) {
            throw new Exception("Amount cannot exceed balance");
        }
        balance -= withdrawalAmount;
    }

    static void deposit(double depositAmount) throws Exception {
        if (depositAmount <= 0) {
            throw new Exception("Amount must be greater than 0");
        }
        balance += depositAmount;
    }

}