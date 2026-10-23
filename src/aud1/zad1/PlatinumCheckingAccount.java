package aud1.zad1;

public class PlatinumCheckingAccount extends InterestCheckingAccount {

    public PlatinumCheckingAccount(String name, double amount) {
        super(name, amount);
    }

    @Override
    public void addInterest() {
        double interest = this.amount * InterestCheckingAccount.INTEREST_RATE*2;
        deposit(interest);
    }
}
