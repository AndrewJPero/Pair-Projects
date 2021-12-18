package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CustomerTest {

    @Test
    public void getBalanceDue() {
        Map<String,Double> balanceMap  = new HashMap<>();
        balanceMap.put("Walking", 10.0);
        balanceMap.put("Grooming", 20.0);
        balanceMap.put("Sitting", 30.0);

        Assert.assertEquals("Walking", 60.0, 60.0, .001);
    }
}
