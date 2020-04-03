package dev.pushparaj.problems;

import java.util.*;
import java.lang.IllegalArgumentException;

public class Sudoku {

    public static final int EMPTY = 10;

    public static void fill(int[][] sudokuTable) {
        if(!isSudokuTableValid(sudokuTable, true))
            throw new IllegalArgumentException("Suduko table is invalid");
        if(!fill(sudokuTable, 0, 0))
            throw new IllegalArgumentException("No solution found for sudoku table");
        if(!isSudokuTableValid(sudokuTable, false))
            throw new IllegalArgumentException("Internal excception during solution finding");
        for(int row = 0; row < 9; row++) {
            System.out.println(Arrays.toString(sudokuTable[row]));
        }
    }

    private static boolean fill(int[][] sudokuTable, int rowIndex, int colIndex) {
        if(rowIndex >= 9 || colIndex >= 9)
            return true;
        int[] nextCell = getNextCell(rowIndex, colIndex);

        if(sudokuTable[rowIndex][colIndex] != EMPTY) {
            return fill(sudokuTable, nextCell[0], nextCell[1]);
        } else {
            for(int trialValue = 1; trialValue <= 9; trialValue++) {
                sudokuTable[rowIndex][colIndex] = trialValue;
                if(isRowValid(sudokuTable, rowIndex, true) 
                    && isColumnValid(sudokuTable, colIndex, true) 
                    && isTheBoxValid(sudokuTable, rowIndex, colIndex, true)){
                        if(!fill(sudokuTable, nextCell[0], nextCell[1]))
                            sudokuTable[rowIndex][colIndex] = EMPTY;
                        else
                            return true;
                        //System.out.println("row : " + rowIndex + " col : " + colIndex + " val : " + sudokuTable[rowIndex][colIndex]);
                    }
                else
                    sudokuTable[rowIndex][colIndex] = EMPTY;
            }
        }
        return false;
    }

    private static boolean isSudokuTableValid(int[][] sudokuTable, boolean ignoreEmpty) {
        if(sudokuTable.length != 9 || sudokuTable[0].length != 9)
            return false;
        for(int it = 0; it < 3; it++) 
            for(int xt = 0; xt < 3; xt ++)
                if(!isTheBoxValid(sudokuTable, it * 3, xt * 3, true))
                    return false;
        for(int row = 0; row < 9; row++)
            if(!isRowValid(sudokuTable, row, true))
                return false;
        for(int col = 0; col < 9; col++)
            if(!isColumnValid(sudokuTable, col, true))
                return false;
        return true;
    }

    private static boolean isTheBoxValid(int[][] sudokuTable, int rowIndex, int colIndex, boolean ignoreEmpty) {
        int colStartIndex = colIndex / 3;
        int rowStartIndex = rowIndex / 3;
        int[] duplicateChecker = new int[11];
        for(int row = rowStartIndex * 3; row < rowStartIndex + 3; row++) {
            for(int col = colStartIndex * 3; col < colStartIndex + 3; col++) {
                if(duplicateChecker[sudokuTable[row][col]] != 1)
                    duplicateChecker[sudokuTable[row][col]] = 1;
                else if(ignoreEmpty && sudokuTable[row][col] == EMPTY)
                    continue;
                else
                    return false;
            }
        }
        return true;
    }

    private static boolean isColumnValid(int[][] sudokuTable, int colIndex, boolean ignoreEmpty) {
        int[] duplicateChecker = new int[11];
        for(int row = 0; row < 9; row++) {
            if(duplicateChecker[sudokuTable[row][colIndex]] != 1)
                    duplicateChecker[sudokuTable[row][colIndex]] = 1;
                else if(ignoreEmpty && sudokuTable[row][colIndex] == EMPTY)
                    continue;
                else
                    return false;
        }
        return true;
    }

    private static boolean isRowValid(int[][] sudokuTable, int rowIndex, boolean ignoreEmpty) {
        int[] duplicateChecker = new int[11];
        for(int col = 0; col < 9; col++) {
            if(duplicateChecker[sudokuTable[rowIndex][col]] != 1)
                    duplicateChecker[sudokuTable[rowIndex][col]] = 1;
                else if(ignoreEmpty && sudokuTable[rowIndex][col] == EMPTY)
                    continue;
                else
                    return false;
        }
        return true;
    }

    private static int[] getNextCell(int rowIndex,int colIndex) {
        int[] rowColIndexPair = new int[2];
        if(colIndex < 8) {
            rowColIndexPair[0] = rowIndex;
            rowColIndexPair[1] = colIndex + 1;
        } else {
            rowColIndexPair[0] = rowIndex + 1;
            rowColIndexPair[1] = 0;
        }
        return rowColIndexPair;
    }

}