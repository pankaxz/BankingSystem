package com.greatlearning.models;

import java.util.ArrayList;

public class CustomerData {
    ArrayList<Customer> customerDB = new ArrayList<>();
    public void setCustomerDB()
    {
        customerDB.add(new Customer("pass", 1, 1000,"Pankaj"));
        customerDB.add(new Customer("pass", 2, 1000,"Swabhiman"));
        customerDB.add(new Customer("pass", 3, 1000,"Ruhina"));
        customerDB.add(new Customer("pass", 4, 1000,"Rohit"));
        customerDB.add(new Customer("pass", 5, 1000,"Gaurav"));
        customerDB.add(new Customer("pass", 6, 1000,"Ayush"));
        customerDB.add(new Customer("pass", 7, 1000,"Mangesh"));
        customerDB.add(new Customer("pass", 8, 1000,"Nandhini"));
        customerDB.add(new Customer("pass", 9, 1000,"Jai"));
        customerDB.add(new Customer("pass", 10, 1000,"Harshita"));
    }
    public ArrayList<Customer>  getCustomerDB()
    {
        return customerDB;
    }
}

