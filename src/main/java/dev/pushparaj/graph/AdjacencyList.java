package dev.pushparaj.graph;

import java.util.*;
import java.lang.IllegalArgumentException;

public class AdjacencyList<T, D extends Comparable<D>> extends Graph<T, D> {

    public ArrayList<LinkedList<VertexDistancePair<T,D>>> adjacencyList = null;
    private HashMap<T,Integer> vertexIndexMap = null;

    public AdjacencyList() {
        this.adjacencyList = new ArrayList<LinkedList<T>> ();
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
    public void deleteVertex(T vertex) {
        if(vertex == null || !containsVertex(vertex))
            return;
        int vertextIndex = vertexIndexMap.get(vertex);
        edgeCount -= adjacencyList.get(vertextIndex).size();
        adjacencyList.set(vertextIndex, null);
        vertexIndexMap.remove(vertex);
        for(LinkedList<VertexDistancePair<T,D>> edges : adjacencyList) {
            ListIIterator<VertexDistancePair<T,D>> iterator = edges.listIterator();
            while(iterator.hasNext()) {
                if(iterator.next().vertex.equals(vertex)){
                    iterator.remove();
                    edgeCount--;
                }
            }
        }
        vertexCount--;
    }

    @Override
    public boolean containsVertex(T vertex) {
        return vertexIndexMap.contains(vertex);
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
    public void updateEdge(T source, T destination, D distance) {
        if(!containsVertex(source) || !containsVertex(destination))
            throw new IllegalArgumentException("Sorce or destination node not found in the graph");
        
        LinkedList<VertexDistancePair<T,D>> edgeList = adjacencyList.get(vertexIndexMap.get(source));
        for(VertexDistancePair<T,D> vertexDistancePair : edgeList) {
            if(vertexDistancePair.vertex.equals(destination)){
                vertexDistancePair.distance = distance;
                return;
            }
        }

    }

    @Override
    public void deleteEdge(T source, T destination) {
        if(!containsVertex(source) || !containsVertex(destination))
            throw new IllegalArgumentException("Sorce or destination node not found in the graph");

        LinkedList<VertexDistancePair<T,D>> edgeList = adjacencyList.get(vertexIndexMap.get(source));
        ListIIterator<VertexDistancePair<T,D>> iterator = edgeList.listIterator();
        while(iterator.hasNext()) {
            if(iterator.next().vertex.equals(destination)){
                iterator.remove();
                edgeCount--;
                return;
            }
        }
    }

    @Override
    public boolean containsEdge(T source, T destination) {
        LinkedList<VertexDistancePair<T,D>> edgeList = adjacencyList.get(vertexIndexMap.get(source));
        for(VertexDistancePair<T,D> vertexDistancePair : edgeList) {
            if(vertexDistancePair.vertex.equals(destination))
                return true;
        }
        return false;
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