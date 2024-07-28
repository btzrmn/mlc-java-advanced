package class06.lab.problem3;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;

    public BankAccount() {
        this.id = bankAccountCount++;
        System.out.printf("Account ID%d created%n", this.id);
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.printf("Deposited %.0f to ID%d%n", amount, this.id);
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public int getId() {
        return id;
    }
}
