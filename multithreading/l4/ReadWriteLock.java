package multithreading.l4;
import java.util.concurrent.locks.*;

// Shared stock price data guarded by a ReadWriteLock
class StockData {
    private double price = 100.0;  // initial price
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // Writer: updates price
    public void updatePrice(double newPrice) {
        lock.writeLock().lock();  // acquire write lock
        try {
            System.out.printf("%s updating price to %.2f%n",
                    Thread.currentThread().getName(), newPrice);
            price = newPrice;
        } finally {
            lock.writeLock().unlock(); // release write lock
        }
    }

    // Reader: reads price
    public void readPrice() {
        lock.readLock().lock();   // acquire read lock
        try {
            System.out.printf("%s read price: %.2f%n",
                    Thread.currentThread().getName(), price);
        } finally {
            lock.readLock().unlock();  // release read lock
        }
    }
}


public class ReadWriteLock {
    public static void main(String[] args) {
        StockData stock = new StockData();

        // Create multiple reader threads
        Thread reader1 = new Thread(() -> stock.readPrice(), "Reader1");
        Thread reader2 = new Thread(() -> stock.readPrice(), "Reader2");

        // Create a writer thread
        Thread writer = new Thread(() -> stock.updatePrice(150.0), "Writer");

        // Start all threads
        reader1.start();
        reader2.start();
        writer.start();

        try {
            reader1.join();
            reader2.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}