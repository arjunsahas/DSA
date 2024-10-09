package com.arjun.problems;

/** Created by arjuns on 8/6/17. */
public class CL {
  public static void main(String[] args) throws ClassNotFoundException {
    ClassLoader classLoader = CL.class.getClassLoader();
    System.out.println(classLoader);
    System.out.println(classLoader.getParent());
    System.out.println(Thread.currentThread().getContextClassLoader());

    Class<?> a = classLoader.loadClass("com.arjun.problems.CL$A");
    ClassLoader classLoader1 = a.getClassLoader();
    System.out.println(classLoader1);
    System.out.println(a);
    Class<?> b = classLoader1.loadClass("com.arjun.problems.CL$B");
    System.out.println(b);
  }

  public static class A {
    public A() {}
  }

  static class B {
    public B() {}
  }
}
