package dev.pushparaj.graphs;

import java.util.*;
/*
Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once. A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in the graph) from the last vertex to the first vertex of the Hamiltonian Path. Determine whether a given graph contains Hamiltonian Cycle or not. If it contains, then prints the path. Following are the input and output of the required function.

Input:
A 2D array graph[V][V] where V is the number of vertices in graph and graph[V][V] is adjacency matrix representation of the graph. A value graph[i][j] is 1 if there is a direct edge from i to j, otherwise graph[i][j] is 0.

Output:
An array path[V] that should contain the Hamiltonian Path. path[i] should represent the ith vertex in the Hamiltonian Path. The code should also return false if there is no Hamiltonian Cycle in the graph.

For example, a Hamiltonian Cycle in the following graph is {0, 1, 2, 4, 3, 0}.

(0)--(1)--(2)
 |   / \   |
 |  /   \  | 
 | /     \ |
(3)-------(4)
And the following graph doesn’t contain any Hamiltonian Cycle.

(0)--(1)--(2)
 |   / \   |
 |  /   \  | 
 | /     \ |
(3)      (4) 
*/
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