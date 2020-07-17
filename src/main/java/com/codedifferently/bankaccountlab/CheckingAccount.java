package com.codedifferently.bankaccountlab;

public class CheckingAccount extends BankAccount {

    private String name;

    public CheckingAccount(String name, Integer accountNumber, Double fees, Double balance, String password) {
        super(accountNumber, fees, balance, password);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + super.toString();
    }

}
