package com.yberdaliyev;

import java.util.HashMap;

/**
 * Created by Yerlan on 13.02.2017.
 */
public class Main {
    public static volatile Boolean isFinished;
    public static volatile HashMap<Short, Long> storage;

    public static void main(String[] args) {

        storage = new HashMap<>();
        isFinished = new Boolean(false);

        new Thread(new RandomGenerator(storage, isFinished)).start();
        new Thread(new Counter(storage, isFinished)).start();
    }
}
