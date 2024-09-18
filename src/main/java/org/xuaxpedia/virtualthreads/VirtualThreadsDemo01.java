package org.xuaxpedia.virtualthreads;

// Java 21 introduces virtual threads managed by the JVM, which are more efficient and
// scalable than traditional threads. They are created with Thread.ofVirtual() and managed
// with Executors.newVirtualThreadPerTaskExecutor(), while traditional threads use
// java.lang.Thread and java.util.concurrent.Executors. Virtual threads reduce resource
// overhead and are efficiently managed with ForkJoinPool and CompletableFuture.

public class VirtualThreadsDemo01 {

    public static void main(String[] args) throws InterruptedException {

        var virtualThread = Thread.startVirtualThread(() -> {
            System.out.println("Virtual Thread");
        });

        virtualThread.join();

    }

}
