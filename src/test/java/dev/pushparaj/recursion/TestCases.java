package dev.pushparaj.recursion;

import java.util.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import dev.pushparaj.BaseTest;
import dev.pushparaj.utils.*;

public class TestCases extends BaseTest {
    @Test
    public void sudokuTest() {
        int[][] sudokuTable = {
            {5, 3, Sudoku.EMPTY, Sudoku.EMPTY, 7, Sudoku.EMPTY, Sudoku.EMPTY, Sudoku.EMPTY, Sudoku.EMPTY},
            {6, Sudoku.EMPTY, Sudoku.EMPTY, 1, 9, 5, Sudoku.EMPTY, Sudoku.EMPTY, Sudoku.EMPTY},
            {Sudoku.EMPTY, 9, 8, Sudoku.EMPTY, Sudoku.EMPTY, Sudoku.EMPTY, Sudoku.EMPTY, 6, Sudoku.EMPTY},
            {8, Sudoku.EMPTY, Sudoku.EMPTY, Sudoku.EMPTY, 6, Sudoku.EMPTY, Sudoku.EMPTY, Sudoku.EMPTY, 3},
            {4, Sudoku.EMPTY, Sudoku.EMPTY, 8, Sudoku.EMPTY, 3, Sudoku.EMPTY, Sudoku.EMPTY, 1},
            {7, Sudoku.EMPTY, Sudoku.EMPTY, Sudoku.EMPTY, 2, Sudoku.EMPTY, Sudoku.EMPTY, Sudoku.EMPTY, 6},
            {Sudoku.EMPTY, 6, Sudoku.EMPTY, Sudoku.EMPTY, Sudoku.EMPTY, Sudoku.EMPTY, 2, 8, Sudoku.EMPTY},
            {Sudoku.EMPTY, Sudoku.EMPTY, Sudoku.EMPTY, 4, 1, 9, Sudoku.EMPTY, Sudoku.EMPTY, 5},
            {Sudoku.EMPTY, Sudoku.EMPTY, Sudoku.EMPTY, Sudoku.EMPTY, 8, Sudoku.EMPTY, Sudoku.EMPTY, 7, 9},
        };
        Sudoku.fill(sudokuTable);
    }

    @Test
    public void boggleTest() {
       String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
       char boggle[][]   = {{'G','I','Z'},
                       {'U','E','K'},
                       {'Q','S','E'}};
        
        Boggle.find(boggle, dictionary);
    }
}