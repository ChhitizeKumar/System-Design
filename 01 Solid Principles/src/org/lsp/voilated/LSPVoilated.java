package org.lsp.voilated;

import java.util.ArrayList;
import java.util.List;

interface Account{
    void deposit(double amount);
    void withdraw(double amount);
}

class SavingsAccount implements Account{
    private double balance;

    public SavingsAccount () {
        balance = 2500;
    }
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Savings Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
    }
}

class CurrentAccount implements Account{
    private double balance;

    public CurrentAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Current Account!");
        }
    }
}

class FixedTermAccount implements Account{
    private double balance;
    public FixedTermAccount () {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Fixed Term Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdrawal not allowed in Fixed Term Account!");
    }
}

class BankClient{
    List<Account> accounts;

    BankClient(List<Account> accounts) {
        this.accounts = accounts;
    }

    void processTransactions() {
        for (Account account : accounts) {
            account.deposit(1000);

            try{
                account.withdraw(500);
            }catch(UnsupportedOperationException e){
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
public class LSPVoilated {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new SavingsAccount());
        accounts.add(new CurrentAccount());
        accounts.add(new FixedTermAccount());

        BankClient client = new BankClient(accounts);
        client.processTransactions();
    }
}
