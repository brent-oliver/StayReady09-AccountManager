package com.codedifferently.bankaccountlab;

public class BusinessAccount extends BankAccount {

    private String company;
    private final Integer taxId;

    public BusinessAccount(String company, Integer id, Integer accountNumber, Double fees, Double balance, String password) {
        super(accountNumber, fees, balance, password);
        this.company = company;
        taxId = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getTaxId() {
        return taxId;
    }

    @Override
    public String toString() {
        return "Company Name: " + company + "\n" +
                "Tax ID: " + taxId + "\n" + super.toString();
    }
}
