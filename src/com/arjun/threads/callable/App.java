package com.arjun.threads.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		Future<Integer> future = service.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return 1;
			}
		});
		
		service.shutdown();
		try {
			System.out.println("Result : "+future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
