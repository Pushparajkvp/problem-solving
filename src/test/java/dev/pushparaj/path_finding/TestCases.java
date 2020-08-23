package dev.pushparaj.path_finding;

import java.util.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import dev.pushparaj.BaseTest;
import dev.pushparaj.utils.*;

public class TestCases extends BaseTest {
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
}