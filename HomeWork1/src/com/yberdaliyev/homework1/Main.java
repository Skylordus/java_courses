package com.yberdaliyev.homework1;
import java.util.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Yerlan on 07.02.2017.
 */
public class Main {

    public static void main(String[] args) {
        //Here we store our result
        AtomicLong sum = new AtomicLong(0);

        //Loading input resources to list
        List<String> inputList = new ArrayList<>();
        inputList.add("input1.txt");
        inputList.add("input2.txt");
        inputList.add("input3.txt");
        inputList.add("input4.txt");
        inputList.add("https://skylordus.github.io/web/homework1.txt");

        //Going through input resources one by one
        Iterator<String> it = inputList.iterator();
        while (it.hasNext()) {
            new Thread(new AdderPrinter(it.next(),sum)).start();
        }

    }
}
