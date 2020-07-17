package com.codedifferently.bankaccountlab;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainApplication {

    static ScanCorrect keyboard = new ScanCorrect();
    static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    static DecimalFormat formatter = new DecimalFormat("$#,##0.00;-$#,##0.00");

    public static void main(String[] args) {
        ScanCorrect keyboard1 = new ScanCorrect();

        System.out.println("Welcome to the ATM! Please choose an option below");
        String stop;
        do {
            System.out.print("\n1. Create Account\n2. View Account\n3. Delete Account\nEnter Option (1-3): ");
            int option = keyboard1.nextInt(1, 3);
            switch (option) {
                case 1:
                    accounts.add(createAccount());
                case 2:
                    viewAccount(); break;
                case 3:
                    deleteAccount(); break;
            }
            System.out.print("\nLeave ATM? "); keyboard1.nextLine(); stop = keyboard1.nextLine();
        } while(stop.equalsIgnoreCase("NO"));
    }

    private static BankAccount createAccount() {
        System.out.println("\nWhat type of of account are you creating? Please choose an option below");
        System.out.print("1. Checking\n2. Savings\n3. Business\nEnter Option (1-3): ");
        int option = keyboard.nextInt(1, 3);
        switch(option) {
            case 1:
                return createChecking();
            case 2:
                return createSavings();
            case 3:
                return createBusiness();
        }
        return null;
    }

    private static CheckingAccount createChecking() {
        System.out.println("\nCreate Checking Account"); keyboard.nextLine();
        System.out.print("Name: "); String name = keyboard.nextLine();
        System.out.print("Account Number: "); int accNum = keyboard.nextInt();
        while(containsAccount(accNum)) {
            System.out.print("Account already exists. Choose another account number: "); accNum = keyboard.nextInt(); }
        System.out.print("Starting Balance: $"); Double balance = keyboard.nextDouble();
        System.out.print("Password: "); keyboard.nextLine(); String password = keyboard.nextLine();
        return new CheckingAccount(name, accNum, 20.0, balance, password);
    }

    private static SavingsAccount createSavings() {
        System.out.println("\nCreate Savings Account"); keyboard.nextLine();
        System.out.print("Name: "); String name = keyboard.nextLine();
        System.out.print("Account Number: "); int accNum = keyboard.nextInt();
        while(containsAccount(accNum)) {
            System.out.print("Account already exists. Choose another account number: "); accNum = keyboard.nextInt(); }
        System.out.print("Starting Balance: $"); Double balance = keyboard.nextDouble();
        System.out.print("Password: "); keyboard.nextLine(); String password = keyboard.nextLine();
        return new SavingsAccount(name, accNum, 2.0, 0.015, balance, password);
    }

    private static BusinessAccount createBusiness() {
        System.out.println("\nCreate Business Account"); keyboard.nextLine();
        System.out.print("Company Name: "); String name = keyboard.nextLine();
        System.out.print("Tax ID: "); int id = keyboard.nextInt();
        System.out.print("Account Number: "); int accNum = keyboard.nextInt();
        while(containsAccount(accNum)) {
            System.out.print("Account already exists. Choose another account number: "); accNum = keyboard.nextInt(); }
        System.out.print("Starting Balance: $"); Double balance = keyboard.nextDouble();
        System.out.print("Password: "); keyboard.nextLine(); String password = keyboard.nextLine();
        return new BusinessAccount(name, id, accNum, 50.0, balance, password);
    }

    private static void viewAccount() {
        System.out.println("\nView Account");
        System.out.print("Enter account number: ");
        int accNum = keyboard.nextInt(); keyboard.nextLine();
        if(containsAccount(accNum)) {
            BankAccount accViewed = accounts.get(findAccount(accNum));
            System.out.print("Enter password: ");
            String pass = keyboard.nextLine();
            if(pass.equals(accViewed.getPassword())) {
                System.out.println("\nViewing Account\n" + accViewed.toString());
                updateAccount(accViewed);
            } else {
                System.out.println("Incorrect Password.");
            }
        } else { System.out.println("No account found."); }
    }

    private static void updateAccount(BankAccount account) {
        System.out.print("\nDo you want to update account? [Yes or No]: ");
        if(keyboard.nextLine().equalsIgnoreCase("YES")) {
            System.out.print("Deposit or Withdraw?: ");
            String choice = keyboard.nextLine();
            if(choice.equalsIgnoreCase("DEPOSIT")) {
                System.out.print("How much? $");
                addToAccount(account, keyboard.nextDouble());
            } else if(choice.equalsIgnoreCase("WITHDRAW")) {
                System.out.print("How much? $");
                subtractFromAccount(account, keyboard.nextDouble());
            } else {
                System.out.println("Invalid input.\n");
            }
        }
    }

    private static void addToAccount(BankAccount account, double amount) {
        account.addToBalance(amount);
        System.out.println("Amount Deposited. New balance is " + formatter.format(account.getBalance()));
    }

    private static void subtractFromAccount(BankAccount account, double amount) {
        account.subtractFromBalance(amount);
        System.out.println("Amount withdrawn. New balance is " + formatter.format(account.getBalance()));
    }

    private static boolean containsAccount(int num) {
        for(BankAccount account : accounts) {
            if (account.getAccountNumber() == num)
                return true;
        }
        return false;
    }

    private static int findAccount(int num) {
        for(int i = 0; i < accounts.size(); i++) {
            if(accounts.get(i).getAccountNumber() == num)
                return i;
        }
        return -1;
    }

    private static void deleteAccount() {
        System.out.print(("\nEnter account number to delete: "));
        int accNum = keyboard.nextInt(); keyboard.nextLine();
        if(containsAccount(accNum)) {
            BankAccount accViewed = accounts.get(findAccount(accNum));
            System.out.print("Enter password: ");
            String pass = keyboard.nextLine();
            if(pass.equals(accViewed.getPassword())) {
                accounts.remove(findAccount(accNum));
                System.out.println("Account deleted.");
            }
        } else { System.out.println("No account found."); }
    }

}
