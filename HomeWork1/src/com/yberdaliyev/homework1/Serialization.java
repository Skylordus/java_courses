package com.yberdaliyev.homework1;


import java.io.*;
import java.net.URL;

/**
 * Created by Yerlan on 12.02.2017.
 */
public abstract class Serialization {

    public static String serialize(String path) throws IOException {
        String inputLine;
        StringBuilder stringBuilder;

        //check whether the path is a URL or file in the system
        if (path.startsWith("http")) {

                //extract the text from the web page
                URL myURL = new URL(path);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(myURL.openStream())
                );
                stringBuilder = new StringBuilder();
                while ((inputLine = in.readLine()) != null)
                    stringBuilder.append(inputLine);
                in.close();
                return stringBuilder.toString();
        } else {
                //extract the text from a file
                FileInputStream fis = new FileInputStream(path);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader bufferedReader = new BufferedReader(isr);
                stringBuilder = new StringBuilder();
                while ((inputLine = bufferedReader.readLine()) != null) {
                    stringBuilder.append(inputLine);
                }
                return stringBuilder.toString();
        }

    }
}
