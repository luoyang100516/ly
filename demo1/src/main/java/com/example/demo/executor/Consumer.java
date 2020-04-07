package com.example.demo.executor;

import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable{
    private BlockingDeque blockingDeque;

    public Consumer(BlockingDeque blockingDeque){
        this.blockingDeque=blockingDeque;
    }


    @Override
    public void run() {
        while(true){
            try {
                int i = (int) blockingDeque.take();
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
