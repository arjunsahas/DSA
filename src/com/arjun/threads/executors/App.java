package com.arjun.threads.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
	public static void main(String[] args) {
		ExecutorService executors = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			executors.submit(new Runner(i));
		}
		executors.shutdown();

		System.out.println("All Tasks Submmitted.");

		try {
			executors.awaitTermination(1, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("All Tasks Completed.");

	}
}
