package inheritance;

import java.io.IOException;

// Helper classes to demonstrate Covariant Return Types
class DeliveryReceipt {
    public String receiptId;
    public double totalAmountINR;

    public DeliveryReceipt(String receiptId, double totalAmountINR) {
        this.receiptId = receiptId;
        this.totalAmountINR = totalAmountINR;
    }

    public void printReceipt() {
        System.out.println("Receipt ID: " + receiptId + " | Amount: ₹" + totalAmountINR);
    }
}

// Subtype of DeliveryReceipt used for Covariant Return Type in subclass method
class ExpressDeliveryReceipt extends DeliveryReceipt {
    public String priorityTag;

    public ExpressDeliveryReceipt(String receiptId, double totalAmountINR, String priorityTag) {
        super(receiptId, totalAmountINR);
        this.priorityTag = priorityTag;
    }

    @Override
    public void printReceipt() {
        System.out.println("EXPRESS Receipt ID: " + receiptId + " | Amount: ₹" + totalAmountINR + " | Tag: " + priorityTag);
    }
}

/**
 * Superclass representing a generic Swiggy Delivery Partner in India.
 */
class SwiggyDeliveryPartner {
    protected String partnerId;
    protected String partnerName;

    public SwiggyDeliveryPartner(String partnerId, String partnerName) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
    }

    // Overridable Method 1: Standard delivery time calculation
    protected double calculateDeliveryTimeMinutes(double distanceKm) {
        // Default base rate: 5 minutes per km + 15 mins restaurant prep
        return (distanceKm * 5.0) + 15.0;
    }

    // Overridable Method 2: Standard pay earnings calculation
    public double calculateEarningsINR(double distanceKm) {
        // Base pay ₹30 + ₹10 per km
        return 30.0 + (distanceKm * 10.0);
    }

    // Overridable Method 3: Generates delivery receipt (Demonstrates Covariant Return Type)
    public DeliveryReceipt generateReceipt(String orderId, double billAmount) throws Exception {
        return new DeliveryReceipt("REC-" + orderId, billAmount);
    }

    // Method Rule Demonstration: STATIC method (Cannot be overridden dynamically - Method Hiding only)
    public static void displayPlatformRules() {
        System.out.println("[Swiggy Superclass Static] All partners must wear Swiggy uniform & helmet.");
    }

    // Method Rule Demonstration: PRIVATE method (Not inherited, cannot be overridden)
    private void verifyInternalBackground() {
        System.out.println("[Swiggy Superclass Private] Internal background verification completed.");
    }

    public void executeBackgroundCheck() {
        verifyInternalBackground();
    }
}

/**
 * Subclass representing an Electric Bike Delivery Partner on Swiggy.
 * Demonstrates method overriding, @Override annotation, access modifier rules, and covariant returns.
 */
class ElectricBikeDeliveryPartner extends SwiggyDeliveryPartner {
    private double batteryCapacityKWh;

    public ElectricBikeDeliveryPartner(String partnerId, String partnerName, double batteryCapacityKWh) {
        super(partnerId, partnerName);
        this.batteryCapacityKWh = batteryCapacityKWh;
    }

    // RULE 1: EXACT MATCH SIGNATURE + @Override annotation
    // RULE 2: ACCESS MODIFIER CANNOT BE RESTRICTED. Parent was 'protected', Child is 'public' (Increasing access is ALLOWED).
    @Override
    public double calculateDeliveryTimeMinutes(double distanceKm) {
        // Electric bike is faster: 3 mins per km + 10 mins restaurant prep
        return (distanceKm * 3.0) + 10.0;
    }

    // Overriding earnings method with EV surge incentive bonus
    @Override
    public double calculateEarningsINR(double distanceKm) {
        // EV Incentive: Base ₹40 + ₹12 per km + ₹10 Green Bonus
        return 40.0 + (distanceKm * 12.0) + 10.0;
    }

