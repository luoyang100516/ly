package com.example.demo.ll;

import com.example.demo.service.TestService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public Properties prop;
    public int RESPNSE_STATUS_CODE_200 = 200;
    public int RESPNSE_STATUS_CODE_201 = 201;
    public int RESPNSE_STATUS_CODE_404 = 404;
    public int RESPNSE_STATUS_CODE_500 = 500;

    public TestBase() throws IOException {
        prop = new Properties();

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
                "/src/main/resources/config.properties");
        prop.load(fis);

    }



}
