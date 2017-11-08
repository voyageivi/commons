/*
 * Copyright 2006-2015 Transsion.com All right reserved. This software is the
 * confidential and proprietary information of Transsion.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Transsion.com.
 */
package com.afmobi.common.util;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ProbabilityUtil Tester.
 *
 * @author vincent
 * @version 1.0
 * @since <pre>八月 9, 2017</pre>
 */
public class ProbabilityUtilTest {

    /**
     * Method: random(ProbabilityConfig<T> probabilityConfig)
     */
    @Test
    public void testRandom() throws Exception {
        Set<ProbabilityUtil.Probability<Integer>> probs = new HashSet<ProbabilityUtil.Probability<Integer>>();
        probs.add(new ProbabilityUtil.Probability<Integer>(1, 10));
        probs.add(new ProbabilityUtil.Probability<Integer>(3, 30));
        probs.add(new ProbabilityUtil.Probability<Integer>(2, 20));
        probs.add(new ProbabilityUtil.Probability<Integer>(4, 40));
        ProbabilityUtil.ProbabilityConfig<Integer> config=ProbabilityUtil.config(probs);
        System.out.println(config);
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        int n=1000;
        for (int i = 0; i < n; i++) {
            Integer x = ProbabilityUtil.random(config);
            if(map.containsKey(x)){
                map.put(x, map.get(x)+1);
            }else{
                map.put(x, 1);
            }
        }
        for(Integer key: map.keySet()){
            System.out.println("key: "+key+"\tcount: "+map.get(key)+"\t p:"+map.get(key)*100.0/n);
        }

    }

}
