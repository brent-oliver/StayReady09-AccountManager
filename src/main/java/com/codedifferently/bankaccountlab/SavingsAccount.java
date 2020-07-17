package com.codedifferently.bankaccountlab;

import java.text.DecimalFormat;

public class SavingsAccount extends BankAccount {

    private String name;
    private Double rate;
    private final DecimalFormat formatter = new DecimalFormat("#.0%");

    public SavingsAccount(String name, Integer accountNumber, Double fees, Double rate, Double balance, String password) {
        super(accountNumber, fees, balance, password);
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + super.toString() + "\nRate: " + formatter.format(rate);
    }
}
