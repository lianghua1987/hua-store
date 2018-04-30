package com.hua.store.portal.httpclient;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HttpClientTest {


    @Test
    public void doGet() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://www.qq.com");
        CloseableHttpResponse response = httpClient.execute(get);
        assertEquals(200, response.getStatusLine().getStatusCode());
        System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
        response.close();
        httpClient.close();
    }


    @Test
    public void doGetWithParam() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        URIBuilder builder = new URIBuilder("https://www.google.com/search");
        builder.addParameter("q", "httpclient");
        HttpGet get = new HttpGet(builder.build());

        CloseableHttpResponse response = httpClient.execute(get);
        assertEquals(200, response.getStatusLine().getStatusCode());
        System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
        response.close();
        httpClient.close();
    }
}
