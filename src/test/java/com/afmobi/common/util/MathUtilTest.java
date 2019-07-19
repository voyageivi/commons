package com.afmobi.common.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * ClassName:   MathUtilTest
 * Date:        2019-07-19 10:33
 *
 * @author Vincent
 */
public class MathUtilTest {

    @Test
    public void percent() {
        Double d=1.0;
        Assert.assertEquals(d, MathUtil.percent(1, 100, 1));
        Assert.assertEquals((Double)20.1,MathUtil.percent(20.1, 100, 1));
        Assert.assertEquals((Double)20.1,MathUtil.percent(201, 1000, 1));
        Assert.assertEquals((Double)20.1,MathUtil.percent(201, 1000l, 1));
        Assert.assertEquals((Double)20.1,MathUtil.percent(201, 1000l, 2));
        Assert.assertEquals((Double)20.0,MathUtil.percent(201, 1000l, 0));
        Assert.assertEquals((Double)20.1,MathUtil.percent(201, 1000l));
    }
}