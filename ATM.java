import java.util.ArrayList;

class ATM {
    private double balance;
    private int withdrawals = 0;
    private final ArrayList<String> transactions = new ArrayList<>();

    private final int MAX_WITHDRAWALS = 3;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean login(int pin) {
        final int storedPin = 1234; // hardcoded for demo
        return pin == storedPin;
    }

    public void checkBalance() {
        System.out.println("\nCurrent Balance: " + balance);
        transactions.add("Checked balance: " + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited " + amount);
            System.out.println("\n" + amount + " deposited successfully.");
        } else {
            System.out.println("\nInvalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (withdrawals >= MAX_WITHDRAWALS) {
            System.out.println("Withdrawal limit reached (3 per session).");
            return;
        }
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            withdrawals++;
            transactions.add("Withdrew " + amount);
            System.out.println(" " + amount + " withdrawn successfully.");
        } else {
            System.out.println(" Insufficient balance or invalid amount.");
        }
    }

    public void showTransactions() {
        System.out.println("\n Transaction History:");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : transactions) {
                System.out.println("- " + t);
            }
        }
    }
}
