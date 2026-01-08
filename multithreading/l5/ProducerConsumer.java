package multithreading.l5;

import java.util.LinkedList;
import java.util.Queue;

// Represents a code submission by a user
class Submission {
    private static int idCounter = 1; // Used to generate unique submission IDs
    private final int submissionId;
    private final String userName;

    public Submission(String userName) {
        this.userName = userName;
        this.submissionId = idCounter++; // Auto-incrementing ID
    }

    public int getSubmissionId() {
        return submissionId;
    }

    public String getUserName() {
        return userName;
    }
}

// Shared resource between producers (users) and consumers (judges)
class SubmissionQueue {
    private final Queue<Submission> queue = new LinkedList<>(); // Shared buffer
    private final int MAX_CAPACITY = 5; // Bounded buffer size

    // Producer logic: User submits a solution
    public synchronized void submit(Submission submission) throws InterruptedException {
        // If queue is full, producer waits
        while (queue.size() == MAX_CAPACITY) {
            System.out.println("⏳ Queue full. " + submission.getUserName() + " is waiting to submit.");
            wait(); // Releases lock and waits for space
        }

        // Add submission to the queue
        queue.offer(submission);
        System.out.println("" + submission.getUserName() + " submitted code: #" + submission.getSubmissionId());

        notifyAll(); // Notifies judges that a new task is available
    }

    // Consumer logic: Judge processes a submission
    public synchronized Submission consume(String judgeName) throws InterruptedException {
        // If queue is empty, consumer waits
        while (queue.isEmpty()) {
            System.out.println("△ " + judgeName + " waiting for submissions...");
            wait(); // Releases lock and waits for submissions
        }

        // Remove a submission from the queue
        Submission sub = queue.poll();
        System.out.println("⚙️ " + judgeName + " started evaluating submission #" +
                           sub.getSubmissionId() + " from " + sub.getUserName());

        notifyAll(); // Notifies waiting producers if queue was full
        return sub;
    }
}
public class ProducerConsumer {
    public static void main(String[] args) {
        SubmissionQueue submissionQueue = new SubmissionQueue();

        // Producer threads (Users submitting code)
        Runnable userTask = () -> {
            String userName = Thread.currentThread().getName();
            for (int i = 0; i < 5; i++) { // Each user submits 5 solutions
                try {
                    Submission submission = new Submission(userName);
                    submissionQueue.submit(submission);
                    Thread.sleep((long) (Math.random() * 1000)); // Simulate time between submissions
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Consumer threads (Judges evaluating submissions)
        Runnable judgeTask = () -> {
            String judgeName = Thread.currentThread().getName();
            for (int i = 0; i < 7; i++) { // Each judge evaluates 7 submissions
                try {
                    Submission submission = submissionQueue.consume(judgeName);
                    Thread.sleep((long) (Math.random() * 2000)); // Simulate evaluation time
                    System.out.println("✅ " + judgeName + " finished evaluating submission #" +
                                       submission.getSubmissionId());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Start producer threads
        Thread user1 = new Thread(userTask, "User1");
        Thread user2 = new Thread(userTask, "User2");
        user1.start();
        user2.start();

        // Start consumer threads
        Thread judge1 = new Thread(judgeTask, "Judge1");
        Thread judge2 = new Thread(judgeTask, "Judge2");
        judge1.start();
        judge2.start();
    }
}
