package multithreading.l3;
class SafeCounter {
    private int count = 0;

    // Entire method is protected by the instance’s monitor lock
    public synchronized void increment() {
        count++;          // atomic under the lock
    }
    // or if we wanted finer control, we could use a synchronized block:
    public void incrementWithBlock() {
        synchronized(this) {
            count++;      // atomic under the lock
        }
        System.out.println("Incremented");
    } 


    public int getCount() {
        return count;
    }
}
public class SyncronisedDemo {
    public static void main(String[] args) throws InterruptedException {
        // Create a shared counter
        SafeCounter counter = new SafeCounter();

        // Task that bumps the counter 1000 times
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        // Run the same task in two threads
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // Expect 2000, but rarely get it
        System.out.println("Final Count: " + counter.getCount());
    }
}
