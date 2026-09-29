package arrays;

public class DynamicArrayDemo {
    private int[] data;
    private int size;

    public DynamicArrayDemo(int initialCapacity) {
        data = new int[initialCapacity];
        size = 0;
    }

    public void add(int value) {
        // If full, grow capacity by 2x
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[size++] = value;
    }

    private void resize(int newCapacity) {
        System.out.println("[Resize Triggered] Growing from " + data.length + " to " + newCapacity);
        int[] newArray = new int[newCapacity];
        // Native fast array copying
        System.arraycopy(data, 0, newArray, 0, size);
        data = newArray; // Reassign reference
    }

    public static void main(String[] args) {
        DynamicArrayDemo arr = new DynamicArrayDemo(2); // Capacity = 2
        arr.add(10);
        arr.add(20);
        arr.add(30); // Triggers resize to 4
        arr.add(40);
        arr.add(50); // Triggers resize to 8
    }
}
