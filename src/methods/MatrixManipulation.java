package methods;

import java.util.Random;

public class MatrixManipulation {

    public static double[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        double[][] matrix = new double[rows][cols];
        for(int i=0; i<rows; i++)
            for(int j=0; j<cols; j++)
                matrix[i][j] = rand.nextInt(10) + 1;  // 1 to 10
        return matrix;
    }

    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] trans = new double[cols][rows];
        for(int i=0; i<rows; i++)
            for(int j=0; j<cols; j++)
                trans[j][i] = matrix[i][j];
        return trans;
    }

    public static double determinant2x2(double[][] matrix) {
        return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
    }

    public static double determinant3x3(double[][] matrix) {
        double det = matrix[0][0]*(matrix[1][1]*matrix[2][2] - matrix[1][2]*matrix[2][1])
                - matrix[0][1]*(matrix[1][0]*matrix[2][2] - matrix[1][2]*matrix[2][0])
                + matrix[0][2]*(matrix[1][0]*matrix[2][1] - matrix[1][1]*matrix[2][0]);
        return det;
    }

    public static double[][] inverse2x2(double[][] matrix) {
        double det = determinant2x2(matrix);
        if(det == 0) return null;
        double[][] inv = new double[2][2];
        inv[0][0] = matrix[1][1] / det;
        inv[0][1] = -matrix[0][1] / det;
        inv[1][0] = -matrix[1][0] / det;
        inv[1][1] = matrix[0][0] / det;
        return inv;
    }

    public static double[][] inverse3x3(double[][] matrix) {
        double det = determinant3x3(matrix);
        if(det == 0) return null;
        double[][] inv = new double[3][3];

        // Cofactor matrix calculation
        inv[0][0] =  (matrix[1][1]*matrix[2][2] - matrix[1][2]*matrix[2][1]);
        inv[0][1] = -(matrix[0][1]*matrix[2][2] - matrix[0][2]*matrix[2][1]);
        inv[0][2] =  (matrix[0][1]*matrix[1][2] - matrix[0][2]*matrix[1][1]);

        inv[1][0] = -(matrix[1][0]*matrix[2][2] - matrix[1][2]*matrix[2][0]);
        inv[1][1] =  (matrix[0][0]*matrix[2][2] - matrix[0][2]*matrix[2][0]);
        inv[1][2] = -(matrix[0][0]*matrix[1][2] - matrix[0][2]*matrix[1][0]);

        inv[2][0] =  (matrix[1][0]*matrix[2][1] - matrix[1][1]*matrix[2][0]);
        inv[2][1] = -(matrix[0][0]*matrix[2][1] - matrix[0][1]*matrix[2][0]);
        inv[2][2] =  (matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0]);

        // Transpose of cofactor matrix (adjugate)
        inv = transpose(inv);

        // Divide by determinant
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                inv[i][j] /= det;

        return inv;
    }

    public static void printMatrix(double[][] matrix) {
        if(matrix == null) {
            System.out.println("Matrix is null (might be non-invertible).");
            return;
        }
        for(double[] row : matrix) {
            for(double val : row) {
                System.out.printf("%10.4f ", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] matrix2x2 = createRandomMatrix(2, 2);
        System.out.println("2x2 Matrix:");
        printMatrix(matrix2x2);
        System.out.println("\nTranspose:");
        printMatrix(transpose(matrix2x2));
        System.out.println("\nDeterminant: " + determinant2x2(matrix2x2));
        System.out.println("\nInverse:");
        printMatrix(inverse2x2(matrix2x2));

        System.out.println("\n----------------------------\n");

        double[][] matrix3x3 = createRandomMatrix(3, 3);
        System.out.println("3x3 Matrix:");
        printMatrix(matrix3x3);
        System.out.println("\nTranspose:");
        printMatrix(transpose(matrix3x3));
        System.out.println("\nDeterminant: " + determinant3x3(matrix3x3));
        System.out.println("\nInverse:");
        printMatrix(inverse3x3(matrix3x3));
    }
}

