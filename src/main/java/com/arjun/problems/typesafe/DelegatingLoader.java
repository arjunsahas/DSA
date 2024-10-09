package com.arjun.problems.typesafe;

/**
 * A classloader that delegates some loads to the system loader, and serves other requests by
 * reading in from a given directory.
 */
public class DelegatingLoader extends LocalClassLoader {
  public DelegatingLoader(String dir) {
    super(dir);
  }

  public synchronized Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
    Class c;
    try {
      if (name.equals("RR") || name.startsWith("java.")) {
        System.out.println("[Loaded " + name + " from system]");
        return this.findSystemClass(name);
      } else return this.loadClassFromFile(name, resolve);
    } catch (Exception d) {
      System.out.println(
          "Exception " + d.toString() + " while loading " + name + " in DelegatingLoader.");
      throw new ClassNotFoundException();
    }
  }
}
