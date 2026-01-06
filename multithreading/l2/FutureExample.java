package multithreading.l2;
import java.util.concurrent.*;

// Future and Submit example ( when something is to be returned from a thread)
public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // submit used when something is to be returned from thread
        Future<Integer> future = executor.submit(() -> { 
            Thread.sleep(1000);
            return 77; // return some result
        });

        System.out.println("Doing other work...");

        Integer result = future.get(); // blocks until result is ready
        System.out.println("Result: " + result);

        executor.shutdown();
    }
}

