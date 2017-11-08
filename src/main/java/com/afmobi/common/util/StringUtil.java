package com.afmobi.common.util;

import com.afmobi.common.pojo.ParamMap;
import com.google.common.base.Objects;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName:   StringUtil
 * Date:        2017-06-23 17:03
 *
 * @author Vincent
 */
public class StringUtil {
    public static boolean hasLength(String filename) {
        return filename!=null&&filename.length()>0;
    }

    public static String joinHttpParam(ParamMap paramMap) {
        if(paramMap==null) return "";
        StringBuilder sb=new StringBuilder();
        List<String> strs=new ArrayList<String>();
        for(String key: paramMap.keySet()){
            strs.add(key+"="+URLEncoder.encode((String) paramMap.get(key)));
        }
        if(strs.size()==0) return "";
        return join(strs,"&");
    }

    public static String join(List<String> list, String conjunction) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String item : list)
        {
            if (first)
                first = false;
            else
                sb.append(conjunction);
            sb.append(item);
        }
        return sb.toString();
    }

}
