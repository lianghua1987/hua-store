package com.hua.store.portal.httpclient;


import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.ArrayList;

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


    @Test
    public void doPost() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.action");
        CloseableHttpResponse response = httpClient.execute(post);
        assertEquals(200, response.getStatusLine().getStatusCode());
        response.close();
        httpClient.close();
    }

    @Test
    public void doPostWithParam() throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.action");
        List<NameValuePair> pairs = new ArrayList<>();
        pairs.add(new BasicNameValuePair("username", "梁骅"));
        pairs.add(new BasicNameValuePair("password", "123456"));

        post.setEntity(new UrlEncodedFormEntity(pairs, "utf-8"));
        CloseableHttpResponse response = httpClient.execute(post);
        System.out.println(EntityUtils.toString(response.getEntity()));
        response.close();
        httpClient.close();
    }
}
