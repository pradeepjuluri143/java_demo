package arrays;

import java.util.Arrays;

/**
 * ============================================================================
 * SELF-LEARNING GUIDE: MULTI-DIMENSIONAL ARRAYS IN JAVA
 * ============================================================================
 * Key Concept: Java does NOT have true contiguous multi-dimensional arrays!
 * - A 2D array in Java is simply an "Array of Arrays".
 * - A 3D array is an "Array of 2D Arrays".
 * 
 * Syntax:
 * - 2D Array: `int[][] matrix = new int[rows][cols];`
 * - Accessing 2D element: `matrix[row][col]`
 * - 3D Array: `int[][][] cube = new int[layers][rows][cols];`
 * - Accessing 3D element: `cube[layer][row][col]`
 * ============================================================================
 */
public class MultiDimensionalArrayDemo {

    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println(" DEMO: MULTI-DIMENSIONAL ARRAYS (2D MATRICES & 3D CUBES)");
        System.out.println("==================================================================");

        // ----------------------------------------------------------------------
        // 1. 2D Array (3x3 Matrix) - e.g. Seating grid or Tic-Tac-Toe / Sudoku grid
        // ----------------------------------------------------------------------
        int[][] seatingGrid = {
            { 1, 2, 3 }, // Row 0
            { 4, 5, 6 }, // Row 1
            { 7, 8, 9 }  // Row 2
        };

        System.out.println("=== 1. 2D Matrix Traversal (3 Rows x 3 Columns) ===");
        System.out.println("Outer Array Length (Number of Rows): " + seatingGrid.length);
        System.out.println("Inner Array Length (Columns in Row 0): " + seatingGrid[0].length + "\n");

        // Nested for loop traversal (Row-major order)
        for (int r = 0; r < seatingGrid.length; r++) {
            System.out.print("Row " + r + ": [ ");
            for (int c = 0; c < seatingGrid[r].length; c++) {
                System.out.print(seatingGrid[r][c] + "\t");
            }
            System.out.println("]");
        }

        // Easy formatting using Arrays.deepToString()
        System.out.println("\nUsing Arrays.deepToString(seatingGrid):");
        System.out.println("  " + Arrays.deepToString(seatingGrid));

        // ----------------------------------------------------------------------
        // 2. 3D Array (2 layers, 2 rows, 3 columns)
        // e.g., Quarterly sales across 2 different branches in Mumbai & Bengaluru
        // ----------------------------------------------------------------------
        int[][][] salesCube = {
            // Layer 0: Mumbai Branch (2 departments, 3 months each)
            { 
                { 10, 20, 30 }, // Dept A: Jan, Feb, Mar
                { 40, 50, 60 }  // Dept B: Jan, Feb, Mar
            },
            // Layer 1: Bengaluru Branch (2 departments, 3 months each)
            { 
                { 70, 80, 90 },    // Dept A: Jan, Feb, Mar
                { 100, 110, 120 }  // Dept B: Jan, Feb, Mar
            }
        };

        System.out.println("\n=== 2. 3D Array Traversal (2 Layers x 2 Rows x 3 Columns) ===");
        System.out.println("Total Layers (Branches): " + salesCube.length);
        System.out.println("Rows per Layer (Departments): " + salesCube[0].length);
        System.out.println("Columns per Row (Months): " + salesCube[0][0].length + "\n");

        String[] branchNames = {"Mumbai Branch", "Bengaluru Branch"};

        // Triple nested loop traversal
        for (int layer = 0; layer < salesCube.length; layer++) {
            System.out.println("--- " + branchNames[layer] + " (Layer " + layer + ") ---");
            for (int r = 0; r < salesCube[layer].length; r++) {
                System.out.print("  Dept " + (r + 1) + ": ");
                for (int c = 0; c < salesCube[layer][r].length; c++) {
                    System.out.print("₹" + salesCube[layer][r][c] + "k  ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
