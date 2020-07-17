package com.codedifferently.bankaccountlab;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScanCorrect {

    Scanner in = new Scanner(System.in);

    public int nextInt() {
        int scanned = 0;
        boolean passed = false;
        while(!passed) {
            try {
                scanned = in.nextInt();
                passed = true;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please try again: ");
                in.nextLine();
            }
        }
        return scanned;
    }

    public int nextInt(int min, int max) {
        int scanned = 0;
        boolean passed = false;
        while(!passed) {
            try {
                scanned = in.nextInt();
                while(scanned < min || scanned > max) {
                    System.out.print("Input must be between " + min + " and " + max + ". Please try again: ");
                    scanned = in.nextInt();
                }
                passed = true;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please try again: ");
                in.nextLine();
            }
        }
        return scanned;
    }

    public double nextDouble() {
        double scanned = 0;
        boolean passed = false;
        while(!passed) {
            try {
                scanned = in.nextDouble();
                passed = true;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please try again: $");
                in.nextLine();
            }
        }
        return scanned;
    }

    public String nextLine() {
        return in.nextLine();
    }

}
