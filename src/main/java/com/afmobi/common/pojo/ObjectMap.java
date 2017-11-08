package com.afmobi.common.pojo;

import java.util.HashMap;

/**
 * ClassName:   ParamMap
 * Date:        2017-06-23 17:22
 *
 * @author Vincent
 */
public class ObjectMap extends HashMap<String,Object>{
    public static ObjectMap newInstance(){
        return new ObjectMap();
    }
    public ObjectMap add(String key, Object value){
        this.put(key,value);
        return this;
    }
}
