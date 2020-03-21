package dev.pushparaj.graph;

import java.util.*;

public class AdjacencyMatrix<T, D extends Comparable<D>> extends Graph<T, D extends Comparable<D>> {
    
    private ArrayList<ArrayList<D>> adjacencyMatrix = null;
    private HashMap<T, Integer> vertexIndexMap = null;

    public AdjacencyMatrix() {
        this.adjacencyMatrix = new ArrayList<ArrayList<t>>();
        this.vertexIndexMap = new HashMap<>();
    }

    @Override
    public void addVertex(T vertex) {
        if(vertex == null || containsVertex(vertex))
            return;
        
        vertexIndexMap.put(vertex, vertexCount);

        //For adding new column
        for(ArrayList<D> list : adjacencyMatrix) 
            list.add(null);
        
        //For adding new row
        ArrayList<D> newRow = new ArrayList<D>();
        for(int i = 0; i <= vertexIndex; i++)
            newRow.add(null);
        adjacencyMatrix.add(newRow);
    
        vertexCount++;
    }

    @Override
    public boolean containsVertex(T vertex) {
        return vertexIndexMap.contains(vertex);
    }
}