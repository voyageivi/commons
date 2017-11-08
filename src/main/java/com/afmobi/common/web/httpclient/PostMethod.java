package com.afmobi.common.web.httpclient;

import com.afmobi.common.util.StringUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/**
 * ClassName:   PostProcessor
 * Date:        2017-06-26 10:44
 *
 * @author Vincent
 */
public class PostMethod extends Processor {
    public PostMethod(RequestBuilder builder) {
        super(builder);
    }

    protected void request(HttpURLConnection connection, RequestBuilder request) throws IOException {
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        if(request.getParamMap()!=null && request.getParamMap().size()>0) {
            String param = StringUtil.joinHttpParam(request.getParamMap());
            os.write(param.getBytes());

        }
        os.flush();
        os.close();
    }
}
