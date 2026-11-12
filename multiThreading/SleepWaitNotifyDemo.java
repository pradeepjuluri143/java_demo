package multiThreadig;

/**
 * ============================================================================
 * DEMONSTRATION: Thread.sleep() vs Object.wait(), wait(time), notify(), notifyAll()
 * ============================================================================
 * 
 * 💡 KEY CONCEPTS FOR FRESHERS:
 * 
 * 1. Thread.sleep(millis):
 *    - Method of java.lang.Thread (static method).
 *    - Pauses the currently executing thread for a given duration.
 *    - DOES NOT release any monitor locks currently held.
 *    - Can be called anywhere (does NOT require a synchronized block).
 * 
 * 2. object.wait():
 *    - Method of java.lang.Object.
 *    - RELEASES the monitor lock and pauses the thread until another thread
 *      calls notify() or notifyAll() on the SAME object.
 *    - MUST be called inside a synchronized block on that object (otherwise throws
 *      IllegalMonitorStateException).
 * 
 * 3. object.wait(timeoutMillis):
 *    - Releases the lock and waits until either:
 *      (a) another thread calls notify()/notifyAll(), OR
 *      (b) the specified timeout expires.
 *    - Does NOT wait forever.
 * 
 * 4. object.notify():
 *    - Method of java.lang.Object.
 *    - Wakes up ONE arbitrary thread currently waiting on that object's monitor.
 *    - MUST be called inside a synchronized block on that object.
 * 
 * 5. object.notifyAll():
 *    - Method of java.lang.Object.
 *    - Wakes up ALL threads currently waiting on that object's monitor.
 *    - MUST be called inside a synchronized block on that object.
 */
