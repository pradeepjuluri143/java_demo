package inheritance;

/**
 * Parent Class representing a Standard Indian Railways IRCTC Train Ticket.
 */
class TrainTicket {
    protected String pnrNumber;
    protected String passengerName;
    protected String sourceStation;
    protected String destinationStation;
    protected double baseFareINR;

    // Default No-Arg Constructor (Demonstrates implicit call when super() is omitted)
    public TrainTicket() {
        System.out.println("-> STEP 1: [TrainTicket] Default Constructor executed.");
        this.pnrNumber = "UNKNOWN-PNR";
        this.passengerName = "Unassigned Passenger";
        this.sourceStation = "NDLS (New Delhi)";
        this.destinationStation = "HWH (Howrah)";
        this.baseFareINR = 500.0;
    }

    // Parameterized Constructor
    public TrainTicket(String pnrNumber, String passengerName, String sourceStation, String destinationStation, double baseFareINR) {
        System.out.println("-> STEP 1: [TrainTicket] Parameterized Constructor executed for PNR: " + pnrNumber);
        this.pnrNumber = pnrNumber;
        this.passengerName = passengerName;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.baseFareINR = baseFareINR;
    }

    public void printTicketSummary() {
        System.out.println("--- STANDARD IRCTC TICKET DETAILS ---");
        System.out.println("PNR Number  : " + pnrNumber);
        System.out.println("Passenger   : " + passengerName);
        System.out.println("Route       : " + sourceStation + " -> " + destinationStation);
        System.out.println("Base Fare   : ₹" + baseFareINR);
    }
}

/**
 * Subclass representing a Premium Tatkal Booking Ticket.
 * Demonstrates 'super(...)', Constructor Chaining, and 'super.' method/field access.
 */
class TatkalTrainTicket extends TrainTicket {
    private double tatkalChargeINR;
    private String bookingTime;

    // Field Shadowing Example: Subclass defines baseFareINR with local priority
    // (Used to demonstrate accessing parent's baseFareINR via 'super.baseFareINR')
    protected double baseFareINR; 

    // Constructor 1: Parameterized using explicit super(...)
    public TatkalTrainTicket(String pnrNumber, String passengerName, String sourceStation, 
                             String destinationStation, double parentBaseFare, double tatkalChargeINR, String bookingTime) {
        // RULE 1: super(...) MUST be the very first statement in the subclass constructor!
        super(pnrNumber, passengerName, sourceStation, destinationStation, parentBaseFare);
        
        System.out.println("-> STEP 2: [TatkalTrainTicket] Child Constructor executed.");
        this.tatkalChargeINR = tatkalChargeINR;
        this.bookingTime = bookingTime;
        
        // Setting child shadow variable
        this.baseFareINR = parentBaseFare + 150.0; // Child fare includes processing fee
    }

    // Constructor 2: Demonstrates calling default super() implicitly/explicitly
    public TatkalTrainTicket(double tatkalChargeINR, String bookingTime) {
        // If super(...) is not written, Java automatically inserts implicit super() call here!
        System.out.println("-> STEP 2: [TatkalTrainTicket] Overloaded Child Constructor executed.");
        this.tatkalChargeINR = tatkalChargeINR;
        this.bookingTime = bookingTime;
        this.baseFareINR = 650.0;
    }

    // Demonstrates method overriding and invoking parent method via super.printTicketSummary()
    @Override
    public void printTicketSummary() {
        // Call Parent method implementation using 'super.'
        super.printTicketSummary(); 

        // Additional Tatkal specific output
        System.out.println("Tatkal Fee  : ₹" + tatkalChargeINR);
        System.out.println("Booking Time: " + bookingTime + " (10:00 AM IRCTC Tatkal Window)");
        System.out.println("Total Amount: ₹" + calculateTotalFare());

        // Demonstrates resolving Field Shadowing using 'super.baseFareINR'
        System.out.println("\n[FIELD SHADOWING RESOLUTION]");
        System.out.println("Child 'this.baseFareINR'  : ₹" + this.baseFareINR);
        System.out.println("Parent 'super.baseFareINR': ₹" + super.baseFareINR);
    }

    public double calculateTotalFare() {
        // Uses super.baseFareINR to get original base fare from parent object state
        return super.baseFareINR + tatkalChargeINR;
    }
}

/**
 * Demonstrates Super Keyword, super(...) with Constructors & Constructor Chaining in Java.
 * 
 * CORE RULES COVERED:
 * 1. Constructor Chaining: Parent constructor ALWAYS executes BEFORE Child constructor.
 * 2. super(...): Used to invoke parameterized parent constructor. Must be the FIRST line in child constructor.
 * 3. Implicit super(): If no super(...) is written, Java compiler automatically inserts super() to invoke parent default constructor.
 * 4. super.methodName(): Used to explicitly invoke parent class method when overridden by child.
 * 5. super.variableName(): Used to access parent class instance field when shadowed by child field.
 */
public class SuperKeywordConstructorChainingDemo {

    public static void main(String[] args) {
        System.out.println("========================================================================");
        System.out.println("   CONCEPT 4: SUPER KEYWORD & CONSTRUCTOR CHAINING (IRCTC TICKETING)");
        System.out.println("========================================================================");

        System.out.println("\n--- 1. Instantiating Tatkal Ticket with Explicit super(...) ---");
        TatkalTrainTicket tatkalTicket1 = new TatkalTrainTicket(
            "PNR-42189012", 
            "Vikramaditya Das", 
            "SBC (KSR Bengaluru)", 
            "MAS (Chennai Central)", 
            850.0, 
            250.0, 
            "10:00:15 AM"
        );

        System.out.println("\n--- Displaying Tatkal Ticket 1 Summary ---");
        tatkalTicket1.printTicketSummary();

        System.out.println("\n--- 2. Instantiating Tatkal Ticket with Implicit super() Call ---");
        TatkalTrainTicket tatkalTicket2 = new TatkalTrainTicket(200.0, "10:01:02 AM");
        
        System.out.println("\n--- Displaying Tatkal Ticket 2 Summary ---");
        tatkalTicket2.printTicketSummary();

        System.out.println("\n========================================================================");
        System.out.println("   CONSTRUCTOR CHAINING RECAP:");
        System.out.println("   1. Object creation flows from Top of Hierarchy (Parent) to Bottom (Child).");
        System.out.println("   2. super(...) must be statement #1 inside child constructor.");
        System.out.println("   3. 'super.' accesses parent methods/fields obscured by child overriding/shadowing.");
        System.out.println("========================================================================");
    }
}
