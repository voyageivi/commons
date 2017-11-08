package com.afmobi.common.web.httpclient;

import com.afmobi.common.util.FileUtil;
import com.afmobi.common.util.StringUtil;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ClassName:   Processor
 * Date:        2017-06-23 17:47
 *
 * @author Vincent
 */
public abstract class Processor {
    private static final Logger _log = Logger.getLogger(Processor.class);
    protected RequestBuilder request;

    public Processor(RequestBuilder request){
        this.request=request;
    }
    public String execute() {
        setProxy(request);
        String rtn = null;
        int code = 0;
        try {
            URL url =getURL(request);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if(request.getReadTimeout()>0){
                connection.setReadTimeout(request.getReadTimeout());
            }
            if(request.getConnectTimeout()>0){
                connection.setConnectTimeout(request.getConnectTimeout());
            }
            connection.setRequestProperty("Charset", "UTF-8");
            if (request.getHeader() != null && request.getHeader().size() > 0) {
                for (String key : request.getHeader().keySet()) {
                    connection.setRequestProperty(key, request.getHeader().get(key));
                }
            }
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            request(connection,request);
            code=connection.getResponseCode();

            return readResponse(connection);
        } catch (Exception e) {
            if(request.getHttpHandler()!=null){
                request.getHttpHandler().handle(code,e);
            }else{
                _log.error("error in request",e);
            }
            e.printStackTrace();
        }
        return rtn;
    }

    protected URL getURL(RequestBuilder request) throws MalformedURLException {
        return new URL(request.getUrl());
    }

    protected String readResponse(HttpURLConnection connection) throws IOException {
        InputStream stream = connection.getInputStream();
        return FileUtil.readStream(stream);
    }

    protected void request(HttpURLConnection connection, RequestBuilder request) throws IOException{}

    private void setProxy(RequestBuilder request) {
        if (StringUtil.hasLength(request.getProxyIP())) {
            System.setProperty("http.proxyHost", request.getProxyIP());
            System.setProperty("http.proxyPort", String.valueOf(request.getProxyPort()));
        }
    }



}
