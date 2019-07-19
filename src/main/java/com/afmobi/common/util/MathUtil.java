/*
 * TOP SECRET
 * Copyright 2006-2015 Transsion.com All right reserved. This software is the
 * confidential and proprietary information of Transsion.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Transsion.com.
 */
package com.afmobi.common.util;

import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;

/**
 * ClassName:MathUtil
 * Date:     2017年1月19日 下午3:40:06
 *
 * @author vincent
 * @see
 */
public class MathUtil {
    //    return Math.round(num * Math.pow(10, len)) / Math.pow(10, len);
    public static Double round(Double num, int len) {
        if (num == null) {
            return 0.0;
        }
        return Math.round(num * Math.pow(10.0, len)) / Math.pow(10, len);
    }

    public static Double toDouble(Object object) {
        Double fee = 0.0;
        if (object != null) {
            fee = Doubles.tryParse(object.toString());
            if (fee == null) {
                fee = 0.0;
            }
        }
        return fee;
    }

    public static Integer toInt(String x) {
        if (x == null) {
            return null;
        }
        return Ints.tryParse(x);
    }

    public static Integer toInt(Double x) {
        if (x == null) {
            return 0;
        }
        return x.intValue();
    }

    public static Double percent(Number x, Number y, Integer len) {
        if (x == null || y == null || y.doubleValue() == 0) {
            return null;
        }
        return round(100.0 * x.doubleValue() / y.doubleValue(), len);
    }
    public static Double percent(Number x, Number y) {
        if (x == null || y == null || y.doubleValue() == 0) {
            return null;
        }
        return round(100.0 * x.doubleValue() / y.doubleValue(), 1);
    }
}
