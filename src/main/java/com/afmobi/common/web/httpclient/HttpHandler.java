package com.afmobi.common.web.httpclient;

/**
 * ClassName:   HttpHandler
 * Date:        2017-06-23 17:20
 *
 * @author Vincent
 */
public interface HttpHandler {
    void handle(int statusCode, Exception e);
}
