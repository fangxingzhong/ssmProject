package com.fang.bean;

public class Account {
    private String account;
    private double money;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account='" + account + '\'' +
                ", money=" + money +
                '}';
    }
}
