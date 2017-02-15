package com.yberdaliyev;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Hashtable;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by Yerlan on 15.02.2017.
 */
public class CustomClassLoader extends ClassLoader {
    private String jarURLPath = "http://skylordus.github.io/web/Animal.jar"; //Path to the jar file
    private Hashtable classes = new Hashtable(); //used to cache already defined classes

    public CustomClassLoader() {
        super(CustomClassLoader.class.getClassLoader());
    }

    @Override
    public Class loadClass(String className) throws ClassNotFoundException {
        return findClass(className);
    }

    @Override
    public Class findClass(String className) {
        byte[] classByte;
        Class result = null;

        result = (Class) classes.get(className);
        if (result!=null) {return result;}

        try {
            return findSystemClass(className);
        } catch (ClassNotFoundException e) {

        }

        try {
            String path = "https://skylordus.github.io/java_courses/resources/animal.jar";
            URL website = new URL(path);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("tmp.jar");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);


            JarFile jarFile = new JarFile("tmp.jar");
            JarEntry jarEntry = jarFile.getJarEntry(className+".class");
            InputStream is = jarFile.getInputStream(jarEntry);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int nextValue = is.read();
            while (nextValue != -1) {
                baos.write(nextValue);
                nextValue = is.read();
            }
            classByte = baos.toByteArray();

            result = defineClass(className,classByte,0,classByte.length,null);

            classes.put(className,result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
