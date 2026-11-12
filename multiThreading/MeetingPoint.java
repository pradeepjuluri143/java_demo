package multiThreadig;

public class MeetingPoint {

    boolean friendArrived = false;

    synchronized void waitForFriend() {
        try {
            while (!friendArrived) {
                System.out.println("Rahul: Waiting for my friend...");
                wait();
            }

            System.out.println("Rahul: My friend arrived! Let's go.");
        } catch (InterruptedException e) {
            System.out.println("Rahul was interrupted.");
        }
    }

    synchronized void friendArrives() {
        friendArrived = true;

        System.out.println("Friend: I have arrived!");
        notify();
    }
}

class WaitNotifyDemo {
    public static void main(String[] args) {

        MeetingPoint meeting = new MeetingPoint();

        Thread rahul = new Thread(() -> {
            meeting.waitForFriend();
        });

        Thread friend = new Thread(() -> {
            try {
                Thread.sleep(2000); // Friend takes 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            meeting.friendArrives();
        });

        rahul.start();
        friend.start();
    }

}
