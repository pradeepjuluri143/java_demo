# Java Samples Repository

Welcome to the Java samples repository! This workspace contains modular sample programs designed to teach Java concepts using clear examples and Indian contexts.

---

## 📦 Packages & Content

- **[`arrays`](file:///t:/Training-Teaching/Projects/java-samples/arrays/README.md)**: Complete guide & code examples covering array declaration, initialization, length, traversal, and loop mutation using primitive and object arrays.
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

## 🛠️ Generic `javac` Command Guide (For Any Folder / Package)

When working with multiple package directories, use the **`@sources.txt` argument file** technique. This is the official and most scalable way to compile all `.java` files across any folder structure recursively.

### 1. Dynamic Recursive Compilation across ALL Packages:

#### On Windows (CMD):
```cmd
:: 1. Find all .java files recursively in all subfolders
dir /s /b *.java > sources.txt

:: 2. Compile everything listed in sources.txt into bin/
javac -d bin @sources.txt

:: 3. Clean up the temporary file
del sources.txt
```

#### On PowerShell:
```powershell
javac -d bin (Get-ChildItem -Recurse -Filter *.java | Select-Object -ExpandProperty FullName)
```

#### On Bash / Linux / macOS:
```bash
find . -name "*.java" > sources.txt
javac -d bin @sources.txt
rm sources.txt
```

> **Why `@sources.txt`?**
> The `@` symbol tells `javac` to read command-line arguments (file paths) from a text file. This avoids hardcoding folder names like `arrays/*.java` and prevents command-length overflow errors as you add more packages in the future.

---

## 🏃 Running Compiled Classes

Always use the `-cp bin` (classpath) flag from the root directory to run any compiled class:

```bash
# Run arrays package demos
java -cp bin arrays.ArrayDeclarationInitializationDemo
java -cp bin arrays.ArrayLengthAndTraversingDemo
java -cp bin arrays.ArrayLoopMutationDemo

# Run root package demos
java -cp bin PassByValuePrimitiveVsObjectDemo
```

For package-specific documentation and array cheat sheets, visit **[arrays/README.md](file:///t:/Training-Teaching/Projects/java-samples/arrays/README.md)**.
