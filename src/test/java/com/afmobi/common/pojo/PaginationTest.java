/*
 * Copyright 2006-2015 Transsion.com All right reserved. This software is the
 * confidential and proprietary information of Transsion.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Transsion.com.
 */
package com.afmobi.common.pojo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Pagination Tester.
 *
 * @author vincent
 * @version 1.0
 * @since <pre>Jul 25, 2018</pre>
 */
public class PaginationTest {

    @Test
    public void test(){
        Pagination.setIsBaseZero(false);
        Pagination p=new Pagination();
        p.setPage(1);
        Assert.assertEquals(Integer.valueOf(0),p.getFrom());

        Pagination.setIsBaseZero(true);
        p.setPage(1);
        Assert.assertEquals(p.getPagesize(),p.getFrom());
    }

} 
