package com.afmobi.common.web.httpclient;

/**
 * ClassName:   GlobleBulider
 * Date:        2017-06-23 17:34
 *
 * @author Vincent
 */
public class GlobalBulider {
    String proxyIP;
    int proxyPort;
    int readTimeout;
    int connectTimeout;

    public String getProxyIP() {
        return proxyIP;
    }

    public GlobalBulider setProxyIP(String proxyIP) {
        this.proxyIP = proxyIP;
        return this;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public GlobalBulider setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
        return this;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public GlobalBulider setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public GlobalBulider setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

}
