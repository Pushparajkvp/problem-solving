package dev.pushparaj.graph;

import java.util.*;

public class AdjacencyMatrix<T, D extends Comparable<D>> extends Graph<T, D> {
    
    private ArrayList<ArrayList<D>> adjacencyMatrix = null;
    private HashMap<T, Integer> vertexIndexMap = null;

    public AdjacencyMatrix() {
        this.adjacencyMatrix = new ArrayList<ArrayList<D>>();
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
    public void deleteVertex(T vertex) {
        if(vertex == null || !containsVertex(vertex))
            return;
        
        int vertexIndex = vertexIndexMap.get(vertex);

         //For adding new column
        for(ArrayList<D> list : adjacencyMatrix){
            if(list.get(vertexIndex) != null)
                edgeCount--;
            list.set(vertexIndex, null);
        }

        ArrayList<D> row = adjacencyMatrix.get(vertexIndex);
        for(int it = 0; it < row.size(); it++) {
            if(row.get(it) != null)
                edgeCount--;
            list.set(it, null);
        }

        vertexIndexMap.remove(vertexIndex);

        vertexCount--;
    }

    @Override
    public boolean containsVertex(T vertex) {
        return vertexIndexMap.contains(vertex);
    }

    @Override
    public void addOrUpdateEdge(T source, T destination, D distance) {
         
    }
}