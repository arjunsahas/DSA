package com.arjun.problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by arjuns on 25/5/17.
 */
public class Generics {
    public static void main(String[] args) {
        System.out.println(Generics.class.getClassLoader());

        List<? extends Employee> employees = new ArrayList<>();
//        employees.add(new Employee());

        // Exception<NullPointerException> nullPointerExceptionException = new Exception<>();

        List<String> strings = new ArrayList<>();
        print(strings); // compatible
//        print1(strings); // List<Object> does not have relation to List<String> even if generic type List is the same.
        print2(strings); // compatible because Collection is super class of List.

        Object[] objArr = new String[10];
        objArr[0] = new Long(0L);

        for (Object o : objArr) {
            System.out.println(o);
        }

        Employee<String>[] employees1 = new Employee[10];

    }

    static void print(List<?> list) {
        System.out.println(list);
    }

    static void print1(List<Object> list) {
        System.out.println(list);
    }

    static void print2(Collection<String> list) {
        System.out.println(list);
    }

    private static class Employee<T> {
        public Employee() {

        }
    }
}
