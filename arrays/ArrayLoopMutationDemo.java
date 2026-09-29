package arrays;

import java.util.Arrays;

/**
 * Custom Object class representing an Indian Cricket Player.
 */
class CricketPlayer {
    String name;
    int runsScored;

    public CricketPlayer(String name, int runsScored) {
        this.name = name;
        this.runsScored = runsScored;
    }

    @Override
    public String toString() {
        return name + " (" + runsScored + " runs)";
    }
}

/**
 * Demonstrates how 'for' loop vs 'for-each' loop behave when attempting to MUTATE
 * Primitive Arrays vs Object Arrays in Java.
 */
public class ArrayLoopMutationDemo {

    public static void main(String[] args) {

        System.out.println("==================================================================");
        System.out.println(" 1. MUTATION ON PRIMITIVE ARRAYS");
        System.out.println("==================================================================");

        // Grocery Item Prices in INR at a local Kirana Store
        int[] pricesINR = {100, 250, 400, 50};

        System.out.println("Original Prices: " + Arrays.toString(pricesINR));

        // ----------------------------------------------------------------------
        // Case A: Attempting Mutation with 'for-each' loop on Primitive Array
        // ----------------------------------------------------------------------
        System.out.println("\n--> Attempting to apply ₹20 bonus discount using for-each loop:");
        for (int p : pricesINR) {
            // 'p' is a LOCAL variable copy of the primitive int value.
            // Mutating 'p' only changes this temporary stack variable!
            p = p - 20; 
        }
        // Verification: Original array remains unchanged!
        System.out.println("After for-each loop: " + Arrays.toString(pricesINR) + " [MUTATION FAILED!]");
        System.out.println("  Explanation: 'for-each' loop copies primitive values; modifying loop variable does not affect array memory.");

        // ----------------------------------------------------------------------
        // Case B: Applying Mutation with indexed 'for' loop on Primitive Array
        // ----------------------------------------------------------------------
        System.out.println("\n--> Applying ₹20 discount using index-based for loop:");
        for (int i = 0; i < pricesINR.length; i++) {
            // Direct memory assignment using array index
            pricesINR[i] = pricesINR[i] - 20;
        }
        // Verification: Original array is mutated!
        System.out.println("After index-based for loop: " + Arrays.toString(pricesINR) + " [MUTATION SUCCESSFUL!]");


        System.out.println("\n==================================================================");
        System.out.println(" 2. MUTATION ON OBJECT ARRAYS");
        System.out.println("==================================================================");

        // --- Part 2A: Modifying OBJECT INTERNAL STATE (Properties) ---
        CricketPlayer[] teamIndia = {
            new CricketPlayer("Rohit Sharma", 45),
            new CricketPlayer("Virat Kohli", 82),
            new CricketPlayer("Hardik Pandya", 30)
        };

        System.out.println("Initial Team Stats: " + Arrays.toString(teamIndia));

        // --- Mutating Object State using 'for-each' loop ---
        System.out.println("\n--> Adding 10 bonus runs to each player using for-each loop:");
        for (CricketPlayer player : teamIndia) {
            // 'player' is a LOCAL copy of the REFERENCE pointing to the object in Heap.
            // Since both 'player' and teamIndia[i] point to the SAME object,
            // mutating internal state (runsScored) modifies the underlying heap object!
            player.runsScored += 10;
        }
        System.out.println("After for-each loop (Object Property Mutation): " + Arrays.toString(teamIndia) + " [MUTATION SUCCESSFUL!]");
        System.out.println("  Explanation: for-each reference variable points to the original Heap object, so state changes reflect.");

        // --- Mutating Object State using Index-based 'for' loop ---
        System.out.println("\n--> Adding 5 more runs to each player using index-based for loop:");
        for (int i = 0; i < teamIndia.length; i++) {
            teamIndia[i].runsScored += 5;
        }
        System.out.println("After index-based for loop: " + Arrays.toString(teamIndia) + " [MUTATION SUCCESSFUL!]");


        // --- Part 2B: REASSIGNING OBJECT REFERENCES in Array ---
        System.out.println("\n------------------------------------------------------------------");
        System.out.println(" REASSIGNING OBJECT REFERENCES (Replacing Elements)");
        System.out.println("------------------------------------------------------------------");

        CricketPlayer[] iplSquad = {
            new CricketPlayer("Player A", 10),
            new CricketPlayer("Player B", 20)
        };

        System.out.println("Original IPL Squad: " + Arrays.toString(iplSquad));

        // --- Attempting to Reassign Reference using 'for-each' loop ---
        System.out.println("\n--> Attempting to replace squad players using for-each loop reference reassignment:");
        for (CricketPlayer player : iplSquad) {
            // Reassigning local 'player' reference variable to a new object.
            // This DOES NOT change the reference stored inside the iplSquad array!
            player = new CricketPlayer("Substitute Player", 0);
        }
        System.out.println("After for-each loop reassignment: " + Arrays.toString(iplSquad) + " [REFERENCE REASSIGNMENT FAILED!]");
        System.out.println("  Explanation: Reassigning loop variable 'player' only updates the local reference, not the array slot.");

        // --- Reassigning Reference using Index-based 'for' loop ---
        System.out.println("\n--> Replacing squad players using index-based for loop:");
        for (int i = 0; i < iplSquad.length; i++) {
            // Direct reassignment of array element reference slot
            iplSquad[i] = new CricketPlayer("Impact Player " + (i + 1), 50);
        }
        System.out.println("After index-based for loop reassignment: " + Arrays.toString(iplSquad) + " [REFERENCE REASSIGNMENT SUCCESSFUL!]");


        System.out.println("\n==================================================================");
        System.out.println(" SUMMARY CHEAT SHEET FOR ARRAY MUTATION IN LOOPS");
        System.out.println("==================================================================");
        System.out.println(" +-----------------------+-------------------+--------------------+");
        System.out.println(" | Operation             | for-each Loop     | Index 'for' Loop   |");
        System.out.println(" +-----------------------+-------------------+--------------------+");
        System.out.println(" | Primitive Value Edit  | NO (Modifies copy)| YES (Mutates array)|");
        System.out.println(" | Object Field Edit     | YES (Same heap obj| YES (Same heap obj)|");
        System.out.println(" | Object Ref Swap       | NO (Modifies copy)| YES (Replaces slot)|");
        System.out.println(" +-----------------------+-------------------+--------------------+");
    }
}
