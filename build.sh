#!/bin/bash

echo "==================================================="
echo " Compiling all Java files into 'bin/' directory..."
echo "==================================================="

# Create bin directory if it doesn't exist
mkdir -p bin

# Recursively find all .java files across any subdirectories and compile using @sources.txt
find . -name "*.java" > sources.txt
javac -d bin @sources.txt
EXITCODE=$?
rm -f sources.txt

if [ $EXITCODE -eq 0 ]; then
    echo ""
    echo "[SUCCESS] Compilation completed successfully!"
    echo "All .class files are saved in the 'bin/' folder."
    echo ""
    echo "Run examples:"
    echo "  java -cp bin arrays.ArrayDeclarationInitializationDemo"
    echo "  java -cp bin arrays.ArrayLengthAndTraversingDemo"
    echo "  java -cp bin arrays.ArrayLoopMutationDemo"
    echo "  java -cp bin PassByValuePrimitiveVsObjectDemo"
else
    echo ""
    echo "[ERROR] Compilation failed! Check compiler output above."
fi
