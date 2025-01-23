package account;

import java.io.IOException;

public interface IBankAccount {
    void deposit(double amount) throws Exception;

    void withdraw(double amount) throws Exception;

    void printBalance();

    void transferToAnotherAccount(IBankAccount account, double amount) throws Exception;

    void getTxtRecordOfOperations() throws Exception;

    int getId();
}
