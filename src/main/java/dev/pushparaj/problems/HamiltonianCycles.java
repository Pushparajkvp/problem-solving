package dev.pushparaj.problems;

import java.util.*;

public class HamiltonianCycles {

    public static void printCycles(int[][] graph) {
        int[] path = new int[graph.length + 1];
        path[0] = 0;
        printCycles(graph, path, 1);
    }

    private static void printCycles(int[][] graph, int path[], int pos) {

        if(pos == path.length - 1) {
            if(graph[pos - 1][0] == 1) {
                System.out.println(Arrays.toString(path));
                return;
            }
        }

        for(int vertex = 0; vertex < graph.length; vertex++) {
            if(isPathValid(graph, path, pos, vertex)) {
                path[pos] = vertex;
                printCycles(graph, path, pos+1);
            }
        }
    }

    private static boolean isPathValid(int[][] graph, int path[], int pos, int vertex) {
        
        if(graph[path[pos - 1]][vertex] == 0)
            return false;
        
        for(int it = 0; it < pos; it++)
            if(path[it]== vertex)
                return false;
        
        return true;
    }
}