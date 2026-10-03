package inheritance;

/**
 * Superclass representing an Electronic FASTag Toll Pass on Indian National Highways (NH-44).
 */
class FASTagVehicle {
    protected String tagId;
    protected String vehicleRegistrationNo; // e.g. "KA-01-MJ-8891"
    protected double accountBalanceINR;

    public FASTagVehicle(String tagId, String vehicleRegistrationNo, double accountBalanceINR) {
        this.tagId = tagId;
        this.vehicleRegistrationNo = vehicleRegistrationNo;
        this.accountBalanceINR = accountBalanceINR;
    }

    public void deductTollFare(double tollAmountINR) {
        if (accountBalanceINR >= tollAmountINR) {
            accountBalanceINR -= tollAmountINR;
            System.out.println("Toll Toll ₹" + tollAmountINR + " deducted for [" + vehicleRegistrationNo + "]. Rem Balance: ₹" + accountBalanceINR);
        } else {
            System.out.println("LOW BALANCE! Vehicle [" + vehicleRegistrationNo + "] blacklisted at barrier.");
        }
    }

    public void displayTagInfo() {
        System.out.println("FASTag ID: " + tagId + " | Reg No: " + vehicleRegistrationNo + " | Balance: ₹" + accountBalanceINR);
    }
}

/**
 * Subclass representing a Commercial Heavy Goods Truck FASTag.
 */
class TruckFASTag extends FASTagVehicle {
    private int numberOfAxles;
    private double currentPayloadWeightTons;

    public TruckFASTag(String tagId, String vehicleRegistrationNo, double accountBalanceINR, int numberOfAxles, double currentPayloadWeightTons) {
        super(tagId, vehicleRegistrationNo, accountBalanceINR);
        this.numberOfAxles = numberOfAxles;
        this.currentPayloadWeightTons = currentPayloadWeightTons;
    }

    // Child-specific method unique to TruckFASTag
    public void weighAxlePayloadAtWeighbridge() {
        System.out.println("[TRUCK WEIGHBRIDGE] Vehicle " + vehicleRegistrationNo + " | Axles: " + numberOfAxles + 
                           " | Payload Weight: " + currentPayloadWeightTons + " Tons.");
        if (currentPayloadWeightTons > 25.0) {
            System.out.println("  -> OVERLOAD WARNING! Penalty toll multiplier applied.");
        }
    }
}

/**
 * Subclass representing a Private Passenger Car FASTag.
 */
class CarFASTag extends FASTagVehicle {
    private boolean isVIPPassHolder;

    public CarFASTag(String tagId, String vehicleRegistrationNo, double accountBalanceINR, boolean isVIPPassHolder) {
        super(tagId, vehicleRegistrationNo, accountBalanceINR);
        this.isVIPPassHolder = isVIPPassHolder;
    }

    // Child-specific method unique to CarFASTag
    public void activateVIPFastLanePass() {
        if (isVIPPassHolder) {
            System.out.println("[CAR VIP PASS] Vehicle " + vehicleRegistrationNo + " granted Express Lane bypass.");
        } else {
            System.out.println("[CAR STANDARD] Standard toll lane assigned.");
        }
    }
}

/**
 * Demonstrates Upcasting & Reference Object Casting (Parent Reference to Child Instance) in Java.
 * 
 * CORE RULES COVERED:
 * 1. UPCASTING (Implicit): FASTagVehicle v = new TruckFASTag(...). Safe, automatic.
 *    - Allows treating specialized objects uniformly as parent type.
 *    - Reference type controls accessible methods at compile-time.
 * 2. DOWNCASTING (Explicit): TruckFASTag t = (TruckFASTag) v.
 *    - Required to access child-specific methods.
 *    - Unsafe if target object is not actually of that child class type -> ClassCastException!
 * 3. Safe Downcasting using 'instanceof': Prevents ClassCastException.
 * 4. Pattern Matching 'instanceof' (Modern Java): Combines check + implicit cast.
 */
public class UpcastingAndCastingDemo {

    public static void main(String[] args) {
        System.out.println("========================================================================");
        System.out.println("   CONCEPT 8: UPCASTING & DOWNCASTING (FASTag TOLL PLAZA REGISTRATION)");
        System.out.println("========================================================================");

        // =====================================================================
        // 1. UPCASTING DEMONSTRATION (Implicit Casting)
        // =====================================================================
        System.out.println("\n--- 1. Upcasting (Child Object assigned to Parent Reference) ---");
        
        // Upcasting TruckFASTag to FASTagVehicle parent reference
        FASTagVehicle tollVehicle1 = new TruckFASTag("TAG-TRK-881", "KA-04-MH-9900", 2500.0, 6, 32.5);
        
        // Upcasting CarFASTag to FASTagVehicle parent reference
        FASTagVehicle tollVehicle2 = new CarFASTag("TAG-CAR-102", "MH-12-PQ-4411", 800.0, true);

        // Invoking inherited method via Parent reference (Works fine!)
        tollVehicle1.displayTagInfo();
        tollVehicle1.deductTollFare(350.0); // 6-Axle Truck Toll

        tollVehicle2.displayTagInfo();
        tollVehicle2.deductTollFare(85.0);  // Car Toll

        // ATTEMPTING DIRECT CHILD METHOD CALL VIA PARENT REFERENCE FAILS AT COMPILE-TIME:
        // tollVehicle1.weighAxlePayloadAtWeighbridge(); // COMPILER ERROR: Cannot find symbol!

        // =====================================================================
        // 2. EXPLICIT DOWNCASTING WITH instanceof CHECK
        // =====================================================================
        System.out.println("\n--- 2. Safe Downcasting using 'instanceof' Check ---");

        // Traditional instanceof check & explicit cast
        if (tollVehicle1 instanceof TruckFASTag) {
            System.out.println("Safe to downcast tollVehicle1 to TruckFASTag!");
            TruckFASTag truck = (TruckFASTag) tollVehicle1; // Explicit Downcast
            truck.weighAxlePayloadAtWeighbridge();          // Now accessible!
        }

        // =====================================================================
        // 3. MODERN JAVA PATTERN MATCHING WITH instanceof
        // =====================================================================
        System.out.println("\n--- 3. Modern Pattern Matching 'instanceof' (Java 16+) ---");

        // Pattern matching directly casts tollVehicle2 into 'car' variable
        if (tollVehicle2 instanceof CarFASTag car) {
            car.activateVIPFastLanePass(); // Child-specific method
        }

        // =====================================================================
        // 4. UNSAFE DOWNCASTING & ClassCastException DEMONSTRATION
        // =====================================================================
        System.out.println("\n--- 4. Unsafe Downcasting (ClassCastException Handling) ---");
        
        try {
            System.out.println("Attempting to downcast CarFASTag reference (tollVehicle2) into TruckFASTag...");
            TruckFASTag invalidCast = (TruckFASTag) tollVehicle2; // WRONG! tollVehicle2 is a CarFASTag
            invalidCast.weighAxlePayloadAtWeighbridge();
        } catch (ClassCastException e) {
            System.out.println("RUNTIME ERROR CAUGHT: " + e.getMessage());
            System.out.println("REASON: Cannot cast a CarFASTag object to a TruckFASTag class!");
        }

        System.out.println("\n========================================================================");
        System.out.println("   CASTING CHEAT SHEET:");
        System.out.println("   - Upcasting   : Child -> Parent (Implicit, ALWAYS SAFE).");
        System.out.println("   - Downcasting : Parent -> Child (Explicit, REQUIRES 'instanceof' CHECK).");
        System.out.println("========================================================================");
    }
}
