package OOPSDesignPrinciple;

import java.util.*;

class Account {
    private String accountNumber;
    private double balance;
    private Bank bank;

    public Account(String accountNumber, double initialDeposit, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.bank = bank;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Bank getBank() {
        return bank;
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Account balances for " + name + ":");
        for (Account acc : accounts) {
            System.out.println(" - Account " + acc.getAccountNumber() + " at " + acc.getBank().getName() + ": $" + acc.getBalance());
        }
    }

    public String getName() {
        return name;
    }
}

class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void openAccount(Customer customer, String accountNumber, double initialDeposit) {
        Account newAccount = new Account(accountNumber, initialDeposit, this);
        customer.addAccount(newAccount);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account " + accountNumber + " opened for " + customer.getName() + " at " + name);
    }
}

 public class Main {
    public static void main(String[] args) {
        Bank bank1 = new Bank("National Bank");
        Bank bank2 = new Bank("City Bank");

        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        bank1.openAccount(alice, "NB001", 1000.0);
        bank1.openAccount(bob, "NB002", 500.0);

        bank2.openAccount(alice, "CB001", 2000.0);

        System.out.println();
        alice.viewBalance();
        System.out.println();
        bob.viewBalance();
    }
}

