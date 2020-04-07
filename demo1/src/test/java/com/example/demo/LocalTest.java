package com.example.demo;

import com.example.demo.service.QuestService;
import com.example.demo.service.impl.TestServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

@SpringBootTest(classes = DemoApplication.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class LocalTest {

    private  static  final  int Max_THREADS = 1111;

    private CountDownLatch cdl = new CountDownLatch(Max_THREADS);

    @Autowired
    TestServiceImpl service;

    @Test
    public void test1(){
        for (int i = 0;i<Max_THREADS;i++){
            Thread t = new Thread(()->{
                try {
                    cdl.countDown();
                    cdl.await();
                    Map<String ,Object> result = service.queryInfo("code");
                    System.out.println(result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
        try {
            Thread.sleep(2111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
