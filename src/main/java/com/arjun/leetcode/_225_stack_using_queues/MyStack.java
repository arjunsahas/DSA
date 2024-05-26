package com.arjun.leetcode._225_stack_using_queues;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue = new ArrayDeque<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        queue.offer(x);
    }
    
    public int pop() {
        Integer lastElement = -1;
        int count = 0;
        if(!queue.isEmpty()) {
            Iterator<Integer> iterator = queue.iterator();
            while (iterator.hasNext()) {
                lastElement = iterator.next();
                if(count == queue.size() -1) {
                    iterator.remove();
                }
                count++;
            }
        }
        return lastElement;
    }
    
    public int top() {
        Integer lastElement = -1;
        if(!queue.isEmpty()) {
            Iterator<Integer> iterator = queue.iterator();
            while (iterator.hasNext()) {
                lastElement = iterator.next();

            }
        }
        return lastElement;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(3);

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());

        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

        System.out.println(myStack.empty());

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(2);

        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */