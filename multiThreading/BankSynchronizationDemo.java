package multiThreadig;

/**
 * ============================================================================
 * DEMONSTRATION: THREAD SYNCHRONIZATION IN JAVA (INDIAN BANKING CONTEXT)
 * ============================================================================
 * 
 * 🎯 SCENARIO FOR FRESHERS:
 * Imagine a Joint SBI Savings Account shared by family members (Rahul, Pooja,
 * Amit).
 * - Initial Joint Balance: ₹5,000
 * - Rahul tries to withdraw ₹4,000 from an SBI ATM.
 * - Pooja simultaneously tries to withdraw ₹3,000 via Google Pay (GPay).
 * - Amit simultaneously tries to withdraw ₹1,000 via PhonePe.
 * - Total requested: ₹8,000 (which exceeds the ₹5,000 balance!).
 * 
 * ⚠️ THE PROBLEM (Race Condition without 'synchronized'):
 * Without synchronization, multiple threads enter the balance check at the SAME
 * time. Both see ₹5,000 >= requested, both dispense money, and balance becomes
 * negative (₹-2,000 or worse) — a data corruption disaster!
 * 
 * 🛡️ THE SOLUTION ('synchronized' Keyword):
 * When withdraw() is marked 'synchronized':
 * 1. Only ONE thread is allowed to enter the method at any given moment.
 * 2. The thread acquires the monitor lock on the shared account object.
 * 3. Other threads must wait in line until the lock is released.
 * 4. Each thread sees the true, up-to-date balance.
 */
class SbiJointAccount {

    // Shared resource (Critical Data)
    private int balanceINR = 5000;

    /**
     * CRITICAL METHOD: Marked 'synchronized' to prevent race conditions.
     * 
     * Only one thread can execute this method on this account at a time.
     */
    public synchronized void withdraw(String personName, int amountINR) {
        System.out.println("\n--------------------------------------------------");
        System.out.println("💳 [TRANSACTION STARTED] " + personName + " wants to withdraw: ₹" + amountINR);
        System.out.println("   [Balance Check] Available Balance: ₹" + balanceINR);

        // Step 1: Check if balance is sufficient
        if (balanceINR >= amountINR) {
            System.out.println("   ✅ Sufficient balance! Processing cash for " + personName + "...");

            try {
                // Simulating banking network / ATM hardware delay of 600ms
                // Because this method is synchronized, other threads CANNOT sneak in during
                // this delay!
                Thread.sleep(600);
            } catch (InterruptedException e) {
                System.out.println("   Transaction interrupted: " + e.getMessage());
            }

            // Step 2: Deduct amount
            balanceINR -= amountINR;

            System.out.println("   💵 Dispensed ₹" + amountINR + " to " + personName);
            System.out.println("   🏦 Remaining Joint Account Balance: ₹" + balanceINR);
        } else {
            // Step 3: Reject transaction if balance is insufficient
            System.out.println("   ❌ TRANSACTION REJECTED for " + personName + "!");
            System.out.println("      Requested: ₹" + amountINR + " | Available: ₹" + balanceINR);
            System.out.println("      Reason: Insufficient funds in SBI Joint Account.");
        }
        System.out.println("--------------------------------------------------");
    }

    public int getBalance() {
        return balanceINR;
    }
}

public class BankSynchronizationDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("==================================================================");
        System.out.println(" 🏦 SBI JOINT ACCOUNT - THREAD SYNCHRONIZATION DEMO");
        System.out.println("==================================================================");

        // Single shared bank account object among all family members
        SbiJointAccount sharedAccount = new SbiJointAccount();
        System.out.println("Initial Joint Account Balance: ₹" + sharedAccount.getBalance());

        // Thread 1: Rahul withdrawing ₹4,000 from SBI ATM
        Thread rahulThread = new Thread(() -> {
            sharedAccount.withdraw("Rahul (SBI ATM)", 4000);
        }, "Rahul-Thread");

        // Thread 2: Pooja withdrawing ₹3,000 via Google Pay (GPay)
        Thread poojaThread = new Thread(() -> {
            sharedAccount.withdraw("Pooja (GPay)", 3000);
        }, "Pooja-Thread");

        // Thread 3: Amit withdrawing ₹1,000 via PhonePe
        Thread amitThread = new Thread(() -> {
            sharedAccount.withdraw("Amit (PhonePe)", 1000);
        }, "Amit-Thread");

        // Start all 3 withdrawal threads at the same time
        System.out.println("\nStarting 3 concurrent withdrawal requests from different threads...");
        rahulThread.start();
        poojaThread.start();
        amitThread.start();

        // Wait for all 3 threads to finish
        rahulThread.join();
        poojaThread.join();
        amitThread.join();

        System.out.println("\n==================================================================");
        System.out.println(" 🏁 ALL TRANSACTIONS PROCESSED");
        System.out.println(" Final Safe Balance in SBI Joint Account: ₹" + sharedAccount.getBalance());
        System.out.println(" Notice: Balance never went negative because of 'synchronized'!");
        System.out.println("==================================================================");
    }
}
