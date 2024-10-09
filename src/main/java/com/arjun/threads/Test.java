package com.arjun.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/** Created by arjuns on 10/11/17. */
public class Test {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Test t = new Test();
    t.init();
  }

  public void init() throws ExecutionException, InterruptedException {
    CompletableFuture completableFuture = new CompletableFuture();
    CompletableFuture<Boolean> booleanCompletableFuture =
        completableFuture.supplyAsync(this::sendMsg).thenApply(this::accept);
    System.out.println(booleanCompletableFuture.get());
  }

  public Supplier<Sample> sendMsg() {
    return () -> new Sample();
  }

  private boolean accept(final Supplier<Sample> sampleSupplier) {
    return sampleSupplier.get().i == 10;
  }

  static class Sample {
    public int i = 10;
  }
}