public class SleepWaitNotifyDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("==================================================================");
        System.out.println(" 🧵 DEMO: sleep(), wait(), wait(time), notify(), notifyAll()");
        System.out.println("==================================================================");

        // -----------------------------------------------------------------
        // DEMO 1: Thread.sleep(millis)
        // -----------------------------------------------------------------
        demoSleep();

        // -----------------------------------------------------------------
        // DEMO 2: object.wait() and object.notify()
        // -----------------------------------------------------------------
        demoWaitAndNotify();

        // -----------------------------------------------------------------
        // DEMO 3: object.wait(timeoutMillis)
        // -----------------------------------------------------------------
        demoTimedWait();

        // -----------------------------------------------------------------
        // DEMO 4: object.notifyAll()
        // -----------------------------------------------------------------
        demoNotifyAll();

        System.out.println("\n==================================================================");
        System.out.println(" ✅ ALL THREAD SYNCHRONIZATION DEMOS COMPLETED SUCCESSFULLY");
        System.out.println("==================================================================");
    }

    /**
     * 1. Demonstrates Thread.sleep(millis).
     * Pauses execution for 1 second without needing any lock.
     */
    public static void demoSleep() throws InterruptedException {
        System.out.println("\n------------------------------------------------------------------");
        System.out.println("1. DEMONSTRATING: Thread.sleep(1000)");
        System.out.println("------------------------------------------------------------------");

        Thread sleeperThread = new Thread(() -> {
            System.out.println("[Sleeper] Thread started. Pausing for 1000ms using Thread.sleep()...");
            try {
                // Thread.sleep() pauses current thread. No synchronized block needed!
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("[Sleeper] Sleep interrupted: " + e.getMessage());
            }
            System.out.println("[Sleeper] Woke up after 1000ms! Continuing execution.");
        }, "Sleeper-Thread");

        sleeperThread.start();
        sleeperThread.join(); // Main thread waits for sleeperThread to complete
    }

    /**
     * 2. Demonstrates object.wait() and object.notify().
     * Scenario: Customer orders Masala Chai and waits. Chaiwala prepares chai and notifies.
     */
    public static void demoWaitAndNotify() throws InterruptedException {
        System.out.println("\n------------------------------------------------------------------");
        System.out.println("2. DEMONSTRATING: object.wait() & object.notify()");
        System.out.println("------------------------------------------------------------------");

        // Shared monitor lock object
        Object chaiLock = new Object();

        // Thread A: Customer waiting for chai
        Thread customer = new Thread(() -> {
            synchronized (chaiLock) {
                try {
                    System.out.println("[Customer] Ordered Masala Chai at Tapri. Calling chaiLock.wait()...");
                    // wait() releases the lock on chaiLock and pauses indefinitely
                    chaiLock.wait();
                    System.out.println("[Customer] Received notify()! Lock re-acquired. Enjoying hot chai ☕");
                } catch (InterruptedException e) {
                    System.out.println("[Customer] Interrupted: " + e.getMessage());
                }
            }
        }, "Customer-Thread");

        // Thread B: Chaiwala preparing chai and calling notify()
        Thread chaiwala = new Thread(() -> {
            try {
                // Simulating preparation time
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (chaiLock) {
                System.out.println("[Chaiwala] Chai is ready! Calling chaiLock.notify()...");
                // notify() wakes up one waiting thread on chaiLock
                chaiLock.notify();
                System.out.println("[Chaiwala] Notified customer. Chaiwala releasing lock now.");
            }
        }, "Chaiwala-Thread");

        customer.start();
        chaiwala.start();

        customer.join();
        chaiwala.join();
    }

    /**
     * 3. Demonstrates object.wait(timeoutMillis).
     * Scenario: User waits for Bank OTP for at most 1000ms. If no notify() comes, it times out and wakes up.
     */
    public static void demoTimedWait() throws InterruptedException {
        System.out.println("\n------------------------------------------------------------------");
        System.out.println("3. DEMONSTRATING: object.wait(timeoutMillis) - Timed Wait");
        System.out.println("------------------------------------------------------------------");

        Object otpLock = new Object();

        Thread otpReceiver = new Thread(() -> {
            synchronized (otpLock) {
                try {
                    System.out.println("[SBI User] Waiting for OTP with a 1000ms timeout: otpLock.wait(1000)...");
                    long startTime = System.currentTimeMillis();

                    // wait(1000) releases lock and waits at most 1000ms.
                    // If no thread calls notify(), it wakes up automatically!
                    otpLock.wait(1000);

                    long timeTaken = System.currentTimeMillis() - startTime;
                    System.out.println("[SBI User] Woke up automatically after " + timeTaken + "ms (Timeout expired)!");
                } catch (InterruptedException e) {
                    System.out.println("[SBI User] Interrupted: " + e.getMessage());
                }
            }
        }, "OTP-Receiver-Thread");

        otpReceiver.start();
        otpReceiver.join();
    }

    /**
     * 4. Demonstrates object.notifyAll().
     * Scenario: Multiple fans waiting for BookMyShow tickets to open. Admin calls notifyAll() to wake all fans.
     */
    public static void demoNotifyAll() throws InterruptedException {
        System.out.println("\n------------------------------------------------------------------");
        System.out.println("4. DEMONSTRATING: object.notifyAll() - Waking All Waiting Threads");
        System.out.println("------------------------------------------------------------------");

        Object bookingLock = new Object();

        // Runnable task for a ticket buyer
        Runnable ticketBuyer = () -> {
            String name = Thread.currentThread().getName();
            synchronized (bookingLock) {
                try {
                    System.out.println("[" + name + "] Waiting for booking to open... calling bookingLock.wait()");
                    // Each thread releases the lock and waits
                    bookingLock.wait();
                    System.out.println("[" + name + "] Woke up by notifyAll()! Booked movie ticket 🎟️");
                } catch (InterruptedException e) {
                    System.out.println("[" + name + "] Interrupted: " + e.getMessage());
                }
            }
        };

        Thread fan1 = new Thread(ticketBuyer, "Fan-Rohit");
        Thread fan2 = new Thread(ticketBuyer, "Fan-Priya");
        Thread fan3 = new Thread(ticketBuyer, "Fan-Amit");

        fan1.start();
        fan2.start();
        fan3.start();

        // Give worker threads time to enter wait() state
        Thread.sleep(500);

        // Admin thread triggers notifyAll()
        Thread admin = new Thread(() -> {
            synchronized (bookingLock) {
                System.out.println("\n[Admin] BookMyShow counter opened! Calling bookingLock.notifyAll()...");
                // notifyAll() wakes up ALL waiting threads on bookingLock
                bookingLock.notifyAll();
                System.out.println("[Admin] notifyAll() sent to all waiting fans.\n");
            }
        }, "Admin-Thread");

        admin.start();

        fan1.join();
        fan2.join();
        fan3.join();
        admin.join();
    }
}

