package org.xuaxpedia.virtualthreads;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

// Java 21 introduces virtual threads managed by the JVM, which are more efficient and
// scalable than traditional threads. They are created with Thread.ofVirtual() and managed
// with Executors.newVirtualThreadPerTaskExecutor(), while traditional threads use
// java.lang.Thread and java.util.concurrent.Executors. Virtual threads reduce resource
// overhead and are efficiently managed with ForkJoinPool and CompletableFuture.

public class VirtualThreadsDemo02 {

    public static void main(String[] args) {

        //It will run 10k tasks on virtual threads taking less than 1 second on modern CPUs.
        try (var taskExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10_000).forEach(n ->
                    taskExecutor.submit(() -> {
                        Thread.sleep(Duration.ofSeconds(1));
                        return n;
                    })
            );
        }

    }

}
