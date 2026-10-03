package inheritance;

/**
 * Superclass representing a generic Telecom Tariff Plan in India.
 */
class TelecomPlan {
    // Variable / Field (Subject to Static Binding / Field Hiding)
    public String planName = "GENERIC_TELECOM_PLAN";
    public double baseMonthlyFeeINR = 199.0;

    // Overridable Method (Subject to Dynamic Method Dispatch / Runtime Binding)
    public double calculateMonthlyBillINR(double dataConsumedGB) {
        System.out.print("[Generic Telecom Plan] ");
        return baseMonthlyFeeINR;
    }

    public void displayPlanBenefits() {
        System.out.println("Plan Name: " + planName + " | Base Fee: ₹" + baseMonthlyFeeINR + " | Standard Calling");
    }
}

/**
 * Subclass representing Jio 5G Unlimited Prepaid Plan.
 */
class Jio5GUnlimitedPlan extends TelecomPlan {
    // Field Shadowing (Declares same variable name - NOT polymorphic!)
    public String planName = "JIO_TRUE_5G_UNLIMITED_299";
    public double baseMonthlyFeeINR = 299.0;

    // Overrides method to include unlimited 5G data logic
    @Override
    public double calculateMonthlyBillINR(double dataConsumedGB) {
        System.out.print("[Jio True 5G Plan] ");
        // Unlimited 5G included at fixed ₹299 regardless of data usage
        return baseMonthlyFeeINR;
    }

    @Override
    public void displayPlanBenefits() {
        System.out.println("Plan Name: " + planName + " | Unlimited 5G Data | Free JioCinema Premium");
    }
}

/**
 * Subclass representing Airtel Family Postpaid Plan.
 */
class AirtelFamilyPostpaidPlan extends TelecomPlan {
    public String planName = "AIRTEL_FAMILY_POSTPAID_999";
    public double baseMonthlyFeeINR = 999.0;
    private int numberOfAddonSims = 3;

    @Override
    public double calculateMonthlyBillINR(double dataConsumedGB) {
        System.out.print("[Airtel Family Plan] ");
        // Base ₹999 + ₹100 per addon SIM + ₹10 per GB beyond 100GB limit
        double extraDataFee = (dataConsumedGB > 100.0) ? (dataConsumedGB - 100.0) * 10.0 : 0.0;
        return baseMonthlyFeeINR + (numberOfAddonSims * 100.0) + extraDataFee;
    }

    @Override
    public void displayPlanBenefits() {
        System.out.println("Plan Name: " + planName + " | " + numberOfAddonSims + " Family Add-on SIMs | Disney+ Hotstar Included");
    }
}

/**
 * Subclass representing BSNL Economy 3G/4G Voucher.
 */
class BSNLEconomyPlan extends TelecomPlan {
    public String planName = "BSNL_STV_147";
    public double baseMonthlyFeeINR = 147.0;

    @Override
    public double calculateMonthlyBillINR(double dataConsumedGB) {
        System.out.print("[BSNL Economy Plan] ");
        // Base ₹147 + ₹15 per GB after 10GB high-speed quota
        double excessData = (dataConsumedGB > 10.0) ? (dataConsumedGB - 10.0) * 15.0 : 0.0;
        return baseMonthlyFeeINR + excessData;
    }

    @Override
    public void displayPlanBenefits() {
        System.out.println("Plan Name: " + planName + " | National Roaming | 10GB Data Quota");
    }
}

/**
 * Demonstrates Dynamic Method Dispatch & Parent Reference Referring to Child Object in Java.
 * 
 * CORE RULES COVERED:
 * 1. DYNAMIC METHOD DISPATCH: Which overridden method executes is decided at RUNTIME based
 *    on the actual object in Heap memory (e.g. Jio, Airtel, BSNL), NOT the reference variable type.
 * 2. FIELD HIDING (CRITICAL): Fields are NOT polymorphic! Field access (ref.planName) is resolved
 *    at COMPILE-TIME based on the reference variable type.
 * 3. HETEROGENEOUS PROCESSING: Enables handling an array of diverse subscriber plans uniformly
 *    without writing complex if-else / switch branches.
 */
