package com.example.atm.database;

import org.litepal.crud.DataSupport;

import java.util.List;
import java.util.Map;

public class Acc extends DataSupport {

    private String account;
    private String password;
    private int balance;
//    当日可用金额
    private int avi_balance;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAvi_balance() {
        return avi_balance;
    }

    public void setAvi_balance(int avi_balance) {
        this.avi_balance = avi_balance;
    }


}
