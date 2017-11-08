package com.afmobi.common.util;

import com.afmobi.common.pojo.ObjectMap;
import com.afmobi.common.pojo.ParamMap;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ClassName:   ObjectUtil
 * Date:        2017-11-08 14:08
 *
 * @author Vincent
 */
public class ObjectUtil {
    public static ParamMap toObjectMap(Object obj) {
        if(obj instanceof ParamMap){
            return (ParamMap) obj;
        }
        ParamMap map = new ParamMap();
        if (obj == null) {
            return map;
        } else if (!(obj instanceof Map)) {
            try {
                BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
                PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

                for (int i = 0; i < pds.length; ++i) {
                    PropertyDescriptor property = pds[i];
                    String key = property.getName();
                    if (!"class".equals(key)) {
                        Method getter = property.getReadMethod();
                        Object value = getter.invoke(obj, new Object[0]);
                        if (value != null) {
                            map.put(key, value);
                        }
                    }
                }

                return map;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            Iterator e = ((Map) obj).keySet().iterator();

            while (e.hasNext()) {
                Object propertyDescriptors = e.next();
                map.put(propertyDescriptors.toString(), ((Map) obj).get(propertyDescriptors));
            }

            return map;
        }
    }
}