    // RULE 3: COVARIANT RETURN TYPE DEMONSTRATION
    // Parent return type: DeliveryReceipt. Child return type: ExpressDeliveryReceipt (Subclass of DeliveryReceipt).
    // RULE 4: EXCEPTION RULE DEMONSTRATION. Parent threw Exception. Child throws narrower IOException (ALLOWED).
    @Override
    public ExpressDeliveryReceipt generateReceipt(String orderId, double billAmount) throws IOException {
        return new ExpressDeliveryReceipt("EV-REC-" + orderId, billAmount, "PRIORITY_EV_FAST");
    }

    // STATIC METHOD HIDING (NOT OVERRIDING! Compiler matches method by reference type, not runtime object)
    public static void displayPlatformRules() {
        System.out.println("[EV Subclass Static] EV partners get ₹500 monthly battery charging subsidy!");
    }
}

/**
 * Demonstrates Method Overriding & Rules of Overriding in Java.
 * 
 * COMPREHENSIVE OVERRIDING RULES FOR STUDENTS:
 * 1. Signature Rule     : Same method name AND exact same parameter types/order.
 * 2. Return Type Rule    : Must be identical OR Covariant (a subclass of parent's return type).
 * 3. Access Level Rule   : CANNOT reduce visibility (e.g. protected -> public OK; public -> protected/private FAIL).
 * 4. Annotation          : Use @Override to catch signature mismatch bugs at compile-time.
 * 5. Non-Overridable     : static methods (Method Hiding), final methods (Error), private methods (Invisible).
 * 6. Exceptions Rule     : Child method CANNOT declare broader checked exceptions than parent method.
 */
public class MethodOverridingRulesDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("========================================================================");
        System.out.println("   CONCEPT 5: METHOD OVERRIDING & OVERRIDING RULES (SWIGGY DELIVERY)");
        System.out.println("========================================================================");

        // 1. Standard Partner Instance
        SwiggyDeliveryPartner standardPartner = new SwiggyDeliveryPartner("SWG-101", "Ramesh Kumar");
        System.out.println("\n--- Standard Delivery Partner (Parent Class) ---");
        System.out.println("Delivery Time (5 km) : " + standardPartner.calculateDeliveryTimeMinutes(5.0) + " mins");
        System.out.println("Earnings (5 km)      : ₹" + standardPartner.calculateEarningsINR(5.0));
        standardPartner.generateReceipt("ORD-8812", 450.0).printReceipt();

        // 2. Electric Bike Partner Instance (Polymorphic parent reference)
        SwiggyDeliveryPartner evPartner = new ElectricBikeDeliveryPartner("SWG-EV-202", "Suresh Patel", 3.2);
        System.out.println("\n--- Electric Bike Partner (Subclass Dynamic Overriding) ---");
        // Overridden methods execute child implementation dynamically!
        System.out.println("Delivery Time (5 km) : " + evPartner.calculateDeliveryTimeMinutes(5.0) + " mins");
        System.out.println("Earnings (5 km)      : ₹" + evPartner.calculateEarningsINR(5.0));
        evPartner.generateReceipt("ORD-9901", 620.0).printReceipt();

        // 3. Static Method Hiding vs Dynamic Method Overriding Demonstration
        System.out.println("\n--- Static Method Hiding Demonstration ---");
        System.out.print("Call via Parent Reference : ");
        SwiggyDeliveryPartner.displayPlatformRules(); // Executes parent static method

        System.out.print("Call via Child Reference  : ");
        ElectricBikeDeliveryPartner.displayPlatformRules(); // Executes child hidden static method

        System.out.println("\n========================================================================");
        System.out.println("   OVERRIDING CHEAT SHEET:");
        System.out.println("   - Method Overriding = Dynamic Polymorphism (Runtime decision).");
        System.out.println("   - Return types can be covariant (Subtype of parent return type).");
        System.out.println("   - Access permissions can be expanded, never narrowed.");
        System.out.println("   - Static methods are HIDDEN, NOT OVERRIDDEN.");
        System.out.println("========================================================================");
    }
}
