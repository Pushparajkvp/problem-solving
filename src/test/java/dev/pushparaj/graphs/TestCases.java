package dev.pushparaj.graphs;

import java.util.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import dev.pushparaj.BaseTest;
import dev.pushparaj.utils.*;

public class TestCases extends BaseTest {

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

}