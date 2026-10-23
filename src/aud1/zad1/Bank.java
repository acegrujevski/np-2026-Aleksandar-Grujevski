package aud1.zad1;

import java.util.*;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account a1) {
        accounts.add(a1);
    }

    public double getTotalAssets() {
        double total = 0;
        for (Account a : accounts) total += a.getAmount();
        return total;
    }

    public void addInterest() {
        for (Account a : accounts){
            if (a instanceof InterestBearingAccount) {
                InterestBearingAccount iba = (InterestBearingAccount)a;
                iba.addInterest();
            }
        }
    }
}
