package com.afmobi.common.web.httpclient;

import com.afmobi.common.pojo.ObjectMap;
import com.afmobi.common.pojo.ParamMap;
import com.afmobi.common.pojo.StringMap;
import com.afmobi.common.util.ObjectUtil;

/**
 * ClassName:   F
 * Date:        2017-06-23 17:04
 *
 * @author Vincent
 */
public class RequestBuilder extends GlobalBulider {

    ParamMap paramMap;
    String url;
    HttpHandler httpHandler;
    StringMap header;

    public RequestBuilder(GlobalBulider initParams) {
        this.proxyIP=initParams.getProxyIP();
        this.proxyPort=initParams.getProxyPort();
        this.readTimeout=initParams.getReadTimeout();
        this.connectTimeout=initParams.getConnectTimeout();
    }

    public ParamMap getParamMap() {
        return paramMap;
    }

    public RequestBuilder setParamMap(ParamMap paramMap) {
        this.paramMap = paramMap;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public RequestBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public StringMap getHeader() {
        return header;
    }

    public RequestBuilder setHeader(StringMap header) {
        this.header = header;
        return this;
    }
    public HttpHandler getHttpHandler() {
        return httpHandler;
    }

    public RequestBuilder setHttpHandler(HttpHandler httpHandler) {
        this.httpHandler = httpHandler;
        return this;
    }
}
