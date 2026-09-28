// Java Demonstration: Pass-by-Value in Java
// IMPORTANT CONCEPT: Java is strictly PASS-BY-VALUE for everything!
// - For primitives: The actual value is copied.
// - For objects: The reference (memory address) is copied by value.

class NumberWrapper {
    int value;

    NumberWrapper(int value) {
        this.value = value;
    }
}

public class PassByValueDemo {

    public static void main(String[] args) {
        // -------------------------------------------------------------
        // 1. PRIMITIVE TYPES (Pass by Value)
        // -------------------------------------------------------------
        int number = 10;
        System.out.println("--- 1. Primitive Type ---");
        System.out.println("Before modifyPrimitive: " + number);
        
        modifyPrimitive(number); // Passing primitive value
        
        System.out.println("After modifyPrimitive:  " + number + " (Original value unchanged)");
        System.out.println();

        // -------------------------------------------------------------
        // 2. OBJECT REFERENCES - Modifying Object Fields
        // (Often mistaken for pass-by-reference because state changes)
        // -------------------------------------------------------------
        NumberWrapper obj = new NumberWrapper(10);
        System.out.println("--- 2. Object Reference (Modifying Content) ---");
        System.out.println("Before modifyObjectState: " + obj.value);
        
        modifyObjectState(obj); // Passing reference by value
        
        System.out.println("After modifyObjectState:  " + obj.value + " (Object content changed)");
        System.out.println();

        // -------------------------------------------------------------
        // 3. OBJECT REFERENCES - Reassigning Reference
        // (Proves Java is NOT Pass-by-Reference)
        // -------------------------------------------------------------
        System.out.println("--- 3. Object Reference (Reassigning Reference) ---");
        System.out.println("Before reassignObject: " + obj.value);
        
        reassignObject(obj); // Attempting to reassign reference
        
        System.out.println("After reassignObject:  " + obj.value + " (Original object still preserved)");
    }

    // 1. Modifying a primitive variable
    public static void modifyPrimitive(int num) {
        // 'num' is a COPY of 'number'. Changing 'num' does not affect 'number'.
        num = 99; 
    }

    // 2. Modifying an object's field
    public static void modifyObjectState(NumberWrapper wrapper) {
        // 'wrapper' is a COPY of the reference pointing to the same object in memory.
        // Changing a field modifies the underlying shared object.
        wrapper.value = 99; 
    }

    // 3. Reassigning an object reference
    public static void reassignObject(NumberWrapper wrapper) {
        // 'wrapper' local variable is reassigned to point to a NEW object.
        // The original reference in main() still points to the old object.
        wrapper = new NumberWrapper(500); 
        wrapper.value = 999; // Modifies only the new object
    }
}
