package com.arjun.algorithms.stack.fixed;

/**
 * Created by arjuns on 30/4/17.
 */
public class Run {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>(10);

        integerStack.push(11);
        integerStack.push(4);
        integerStack.push(7);
        integerStack.push(14);
        integerStack.push(9);
        integerStack.push(16);

        integerStack.push(0);
        integerStack.push(2);
        integerStack.push(5);
        integerStack.push(1);
//        integerStack.push(111);

        try {
            integerStack.push(112);
        } catch (RuntimeException e) {
            System.out.printf("no space for 112 ");
        }


        int size = integerStack.size();
        for (int i = 0; i < size; i++) {
            System.out.println(integerStack.pop());
        }

//        integerStack.pop();
    }
}
