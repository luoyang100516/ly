package com.example.demo.executor;

import java.util.concurrent.BlockingDeque;

public class Producer implements Runnable{

    private BlockingDeque blockingDeque;

    public Producer(BlockingDeque blockingDeque){
        this.blockingDeque=blockingDeque;
    }


    @Override
    public void run() {
        for(int i =1 ;i<11;i++){
            try {
                blockingDeque.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
