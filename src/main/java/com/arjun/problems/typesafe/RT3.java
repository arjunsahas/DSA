package com.arjun.problems.typesafe;

public class RT3 {
    public static void main() {
        try {
            System.out.println("Hello...");
            System.out.println("Going to attempt to read a field that exists in the ersatz class but not the real class...");
            RR rr = new RR();
            R r = rr.getR();
            System.out.println("  r.s is " + r.s + ".");
            System.out.println("...bye.");
        } catch (Exception e) {
            System.out.println("Exception " + e.toString() + " in RT3.main.");
        }
    }

}