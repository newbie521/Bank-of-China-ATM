package com.example.atm.util;

public class Fruit
{
    private String date;
    private String exchange;
    private String type;

    public Fruit(String date, String exchange, String type){
        this.date = date;
        this.exchange = exchange;
        this.type = type;
    }

    public String getDate(){
        return date;
    }

    public String getType() {
        return type;
    }

    public String getExchange() {
        return exchange;
    }


}