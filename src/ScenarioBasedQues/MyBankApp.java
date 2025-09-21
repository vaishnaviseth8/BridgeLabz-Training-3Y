package ScenarioBasedQues;

public class MyBankApp {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 10000, 5.0);
        CurrentAccount current = new CurrentAccount("CA456", 20000);

        savings.deposit(5000);
        savings.withdraw(2000);
        System.out.println("Savings Account Balance: " + savings.checkBalance());
        System.out.println("Savings Account Interest: " + savings.calculateInterest());

        current.deposit(10000);
        current.withdraw(15000);
        System.out.println("Current Account Balance: " + current.checkBalance());
        System.out.println("Current Account Interest: " + current.calculateInterest());
    }
}

interface ITransaction {
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}

abstract class Account implements ITransaction {
    protected String accountNumber;
    private double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    protected double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    public abstract double calculateInterest();
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber) {
        super(accountNumber);
        this.interestRate = 4.0; // default interest rate
    }

    public SavingsAccount(String accountNumber, double openingBalance, double interestRate) {
        super(accountNumber, openingBalance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

class CurrentAccount extends Account {
    private final double interestRate = 2.0;

    public CurrentAccount(String accountNumber) {
        super(accountNumber);
    }

    public CurrentAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }
}

