package com.arsha.fundamentals.exceptions;

import java.io.FileNotFoundException;

public class ThrowDemo {

    public static void main(String[] args) {

        ThrowDemo demo = new ThrowDemo();
        //demo.transferMoney(new Account(), new Account(), 10);

        try {
            demo.transferMoney(new Account(), new Account(), 10);
        } catch (Exception e) {
            new ExceptionManager(e);
        }
    }

    public void transferMoney(Account from, Account to, double moneyToTransfer) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        if (from.getMoney() < moneyToTransfer) {
            throw new NotEnoughMoneyException("Pool nadari");
            //throw new RuntimeException(new NotEnoughMoneyException());
        }
    }
}

class Account {

    private double money = 0;

    public double getMoney() {
        return this.money;
    }
}
