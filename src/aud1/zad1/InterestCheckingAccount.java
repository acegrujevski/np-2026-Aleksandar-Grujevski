package aud1.zad1;

public class InterestCheckingAccount extends Account implements InterestBearingAccount {

    public static double INTEREST_RATE = 0.03;

    public InterestCheckingAccount(String name, double amount) {
        super(name, amount);
    }

    @Override
    public void addInterest() {
        double interest = this.amount * INTEREST_RATE;
        deposit(interest);
    }


}
