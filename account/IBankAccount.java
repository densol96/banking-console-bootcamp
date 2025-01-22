package account;

public interface IBankAccount {
    public void deposit(double amount) throws Exception;

    public void withdraw(double amount) throws Exception;

    public void printBalance();

    public void transferBalance(IBankAccount account);
}
