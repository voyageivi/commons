package com.afmobi.common.web.httpclient;

import com.afmobi.common.util.StringUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ClassName:   GetProcessor
 * Date:        2017-06-23 18:23
 *
 * @author Vincent
 */
public class GetMethod extends Processor {

    public GetMethod(RequestBuilder builder) {
        super(builder);
    }

    @Override
    protected URL getURL(RequestBuilder request) throws MalformedURLException {
        String url=request.getUrl();

        if(request.getParamMap()!=null && request.getParamMap().size()>0) {
            String param = StringUtil.joinHttpParam(request.getParamMap());
            url=url+"?"+param;
            return new URL(url);
        }
        return new URL(url);
    }

}