public class DynamicMethodDispatchDemo {

    public static void main(String[] args) {
        System.out.println("========================================================================");
        System.out.println("   CONCEPT 9: DYNAMIC METHOD DISPATCH (INDIAN TELECOM PLANS)");
        System.out.println("========================================================================");

        // Parent reference pointing to different child instances on Heap (Upcasting)
        TelecomPlan plan1 = new Jio5GUnlimitedPlan();
        TelecomPlan plan2 = new AirtelFamilyPostpaidPlan();
        TelecomPlan plan3 = new BSNLEconomyPlan();

        // =====================================================================
        // 1. DYNAMIC METHOD DISPATCH DEMONSTRATION (RUNTIME POLYMORPHISM)
        // =====================================================================
        System.out.println("\n--- 1. Dynamic Method Dispatch Execution ---");
        
        // Even though plan1, plan2, plan3 are of type TelecomPlan reference,
        // Java dynamically invokes the SUBCLASS method implementations at runtime!
        System.out.println("Subscriber 1 Bill (120 GB Data): ₹" + plan1.calculateMonthlyBillINR(120.0));
        System.out.println("Subscriber 2 Bill (120 GB Data): ₹" + plan2.calculateMonthlyBillINR(120.0));
        System.out.println("Subscriber 3 Bill (20 GB Data) : ₹" + plan3.calculateMonthlyBillINR(20.0));

        // =====================================================================
        // 2. FIELD HIDING DEMONSTRATION (NO POLYMORPHISM FOR FIELDS!)
        // =====================================================================
        System.out.println("\n--- 2. Field Hiding vs Method Overriding (CRITICAL JAVA RULE) ---");
        
        System.out.println("Accessing plan1.planName via Parent Reference : " + plan1.planName); 
        // Output: "GENERIC_TELECOM_PLAN" (Resolved at COMPILE-TIME from TelecomPlan reference type!)

        System.out.print("Invoking plan1.displayPlanBenefits() Method    : ");
        plan1.displayPlanBenefits();
        // Output: "Plan Name: JIO_TRUE_5G_UNLIMITED_299..." (Resolved at RUNTIME from Jio object!)

        // =====================================================================
        // 3. UNIFIED POLYMORPHIC ARRAY PROCESSING
        // =====================================================================
        System.out.println("\n--- 3. Heterogeneous Array Batch Processing ---");
        
        // Polymorphic array storing different subscriber plans under TelecomPlan superclass type
        TelecomPlan[] subscriberList = {
            new Jio5GUnlimitedPlan(),
            new AirtelFamilyPostpaidPlan(),
            new BSNLEconomyPlan()
        };

        double totalRevenueINR = 0.0;
        int subscriberIndex = 1;

        for (TelecomPlan plan : subscriberList) {
            System.out.println("\nProcessing Subscriber #" + subscriberIndex++ + ":");
            plan.displayPlanBenefits(); // Dynamically dispatched
            double bill = plan.calculateMonthlyBillINR(25.0); // Dynamically dispatched
            System.out.println("  -> Monthly Bill Amount: ₹" + bill);
            totalRevenueINR += bill;
        }

        System.out.println("\nTotal Telecom Batch Billing Revenue: ₹" + totalRevenueINR);

        System.out.println("\n========================================================================");
        System.out.println("   DYNAMIC DISPATCH RECAP:");
        System.out.println("   - Methods are overridden dynamically at RUNTIME based on Heap OBJECT.");
        System.out.println("   - Fields/Variables are resolved statically at COMPILE-TIME based on REFERENCE.");
        System.out.println("========================================================================");
    }
}
