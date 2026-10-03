package inheritance;

// ============================================================================
// 1. SINGLE INHERITANCE: One Parent -> One Child
// ============================================================================
class TataVehicle {
    protected String brandName = "Tata Motors";
    protected String modelName;

    public TataVehicle(String modelName) {
        this.modelName = modelName;
    }

    public void startEngine() {
        System.out.println("[" + brandName + " " + modelName + "] Engine started cleanly.");
    }
}

// TataPassengerCar extends TataVehicle (Single Inheritance)
class TataPassengerCar extends TataVehicle {
    protected int seatingCapacity;

    public TataPassengerCar(String modelName, int seatingCapacity) {
        super(modelName);
        this.seatingCapacity = seatingCapacity;
    }

    public void displayPassengerInfo() {
        System.out.println("[" + brandName + " " + modelName + "] Seating Capacity: " + seatingCapacity + " Passengers");
    }
}

// ============================================================================
// 2. MULTILEVEL INHERITANCE: Grandparent -> Parent -> Child
// ============================================================================
// TataNexonEV extends TataPassengerCar which extends TataVehicle
class TataNexonEV extends TataPassengerCar {
    private double batteryCapacityKWh;

    public TataNexonEV(String modelName, int seatingCapacity, double batteryCapacityKWh) {
        super(modelName, seatingCapacity);
        this.batteryCapacityKWh = batteryCapacityKWh;
    }

    public void chargeBattery() {
        System.out.println("[" + brandName + " " + modelName + "] Charging battery (" + batteryCapacityKWh + " kWh) via Fast DC Charger.");
    }
}

// ============================================================================
// 3. HIERARCHICAL INHERITANCE: One Parent -> Multiple Children
// ============================================================================
// TataCommercialTruck ALSO extends TataVehicle (creating Hierarchical structure alongside TataPassengerCar)
class TataCommercialTruck extends TataVehicle {
    private double payloadCapacityTons;

    public TataCommercialTruck(String modelName, double payloadCapacityTons) {
        super(modelName);
        this.payloadCapacityTons = payloadCapacityTons;
    }

    public void loadCargo() {
        System.out.println("[" + brandName + " " + modelName + "] Loaded " + payloadCapacityTons + " Tons of goods for highway transport.");
    }
}

// ============================================================================
// 4. WHY MULTIPLE INHERITANCE OF CLASSES IS UNSUPPORTED (THE DIAMOND PROBLEM)
// ============================================================================
/*
 * DIAMOND PROBLEM EXPLANATION:
 * Suppose class GasEngine has method startEngine() -> prints "Vroom with Petrol"
 * Suppose class ElectricMotor has method startEngine() -> prints "Silent Whir with Electricity"
 * 
 * If Java allowed:
 * class HybridCar extends GasEngine, ElectricMotor { ... }
 * 
 * When hybridCar.startEngine() is called:
 * WHICH startEngine() should Java execute? GasEngine's or ElectricMotor's?
 * This ambiguity is known as the DIAMOND PROBLEM.
 * To eliminate ambiguity and keep the compiler simple/safe, Java DOES NOT support multiple inheritance of classes.
 */

// ============================================================================
// 5. HYBRID INHERITANCE & SOLVING MULTIPLE INHERITANCE VIA INTERFACES
// ============================================================================
interface IGPSNavigable {
    void navigateTo(String destination);
}

interface IElectricVehicle {
    void displayBatteryStatus();
}

// TataTiagoEV extends TataPassengerCar AND implements IGPSNavigable, IElectricVehicle
// This achieves Multiple Behavioral Inheritance (Hybrid Inheritance) without class ambiguity!
class TataTiagoEV extends TataPassengerCar implements IGPSNavigable, IElectricVehicle {
    private int batteryPercentage;

    public TataTiagoEV(String modelName, int seatingCapacity, int batteryPercentage) {
        super(modelName, seatingCapacity);
        this.batteryPercentage = batteryPercentage;
    }

