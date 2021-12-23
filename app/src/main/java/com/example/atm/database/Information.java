package com.example.atm.database;

import org.litepal.crud.DataSupport;

import java.security.PrivateKey;

// 交易明细
public class Information extends DataSupport
{
    private String account;
    private String date;
    private String exchange;
    private String type;

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getExchange() {
        return exchange;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
