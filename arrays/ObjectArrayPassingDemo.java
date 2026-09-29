package arrays;

// Custom Employee Class
class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.printf("Employee: %-8s | Salary: ₹%.2f%n", name, salary);
    }
}

public class ObjectArrayPassingDemo {
    public static void main(String[] args) {
        Employee[] staff = {
                new Employee("Anil", 50000),
                new Employee("Sunita", 65000),
                new Employee("Rajesh", 48000)
        };

        System.out.println("=== Staff Before Salary Raise ===");
        for (Employee e : staff)
            e.display();

        // 1. Pass object array to method (Mutates internal objects on Heap)
        giveSalaryRaise(staff, 10.0);

        System.out.println("\n=== Staff After 10% Raise ===");
        for (Employee e : staff)
            e.display();

        // 2. Method returning a newly created & filtered Object Array
        Employee[] highEarners = filterHighEarners(staff, 60000);

        System.out.println("\n=== High Earners (> ₹60,000) ===");
        for (Employee e : highEarners)
            e.display();
    }

    // Mutates object properties inside the passed array
    public static void giveSalaryRaise(Employee[] employees, double percentage) {
        for (Employee e : employees) {
            if (e != null) {
                e.salary += e.salary * (percentage / 100.0);
            }
        }
    }

    // Filters objects and returns a new Object Array
    public static Employee[] filterHighEarners(Employee[] employees, double minSalary) {
        int count = 0;
        for (Employee e : employees) {
            if (e != null && e.salary >= minSalary)
                count++;
        }

        Employee[] result = new Employee[count];
        int idx = 0;
        for (Employee e : employees) {
            if (e != null && e.salary >= minSalary) {
                result[idx++] = e;
            }
        }
        return result;
    }
}
