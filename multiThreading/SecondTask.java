package multiThreadig;

/**
 * Demonstrates defining a thread task by implementing the Runnable interface.
 * 
 * Key Advantages of Runnable:
 * 1. Java supports multiple interface implementation, so a class can implement
 * Runnable while extending another domain class.
 * 2. Clean separation of the task logic (Runnable) from thread execution
 * (Thread).
 */
public class SecondTask implements Runnable {

    @Override
    public void run() {
        System.out.println("My Runnnable task");
    }

}
