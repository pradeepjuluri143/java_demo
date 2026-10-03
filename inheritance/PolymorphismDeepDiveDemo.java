package inheritance;

// ============================================================================
// 1. ABSTRACTION / INTERFACE FOR LOOSE COUPLING
// ============================================================================
/**
 * Interface representing a generic Payment Gateway in India.
 * Formulates the contract that all concrete payment providers must satisfy.
 */
interface IPaymentGateway {
    // Dynamic Polymorphism Target Method
    boolean processPayment(String transactionId, double amountINR);
    String getGatewayProviderName();
}

// ============================================================================
// 2. CONCRETE IMPLEMENTATIONS (DYNAMIC POLYMORPHISM / OVERRIDING)
// ============================================================================

/**
 * Concrete implementation for UPI Payment Gateway (PhonePe / Google Pay / BHIM).
 */
class UPIPaymentGateway implements IPaymentGateway {
    private String upiVpa;

    public UPIPaymentGateway(String upiVpa) {
        this.upiVpa = upiVpa;
    }

    @Override
    public boolean processPayment(String transactionId, double amountINR) {
        System.out.println("[UPI GATEWAY] Routing ₹" + amountINR + " via NPCI UPI network for VPA: " + upiVpa + " [Txn: " + transactionId + "]");
        System.out.println("  -> UPI PIN verified via mobile device. Payment SUCCESSFUL!");
        return true;
    }

    @Override
    public String getGatewayProviderName() {
        return "NPCI UPI (Unified Payments Interface)";
    }

    // STATIC POLYMORPHISM (METHOD OVERLOADING) inside UPI Payment Gateway
    // Method 1: Standard pay with default UPI ID
    public void payInstant(double amountINR) {
        processPayment("TXN-INSTANT-01", amountINR);
    }

    // Method 2: Overloaded pay with custom receiver note
    public void payInstant(double amountINR, String transactionNote) {
        System.out.println("Note attached: '" + transactionNote + "'");
        processPayment("TXN-INSTANT-02", amountINR);
    }
}

/**
 * Concrete implementation for Credit/Debit Card Gateway (HDFC / SBI / ICICI Cards).
 */
class CreditCardPaymentGateway implements IPaymentGateway {
    private String maskedCardNumber;
    private String cardNetwork; // Visa, MasterCard, RuPay

    public CreditCardPaymentGateway(String cardNumber, String cardNetwork) {
        this.maskedCardNumber = "XXXX-XXXX-XXXX-" + cardNumber.substring(cardNumber.length() - 4);
        this.cardNetwork = cardNetwork;
    }

    @Override
    public boolean processPayment(String transactionId, double amountINR) {
        System.out.println("[" + cardNetwork.toUpperCase() + " CARD] Authorizing ₹" + amountINR + 
                           " for Card: " + maskedCardNumber + " [Txn: " + transactionId + "]");
        System.out.println("  -> 2FA OTP verified via Bank Secure Gateway. Payment SUCCESSFUL!");
        return true;
    }

    @Override
    public String getGatewayProviderName() {
        return cardNetwork + " Payment Gateway";
    }
}

/**
 * Concrete implementation for NetBanking Gateway (SBI / ICICI / HDFC NetBanking).
 */
class NetBankingPaymentGateway implements IPaymentGateway {
    private String bankName;

    public NetBankingPaymentGateway(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public boolean processPayment(String transactionId, double amountINR) {
        System.out.println("[NET BANKING] Redirecting to " + bankName + " NetBanking portal for ₹" + amountINR + " [Txn: " + transactionId + "]");
        System.out.println("  -> Bank Corporate User Credentials authenticated. Payment SUCCESSFUL!");
        return true;
    }

    @Override
    public String getGatewayProviderName() {
        return bankName + " NetBanking Portal";
    }
}

// ============================================================================
// 3. HIGH-LEVEL DECOUPLED SERVICE CLASS (DESIGN PATTERN)
// ============================================================================
/**
 * E-Commerce Checkout Engine (e.g. Flipkart / Amazon India Order Checkout).
 * 
 * LOOSE COUPLING PRINCIPLE:
 * This class DOES NOT depend on UPIPaymentGateway, CreditCardPaymentGateway, or NetBankingPaymentGateway!
 * It depends ONLY on the abstraction interface 'IPaymentGateway'.
 * 
 * BENEFIT: You can add 10 new payment methods (e.g., Cred, WhatsApp Pay, EMI, Crypto) without changing
 * a single line of code inside ECommerceCheckoutService!
 */
class ECommerceCheckoutService {
    // Injected Dependency (Polymorphic Reference)
    private IPaymentGateway paymentGateway;

