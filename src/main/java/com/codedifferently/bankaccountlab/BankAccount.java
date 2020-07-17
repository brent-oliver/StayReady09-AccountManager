package com.codedifferently.bankaccountlab;

import java.text.DecimalFormat;

public abstract class BankAccount {

    private final Integer accountNumber;
    private Double fees;
    private Double balance;
    private String password;
    private final DecimalFormat formatter = new DecimalFormat("$#,##0.00;-$#,##0.00");

    public BankAccount(Integer accountNumber, Double fees, Double balance, String password) {
        this.accountNumber = accountNumber;
        this.fees = fees;
        this.balance = balance;
        this.password = password;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double newFees) {
        fees = newFees;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double amount) {
        balance = amount;
    }

    public void addToBalance(Double amount) {
        balance += amount;
    }

    public void subtractFromBalance(Double amount) {
        balance -= amount;
    }

    public void changePassword(String newPass) {
        password = newPass;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return "Account Number: " + accountNumber + "\n" +
                "Fees: " + formatter.format(fees) + "/month\n" +
                "Balance: " + formatter.format(balance);
    }

}
