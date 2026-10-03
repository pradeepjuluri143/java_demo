# Java Samples Repository

Welcome to the Java samples repository! This workspace contains modular sample programs designed to teach Java concepts using clear examples, step-by-step inline comments, cheat sheets, and real-world Indian contexts.

---

## 📦 Packages & Content

- **`inheritance/`**: 10 complete sample programs covering inheritance basics, types, diamond problem, access modifiers, super keyword, constructor chaining, method overriding rules, final keyword, Object class, casting, dynamic method dispatch, and polymorphism deep dive.
- **`arrays/`**: Complete guide & code examples covering array declaration, initialization, length, traversal, and loop mutation using primitive and object arrays.
- **Root Demos**: Pass-by-value demos (`PassByValuePrimitiveVsObjectDemo.java`), OOP models (`Student`, `Address`, `Branch`, `Book`, etc.).

---

## ⚙️ Automated Build Utilities (Compiles All Folders)

To automatically compile **all `.java` files** (including any present or future package folders) into the **`bin/`** directory, run one of the included build scripts from the project root:

### ⚡ Quick Commands:
- **Command Prompt (CMD):**
  ```cmd
  build.bat
  ```
- **PowerShell:**
  ```powershell
  .\build.ps1
  ```
- **Git Bash / Linux:**
  ```bash
  ./build.sh
  ```

---

## 🏛️ Java Inheritance & Polymorphism Curriculum (`inheritance`)

### 📁 Package Directory & Curriculum Structure (10 Demos)

```text
java-samples/
└── inheritance/
    ├── BasicsAndWhyInheritanceDemo.java         # 1. Inheritance Basics, DRY Principle & IS-A Relationship
    ├── TypesOfInheritanceDemo.java              # 2. Types of Inheritance & Unsupported Multiple Inheritance (Diamond Problem)
    ├── AccessModifiersInheritanceDemo.java      # 3. Access Control (private, default, protected, public) with Inheritance
    ├── SuperKeywordConstructorChainingDemo.java # 4. Super Keyword, super(...) & Constructor Chaining
    ├── MethodOverridingRulesDemo.java           # 5. Method Overriding Rules, Covariant Returns & Static Hiding
    ├── FinalKeywordInheritanceDemo.java         # 6. Final Keyword Impact (Final Variables, Methods & Classes)
    ├── ObjectUniversalSuperClassDemo.java       # 7. java.lang.Object Class (equals, ==, toString, hashCode)
    ├── UpcastingAndCastingDemo.java             # 8. Upcasting, Downcasting, instanceof & ClassCastException
    ├── DynamicMethodDispatchDemo.java           # 9. Dynamic Method Dispatch & Field Hiding vs Method Overriding
    └── PolymorphismDeepDiveDemo.java            # 10. Polymorphism Deep Dive (Overloading vs Overriding, Loose Coupling)
```

---

### 📚 Inheritance Detailed Topic Summaries

#### 1. `inheritance.BasicsAndWhyInheritanceDemo`
- **Topics**: What is Inheritance, Why We Need It & Process in Java (`extends` keyword).
- **Core Concepts**: Code Reusability, Don't Repeat Yourself (DRY) principle, Superclass (Parent) vs Subclass (Child), and **IS-A** relationship (`SavingsAccount` IS-A `BankAccount`).
- **Indian Context**: SBI & HDFC Bank Accounts (`BankAccount` superclass -> `SavingsAccount` & `CurrentAccount` subclasses).

#### 2. `inheritance.TypesOfInheritanceDemo`
- **Topics**: Types of Inheritance & Unsupported Multiple Inheritance (The Diamond Problem).
- **Core Concepts**: Single, Multilevel, Hierarchical inheritance. Deep dive into the **Diamond Problem** (method signature ambiguity with multiple parent classes) and why Java bans class multiple inheritance. Demonstrates how multiple interfaces solve hybrid inheritance safely.
- **Indian Context**: Tata Motors EV & Commercial Vehicle lineup (`TataVehicle` -> `TataPassengerCar` -> `TataNexonEV`, `TataCommercialTruck`, `TataTiagoEV`).

