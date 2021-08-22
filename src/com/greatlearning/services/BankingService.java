package com.greatlearning.services;

import com.greatlearning.models.Customer;
import com.greatlearning.models.CustomerData;

import java.util.ArrayList;
import java.util.Scanner;

public class BankingService {
    public CustomerData customerData = new CustomerData();
    public void initialise()
    {
        customerData.setCustomerDB();
    }

    Scanner sc = new Scanner(System.in);
    int bankBalance = 1000;
    int amount;

    public void logout(){
        System.out.println("--------------------Thank you from banking with us-----------------------------");
    }

    public void deposit(Customer customer)
    {

        System.out.println("Enter the deposit amount");
        amount = sc.nextInt();

        if(amount > 0){
            System.out.println("Amount deposited successfully");
            customer.setBalance(customer.getBalance()+amount);
            System.out.println("Remaining balance : "+ customer.getBalance());
        }
    }

    public void withdraw(Customer customer, String operation)
    {
        System.out.println("Enter the amount to "+ operation);
        amount = sc.nextInt();
        if(customer.getBalance() >= amount)
        {
            customer.setBalance(customer.getBalance()-amount);
            switch (operation)
            {
                case "withdraw":
                        System.out.println("Amount deducted successfully");
                    break;

                case "transfer":
                    System.out.println("Amount transferred successfully");
                    break;
            }
            System.out.println("Remaining balance : "+ customer.getBalance());
        }

        else {
            System.out.println("Insufficient balance!");
        }
    }

    public void transfer(Customer customer1)
    {
        int otp;
        int otpGenerated;
        int toBeTransferredAccountNo;

        System.out.println("Enter the OTP");
        OTPService otpService = new OTPService();
        otpGenerated = otpService.generateOTP();

        System.out.println("Generated OTP : "+otpGenerated);
        otp = sc.nextInt();

        if(otp == otpGenerated)
        {
            System.out.println("OTP Validation successful");
            System.out.println("Enter the recipient's account number");
            toBeTransferredAccountNo = sc.nextInt();
            Customer recipient = validateAccountNumber(toBeTransferredAccountNo, customerData.getCustomerDB());

            if( recipient != null){
                withdraw(customer1, "transfer");
                recipient.setBalance(recipient.getBalance()+amount);
            }else{
                System.out.println("Account not found");
            }
        }
    }

    public void getInfo(Customer customer)
    {
        char current;
        System.out.println("Do you want to get information for the current account ?");
        current = sc.next().charAt(0);
        if(current == 'y' || current == 'Y' )
        {
            System.out.println("Account number : " + customer.getBalance());
            System.out.println("Account Holder Name : " + customer.getName());
        }
        else {
            System.out.println("Enter Account number");
            int guestAccountNumber = sc.nextInt();
            System.out.println("Enter Password");
            String guestAccountPassword = sc.next();

            Customer guest = validateAccountNumber(guestAccountNumber, customerData.getCustomerDB());
            if(guest!= null && guest.getPassword().equals(guestAccountPassword))
            {
                System.out.println(guest.getBalance());
            }
            else {System.out.println("Invalid credentials");}
        }
    }


    public Customer validateAccountNumber (int accountNumber, ArrayList<Customer> customerDB)
    {
        Customer guest;
        for (Customer customer : customerDB) {
            if (customer.getAccountNumber() == accountNumber) {
                guest = customer;
                return guest;
            }
        }
        System.out.println("Customer not found");
        return null;
    }

}
