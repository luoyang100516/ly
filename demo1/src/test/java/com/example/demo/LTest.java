package com.example.demo;

import com.example.demo.ll.RestClient;
import com.sun.deploy.net.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class LTest {

    String url = "https://reqres.in/";

    @Test
    public void getRes(){
        try {
            CloseableHttpClient clients = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse data = clients.execute(httpGet);
            int code = data.getStatusLine().getStatusCode();
            HttpEntity httpEntity= data.getEntity();
            String da = EntityUtils.toString(httpEntity);
            System.out.println("code:"+code);
            System.out.println("data:"+da);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
