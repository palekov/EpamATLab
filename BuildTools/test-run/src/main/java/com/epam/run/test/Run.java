package com.epam.run.test;

import org.junit.Assert;
import org.junit.Test;

public class Run {
    private int less = 1;
    private int more = 2;

    @Test
    public void positiveTest() {
        Assert.assertTrue(more > less);
        System.out.println("Passed");
    }

    @Test
    public void negativeTestMore() {
        Assert.assertTrue(less > more);
    }

    @Test
    public void negativeTestEquals() {
        Assert.assertTrue(less == more);
    }

}