    // Dependency Injection via Constructor (Loose Coupling)
    public ECommerceCheckoutService(IPaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    // Setter to switch payment gateway dynamically at runtime
    public void setPaymentGateway(IPaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void checkoutOrder(String orderId, double orderTotalINR) {
        System.out.println("\n--- Initiating Order Checkout for Order #" + orderId + " ---");
        System.out.println("Order Total Amount : ₹" + orderTotalINR);
        System.out.println("Selected Gateway   : " + paymentGateway.getGatewayProviderName());

        // Polymorphic Call (Dynamic Method Dispatch)
        boolean isSuccess = paymentGateway.processPayment("TXN-CHK-" + orderId, orderTotalINR);

        if (isSuccess) {
            System.out.println("ORDER STATUS: CONFIRMED & DISPATCH READY.");
        } else {
            System.out.println("ORDER STATUS: FAILED. Please retry payment.");
        }
    }
}

/**
 * Demonstrates Polymorphism Deep Dive (Static vs Dynamic, Loose Coupling & Real-World Patterns).
 * 
 * CONCEPTS SUMMARY FOR STUDENTS:
 * 1. STATIC POLYMORPHISM  : Method Overloading (Resolved at compile-time by method signature).
 * 2. DYNAMIC POLYMORPHISM : Method Overriding (Resolved at runtime by target object type).
 * 3. LOOSE COUPLING       : High-level modules depend on abstractions (interfaces), not concrete implementations.
 * 4. EXTENSIBILITY        : New features can be added by introducing new subclasses without altering core engine logic.
 */
public class PolymorphismDeepDiveDemo {

    public static void main(String[] args) {
        System.out.println("========================================================================");
        System.out.println("   CONCEPT 10: POLYMORPHISM DEEP DIVE (FLIPKART / AMAZON CHECKOUT)");
        System.out.println("========================================================================");

        // =====================================================================
        // 1. STATIC POLYMORPHISM DEMONSTRATION (METHOD OVERLOADING)
        // =====================================================================
        System.out.println("\n--- 1. Static Polymorphism (Method Overloading) ---");
        UPIPaymentGateway upiGateway = new UPIPaymentGateway("ananya@okaxis");

        // Compiler selects which overload to call based on argument list
        upiGateway.payInstant(1500.0);
        upiGateway.payInstant(2500.0, "Saree purchase gift for mother");

        // =====================================================================
        // 2. DYNAMIC POLYMORPHISM & LOOSE COUPLING IN REAL-WORLD PATTERN
        // =====================================================================
        System.out.println("\n--- 2. Dynamic Polymorphism & Loose Coupling in Action ---");

        // Customer 1 chooses UPI Payment
        ECommerceCheckoutService checkoutEngine = new ECommerceCheckoutService(upiGateway);
        checkoutEngine.checkoutOrder("OD-2026-9011", 1500.0);

        // Customer 2 chooses HDFC Credit Card (Switching payment gateway seamlessly!)
        IPaymentGateway hdfcCardGateway = new CreditCardPaymentGateway("4532119988223456", "RuPay Credit");
        checkoutEngine.setPaymentGateway(hdfcCardGateway);
        checkoutEngine.checkoutOrder("OD-2026-9012", 18500.0);

        // Customer 3 chooses SBI NetBanking
        IPaymentGateway sbiNetBanking = new NetBankingPaymentGateway("State Bank of India");
        checkoutEngine.setPaymentGateway(sbiNetBanking);
        checkoutEngine.checkoutOrder("OD-2026-9013", 42000.0);

        System.out.println("\n========================================================================");
        System.out.println("   POLYMORPHISM ARCHITECTURE RECAP:");
        System.out.println("   1. Static Polymorphism  : Overloading (Compile-Time).");
        System.out.println("   2. Dynamic Polymorphism : Overriding (Run-Time).");
        System.out.println("   3. Loose Coupling       : Program to an Interface, not an Implementation.");
        System.out.println("   4. Flexible Design      : Solves real-world software architecture scaling.");
        System.out.println("========================================================================");
    }
}
