/*
 * Copyright 2006-2015 Transsion.com All right reserved. This software is the
 * confidential and proprietary information of Transsion.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Transsion.com.
 */
package com.afmobi.common.util;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * CollectionUtil Tester.
 *
 * @author vincent
 * @version 1.0
 * @since <pre>Aug 20, 2018</pre>
 */
public class CollectionUtilTest {

    /**
     * Method: hasContent(Collection collection)
     */
    @Test
    public void testHasContentCollection() throws Exception {

    }

    /**
     * Method: isEmpty(Collection collection)
     */
    @Test
    public void testIsEmptyCollection() throws Exception {

    }

    /**
     * Method: hasContent(Map map)
     */
    @Test
    public void testHasContentMap() throws Exception {

    }

    /**
     * Method: isEmpty(Map map)
     */
    @Test
    public void testIsEmptyMap() throws Exception {

    }

    /**
     * Method: contain(Collection<T> list, Predicate<T> predicate)
     */
    @Test
    public void testContainForListPredicate() throws Exception {

    }

    /**
     * Method: contain(Collection<T> list, T obj)
     */
    @Test
    public void testContainForListObj() throws Exception {

    }

    /**
     * Method: match(Map<K, V> rtn, Predicate<K> p)
     */
    @Test
    public void testMatch() throws Exception {

    }

    /**
     * Method: distinct(List<T> arr, Function<T, String> keyFunc)
     */
    @Test
    public void testDistinct() throws Exception {
        List<String> arr = Lists.newArrayList("a", "b", "b", "c");
        arr=CollectionUtil.distinct(arr, new Function<String, String>() {
            public String apply(String input) {
                return input;
            }
        });
        System.out.println(arr);
    }


} 
