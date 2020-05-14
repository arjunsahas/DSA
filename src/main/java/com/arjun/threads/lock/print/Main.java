package com.arjun.threads.lock.print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 2147483647; i++) {
            executorService.execute(new Job(printQueue));
        }
    }

}
