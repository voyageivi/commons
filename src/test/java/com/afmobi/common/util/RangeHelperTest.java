package com.afmobi.common.util;

import com.google.common.collect.Ordering;
import org.junit.Test;

/**
 * ClassName:   RangeHelperTest
 * Date:        2019-04-19 20:42
 *
 * @author Vincent
 */
public class RangeHelperTest {


    @Test
    public void testInit() {
        Ordering<Integer> naturalOrdering = Ordering.natural();
        RangeHelper<Integer> rangeHelper = new RangeHelper<Integer>(naturalOrdering);
        rangeHelper.init(1, 5, 10);
        System.out.println(rangeHelper.ranges);
    }

    @Test
    public void testInit2() {
        Ordering<Integer> naturalOrdering = Ordering.natural();
        RangeHelper<Integer> rangeHelper = new RangeHelper<Integer>(naturalOrdering);
        rangeHelper.init(
                new RangeHelper.Range<Integer>(1, 3),
                new RangeHelper.Range<Integer>(1, 9),
                new RangeHelper.Range<Integer>(10, 9),
                new RangeHelper.Range<Integer>(2, 5));
        System.out.println(rangeHelper.ranges);
    }

    @Test
    public void testFindRange() {
        Ordering<Integer> naturalOrdering = Ordering.natural();
        RangeHelper<Integer> rangeHelper=new RangeHelper<Integer>(naturalOrdering);
        rangeHelper.init(1, 5, 10);
        RangeHelper.Range<Integer> range = rangeHelper.findRange(5);
        System.out.println(range);
    }

}