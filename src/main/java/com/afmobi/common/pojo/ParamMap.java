package com.afmobi.common.pojo;

/**
 * ClassName:   ParamMap
 * Date:        2017-06-23 17:22
 *
 * @author Vincent
 */
public class ParamMap extends ObjectMap {
    public static ParamMap newInstance() {
        return new ParamMap();
    }

    @Override
    public ParamMap add(String key, Object value) {
        this.put(key, value);
        return this;
    }
}
