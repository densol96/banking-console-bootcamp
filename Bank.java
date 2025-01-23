import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import account.BankAccount;
import account.IBankAccount;

public class Bank {
    private Map<Integer, IBankAccount> accounts = new LinkedHashMap<>();

    public Bank(int numAccounts) {
        generateAccounts(numAccounts);
    }

    private void generateAccounts(int n) {
        final int MAX_BALANCE_LIMIT = 300;
        for (int i = 0; i < n; i++) {
            IBankAccount account = new BankAccount((int) (Math.random() * MAX_BALANCE_LIMIT + 1)); // 0 - 300
            accounts.put(account.getId(), account);
        }
    }

    public void addAccount(IBankAccount account) {
        accounts.put(account.getId(), account);
    }

    public IBankAccount getAccount(int id) {
        return accounts.get(id);
    }

    public Collection<IBankAccount> getAccounts() {
        return accounts.values();
    }
}