package arrays;

public class MultiDimensionalArrayDemo {
    public static void main(String[] args) {
        // 1. Creating and traversing a 2D Array (3x3 Matrix)
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("=== 2D Matrix Traversal ===");
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + "\t");
            }
            System.out.println();
        }

        // 2. Creating and traversing a 3D Array (2 layers, 2 rows, 3 cols)
        int[][][] cube = {
                { { 1, 2, 3 }, { 4, 5, 6 } },
                { { 7, 8, 9 }, { 10, 11, 12 } }
        };

        System.out.println("\n=== 3D Cube Layer 0 Traversal ===");
        for (int r = 0; r < cube[0].length; r++) {
            for (int c = 0; c < cube[0][r].length; c++) {
                System.out.print(cube[0][r][c] + " ");
            }
            System.out.println();
        }
    }
}
