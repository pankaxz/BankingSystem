package com.greatlearning.models;

import java.util.ArrayList;


public class CustomerData {
    ArrayList<Customer> customerDB = new ArrayList<>();
    public void setCustomerDB()
    {
        customerDB.add(new Customer("pass", 1, 1000,"Pankaj"));
        customerDB.add( new Customer("pass", 2, 1000,"Swabhiman"));
        customerDB.add(new Customer("pass", 3, 1000,"Ruhina"));
        customerDB.add(new Customer("pass", 4, 1000,"Rohit"));
        customerDB.add(new Customer("pass", 5, 1000,"Gaurav"));
    }
    public ArrayList<Customer>  getCustomerDB()
    {
        return customerDB;
    }
}

