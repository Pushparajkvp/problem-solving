package dev.pushparaj.problems;

import java.util.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import dev.pushparaj.BaseTest;
import dev.pushparaj.problems.*;

public class InitialTestCases extends BaseTest {

    @Test
    public void checkIfBstTests() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(25);
        assertTrue(CheckIfBST.check(root));
        root.left.left = new Node(10);
        assertFalse(CheckIfBST.check(root));
    }

    @Test
    public void checkBASTAdddGreaterNumbers(){
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(25);
        TreePrinter.printNode(root);
        BSTAddGreaterNumbers.addGreaterNumbers(root);
        TreePrinter.printNode(root);
    }
    
    @Test
    public void printCyclesTest() {
        int[][] graph = {
            {0, 1, 1, 1, 0},
            {1, 0, 1, 1, 0}, 
            {1, 1, 0, 1, 0},
            {1, 1, 1, 0, 1},
            {1, 0, 0, 1, 0}
        };
        HamiltonianCycles.printCycles(graph);
    }

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
    public void matrixPathsTest() {
        int[][] matrix = {
            {0, 5, MatrixPathFinding.BLOCKED, MatrixPathFinding.BLOCKED},
            {10, 20, 7 , 30},
            {MatrixPathFinding.BLOCKED, 5, 3, MatrixPathFinding.BLOCKED},
            {50, 20, 1, 2}
        };
        MatrixPathFinding.printPaths(matrix, 0, 0, 3, 3);
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