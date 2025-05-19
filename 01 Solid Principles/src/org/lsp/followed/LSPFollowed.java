package org.lsp.followed;

import java.util.ArrayList;
import java.util.List;

interface DepositOnlyAccount{
    public void deposit(double amount);
}

interface WithdrawalAccount extends DepositOnlyAccount{
    public void withdraw(double amount);
}

class SavingsAccount implements WithdrawalAccount {

    private double balance;

    public SavingsAccount(){
        this.balance = 1000;
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

class CurrentAccount implements WithdrawalAccount {

    private double balance;

    public CurrentAccount(){
        this.balance = 2000;
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

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
    }
}

class FixedTermAccount implements DepositOnlyAccount {
    private double balance;
    public FixedTermAccount(){
        this.balance = 5000;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Fixed Term Account. New Balance: " + balance);
    }
}

class BankClient {
    List<WithdrawalAccount> withdrawalAccounts;
    List<DepositOnlyAccount> depositOnlyAccounts;

    public BankClient(List<WithdrawalAccount> withdrawalAccounts, List<DepositOnlyAccount> depositOnlyAccounts){
        this.withdrawalAccounts = withdrawalAccounts;
        this.depositOnlyAccounts = depositOnlyAccounts;
    }

    public void processTransactions(){

        for(WithdrawalAccount withdrawalAccount : withdrawalAccounts){
            withdrawalAccount.deposit(1000);
            withdrawalAccount.withdraw(200);
        }

        for(DepositOnlyAccount depositOnlyAccount : depositOnlyAccounts){
            depositOnlyAccount.deposit(5000);
        }
    }
}

public class LSPFollowed {
    public static void main(String[] args) {
        List<WithdrawalAccount> withdrawalAccounts = new ArrayList<>();
        List<DepositOnlyAccount> depositOnlyAccounts = new ArrayList<>();

        withdrawalAccounts.add(new SavingsAccount());
        withdrawalAccounts.add(new CurrentAccount());

        depositOnlyAccounts.add(new FixedTermAccount());

        BankClient bankClient = new BankClient(withdrawalAccounts, depositOnlyAccounts);
        bankClient.processTransactions();
    }
}
