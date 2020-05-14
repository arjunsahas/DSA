package com.arjun.threads.sync.pc;

import java.util.Date;
import java.util.LinkedList;

class EventStorage {
    private int maxSize;
    private LinkedList<Date> storage;


    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<Date>();
    }


    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        storage.offer(new Date());
        System.out.printf("Set: %d \n", storage.size());
        notifyAll();
    }


    public synchronized void get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        System.out.printf("Get: %d: %s \n", storage.size(), ((LinkedList<?>) storage).poll());
        notifyAll();
    }

}


class Producer implements Runnable {
    private EventStorage storage;


    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }


    public Producer(EventStorage storage) {
        this.storage = storage;
    }

}


class Consumer implements Runnable {
    private EventStorage storage;


    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.get();
        }
    }


    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

}
