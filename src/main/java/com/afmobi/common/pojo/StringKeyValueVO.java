package com.afmobi.common.pojo;

/**
 * ClassName:   StringKeyValueVO
 * Date:        2019-07-16 10:48
 *
 * @author Vincent
 */
public class StringKeyValueVO extends KeyValueVO<String, String> {
    public static StringKeyValueVO of(String key, String value) {
        StringKeyValueVO rtn = new StringKeyValueVO();
        rtn.setKey(key);
        rtn.setValue(value);
        return rtn;
    }
}
