package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BusinessAccountTest {

    @Test
    public void constructorTest() {
        // Given
        String name = "Code Differently";
        Integer id = 5003;
        Integer accNum = 12345;
        Double fees = 0.06;
        Double balance = 500.0;
        String password = "MyPassword";

        // When
        BusinessAccount myAccount = new BusinessAccount(name, id, accNum, fees, balance, password);
        String actualName = myAccount.getCompany();
        Integer actualId = myAccount.getTaxId();
        Integer actualAccNum = myAccount.getAccountNumber();
        Double actualFees = myAccount.getFees();
        Double actualBal = myAccount.getBalance();
        String actualPass = myAccount.getPassword();

        // Then
        Assert.assertEquals(name, actualName);
        Assert.assertEquals(id, actualId);
        Assert.assertEquals(accNum, actualAccNum);
        Assert.assertEquals(fees, actualFees);
        Assert.assertEquals(balance, actualBal);
        Assert.assertEquals(password, actualPass);
    }

    BusinessAccount myAccount;
    @Before
    public void initialize() {
        myAccount = new BusinessAccount("Code Differently", 5003, 12345, 0.06, 500.0, "MyPassword");
    }

    @Test
    public void getCompanyTest() {
        // Given
        String expected = "Code Differently";

        // When
        String actual = myAccount.getCompany();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setCompanyTest() {
        // Given
        String expected = "JP Morgan & Chase";

        // When
        myAccount.setCompany(expected);
        String actual = myAccount.getCompany();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTaxIdTest() {
        // Given
        Integer expected = 5003;

        // When
        Integer actual = myAccount.getTaxId();

        // Then
        Assert.assertEquals(expected, actual);
    }

}
