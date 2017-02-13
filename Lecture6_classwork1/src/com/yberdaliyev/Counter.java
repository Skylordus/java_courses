package com.yberdaliyev;

import java.util.HashMap;

/**
 * Created by Yerlan on 13.02.2017.
 */
public class Counter implements Runnable {
    private volatile Boolean isFinished;
    private volatile HashMap<Short, Long> storage;

    public Counter(HashMap<Short, Long> storage, Boolean isFinished) {
        this.isFinished = isFinished;
        this.storage = storage;
    }

    @Override
    public void run() {
        int timer = 0;
        long value;

        while (!isFinished) {
            synchronized (isFinished) {
                if (timer > 4) {
                    for (short key : storage.keySet()) {
                        value = storage.get(key);
                        System.out.print("#" + key + " -> " + value + " ");
                        if (value > 5) isFinished = true;
                    }
                    System.out.println();
                    System.out.println();
                    timer = 0;
                }
                try {
                    isFinished.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                timer++;
            }
        }
        System.out.println("- - - End Counter - - -");
    }
}
