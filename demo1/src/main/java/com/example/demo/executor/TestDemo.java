package com.example.demo.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class TestDemo {
    public static void main(String[] args) {
        BlockingDeque blockingQueue = (BlockingDeque) new ArrayBlockingQueue(11);
//        BlockingDeque blockingQueue = new BlockingDeque();
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);
        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
