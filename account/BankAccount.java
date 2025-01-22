package account;

public class BankAccount implements IBankAccount {
    private double balance;

    public BankAccount() {
        System.out.println("Bank account created with the default balance value of " + balance);
    }

    public BankAccount(double balance) {
        try {
            /*
             * Reusing validation logic from deposit() here. This will work, since the
             * default value of balance is 0.0
             */
            deposit(balance);
            System.out.println("Bank account created with the default balance value of " + balance);
        } catch (Exception e) {
            System.out.println(
                    e.getMessage().replace("deposit", "create account with").replace(" Please try again.", ""));
            System.out.println("Bank account created with the initial balance value of " + balance);
        }

    }

    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Unable to deposit non-positive values of amount. Please try again.");
        } else if (amount > 1000) {
            throw new Exception("Unable to deposit large values (>1000) of amount at a time. Please try again.");
        } else {
            balance += amount;
        }
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= 0)
            throw new Exception("Ypu have provided a non-positive value. Withdrawal aborted.");
        else if (amount > balance)
            throw new Exception("Not enough funds.");
        balance -= amount;
    }

    public void printBalance() {
        System.out.println("The current balance is: " + balance);
    }

    public void transferBalance(IBankAccount account) {
        try {
            account.deposit(balance);
            balance = 0;
            System.out.println("Balance transferred succefully to a bank account with the address of " + account);
        } catch (Exception e) {
            System.out.println("Unable to transfer. " + e.getMessage());
        }

    }

}