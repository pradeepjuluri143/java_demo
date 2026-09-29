Write-Host "===================================================" -ForegroundColor Cyan
Write-Host " Compiling all Java files into 'bin/' directory..." -ForegroundColor Cyan
Write-Host "===================================================" -ForegroundColor Cyan

# Create bin directory if it doesn't exist
if (-not (Test-Path -Path "bin")) {
    New-Item -ItemType Directory -Path "bin" | Out-Null
}

# Recursively find all .java files across any present or future package folders
$javaFiles = Get-ChildItem -Recurse -Filter *.java | Select-Object -ExpandProperty FullName

if ($javaFiles) {
    javac -d bin $javaFiles

    if ($LASTEXITCODE -eq 0) {
        Write-Host "`n[SUCCESS] Compilation completed successfully!" -ForegroundColor Green
        Write-Host "All .class files are saved in the 'bin/' folder." -ForegroundColor Green
        Write-Host "`nRun examples:" -ForegroundColor Yellow
        Write-Host "  java -cp bin arrays.ArrayDeclarationInitializationDemo"
        Write-Host "  java -cp bin arrays.ArrayLengthAndTraversingDemo"
        Write-Host "  java -cp bin arrays.ArrayLoopMutationDemo"
        Write-Host "  java -cp bin PassByValuePrimitiveVsObjectDemo"
    } else {
        Write-Host "`n[ERROR] Compilation failed! Check compiler output above." -ForegroundColor Red
    }
} else {
    Write-Host "No .java files found in project." -ForegroundColor Yellow
}
