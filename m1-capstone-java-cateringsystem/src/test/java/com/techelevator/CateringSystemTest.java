package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CateringSystemTest {
    private CateringSystem cateringSystem;

    @Before
    public void setup(){
        cateringSystem= new CateringSystem();
    }



    @Test
    public void update_shopping_balance_zero_quantity(){

        float testBalance= cateringSystem.getCurrentAccountBalance();
        float actualBalance= cateringSystem.updatingBalanceAfterShopping(5,0);
        Assert.assertEquals(testBalance, actualBalance,.009);
    }


    @Test
    public void update_shopping_balance_with_quantity(){

        float testBalance= -10;
        float actualBalance= cateringSystem.updatingBalanceAfterShopping(5,2);
        Assert.assertEquals(testBalance, actualBalance,.009);
    }

    @Test
    public void reset_Balance(){
        float testBalance= 0;
        float actualBalance= cateringSystem.resetBalance();
        Assert.assertEquals(testBalance,actualBalance, .009);
    }

    @Test
    public void adding_more_than_500_at_one_time(){
        float testBalance=0;

   //     float actualBalance = cateringSystem.addMoney(501);
    }
}


