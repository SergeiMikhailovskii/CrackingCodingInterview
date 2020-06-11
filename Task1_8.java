package com.mikhailovskii.task1_5;

public class Task1_8 {

    public static void main(String[] args) {
        Task1_8 task18 = new Task1_8();

        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 0},
                {16, 17, 18, 19, 20}
        };

        matrix = task18.setRowAndColumnToZero(matrix);

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

    private int[][] setRowAndColumnToZero(int[][] matrix) {
        int zeroI = 0, zeroJ = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroI = i;
                    zeroJ = j;
                }
            }
        }

        if (zeroI != 0) {
            for (int i = 0; i < zeroI; i++) {
                matrix[i][zeroJ] = 0;
            }
        }

        if (zeroI != matrix.length - 1) {
            for (int i = zeroI + 1; i < matrix.length; i++) {
                matrix[i][zeroJ] = 0;
            }
        }

        if (zeroJ != 0) {
            for (int j = 0; j < zeroJ; j++) {
                matrix[zeroI][j] = 0;
            }
        }

        if (zeroJ != matrix[zeroI].length - 1) {
            for (int j = zeroJ + 1; j < matrix[zeroI].length; j++) {
                matrix[zeroI][j] = 0;
            }
        }


        return matrix;
    }

}
