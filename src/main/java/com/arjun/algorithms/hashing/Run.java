package com.arjun.algorithms.hashing;

import java.util.Objects;

/**
 * Created by arjuns on 1/5/17.
 */
public class Run {
    public static void main(String[] args) {
        HashTable<Employee, String> hashtable = new HashTable<>();
        Employee employee = new Employee("emp1", 33);
        hashtable.insert(employee, "emp1");
        employee = new Employee("emp4", 37);
        hashtable.insert(employee, "emp4");
        employee = new Employee("emp5", 40);
        hashtable.insert(employee, "emp5");

        employee = new Employee("emp2", 40);
        hashtable.insert(employee, "emp2");

        employee = new Employee("emp3", 40);
        hashtable.insert(employee, "emp3");

        employee = new Employee("3emp", 40);
        hashtable.insert(employee, "3emp");

        System.out.println(hashtable.get(new Employee("3emp", 40)));

        System.out.println(hashtable.get(new Employee("emp2", 40)));

        System.out.println(hashtable.get(new Employee("emp5", 40)));

        System.out.println("Removed " + hashtable.remove(new Employee("3emp", 40)));

        System.out.println(hashtable.get(new Employee("3emp", 40)));


    }

    public static class Employee {
        private String name;
        private int age;

        public Employee(final String name, final int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            final Employee employee = (Employee) o;

            return Objects.equals(name, employee.getName()) && Objects.equals(age, employee.getAge());
        }

        @Override
        public String toString() {
            return "Name : " + name + " Age : " + age;
        }
    }
}
