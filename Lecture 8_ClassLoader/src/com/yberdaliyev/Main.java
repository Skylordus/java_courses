package com.yberdaliyev;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Yerlan on 15.02.2017.
 */
public class Main {
    public static void main(String[] args) {

        CustomClassLoader customClassLoader = new CustomClassLoader();
        Class<?> myClass = customClassLoader.findClass("Animal");
        Object obj = null;

        try {
            obj = myClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Method method = null;
        try {
            method = obj.getClass().getMethod("getSpecies",null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(method.invoke(obj));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
