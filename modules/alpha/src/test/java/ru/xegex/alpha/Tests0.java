package ru.xegex.alpha;

import org.junit.Assert;
import org.junit.Test;

public class Tests0 {
    @Test
    public void integerErr() {

        Integer a1 = 300;
        Integer a2 = 300;

        Assert.assertFalse(a1 == a2);
        Assert.assertTrue(a1 >= a2);
        Assert.assertTrue(a1 <= a2);

    }

    @Test
    public void integerOk() {

        Integer a1 = 127;
        Integer a2 = 127;

        Assert.assertTrue(a1 == a2);
        Assert.assertTrue(a1 >= a2);
        Assert.assertTrue(a1 <= a2);

    }

    @Test
    public void unsafe() {
//        Unsafe unsafe = Unsafe.getUnsafe();
    }
}
