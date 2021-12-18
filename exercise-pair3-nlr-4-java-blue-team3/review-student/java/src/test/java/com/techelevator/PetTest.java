package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class PetTest {

    private Pet pet;

    @Test
    public void listVaccinations() {
        List<String> resultList = new ArrayList<>();

        resultList.add("Rabies");
        resultList.add("Distemper");
        resultList.add("Parvo");

        String vaccinationsResults = String.join(", ", resultList); //string.join converts the list to strings, delimiter comes after each string

        Assert.assertEquals("Rabies, Distemper, Parvo", vaccinationsResults);

    }
}
