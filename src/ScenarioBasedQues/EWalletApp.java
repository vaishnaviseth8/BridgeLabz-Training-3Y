package ScenarioBasedQues;

public class EWalletApp {
    public static void main(String[] args) {
        User alice = new User("Alice", "alice@example.com");
        User bob = new User("Bob", "bob@example.com");

        Wallet aliceWallet = new PersonalWallet(alice, 100.0);
        Wallet bobWallet = new BusinessWallet(bob);

        aliceWallet.loadMoney(50);
        System.out.println("Alice balance after loading money: $" + aliceWallet.getBalance());

        boolean transferSuccess = aliceWallet.transferTo(bob, 70);
        System.out.println("Transfer success: " + transferSuccess);
        System.out.println("Alice balance after transfer: $" + aliceWallet.getBalance());
        System.out.println("Bob balance after receiving transfer: $" + bobWallet.getBalance());

        aliceWallet.printTransactionHistory();
        bobWallet.printTransactionHistory();
    }
}

interface Transferrable {
    boolean transferTo(User receiver, double amount);
}

class User {
    private String name;
    private String email;
    private Wallet wallet;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.wallet = null;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }
}

abstract class Wallet implements Transferrable {
    private User owner;
    private double balance;
    private java.util.List<Transaction> transactions = new java.util.ArrayList<>();

    public Wallet(User owner) {
        this.owner = owner;
        this.balance = 0.0;
        owner.setWallet(this);
    }

    public Wallet(User owner, double referralBonus) {
        this.owner = owner;
        this.balance = referralBonus;
        owner.setWallet(this);
    }

    public double getBalance() {
        return balance;
    }

    public void loadMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Load Money", amount));
        }
    }

    protected void deduct(double amount) {
        balance -= amount;
    }

    protected void add(double amount) {
        balance += amount;
    }

    public void printTransactionHistory() {
        System.out.println("Transaction history for " + owner.getName() + ":");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    protected void recordTransaction(String type, double amount) {
        transactions.add(new Transaction(type, amount));
    }
}

class PersonalWallet extends Wallet {
    private static final double TAX_RATE = 0.02; // 2% tax on transfers

    public PersonalWallet(User owner) {
        super(owner);
    }

    public PersonalWallet(User owner, double referralBonus) {
        super(owner, referralBonus);
    }

    @Override
    public boolean transferTo(User receiver, double amount) {
        double tax = amount * TAX_RATE;
        double totalDeduction = amount + tax;

        if (getBalance() >= totalDeduction) {
            deduct(totalDeduction);
            receiver.getWallet().add(amount);
            recordTransaction("Transfer to " + receiver.getName(), amount);
            return true;
        }
        return false;
    }
}

class BusinessWallet extends Wallet {
    private static final double TAX_RATE = 0.01; // 1% tax on transfers
    private static final double TRANSFER_LIMIT = 10000; // max per transfer

    public BusinessWallet(User owner) {
        super(owner);
    }

    public BusinessWallet(User owner, double referralBonus) {
        super(owner, referralBonus);
    }

    @Override
    public boolean transferTo(User receiver, double amount) {
        if (amount > TRANSFER_LIMIT) {
            System.out.println("Transfer amount exceeds limit.");
            return false;
        }
        double tax = amount * TAX_RATE;
        double totalDeduction = amount + tax;

        if (getBalance() >= totalDeduction) {
            deduct(totalDeduction);
            receiver.getWallet().add(amount);
            recordTransaction("Transfer to " + receiver.getName(), amount);
            return true;
        }
        return false;
    }
}

class Transaction {
    private String type;
    private double amount;
    private java.time.LocalDateTime timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = java.time.LocalDateTime.now();
    }

    @Override
    public String toString() {
        return timestamp + " - " + type + ": $" + String.format("%.2f", amount);
    }
}

