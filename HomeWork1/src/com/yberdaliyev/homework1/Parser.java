package com.yberdaliyev.homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yerlan on 12.02.2017.
 */
public class Parser {

    public static ArrayList<Long> parse(String text) {

        ArrayList<Long> longList = new ArrayList<>();
        String word;

        Scanner sc = new Scanner(text);
        while (sc.hasNext()) { //if file has some word
            word = getDigits(sc.next()); //getting next word and processing it
            if (!word.isEmpty()) {
                //parse String to Long if it's not empty
                long myLong = Long.parseLong(word);

                //finally add this number to the list
                longList.add(myLong);
            }
        }
        sc.close();

        return longList;
    }

    private static String getDigits(String word) {
        word = word.replaceAll("[^-0-9]", ""); //removing all not-a-number chars except - and .

        //removing extra zeros in front
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '0') {
                if ((i + 1) < word.length()) word = word.substring(i + 1);
            } else {
                break;
            }
        }

        //if '-' char in the middle then remove it, if it is the first char then leave it be
        if (!word.isEmpty()) {
            if (word.charAt(0) != '-') {
                word = word.replaceAll("[-]", "");
            } else {
                word = word.replaceAll("[-]", "");
                word = "-" + word;
            }
        }

        return word;
    }

}
