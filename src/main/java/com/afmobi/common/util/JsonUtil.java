package com.afmobi.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

/**
 * ClassName:   JsonUtil
 * Date:        2018-07-18 15:19
 *
 * @author Vincent
 */
public class JsonUtil {
    private static final Logger logger = Logger.getLogger(FileUtil.class);

    public static <T> T parseObject(Object video, Class<T> clazz) {
        String json = JSON.toJSONString(video);
        try {
            return JSON.parseObject(json, clazz);
        } catch (Exception e) {
            logger.error("parse object fail, json: " + json);
        }
        return null;
    }
}
