package com.sony.assignment;

import com.sony.assignment.model.Byteland;
import com.sony.assignment.unification.CaseHandler;
import com.sony.assignment.unification.UnificationScheduler;
import org.junit.Assert;
import org.junit.Test;

public class AppTest
{
    @Test
    public void testCaseWithFourCities()
    {
        Byteland byteland = new Byteland(4, new int[]{0, 1, 2});
        UnificationScheduler unificationScheduler = new UnificationScheduler(byteland);
        Assert.assertEquals(2, unificationScheduler.calculateStepCount());
    }

    @Test
    public void testCaseWithEightCities()
    {
        Byteland byteland = new Byteland(8, new int[]{0, 1, 2, 0, 0, 3, 3});
        UnificationScheduler unificationScheduler = new UnificationScheduler(byteland);
        Assert.assertEquals(4, unificationScheduler.calculateStepCount());
    }

    @Test
    public void testCaseWithNineCities()
    {
        Byteland byteland = new Byteland(9, new int[]{0, 1, 1, 1, 1, 0, 2, 2});
        UnificationScheduler unificationScheduler = new UnificationScheduler(byteland);
        Assert.assertEquals(5, unificationScheduler.calculateStepCount());
    }
}
