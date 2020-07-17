package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTest {

    @Test
    public void constructorTest() {
        // Given
        String name = "Barry";
        Integer accNum = 12345;
        Double fees = 0.06;
        Double rate = 0.07;
        Double balance = 500.0;
        String password = "MyPassword";

        // When
        SavingsAccount myAccount = new SavingsAccount(name, accNum, fees, rate, balance, password);
        String actualName = myAccount.getName();
        Integer actualAccNum = myAccount.getAccountNumber();
        Double actualFees = myAccount.getFees();
        Double actualRate = myAccount.getRate();
        Double actualBal = myAccount.getBalance();
        String actualPass = myAccount.getPassword();

        // Then
        Assert.assertEquals(name, actualName);
        Assert.assertEquals(accNum, actualAccNum);
        Assert.assertEquals(fees, actualFees);
        Assert.assertEquals(rate, actualRate);
        Assert.assertEquals(balance, actualBal);
        Assert.assertEquals(password, actualPass);
    }

    SavingsAccount myAccount;
    @Before
    public void initialize() {
        myAccount = new SavingsAccount("Jason", 15498, 0.03, 0.02, 250.0, "17WonderBoy!");
    }

    @Test
    public void getNameTest() {
        // Given
        String expected = "Jason";

        // When
        String actual = myAccount.getName();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNameTest() {
        // Given
        String expected = "Tim";

        // When
        myAccount.setName(expected);
        String actual = myAccount.getName();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRateTest() {
        // Given
        Double expected = 0.02;

        // When
        Double actual = myAccount.getRate();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setRateTest() {
        // Given
        Double expected = 0.8;

        // When
        myAccount.setRate(expected);
        Double actual = myAccount.getRate();

        // Then
        Assert.assertEquals(expected, actual);
    }

}