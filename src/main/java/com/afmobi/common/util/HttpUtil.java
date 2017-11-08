package com.afmobi.common.util;

import com.afmobi.common.pojo.ParamMap;
import com.afmobi.common.pojo.StringMap;
import com.afmobi.common.web.httpclient.*;

import java.net.HttpURLConnection;


/**
 * @author vincent
 * @version 2012-6-20 上午11:27:13
 */
public class HttpUtil {
    private static GlobalBulider globalBulider=new GlobalBulider();
    static {
        globalBulider.setConnectTimeout(60*1000);
        globalBulider.setReadTimeout(60*1000);
        HttpURLConnection.setFollowRedirects(true);
    }
    private HttpUtil(){}
    public static GlobalBulider getGlobal() {
        return globalBulider;
    }

    public static RequestBuilder builder(){
        return new RequestBuilder(getGlobal());
    }
    public static RequestBuilder builder(String url,ParamMap params){
        RequestBuilder rtn=new RequestBuilder(getGlobal());
        rtn.setUrl(url);
        rtn.setParamMap(params);
        return rtn;
    }
    public static RequestBuilder builder(String url, ParamMap params, HttpHandler handler){
        RequestBuilder rtn=new RequestBuilder(getGlobal());
        rtn.setUrl(url);
        rtn.setParamMap(params);
        rtn.setHttpHandler(handler);
        return rtn;
    }
    public static RequestBuilder builder(String url, HttpHandler handler){
        RequestBuilder rtn=new RequestBuilder(getGlobal());
        rtn.setUrl(url);
        rtn.setHttpHandler(handler);
        return rtn;
    }

    //------------- get -------------
    public static String get(RequestBuilder builder) {
        return new GetMethod(builder).execute();
    }

    public static String get(String url){
        RequestBuilder builder=builder();
        builder.setUrl(url);
        return get(builder);
    }
    public static String get(String url, ParamMap params){
        RequestBuilder builder=builder(url,params);
        return get(builder);
    }
    public static String get(String url, Object params){
        RequestBuilder builder=builder(url,ObjectUtil.toObjectMap(params));
        return get(builder);
    }

    //------------- post -------------
    public static String post(RequestBuilder builder) {
        return new PostMethod(builder).execute();
    }

    public static String post(String url){
        RequestBuilder builder=builder();
        builder.setUrl(url);
        return post(builder);
    }
    public static String post(String url, ParamMap params){
        RequestBuilder builder=builder(url,params);
        return post(builder);
    }
    public static String post(String url, Object params){
        RequestBuilder builder=builder(url,ObjectUtil.toObjectMap(params));
        return post(builder);
    }


    //------------- post json -------------

    public static String postJSON(RequestBuilder builder){
        return new PostJSONMethod(builder).execute();
    }
    public static String postJSON(String url, Object param, StringMap header){
        RequestBuilder builder=builder(url,ObjectUtil.toObjectMap(param));
        builder.setHeader(header);
        return postJSON(builder);
    }
    public static String postJSON(String url, Object param){
        RequestBuilder builder=builder(url,ObjectUtil.toObjectMap(param));
        return postJSON(builder);
    }
    public static String postJSON(String url, ParamMap param, StringMap header){
        RequestBuilder builder=builder(url,param);
        builder.setHeader(header);
        return postJSON(builder);
    }
    public static String postJSON(String url, ParamMap param){
        RequestBuilder builder=builder(url,param);
        return postJSON(builder);
    }

}
