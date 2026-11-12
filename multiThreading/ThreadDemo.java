package multiThreadig;

/**
 * ============================================================================
 * DEMONSTRATION: MULTITHREADING BASICS & THREAD METHODS IN JAVA
 * ============================================================================
 * 
 * Demonstrates:
 * 1. Creating a Thread by extending Thread class (FirstThread)
 * 2. Creating a Thread by implementing Runnable interface (SecondTask)
 * 3. Starting threads concurrently using start()
 * 4. Displaying thread details using standard Thread methods:
 *    - getId()                 : Unique thread identifier
 *    - getName() / setName()   : Thread name
 *    - getPriority() / setPriority(): Priority value (1 to 10)
 *    - getState()              : Current state (NEW, RUNNABLE, TIMED_WAITING, TERMINATED)
 *    - isAlive()               : True if thread has started and not yet died
 *    - isDaemon()              : Whether the thread is a background daemon thread
 *    - isInterrupted()         : Whether the thread has received an interrupt signal
 *    - getThreadGroup()        : The thread group to which this thread belongs
 *    - Thread.currentThread()  : Static method to get the currently executing thread
 *    - Thread.activeCount()    : Estimated count of active threads in current thread group
 */
public class ThreadDemo {

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" 🧵 JAVA MULTITHREADING & THREAD METHODS DEMO");
        System.out.println("==================================================================");

        // -----------------------------------------------------------------
        // 1. INSPECT THE MAIN THREAD
        // -----------------------------------------------------------------
        // The JVM starts every Java application with a thread named "main".
        Thread mainThread = Thread.currentThread();
        System.out.println("\n--- 1. CURRENT (MAIN) THREAD INFORMATION ---");
        displayThreadInfo(mainThread, "Main Thread (JVM Entry Point)");

        // -----------------------------------------------------------------
        // 2. CREATE FIRST THREAD (Extends Thread)
        // -----------------------------------------------------------------
        System.out.println("\n--- 2. CREATING FIRST THREAD (Extending Thread) ---");
        FirstThread firstThread = new FirstThread("UPI-Verification-Thread");
        
        // Setting custom priority (ranges from MIN_PRIORITY=1 to MAX_PRIORITY=10)
        firstThread.setPriority(Thread.NORM_PRIORITY + 2); // Priority 7

        System.out.println("FirstThread instance created (Before calling start()):");
        displayThreadInfo(firstThread, "FirstThread (NEW State)");

        // -----------------------------------------------------------------
        // 3. CREATE SECOND THREAD (Implements Runnable)
        // -----------------------------------------------------------------
        System.out.println("\n--- 3. CREATING SECOND THREAD (Implementing Runnable) ---");
        SecondTask secondTask = new SecondTask();
        
        // Pass the Runnable task to the Thread constructor
        Thread secondThread = new Thread(secondTask, "GST-Invoice-Thread");
        
        // Setting high priority
        secondThread.setPriority(Thread.MAX_PRIORITY); // Priority 10

        System.out.println("SecondThread instance created with Runnable (Before calling start()):");
        displayThreadInfo(secondThread, "SecondThread (NEW State)");

        // -----------------------------------------------------------------
        // 4. START BOTH THREADS
        // -----------------------------------------------------------------
        System.out.println("\n--- 4. STARTING BOTH THREADS CONCURRENTLY ---");
        System.out.println("Calling start() allocates a new Call Stack and tells OS to invoke run().");
        System.out.println("------------------------------------------------------------------");
        
        firstThread.start();
        secondThread.start();

        // -----------------------------------------------------------------
        // 5. INSPECT THREAD STATES WHILE RUNNING
        // -----------------------------------------------------------------
        System.out.println("\n--- 5. THREAD STATES AFTER start() ---");
        System.out.println("Active threads in thread group: " + Thread.activeCount());
        displayThreadInfo(firstThread, "FirstThread (While Running / Alive)");
        displayThreadInfo(secondThread, "SecondThread (While Running / Alive)");

        // -----------------------------------------------------------------
        // 6. MAIN THREAD WAITS USING join()
        // -----------------------------------------------------------------
        System.out.println("\n--- 6. MAIN THREAD WAITING WITH join() ---");
        try {
            System.out.println("[Main Thread] Waiting for worker threads to finish...");
            // join() causes the current thread (main) to pause until the target thread terminates
            firstThread.join();
            secondThread.join();
            System.out.println("[Main Thread] Both worker threads have finished!");
        } catch (InterruptedException e) {
            System.out.println("[Main Thread] Interrupted while waiting: " + e.getMessage());
        }

        // -----------------------------------------------------------------
        // 7. INSPECT THREAD STATES AFTER COMPLETION
        // -----------------------------------------------------------------
        System.out.println("\n--- 7. THREAD STATES AFTER COMPLETION ---");
        displayThreadInfo(firstThread, "FirstThread (TERMINATED State)");
        displayThreadInfo(secondThread, "SecondThread (TERMINATED State)");

        System.out.println("\n==================================================================");
        System.out.println(" ✅ MULTITHREADING DEMO FINISHED SUCCESSFULLY");
        System.out.println("==================================================================");
    }

    /**
     * Helper method to inspect and print Thread properties using Thread methods.
     */
    public static void displayThreadInfo(Thread thread, String label) {
        System.out.println("------------------------------------------------------------------");
        System.out.println("📌 " + label);
        System.out.println("   Method                    Returned Value");
        System.out.println("   ---------------------------------------------------------------");
        System.out.println("   thread.getId()            : " + thread.getId());
        System.out.println("   thread.getName()          : " + thread.getName());
        System.out.println("   thread.getPriority()      : " + thread.getPriority() + " (MIN=1, NORM=5, MAX=10)");
        System.out.println("   thread.getState()         : " + thread.getState());
        System.out.println("   thread.isAlive()          : " + thread.isAlive());
        System.out.println("   thread.isDaemon()         : " + thread.isDaemon());
        System.out.println("   thread.isInterrupted()    : " + thread.isInterrupted());
        System.out.println("   thread.getThreadGroup()   : " + (thread.getThreadGroup() != null ? thread.getThreadGroup().getName() : "None"));
        System.out.println("------------------------------------------------------------------");
    }
}

