package com.techelevator;

import com.techelevator.items.CateringItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CateringSystemTest {
    private CateringSystem cateringSystem;

    @Before
    public void setup() {
        cateringSystem = new CateringSystem();
    }


    @Test
    public void update_shopping_balance_zero_quantity() {

        float testBalance = cateringSystem.getCurrentAccountBalance();
        float actualBalance = cateringSystem.updatingBalanceAfterShopping(5, 0);
        Assert.assertEquals(testBalance, actualBalance, .009);
    }


    @Test
    public void update_shopping_balance_with_quantity() {

        float testBalance = -10;
        float actualBalance = cateringSystem.updatingBalanceAfterShopping(5, 2);
        Assert.assertEquals(testBalance, actualBalance, .009);
    }

    @Test
    public void reset_Balance() {
        float testBalance = 0;
        float actualBalance = cateringSystem.resetBalance();
        Assert.assertEquals(testBalance, actualBalance, .009);
    }

    @Test
    public void adding_more_than_500_at_one_time() {
        float testBalance = 0;

        //     float actualBalance = cateringSystem.addMoney(501);
    }

    @Test
    public void making_change_correctly() {

        float testBalance = 45;

        Map<Float, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put(50F,0);
        expectedResult.put(20F,2 );
        expectedResult.put(10F,0);
        expectedResult.put(5F,1);
        expectedResult.put(1F,0);
        expectedResult.put(.25F,0);
        expectedResult.put(.1F,0);
        expectedResult.put(.05F,0);

        Map<Float,Integer> result = cateringSystem.makeChange(testBalance);
        Assert.assertEquals(expectedResult, result);
    }
//@Test
}