#### 3. `inheritance.AccessModifiersInheritanceDemo`
- **Topics**: Access Control (Modifiers) with Inheritance Re-visited.
- **Core Concepts**: Access permissions matrix (`private`, `default`/package-private, `protected`, `public`). Encapsulation preservation vs inheritance exposure.
- **Indian Context**: UIDAI Aadhaar Identity Verification (`AadhaarIdentityCard` superclass -> `AadhaarVerifiedStudent` subclass).

#### 4. `inheritance.SuperKeywordConstructorChainingDemo`
- **Topics**: Super Keyword, `super(...)` with Constructors & Constructor Chaining.
- **Core Concepts**: `super(...)` constructor invocation rule (MUST be the first line in child constructor), implicit vs explicit `super()` calls, top-down constructor execution order (Parent first, then Child), resolving method overriding with `super.method()`, and resolving field shadowing with `super.variable`.
- **Indian Context**: IRCTC Railway Ticket Booking (`TrainTicket` superclass -> `TatkalTrainTicket` subclass).

#### 5. `inheritance.MethodOverridingRulesDemo`
- **Topics**: Method Overriding & Rules of Overriding.
- **Core Concepts**: Exact method signature matching, `@Override` compiler check, access modifier rule (cannot narrow visibility; expanding is allowed), Covariant Return Types (returning subclass of parent return type), checked exception rules, static method hiding vs dynamic overriding, and private/final method non-overridability.
- **Indian Context**: Swiggy & Zomato Delivery Partner platform (`SwiggyDeliveryPartner` superclass -> `ElectricBikeDeliveryPartner` subclass).

#### 6. `inheritance.FinalKeywordInheritanceDemo`
- **Topics**: Final Keyword Impact on Inheritance.
- **Core Concepts**: `final` variables (constants/immutable state), `final` methods (cannot be overridden by subclasses; locks core business logic/security rules), and `final` classes (cannot be extended/subclassed; e.g. `java.lang.String`). Performance optimization via JIT inlining.
- **Indian Context**: Reserve Bank of India (RBI) Financial Regulatory Policy (`RBIBankingRegulation` superclass -> `StateBankOfIndia` subclass; `RBISecureDatabaseVault` final class).

#### 7. `inheritance.ObjectUniversalSuperClassDemo`
- **Topics**: Universal Super Class `java.lang.Object` & Important Methods.
- **Core Concepts**: `java.lang.Object` as the root of all Java class hierarchies. Overriding `toString()`, `equals(Object obj)`, and `hashCode()`. Reference identity (`==`) vs Logical content equality (`equals()`). Contract between `equals()` and `hashCode()` for hash-based collections (`HashSet`, `HashMap`).
- **Indian Context**: UPI Payment Transactions (`UPITransaction`).

#### 8. `inheritance.UpcastingAndCastingDemo`
- **Topics**: Upcasting & Reference Object Casting (Parent Reference to Child Instance).
- **Core Concepts**: Implicit Upcasting (`Parent p = new Child()`) vs Explicit Downcasting (`Child c = (Child) p`), compile-time reference type restrictions, avoiding `ClassCastException` using `instanceof` checks, and modern Java Pattern Matching `instanceof`.
- **Indian Context**: NH-44 Toll Plaza FASTag System (`FASTagVehicle` superclass -> `TruckFASTag` & `CarFASTag` subclasses).

#### 9. `inheritance.DynamicMethodDispatchDemo`
- **Topics**: Dynamic Method Dispatch & Parent Reference Referring to Child Object.
- **Core Concepts**: Run-time Polymorphism mechanism. Method invocation decision is made at **RUNTIME** based on the actual target **OBJECT** in Heap memory, NOT the reference variable type. **Field Hiding rule**: Field access is resolved at **COMPILE-TIME** based on reference type (Fields are NOT polymorphic!). Heterogeneous polymorphic array processing.
- **Indian Context**: Jio, Airtel, and BSNL Telecom Tariff Plans (`TelecomPlan` superclass -> `Jio5GUnlimitedPlan`, `AirtelFamilyPostpaidPlan`, `BSNLEconomyPlan`).

