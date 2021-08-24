package com.greatlearning.main;

import com.greatlearning.models.Customer;
import com.greatlearning.services.BankingService;
import java.util.Scanner;
import java.util.*;

public class Driver {
    public static void main(String[] args) {

        BankingService bankingService = new BankingService();
        bankingService.initialise();
        ArrayList<Customer> customerDB = bankingService.customerData.getCustomerDB();

        Scanner sc = new Scanner(System.in);
        String bankPassword;
        int bankAccountNo;

        System.out.println("Welcome to login page");
        System.out.println();
        System.out.println("Enter your account number");
        bankAccountNo = sc.nextInt();
        Customer guest = bankingService.validateAccountNumber(bankAccountNo, customerDB);
        if(guest != null )
        {
            System.out.println("Enter your password");
            bankPassword = sc.next();

            if(validateCustomer(bankPassword, guest)) {
                Customer loggedInCustomer = guest;
                System.out.println("Hello : "+ guest.getName());
                int option = 0;
                do {
                    System.out.println();
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("0. Logout");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Transfer");
                    System.out.println("4. Check info");
                    System.out.println("-------------------------------------------------------------------------");
                    option = sc.nextInt();

                    switch (option) {
                        case 0 -> bankingService.logout();
                        case 1 -> bankingService.deposit(loggedInCustomer);
                        case 2 -> bankingService.withdraw(loggedInCustomer, "withdraw");
                        case 3 -> bankingService.transfer(loggedInCustomer);
                        case 4 -> bankingService.getInfo(loggedInCustomer);
                        default -> System.out.println("Unexpected value: " + option + ", please enter correct option.");
                    }
                }
                while(option!=0);
            }
            else{
                System.out.println("Please enter valid credentials");
            }
        }
    }

    private static boolean validateCustomer (String password, Customer guest){
        return password.equals(guest.getPassword());
    }
}