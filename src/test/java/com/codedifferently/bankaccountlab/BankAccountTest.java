package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

    @Test
    public void constructorTest() {
        // Given
        Integer accNum = 12345;
        Double fees = 0.06;
        Double balance = 500.0;
        String password = "MyPassword";

        // When
        BankAccount myAccount = new CheckingAccount("Barry", accNum, fees, balance, password);
        Integer actualAccNum = myAccount.getAccountNumber();
        Double actualFees = myAccount.getFees();
        Double actualBal = myAccount.getBalance();
        String actualPass = myAccount.getPassword();

        // Then
        Assert.assertEquals(accNum, actualAccNum);
        Assert.assertEquals(fees, actualFees);
        Assert.assertEquals(balance, actualBal);
        Assert.assertEquals(password, actualPass);
    }

    BankAccount myAccount;
    @Before
    public void initialize() {
        myAccount = new CheckingAccount("Bruce", 860043, 0.05, 1000.0, "ImBatman");
    }

    @Test
    public void getAccountNumTest() {
        // Given
        Integer expected = 860043;

        // When
        Integer actual = myAccount.getAccountNumber();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFeesTest() {
        // Given
        Double expected = 0.05;

        // When
        Double actual = myAccount.getFees();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setFeesTest() {
        // Given
        Double expected = 1.8;

        // When
        myAccount.setFees(expected);
        Double actual = myAccount.getFees();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBalanceTest() {
        // Given
        Double expected = 1000.0;

        // When
        Double actual = myAccount.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBalanceTest() {
        // Given
        Double expected = 5000.0;

        // When
        myAccount.setBalance(expected);
        Double actual = myAccount.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addToBalanceTest() {
        // Given
        Double expected = 1500.0;

        // When
        myAccount.addToBalance(500.0);
        Double actual = myAccount.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void subtractFromBalanceTest() {
        // Given
        Double expected = 500.0;

        // When
        myAccount.subtractFromBalance(500.0);
        Double actual = myAccount.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void changePasswordTest() {
        // Given
        String expected = "BatLover19";

        // When
        myAccount.changePassword(expected);
        String actual = myAccount.getPassword();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPasswordTest() {
        // Given
        String expected = "ImBatman";

        // When
        String actual = myAccount.getPassword();

        // Then
        Assert.assertEquals(expected, actual);
    }

}
