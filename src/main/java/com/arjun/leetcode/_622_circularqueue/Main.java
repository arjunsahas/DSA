package com.arjun.leetcode._622_circularqueue;

class Main {
    private int[] q;
    private int last = -1;
    private int first = -1;
    private int k = 0;

    public Main(int k) {
        this.q = new int[k];
        this.k = q.length;
    }

    public boolean enQueue(int value) {
        if(last + 1 < k) {
            q[++last] = value;
            if(last == 0) first++;
            System.out.println(last);
            System.out.println(toString());
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
          if(last >= 0 && first <= last) {
            q[first++] = 0;
             System.out.println(first);
             System.out.println(toString());
            return true;
        }
        return false;
    }
    
    public int Front() {
        int ret = -1;
        if(!isEmpty()) return q[0];
        return ret;
    }
    
    public int Rear() {
        int ret = -1;
        if(last >= 0 && last < k) {
            ret = q[last];
        }
        return ret;
    }
    
    public boolean isEmpty() {
        return last < 0;
    }
    
    public boolean isFull() {
        return last == (k - 1);
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i: q) {
            builder.append(i).append(",");
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Main obj = new Main(3);
        System.out.println(obj.enQueue(1));
        obj.enQueue(2);
        obj.enQueue(3);
        obj.deQueue();
        obj.deQueue();
        obj.deQueue();
        System.out.println(obj.deQueue());
        System.out.println(obj.Front());
        obj.Rear();
        obj.isEmpty();
        obj.isFull();
        System.out.println(obj);
    }
}

class MyCircularQueue {
    private int[] q;
    private int last = -1;
    private int first = 0;
    private int k = 0;

    public MyCircularQueue(int k) {
        this.q = new int[k];
        this.k = q.length;
    }

    public boolean enQueue(int value) {
        if(!isFull()) {
            q[++last% k] = value;
            System.out.println(last);
            System.out.println(toString());
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(!isEmpty()) {
            first++;
            System.out.println(first);
            System.out.println(toString());
            return true;
        }
        return false;
    }

    public int Front() {
        return !isEmpty() ? q[first % k] : -1;
    }

    public int Rear() {
        return !isEmpty() ? q[last % k] : -1;
    }

    public boolean isEmpty() {
        return first > last;
    }

    public boolean isFull() {
        return last - first + 1 == k;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i: q) {
            builder.append(i).append(",");
        }
        return builder.toString();
    }

}