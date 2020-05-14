package com.arjun.threads.rwlock.prices;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PricesInfo {
    ReadWriteLock lock = new ReentrantReadWriteLock();
    private double price1;
    private double price2;


    public PricesInfo() {
        price1 = 1.0;
        price2 = 2.0;
        lock = new ReentrantReadWriteLock();
    }
}
