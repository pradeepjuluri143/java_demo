package arrays;

/**
 * Custom Object Class representing an Employee in an Indian IT firm.
 */
class Employee {
    String name;
    double salary; // Salary in Indian Rupees (INR)

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.printf("  Employee: %-8s | Monthly Salary: ₹%.2f%n", name, salary);
    }
}

/**
 * ============================================================================
 * SELF-LEARNING GUIDE: PASSING OBJECT ARRAYS TO METHODS IN JAVA
 * ============================================================================
 * Key Concepts:
 * 1. Object Arrays store REFERENCES to objects on the Heap.
 * 2. Passing an Object Array (Employee[]) to a method passes a copy of the array reference.
 * 3. Modifying individual object properties inside the array (e.g. employee.salary += ...)
 *    MUTATES the actual objects stored in Heap memory.
 * 4. Methods can also process an object array and RETURN a NEW object array
 *    (e.g., filtering elements matching a criteria like min salary).
 * ============================================================================
 */
public class ObjectArrayPassingDemo {

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" DEMO: OBJECT ARRAY PASSING & METHOD MUTATION");
        System.out.println("==================================================================");

        // Initializing staff array containing 3 Employee object references
        Employee[] staff = {
            new Employee("Anil", 50000.00),
            new Employee("Sunita", 65000.00),
            new Employee("Rajesh", 48000.00)
        };

        System.out.println("=== Staff Members Before Salary Appraisal ===");
        for (Employee e : staff) {
            e.display();
        }

        // ----------------------------------------------------------------------
        // Case 1: Pass object array to a method that mutates object state
        // ----------------------------------------------------------------------
        System.out.println("\n--> Step 1: Applying 10% annual salary increment via giveSalaryRaise()...");
        giveSalaryRaise(staff, 10.0);

        System.out.println("\n=== Staff Members After 10% Increment ===");
        for (Employee e : staff) {
            e.display(); // Salaries updated: Anil -> ₹55,000, Sunita -> ₹71,500, Rajesh -> ₹52,800
        }

        // ----------------------------------------------------------------------
        // Case 2: Pass object array to a method that creates and returns a NEW filtered array
        // ----------------------------------------------------------------------
        System.out.println("\n--> Step 2: Filtering high earners (> ₹60,000 INR) via filterHighEarners()...");
        Employee[] highEarners = filterHighEarners(staff, 60000.00);

        System.out.println("\n=== Filtered High Earners List (New Returned Array) ===");
        System.out.println("High Earners Array Length: " + highEarners.length);
        for (Employee e : highEarners) {
            e.display();
        }
    }

    /**
     * Mutates properties of objects inside the passed array.
     * @param employees Array of Employee references.
     * @param percentage Salary hike percentage.
     */
    public static void giveSalaryRaise(Employee[] employees, double percentage) {
        // Traversing object array with enhanced for-each loop
        for (Employee e : employees) {
            // Null-check safety to avoid NullPointerException if array slots are empty
            if (e != null) {
                // Mutating property of object in Heap via reference 'e'
                e.salary += e.salary * (percentage / 100.0);
            }
        }
    }

    /**
     * Filters objects matching a salary threshold and returns a NEW object array.
     * @param employees Original array of employees.
     * @param minSalary Minimum salary threshold in INR.
     * @return A newly created Employee[] containing only matching employees.
     */
    public static Employee[] filterHighEarners(Employee[] employees, double minSalary) {
        // --- Pass 1: Count matching elements to size the result array ---
        int count = 0;
        for (Employee e : employees) {
            if (e != null && e.salary >= minSalary) {
                count++;
            }
        }

        // --- Pass 2: Instantiate new array with exact required size ---
        Employee[] result = new Employee[count];
        int idx = 0;

        // --- Pass 3: Populate result array with references to matching objects ---
        for (Employee e : employees) {
            if (e != null && e.salary >= minSalary) {
                result[idx++] = e; // Assigns matching reference to new array slot
            }
        }

        return result; // Return reference to newly created array object
    }
}