#### 10. `inheritance.PolymorphismDeepDiveDemo`
- **Topics**: Polymorphism Deep Dive (Static vs Dynamic, Loose Coupling & Real-World Patterns).
- **Core Concepts**: Compile-time (Static) Polymorphism via Method Overloading vs Run-time (Dynamic) Polymorphism via Method Overriding. Loose Coupling principle (depending on abstractions rather than concrete implementations). Factory & Dependency Injection design patterns.
- **Indian Context**: Flipkart & Amazon India E-Commerce Multi-Payment Gateway Engine (`IPaymentGateway` interface -> `UPIPaymentGateway`, `CreditCardPaymentGateway`, `NetBankingPaymentGateway` -> `ECommerceCheckoutService`).

---

### ⚡ Inheritance Quick Reference Cheat Sheets

#### Access Modifiers Matrix
| Access Modifier | Same Class | Same Package Subclass | Same Package Non-Subclass | Different Package Subclass | Different Package Non-Subclass |
| :--- | :---: | :---: | :---: | :---: | :---: |
| `private` | ✅ | ❌ | ❌ | ❌ | ❌ |
| `default` (package) | ✅ | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ | ✅ |

#### Overloading vs Overriding
| Characteristic | Method Overloading (Static) | Method Overriding (Dynamic) |
| :--- | :--- | :--- |
| **Binding Time** | Compile-Time (Static Binding) | Run-Time (Dynamic Dispatch) |
| **Location** | Same class or Subclass | Superclass & Subclass relationship |
| **Method Name** | MUST be identical | MUST be identical |
| **Parameter List**| MUST be DIFFERENT | MUST be EXACTLY THE SAME |
| **Return Type** | Can be different | Must be same OR Covariant (Subtype) |
| **Private/Static**| Can be overloaded | Cannot be overridden (Static = Hidden) |

#### Binding Matrix: Methods vs Fields
| Member Type | Invocation Target Determined By | Binding Type |
| :--- | :--- | :--- |
| **Instance Methods** | Actual Target **OBJECT** in Heap | Dynamic (Run-Time) |
| **Instance Fields / Variables** | **REFERENCE Variable Type** | Static (Compile-Time) |
| **Static Methods** | **REFERENCE Variable Type** | Static (Compile-Time) |

---

## 🛠️ Generic `javac` Command Guide (For Any Folder / Package)

When working with multiple package directories, use the **`@sources.txt` argument file** technique to compile all `.java` files across any folder structure recursively.

```powershell
# On PowerShell:
javac -d bin (Get-ChildItem -Recurse -Filter *.java | Select-Object -ExpandProperty FullName)
```

```cmd
:: On Windows CMD:
dir /s /b *.java > sources.txt
javac -d bin @sources.txt
del sources.txt
```

---

## 🏃 Running Compiled Classes

Always use the `-cp bin` (classpath) flag from the root directory to run any compiled class:

```bash
# Run inheritance package demos
java -cp bin inheritance.BasicsAndWhyInheritanceDemo
java -cp bin inheritance.TypesOfInheritanceDemo
java -cp bin inheritance.AccessModifiersInheritanceDemo
java -cp bin inheritance.SuperKeywordConstructorChainingDemo
java -cp bin inheritance.MethodOverridingRulesDemo
java -cp bin inheritance.FinalKeywordInheritanceDemo
java -cp bin inheritance.ObjectUniversalSuperClassDemo
java -cp bin inheritance.UpcastingAndCastingDemo
java -cp bin inheritance.DynamicMethodDispatchDemo
java -cp bin inheritance.PolymorphismDeepDiveDemo

# Run arrays package demos
java -cp bin arrays.ArrayDeclarationInitializationDemo
java -cp bin arrays.ArrayLengthAndTraversingDemo
java -cp bin arrays.ArrayLoopMutationDemo

# Run root package demos
java -cp bin PassByValuePrimitiveVsObjectDemo
```
