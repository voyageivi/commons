package com.afmobi.common.util;

import com.afmobi.common.pojo.ParamMap;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ClassName:   StringUtil
 * Date:        2017-06-23 17:03
 *
 * @author Vincent
 */
public class StringUtil {
    public static boolean hasLength(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean isEmpty(String str) {
        if (str == null) return true;
        return "".equals(str.trim());
    }

    public static String joinHttpParam(ParamMap paramMap) {
        if (paramMap == null) return "";
        List<String> strs = new ArrayList<String>();
        for (String key : paramMap.keySet()) {
            String val = null;
            try {
                val = URLEncoder.encode(String.valueOf(paramMap.get(key)), "utf-8");
            } catch (UnsupportedEncodingException e) {
                continue;
            }
            strs.add(key + "=" + val);
        }
        if (strs.size() == 0) return "";
        return join(strs, "&");
    }

    public static String join(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String item : list) {
            if (first)
                first = false;
            else
                sb.append(str);
            sb.append(item);
        }
        return sb.toString();
    }

    public static String replace(String str, Map<String, String> mapper) {
        if (!StringUtil.hasLength(str)) return "";
        for (Map.Entry<String, String> entry : mapper.entrySet()) {
            str = str.replaceAll(entry.getKey(), entry.getValue());
        }
        return str;
    }

    private String valOrNull(String str) {
        if (isEmpty(str)) return null;
        return str;
    }

}
