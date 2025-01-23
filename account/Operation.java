package account;

import java.time.LocalDateTime;

public class Operation {
    private static int count = 0;
    private int id;
    private boolean isSuccess = false;
    private String name;
    private double amount;
    private LocalDateTime dateTime;

    public Operation(boolean isSuccess, String name, double amount) {
        this.id = ++count;
        this.isSuccess = isSuccess;
        this.name = name != null ? name : "UNKNOWN OPERATION";
        this.amount = amount > 0 ? amount : 0;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return id + " - " + (isSuccess ? "SUCCESS" : "ERROR") + " - " + name + " - " + amount + " - " + dateTime;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
