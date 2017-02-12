package com.yberdaliyev.homework1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Yerlan on 12.02.2017.
 */
public class AdderPrinter implements Runnable {
    private ArrayList<Long> numbers;
    private AtomicLong sum;
    private String path;

    public AdderPrinter(String path, AtomicLong sum) {
        this.path = path;
        this.sum = sum;
    }

    @Override
    public void run() {

        //get array of numbers out of File located in the given path
        try {
            numbers = Parser.parse(Serialization.serialize(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        synchronized (sum) {
            //get positive, even integers from the array & add them to sum
            for (long number : numbers) {
                if ((number > 0) && (number % 2 == 0)) {
                    sum.addAndGet(number);
                }
            }
            //output the result to console
            System.out.println(sum);

        }
    }
}