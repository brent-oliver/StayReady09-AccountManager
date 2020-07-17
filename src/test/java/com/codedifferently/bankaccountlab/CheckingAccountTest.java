package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckingAccountTest {

    @Test
    public void constructorTest() {
        // Given
        String name = "Barry";
        Integer accNum = 12345;
        Double fees = 0.06;
        Double balance = 500.0;
        String password = "MyPassword";

        // When
        CheckingAccount myAccount = new CheckingAccount(name, accNum, fees, balance, password);
        String actualName = myAccount.getName();
        Integer actualAccNum = myAccount.getAccountNumber();
        Double actualFees = myAccount.getFees();
        Double actualBal = myAccount.getBalance();
        String actualPass = myAccount.getPassword();

        // Then
        Assert.assertEquals(name, actualName);
        Assert.assertEquals(accNum, actualAccNum);
        Assert.assertEquals(fees, actualFees);
        Assert.assertEquals(balance, actualBal);
        Assert.assertEquals(password, actualPass);
    }

    CheckingAccount myAccount;
    @Before
    public void initialize() {
        myAccount = new CheckingAccount("Jason", 15498, 0.03, 250.0, "17WonderBoy!");
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

}
