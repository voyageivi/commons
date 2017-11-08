package com.afmobi.common.web.httpclient;

import com.afmobi.common.util.StringUtil;
import com.alibaba.fastjson.JSON;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/**
 * ClassName:   PostBodyMethod
 * Date:        2017-11-08 09:47
 *
 * @author Vincent
 */
public class PostJSONMethod extends Processor {
    public PostJSONMethod(RequestBuilder request) {
        super(request);
    }

    @Override
    protected void request(HttpURLConnection connection, RequestBuilder request) throws IOException {
        connection.setDoOutput(true);
        if (request.getParamMap().isEmpty()) {
            connection.setFixedLengthStreamingMode(0);
        } else {
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            String param = JSON.toJSONString(request.getParamMap());
            byte[] data = param.getBytes("UTF-8");
            connection.setFixedLengthStreamingMode(data.length);
            flushData(connection.getOutputStream(), data);
        }
    }

    private void flushData(OutputStream outputStream, byte[] data) throws IOException {
        BufferedOutputStream brs = new BufferedOutputStream(outputStream);
        brs.write(data);
        brs.flush();
        brs.close();
    }

}
