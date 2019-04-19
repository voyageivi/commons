package com.afmobi.common.pojo;

import org.junit.Assert;
import org.junit.Test;

/**
 * ClassName:   KeyValueVOTest
 * Date:        2019-04-11 11:37
 *
 * @author Vincent
 */
public class KeyValueVOTest {
    @Test
    public void test1() {
        KeyValueVO<String, String> kv = new KeyValueVO<String, String>();
        Assert.assertNull(kv.getKey());
        Assert.assertNull(kv.getValue());

        kv = KeyValueVO.of("k1", "k2");
        Assert.assertEquals("k1", kv.getKey());
        Assert.assertEquals("k2", kv.getValue());


    }
}
