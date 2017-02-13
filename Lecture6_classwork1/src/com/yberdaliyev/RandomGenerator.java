package com.yberdaliyev;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Yerlan on 13.02.2017.
 */
public class RandomGenerator implements Runnable {
    private volatile Boolean isFinished;
    private volatile HashMap<Short, Long> storage;

    public RandomGenerator(HashMap<Short, Long> storage, Boolean isFinished) {
        this.isFinished = isFinished;
        this.storage = storage;
    }

    @Override
    public void run() {
        while (!isFinished) {
            short number = (short) new Random().nextInt(99);
            synchronized (isFinished) {
                long count = storage.containsKey(number) ? storage.get(number) : 0;
                storage.put(number, count + 1);
                isFinished.notifyAll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("- - - End RandomGenerator - - -");
    }
}
