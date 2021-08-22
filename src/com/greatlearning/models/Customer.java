package com.greatlearning.models;

public class Customer {
    public Customer(String password, int accountNumber, int balance, String name)
    {
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
    }

    public Customer(){
    }

    private String name;
    private String password;
    private int accountNumber;
    private int balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
