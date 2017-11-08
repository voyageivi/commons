/*
 * Copyright 2006-2015 Transsion.com All right reserved. This software is the
 * confidential and proprietary information of Transsion.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Transsion.com.
 */
package com.afmobi.common.util;

import com.afmobi.common.pojo.ObjectMap;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * ObjectUtil Tester.
 *
 * @author vincent
 * @version 1.0
 * @since <pre>十一月 8, 2017</pre>
 */
@RunWith(JUnit4.class)
public class ObjectUtilTest {

    /**
     * Method: toObjectMap(Object obj)
     */
    @Test
    public void testToObjectMap() throws Exception {
        A a=new A();
        a.setName("xx");
        a.setAge(12);
        ObjectMap map= ObjectUtil.toObjectMap(a);
        System.out.println(map);
    }


}

class A{
    String name;
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
