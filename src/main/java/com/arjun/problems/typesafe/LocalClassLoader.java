package com.arjun.problems.typesafe;// LocalClassLoader.java

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Defines a Class Loader that knows how to read a class
 * from the local file system.
 */

public abstract class LocalClassLoader extends java.lang.ClassLoader {
    private String directory;

    public LocalClassLoader(String dir) {
        directory = dir;
    }

    protected Class loadClassFromFile(String name, boolean resolve)
            throws ClassNotFoundException, FileNotFoundException {
        File target = new File(directory + name.replace('.', '/') + ".class");
        if (!target.exists()) throw new java.io.FileNotFoundException();
        long bytecount = target.length();
        byte[] buffer = new byte[(int) bytecount];
        try {
            FileInputStream f = new FileInputStream(target);
            int readCount = f.read(buffer);
            f.close();
            Class c = defineClass(name, buffer, 0, (int) bytecount);
            if (resolve) resolveClass(c);
            System.out.println("[Loaded " + name + " from " + target + " (" + bytecount + " bytes)]");
            return c;
        } catch (java.lang.Exception e) {
            System.out.println("Aborting read: " + e.toString() + " in LocalClassLoader.");
            throw new ClassNotFoundException();
        }
    }
}


// RT3

