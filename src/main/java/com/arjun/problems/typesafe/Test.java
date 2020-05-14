package com.arjun.problems.typesafe;// Test

/**
 * Test harness for classloader examples. Loads the user class into
 * a newly constructed DelegatingLoader.
 */
public class Test {
    DelegatingLoader loader;

    public void doIt(String argv[]) {
        try {
            if (argv.length < 1) {
                System.out.println("Usage: java Test ");
                return;
            }
            String target = argv[0];
            this.loader = new DelegatingLoader("ersatz/");
            Class c = this.loader.loadClass(target, true);
            Object[] arg = {};
            Class[] argClass = {};
            c.getMethod("main", argClass).invoke(null, arg);
        } catch (Exception e) {
            System.out.println("Error " + e.toString() + " in Test.doIt.");
        }
    }

    public static void main(String argv[]) {
        Test t = new Test();
        t.doIt(argv);
    }
}