package com.example.demo.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.Executors.*;

public class ExecutorDemo implements Runnable{
    public static void main(String[] args) {
//        ThreadPoolExecutor;
//        Executors.newScheduledThreadPool();
//        ExecutorService pool =Executors.newCachedThreadPool();
//        ExecutorService executorService = newFixedThreadPool(3);
//        for(int i = 1;i<11;i++){
//            executorService.execute(new ExecutorDemo());
//        }

        for(int i = 1;i<11;i++){
            new Thread(new ExecutorDemo()).run();
        }

    }

    @Override
    public void run() {
        try {
            Thread.sleep(Long.parseLong("1111"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.println(name);
    }
}
