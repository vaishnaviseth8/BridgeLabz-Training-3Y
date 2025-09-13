package TypesofInheritance;

class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance        : $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        displayDetails();
        System.out.println("Interest Rate  : " + interestRate + "%");
        System.out.println("Account Type   : Savings Account");
        System.out.println("----------------------------------");
    }
}

class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        displayDetails();
        System.out.println("Withdraw Limit : $" + withdrawalLimit);
        System.out.println("Account Type   : Checking Account");
        System.out.println("----------------------------------");
    }
}

class FixedDepositAccount extends BankAccount {
    private int termInMonths;

    public FixedDepositAccount(String accountNumber, double balance, int termInMonths) {
        super(accountNumber, balance);
        this.termInMonths = termInMonths;
    }

    public void displayAccountType() {
        displayDetails();
        System.out.println("Term Duration  : " + termInMonths + " months");
        System.out.println("Account Type   : Fixed Deposit Account");
        System.out.println("----------------------------------");
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA12345", 5000.00, 3.5);
        CheckingAccount ca = new CheckingAccount("CA98765", 3000.00, 1000.00);
        FixedDepositAccount fda = new FixedDepositAccount("FD54321", 10000.00, 12);

        sa.displayAccountType();
        ca.displayAccountType();
        fda.displayAccountType();
    }
}
