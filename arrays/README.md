# Java Arrays - Complete Sample Programs & Self-Learning Guide

This package (`arrays`) contains a complete curriculum of Java array sample programs designed for **self-learning**. Every program includes detailed step-by-step inline comments, Javadoc headers, memory layout notes (Stack vs. Heap, Reference vs. Primitive), and Indian context examples.

---

## 📁 Package Structure (11 Demos)

```text
java-samples/
└── arrays/
    ├── ArrayDeclarationInitializationDemo.java   # Declaration, default values, array literals
    ├── ArrayLengthAndTraversingDemo.java          # .length property & 5 traversing methods
    ├── ArrayLoopMutationDemo.java                # Loop mutation (for vs for-each)
    ├── ArrayPassingDemo.java                     # Primitive array passing & method mutation
    ├── ObjectArrayPassingDemo.java               # Object array passing, hikes & filtering
    ├── DynamicArrayDemo.java                     # Custom Dynamic Array (ArrayList internal logic)
    ├── ArraySortingDemo.java                     # Bubble Sort, Selection Sort, Arrays.sort(), Descending
    ├── ArraySearchingDemo.java                   # Linear Search vs Arrays.binarySearch()
    ├── ArraysClassDemo.java                      # java.util.Arrays utility class methods
    ├── MultiDimensionalArrayDemo.java            # 2D Matrices & 3D Cubes traversal
    ├── RaggedArraysAndVectorsDemo.java           # Ragged (Jagged) arrays & Vector math
    └── README.md
```

---

## 🛠️ How to Compile and Run

From the root project directory (`java-samples/`), run:

```bash
# Automated compile script (Compiles all files into bin/)
build.bat      # Windows CMD
.\build.ps1    # PowerShell
./build.sh     # Git Bash / Linux
```

### Running individual programs from `bin/`:

```bash
java -cp bin arrays.ArrayDeclarationInitializationDemo
java -cp bin arrays.ArrayLengthAndTraversingDemo
java -cp bin arrays.ArrayLoopMutationDemo
java -cp bin arrays.ArrayPassingDemo
java -cp bin arrays.ObjectArrayPassingDemo
java -cp bin arrays.DynamicArrayDemo
java -cp bin arrays.ArraySortingDemo
java -cp bin arrays.ArraySearchingDemo
java -cp bin arrays.ArraysClassDemo
java -cp bin arrays.MultiDimensionalArrayDemo
java -cp bin arrays.RaggedArraysAndVectorsDemo
```

---

## 📚 Curriculum Summary & Key Concepts

### 1. `ArrayDeclarationInitializationDemo.java`
- **Concepts**: Stack reference vs Heap object allocation, default uninitialized values (`0`, `0.0`, `null`), array literals `{...}`, and anonymous arrays `new Type[]{...}`.
- **Context**: IPL scores, petrol prices in INR, Metro cities, UPI payment transaction objects (`UPIPayment`).

### 2. `ArrayLengthAndTraversingDemo.java`
- **Concepts**: Array `.length` final instance property vs `String.length()`, 5 traversal techniques (Forward `for`, Reverse `for`, Enhanced `for-each`, `while` loop, `Arrays.toString()`), and 2D matrix loops.
- **Context**: CBSE subject marks, Indian Railways `TrainRoute[]` objects, city temperatures.

### 3. `ArrayLoopMutationDemo.java`
- **Concepts**: Indexed `for` vs `for-each` loop mutation behavior.
  - *Primitives*: `for-each` works on local copies (Mutation fails); indexed `for` mutates array memory (Mutation succeeds).
  - *Objects*: Field modification succeeds in both loops; reference reassignment only succeeds in indexed `for`.
- **Context**: Kirana store grocery prices, Team India `CricketPlayer[]` stats.

### 4. `ArrayPassingDemo.java`
- **Concepts**: Pass-by-value of array references to methods. Modifying elements vs reassigning local array parameter reference.

### 5. `ObjectArrayPassingDemo.java`
- **Concepts**: Modifying object properties inside methods (`giveSalaryRaise`), avoiding `NullPointerException`, and returning newly allocated filtered object arrays (`filterHighEarners`).
- **Context**: IT employee salaries in Indian Rupees (INR).

### 6. `DynamicArrayDemo.java`
- **Concepts**: Internal mechanics of dynamic arrays (`java.util.ArrayList`). Tracks `size` vs `capacity`, implements 2x capacity doubling strategy, and fast byte copying using `System.arraycopy()`.
- **Context**: Train waiting list PNR tracker.

### 7. `ArraySortingDemo.java`
- **Concepts**: Custom Bubble Sort ($O(N^2)$), Selection Sort ($O(N^2)$), built-in `Arrays.sort()` (Dual-Pivot Quicksort), and Descending order using `Collections.reverseOrder()` with wrapper classes (`Integer[]`).

### 8. `ArraySearchingDemo.java`
- **Concepts**: Linear Search ($O(N)$) vs Binary Search ($O(\log N)$). Mandatory sorting prerequisite for binary search and decoding negative return values `-(insertion point) - 1`.

### 9. `ArraysClassDemo.java`
- **Concepts**: Standard `java.util.Arrays` utilities: `toString()`, `fill()`, `copyOf()`, `copyOfRange()`, `deepToString()`, and `equals()` vs `==`.

### 10. `MultiDimensionalArrayDemo.java`
- **Concepts**: "Array of Arrays" representation in Java memory. Row-major order nested loop traversal for 2D matrices and 3D cubes.
- **Context**: Quarterly department sales in Mumbai & Bengaluru branches.

### 11. `RaggedArraysAndVectorsDemo.java`
- **Concepts**: Ragged/Jagged arrays (rows with unequal column lengths) and vector dot product calculations ($\sum A_i \cdot B_i$).
- **Context**: Auto-rickshaw driver daily trips and fares.

---

## ⚡ Quick Reference: Loop Mutation Matrix

| Operation | `for-each` Loop | Index-based `for` Loop | Technical Rationale |
| :--- | :--- | :--- | :--- |
| **Primitive Array Value Edit** | ❌ **No Mutation** | ✅ **Mutates Array** | `for-each` copies primitive values into a local stack variable. |
| **Object Internal Field Edit** | ✅ **Mutates Object** | ✅ **Mutates Object** | Both loop variables hold references pointing to the same Heap object. |
| **Object Reference Swap** | ❌ **No Mutation** | ✅ **Replaces Slot** | `for-each` reassigns the local variable reference, not the array slot. |
