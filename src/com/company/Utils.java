package com.company;

import static com.company.Constants.INFINITY;

public class Utils {

    public static void printGraph(int[][] matrix) {
        int vertex = matrix.length;
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j <vertex ; j++) {
                System.out.print((matrix[i][j] == INFINITY ? "INF" : matrix[i][j]) + " ");
            }
            System.out.println();
        }
    }

}
