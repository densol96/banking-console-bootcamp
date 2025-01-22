/*
 *  Created on Jan 22, 2025
 * 
 *  Deniss Solovjovs
 */

import java.util.Scanner;

import account.BankAccount;
import account.IBankAccount;

class ConsoleApp {
    public static void main(String[] args) {
        boolean demonstrationIsOn = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("====== Console App Demonstration of Banking Task ======");

        IBankAccount userAccount = new BankAccount(200);
        IBankAccount anotherAccount = new BankAccount();

        while (demonstrationIsOn) {
            System.out.println("== Choose an option: ==");
            System.out.println("1) Check balance");
            System.out.println("2) Deposit amount");
            System.out.println("3) Withdraw amount");
            System.out.println("4) Transfer all balance to another account");
            System.out.println("5) Exit");

            System.out.print("Please enter your choice: ");
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    userAccount.printBalance();
                    break;
                case 2:
                    System.out.println("Enter the amount for deposit in range (0, 1000]");
                    int amountDeposit = scanner.nextInt();
                    try {
                        userAccount.deposit(amountDeposit);
                        System.out.println("Amount deposited");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter the amount for withdrawal (> 0)");
                    int amountWithdraw = scanner.nextInt();
                    try {
                        userAccount.withdraw(amountWithdraw);
                        System.out.println("Amount witdrawed");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    // In method logging (since also in-method ahndling of exception)
                    userAccount.transferBalance(anotherAccount);
                    break;
                case 5:
                    demonstrationIsOn = false;
                    break;
                default:
                    System.out.println("Invalid option of " + userInput + " provided. Try again.");
            }
        }
        System.out.println("See you another time!");
        scanner.close();
    }
}