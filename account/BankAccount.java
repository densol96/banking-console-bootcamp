package account;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BankAccount implements IBankAccount {
    private static int count = 0;
    private int id;
    private double balance;
    private List<Operation> operationHistory = new ArrayList<>();

    public BankAccount() {
        id = ++count;
        // first depost record will display an actual amount
        operationHistory.add(new Operation(true, "Account created", 0));

    }

    public BankAccount(double balance) {
        id = ++count;
        // first depost record will display an actual amount
        operationHistory.add(new Operation(true, "Account created", 0));
        try {
            /*
             * Reusing validation logic from deposit() here. This will work, since the
             * default value of balance is 0.0
             */
            deposit(balance);
        } catch (Exception e) {
            System.out.println(
                    e.getMessage().replace("deposit", "create account with").replace(" Please try again.", ""));
        }

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            operationHistory.add(new Operation(false, "Deposit", amount));
            throw new Exception("Unable to deposit non-positive values of amount. Please try again.");
        } else if (amount > 1000) {
            operationHistory.add(new Operation(false, "Deposit", amount));
            throw new Exception("Unable to deposit large values (>1000) of amount at a time. Please try again.");
        } else {
            balance += amount;
            operationHistory.add(new Operation(true, "Deposit", balance));
        }
    }

    @Override
    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            operationHistory.add(new Operation(false, "Withdraw", amount));
            throw new Exception("You have provided a non-positive value. Withdrawal aborted.");
        }

        else if (amount > balance) {
            operationHistory.add(new Operation(false, "Withdraw", amount));
            throw new Exception("Not enough funds.");
        }
        balance -= amount;
        operationHistory.add(new Operation(true, "Withdraw", amount));
    }

    @Override
    public void printBalance() {
        System.out.println("The current balance is: " + balance);
        operationHistory.add(new Operation(true, "Balance printed", balance));
    }

    @Override
    public void transferToAnotherAccount(IBankAccount account, double amount) throws Exception {
        if (account == null) {
            operationHistory.add(new Operation(false, "Balance transfer", balance));
            throw new Exception("Invalid other account provided (null). Unable to transfer.");

        }
        if (amount > balance) {
            operationHistory.add(new Operation(false, "Balance transfer", balance));
            throw new Exception("Not enough funds. Unable to transfer.");
        }
        try {
            account.deposit(amount);
            balance -= amount;
            operationHistory.add(new Operation(true, "Balance transfer", balance));
        } catch (Exception e) {
            operationHistory.add(new Operation(false, "Balance transfer", balance));
            throw new Exception("Unable to transfer. " + e.getMessage());
        }
    }

    @Override
    public void getTxtRecordOfOperations() throws Exception {
        try (FileWriter fileWriter = new FileWriter("output_txt_reports/bank_account_" + id + ".txt");
                PrintWriter printWriter = new PrintWriter(fileWriter)) {

            for (Operation line : operationHistory) {
                printWriter.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new Exception("An error occurred while writing to the file.");
        }
    }

    @Override
    public String toString() {
        return "ID -> " + id;
    }

}