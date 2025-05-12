
import java.util.Scanner;

public class ATMINTERFACE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM(100000); // Initial balance ₹100,000

        System.out.println(" Welcome to Secure Java ATM Interface!");
        System.out.print(" Please enter your 4-digit PIN: ");
        int enteredPin = sc.nextInt();

        if (!atm.login(enteredPin)) {
            System.out.println(" Incorrect PIN. Exiting system.");
            return;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n Menu:");
            System.out.println("1. Check Balance !");
            System.out.println("2. Deposit Money !");
            System.out.println("3. Withdraw Money !");
            System.out.println("4. View Transaction History !");
            System.out.println("5. Exit !");
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> atm.checkBalance();
                case 2 -> {
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                }
                case 3 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                }
                case 4 -> atm.showTransactions();
                case 5 -> {
                    System.out.println("Thank you for using Java ATM. Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
