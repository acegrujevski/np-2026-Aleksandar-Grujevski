package aud1.zad1;

public abstract class Account {

    private String name;
    private int accountId;
    private static int ID = 1;



    protected double amount;

    public Account(String name, double amount) {
        this.name = name;
        this.accountId = ID++;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void withdraw(double amount){
        this.amount -= amount;
        System.out.println("Withdraw: " + amount + "$ to account: " + name);
    }

    public void deposit(double amount){
        this.amount += amount;
        System.out.println("Deposit: " + amount + "$ to account: " + name);
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", accountId=" + accountId +
                ", amount=" + amount +
                '}';
    }
}
