package dev.pushparaj.graph;

import java.util.*;
import java.lang.IllegalArgumentException;

public class AdjacencyList<T, D extends Comparable<D>> extends Graph<T, D extends Comparable<D>> {

    public ArrayList<LinkedList<VertexDistancePair<T,D>>> adjacencyList = null;
    private HashMap<T,Integer> vertexIndexMap = null;

    public AdjacencyList() {
        this.adjacencyList = new new ArrayList<LinkedList<T>> ();
        this.vertexIndexMap = new HashMap<>();
    }

    @Override
    public void addVertex(T vertex) {
        if(vertex == null || containsVertex(vertex))
            return;

        vertexIndexMap.put(vertex, vertexCount);

        LinkedList<T> newVertexList = new LinkedList<T>();
        VertexDistancePair<T,D> vertexDistancePair = new VertexDistancePair(vertex, null);
        newVertexList.add(vertexDistancePair);
        
        adjacencyList.add(newVertexList);
        vertexCount++;
    }

    @Override
    public void addOrUpdateEdge(T source, T destination, D distance) {
        if(!containsVertex(source) || !containsVertex(destination))
            throw new IllegalArgumentException("Sorce or destination node not found in the graph");

        LinkedList<VertexDistancePair<T,D>> edgeList = adjacencyList.get(vertexIndexMap.get(source));
        for(VertexDistancePair<T,D> vertexDistancePair : edgeList) {
            if(vertexDistancePair.vertex.equals(destination)){
                vertexDistancePair.distance = distance;
                return;
            }
        }
        VertexDistancePair<T,D> newVertexDistancePair = new VertexDistancePair(destination, distance);
        edgeList.add(newVertexDistancePair);
        edgeCount++;
    }

    @Override
    public void deleteVertex(T vertex) {
        if(vertex == null || !containsVertex(vertex))
            return;
        int vertextIndex = vertexIndexMap.get(vertex);
        edgeCount -= adjacencyList.get(vertextIndex).size();
        adjacencyList.set(vertextIndex, null);

    }

    @Override
    public boolean containsVertex(T vertex) {
        return vertexIndexMap.contains(vertex);
    }



    public static class VertexDistancePair<T, D extends Comparable<D>> {
        public T vertex;
        public D distance;

        public VertexDistancePair(T vertex, D distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}