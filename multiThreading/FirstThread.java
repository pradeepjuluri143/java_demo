package multiThreadig;

/**
 * Demonstrates creating a thread by extending the java.lang.Thread class
 * directly.
 * 
 * Steps to create a thread using Thread class:
 * 1. Define a class that extends java.lang.Thread.
 * 2. Override the public void run() method with the task logic.
 * 3. Create an object of this class and invoke .start() to execute it
 * concurrently.
 */
public class FirstThread extends Thread {

    public FirstThread() {
        super();
    }

    public FirstThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("First  Thread  task to execute");
    }

    /**
     * Main method delegates to ThreadDemo so running this file directly executes
     * the demo.
     */
    public static void main(String[] args) {
        Thread firstThread = new FirstThread("ExtendsThread");
        Thread secondThread = new Thread(new SecondTask(), "Runnable Thread");
        System.out.println("In Main Thread before calling threads");
        System.out.println("1111111111111");
        System.out.println("222222222222222");
        System.out.println("33333333333333");
        System.out.println("444444444444444");
        System.out.println("First thread state before " + firstThread.getState());
        System.out.println("Second thread state before " + secondThread.getState());
        firstThread.start();
        secondThread.start();
        System.out.println("First thread state after " + firstThread.getState());
        System.out.println("Second thread state after " + secondThread.getState());
        System.out.println("In Main Thread after calling threads");
    }
}