    @Override
    public void navigateTo(String destination) {
        System.out.println("[" + modelName + " GPS] Navigating to: " + destination + " via MapMyIndia / Google Maps.");
    }

    @Override
    public void displayBatteryStatus() {
        System.out.println("[" + modelName + " EV] Battery Level: " + batteryPercentage + "%");
    }
}

/**
 * Demonstrates Types of Inheritance in Java & Unsupported Multiple Inheritance (Diamond Problem).
 * 
 * CONCEPTS DEMONSTRATED:
 * 1. Single Inheritance: TataVehicle -> TataPassengerCar
 * 2. Multilevel Inheritance: TataVehicle -> TataPassengerCar -> TataNexonEV
 * 3. Hierarchical Inheritance: TataVehicle -> TataPassengerCar AND TataCommercialTruck
 * 4. Diamond Problem: Code comments & structural explanation of why class multiple inheritance is banned.
 * 5. Multiple Behavioral Inheritance (Hybrid): Interfaces (IGPSNavigable, IElectricVehicle) + Class Extension.
 */
public class TypesOfInheritanceDemo {

    public static void main(String[] args) {
        System.out.println("========================================================================");
        System.out.println("   CONCEPT 2: TYPES OF INHERITANCE & THE DIAMOND PROBLEM (TATA MOTORS)");
        System.out.println("========================================================================");

        // --- 1. Single Inheritance ---
        System.out.println("\n--- 1. Single Inheritance Demo (TataVehicle -> TataPassengerCar) ---");
        TataPassengerCar safari = new TataPassengerCar("Safari Gold Edition", 7);
        safari.startEngine();            // Inherited from TataVehicle
        safari.displayPassengerInfo();   // Unique to TataPassengerCar

        // --- 2. Multilevel Inheritance ---
        System.out.println("\n--- 2. Multilevel Inheritance Demo (TataVehicle -> TataPassengerCar -> TataNexonEV) ---");
        TataNexonEV nexonEV = new TataNexonEV("Nexon EV Max", 5, 40.5);
        nexonEV.startEngine();            // Grandparent method (TataVehicle)
        nexonEV.displayPassengerInfo();   // Parent method (TataPassengerCar)
        nexonEV.chargeBattery();          // Child method (TataNexonEV)

        // --- 3. Hierarchical Inheritance ---
        System.out.println("\n--- 3. Hierarchical Inheritance Demo (TataVehicle -> TataCommercialTruck) ---");
        TataCommercialTruck primaTruck = new TataCommercialTruck("Prima 2830.K", 28.0);
        primaTruck.startEngine();         // Inherited from TataVehicle
        primaTruck.loadCargo();           // Unique to TataCommercialTruck

        // --- 4. Hybrid / Multiple Inheritance via Interfaces ---
        System.out.println("\n--- 4. Hybrid & Multiple Inheritance via Interfaces (TataTiagoEV) ---");
        TataTiagoEV tiagoEV = new TataTiagoEV("Tiago EV XZ+", 5, 85);
        tiagoEV.startEngine();            // Class inheritance (TataVehicle)
        tiagoEV.displayPassengerInfo();   // Class inheritance (TataPassengerCar)
        tiagoEV.navigateTo("Bengaluru Tech Park"); // Interface 1 implementation
        tiagoEV.displayBatteryStatus();   // Interface 2 implementation

        System.out.println("\n========================================================================");
        System.out.println("   SUMMARY OF INHERITANCE TYPES IN JAVA:");
        System.out.println("   1. Single Inheritance        : Supported  (Class A -> Class B)");
        System.out.println("   2. Multilevel Inheritance    : Supported  (Class A -> Class B -> Class C)");
        System.out.println("   3. Hierarchical Inheritance  : Supported  (Class A -> Class B and Class C)");
        System.out.println("   4. Multiple Class Inheritance: UNSUPPORTED (Avoids Diamond Ambiguity)");
        System.out.println("   5. Multiple Interfaces       : Supported  (Solves Diamond Problem cleanly)");
        System.out.println("========================================================================");
    }
}
