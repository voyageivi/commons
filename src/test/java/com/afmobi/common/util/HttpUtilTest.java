/*
 * Copyright 2006-2015 Transsion.com All right reserved. This software is the
 * confidential and proprietary information of Transsion.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Transsion.com.
 */
package com.afmobi.common.util;

import com.afmobi.common.pojo.ParamMap;
import com.afmobi.common.pojo.StringMap;
import com.afmobi.common.web.httpclient.RequestBuilder;
import org.junit.Test;

/**
 * HttpUtil Tester.
 *
 * @author vincent
 * @version 1.0
 * @since <pre>六月 23, 2017</pre>
 */
public class HttpUtilTest  {

    /**
     * Method: get(RequestBuilder builder)
     */
    @Test
    public void testGet() throws Exception {
        String out=HttpUtil.get(HttpUtil.builder().setUrl("http://localhost:8080"));
        System.out.println(out);
    }

    /**
     * Method: post(RequestBuilder builder)
     */
    @Test
    public void testPost() throws Exception {
        String out=HttpUtil.post(HttpUtil.builder().setUrl("http://localhost:8080"));
        System.out.println(out);
    }

    @Test
    public void testPostBody(){
        String url="http://localhost:8081";
        ParamMap param=new ParamMap();
        param.add("test","test2");
        RequestBuilder builder= HttpUtil.builder(url,param);
        StringMap headers=new StringMap();
        headers.put("test1","test1");
        builder.setHeader(headers);
//        String out=HttpUtil.postBody(builder);
//        System.out.println(out);
    }

} 
