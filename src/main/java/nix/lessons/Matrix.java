package nix.lessons;

import java.util.Random;

public class Matrix {

    public static  int[][] init(int rows, int columns){

        int[][] matrix = new int[rows][columns];
        Random randomItem = new Random();

        for(int row = 0; row < matrix.length; row++)
            for(int el=0; el < matrix[row].length; el++)
                matrix[row][el] = randomItem.nextInt(0,10);

        return matrix;
    }

    public static void print(int[][] matrix){

        for(int i=0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] m){

        int tRows = m[0].length;
        int tColumns = m.length;
        int[][] transMatrix = new int [tRows][tColumns];

        for(int i=0; i < m.length; i++)
            for(int j=0; j < m[i].length; j++)
                transMatrix[j][i] = m[i][j];
        return transMatrix;
    }
}
