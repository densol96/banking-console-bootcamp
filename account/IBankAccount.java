package account;

import java.io.IOException;

public interface IBankAccount {
    public void deposit(double amount) throws Exception;

    public void withdraw(double amount) throws Exception;

    public void printBalance();

    public void transferToAnotherAccount(IBankAccount account, double amount) throws Exception;

    void getTxtRecordOfOperations() throws Exception;

    int getId();
}
