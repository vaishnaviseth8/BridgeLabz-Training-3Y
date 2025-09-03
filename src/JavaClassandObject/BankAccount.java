package JavaClassandObject;

public class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: $%.2f\n", amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrawn: $%.2f\n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void displayBalance() {
        System.out.printf("Current Balance: $%.2f\n", balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Anuj Verma", "ACC123456", 1000.00);

        account.displayBalance();
        account.deposit(250.00);
        account.withdraw(100.00);
        account.withdraw(1500.00);
        account.displayBalance();
    }
}

