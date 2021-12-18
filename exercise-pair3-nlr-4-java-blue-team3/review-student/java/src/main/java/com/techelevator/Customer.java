package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Customer extends Person implements Billable {
    private String phoneNumber;
    private List<Pet> pets = new ArrayList<>();

    public Customer(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName);
        this.phoneNumber = phoneNumber;
    }

    public Customer(String firstName, String lastName) {
        this(firstName, lastName, ""); //new Customer or this?


    }

    @Override
    public double getBalanceDue(Map<String, Double> servicesRendered) {
        double total = 0;
        for (double temp : servicesRendered.values()){
            total += temp;
        }
        return total;
    }
}
