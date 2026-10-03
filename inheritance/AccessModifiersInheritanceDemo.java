package inheritance;

/**
 * Superclass representing an Indian UIDAI Aadhaar Identity Card record.
 * Demonstrates all four access modifiers: private, default (package-private), protected, public.
 */
class AadhaarIdentityCard {
    // 1. PRIVATE: Accessible ONLY inside AadhaarIdentityCard class. Subclasses CANNOT access directly.
    private String biometricIrisHash;

    // 2. DEFAULT (Package-Private): Accessible to any class inside package 'inheritance'.
    String internalCenterCode;

    // 3. PROTECTED: Accessible to classes in package 'inheritance' AND subclasses everywhere.
    protected String citizenFullName;
    protected String aadhaarNumber; // Format: XXXX-XXXX-1234

    // 4. PUBLIC: Accessible from anywhere in the application.
    public String stateOfResidence;

    // Superclass Constructor
    public AadhaarIdentityCard(String biometricIrisHash, String internalCenterCode, 
                               String citizenFullName, String aadhaarNumber, String stateOfResidence) {
        this.biometricIrisHash = biometricIrisHash;
        this.internalCenterCode = internalCenterCode;
        this.citizenFullName = citizenFullName;
        this.aadhaarNumber = aadhaarNumber;
        this.stateOfResidence = stateOfResidence;
    }

    // Public getter to safely expose private biometric information in masked format
    public String getMaskedBiometricHash() {
        if (biometricIrisHash != null && biometricIrisHash.length() > 8) {
            return biometricIrisHash.substring(0, 4) + "****" + biometricIrisHash.substring(biometricIrisHash.length() - 4);
        }
        return "****SECRET****";
    }

    // Protected method for subclass access
    protected void displayBaseIdentity() {
        System.out.println("UIDAI Record -> Name: " + citizenFullName + " | Aadhaar: " + aadhaarNumber);
    }
}

/**
 * Subclass representing an Aadhaar-Verified College Student in India.
 * Demonstrates direct access rights to parent class fields based on access modifiers.
 */
class AadhaarVerifiedStudent extends AadhaarIdentityCard {
    private String studentId;
    private String universityName;

    public AadhaarVerifiedStudent(String biometricIrisHash, String internalCenterCode, 
                                  String citizenFullName, String aadhaarNumber, String stateOfResidence,
                                  String studentId, String universityName) {
        super(biometricIrisHash, internalCenterCode, citizenFullName, aadhaarNumber, stateOfResidence);
        this.studentId = studentId;
        this.universityName = universityName;
    }

    public void verifyStudentIdentity() {
        System.out.println("--- Student Aadhaar Verification Audit ---");
        
        // --- 1. PUBLIC Access Test ---
        // SUCCESS: 'public' field stateOfResidence is directly accessible anywhere
        System.out.println("[PUBLIC Field]    State of Residence : " + stateOfResidence);

        // --- 2. PROTECTED Access Test ---
        // SUCCESS: 'protected' fields citizenFullName & aadhaarNumber are directly accessible in subclasses
        System.out.println("[PROTECTED Field] Citizen Name       : " + citizenFullName);
        System.out.println("[PROTECTED Field] Aadhaar Number     : " + aadhaarNumber);

        // --- 3. DEFAULT (Package-Private) Access Test ---
        // SUCCESS: 'internalCenterCode' is accessible here because both classes belong to package 'inheritance'
        System.out.println("[DEFAULT Field]   UIDAI Center Code  : " + internalCenterCode);

        // --- 4. PRIVATE Access Test ---
        // UNCOMMENTING THE LINE BELOW WILL CAUSE COMPILATION ERROR:
        // System.out.println("[PRIVATE Field] Biometric: " + this.biometricIrisHash);
        // Error: biometricIrisHash has private access in inheritance.AadhaarIdentityCard

        // CORRECT WAY: Access private data through a public/protected parent method:
        System.out.println("[PRIVATE via Getter] Masked Biometric: " + getMaskedBiometricHash());
        
        System.out.println("[Student Info]    Roll No: " + studentId + " | Uni: " + universityName);
    }
}

/**
 * Demonstrates Access Control (Modifiers) with Inheritance in Java.
 * 
 * SUMMARY MATRIX FOR STUDENTS:
 * +-------------------+---------------+-------------------+----------------------+---------------------+
 * | Access Modifier   | Same Class    | Same Pkg Subclass | Same Pkg Non-Subclass| Diff Pkg Subclass   |
 * +-------------------+---------------+-------------------+----------------------+---------------------+
 * | private           |      YES      |        NO         |          NO          |          NO         |
 * | default (package) |      YES      |      YES          |         YES          |          NO         |
 * | protected         |      YES      |      YES          |         YES          |         YES         |
 * | public            |      YES      |      YES          |         YES          |         YES         |
 * +-------------------+---------------+-------------------+----------------------+---------------------+
 */
public class AccessModifiersInheritanceDemo {

    public static void main(String[] args) {
        System.out.println("========================================================================");
        System.out.println("   CONCEPT 3: ACCESS MODIFIERS WITH INHERITANCE (AADHAAR IDENTITY)");
        System.out.println("========================================================================");

        AadhaarVerifiedStudent student = new AadhaarVerifiedStudent(
            "HASH-9981-IRIS-X8829104", 
            "ENROLL-KA-BLR-04", 
            "Priya Ananth", 
            "5432-9876-1234", 
            "Karnataka", 
            "2026-CS-108", 
            "VTU Mysuru"
        );

        // Execute student verification method demonstrating access inside subclass
        student.verifyStudentIdentity();

        System.out.println("\n--- Testing Access from External Client (AccessModifiersInheritanceDemo main) ---");
        // Accessing public field from outside
        System.out.println("Public field access from main(): " + student.stateOfResidence);
        
        // Accessing protected field from main() (allowed because main() is in the SAME package 'inheritance')
        System.out.println("Protected field access from same package main(): " + student.citizenFullName);

        // Direct private access fails! (e.g., student.biometricIrisHash is invisible)
        System.out.println("Private field via public getter from main(): " + student.getMaskedBiometricHash());

        System.out.println("\n========================================================================");
        System.out.println("   KEY LESSONS FOR STUDENTS:");
        System.out.println("   1. Private members are NOT inherited; they remain encapsulated.");
        System.out.println("   2. Protected members ARE inherited and intended for subclass access.");
        System.out.println("   3. Default members are visible ONLY within the same package.");
        System.out.println("   4. Public members are accessible everywhere without restriction.");
        System.out.println("========================================================================");
    }
}
