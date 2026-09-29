@echo off
echo ===================================================
echo  Compiling all Java files into 'bin/' directory...
echo ===================================================

:: Create bin folder if it does not exist
if not exist "bin" (
    mkdir "bin"
)

:: Recursively collect all .java files from root and subdirectories
dir /s /b *.java > sources.txt

:: Compile all Java files listed in sources.txt into bin/
javac -d bin @sources.txt

:: Save error code and remove temporary sources list file
set EXITCODE=%ERRORLEVEL%
if exist sources.txt del sources.txt

if %EXITCODE% equ 0 (
    echo.
    echo [SUCCESS] Compilation completed successfully!
    echo All .class files are saved in the 'bin/' folder.
    echo.
    echo Run examples:
    echo   java -cp bin arrays.ArrayDeclarationInitializationDemo
    echo   java -cp bin arrays.ArrayLengthAndTraversingDemo
    echo   java -cp bin arrays.ArrayLoopMutationDemo
    echo   java -cp bin PassByValuePrimitiveVsObjectDemo
) else (
    echo.
    echo [ERROR] Compilation failed! Check compiler output above.
)
