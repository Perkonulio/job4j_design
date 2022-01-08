package ru.job4j.inputoutput;

public class Matrix {
    public int[][] multiple(int size) {
        int[][] multiTable = new int[size][size];
        for (int i = 0; i < multiTable.length; i++) {
            for (int j = 0; j < multiTable[i].length; j++) {
                multiTable[i][j] = (i + 1) * (j + 1);
            }
        }
        return multiTable;
    }
}
