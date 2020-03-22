package dev.pushparaj.graph;

import java.util.*;
import java.lang.IllegalArgumentException;

public abstract class Graph<T, D extends Comparable<D>>{

    protected int vertexCount = 0, edgeCount = 0;

    public void addVertices(T[] vertices) {
        for(int i = 0; i < vertices.length; i++)
            addVertex(vertices[i]);
    }

    public void deleteVertices(T[] vertices) {
        for(int i = 0; i < vertices.length; i++)
            deleteVertex(vertices[i]);
    }

    public void addOrUpdateEdges(T[] sources, T[] destinations, D[] distances) {
        if(sources.length != destinations.length || sources.length != distances.length)
            throw new IllegalArgumentException("The provided edges are not valid");
        
        for(int i = 0; i < sources.length; i++)
            addOrUpdateEdge(sources[i], destinations[i], distances[i]);
    }

    public void deleteEdges(T[] sources, T[] destinations) {
        if(sources.length != destinations.length)
            throw new IllegalArgumentException("The provided edges are not valid");
        
        for(int i = 0; i < sources.length; i++)
            deleteEdge(sources[i], destinations[i]);
    }

    public void addVertices(List<T> vertices) {
        for(int i = 0; i < vertices.size(); i++)
            addVertex(vertices.get(i));
    }

    public void deleteVertices(List<T> vertices) {
        for(int i = 0; i < vertices.size(); i++)
            deleteVertex(vertices.get(i));
    }

    public void addOrUpdateEdges(List<T> sources, List<T> destinations, List<D> distances) {
        if(sources.size() != destinations.size() || sources.size() != distances.size())
            throw new IllegalArgumentException("The provided edges are not valid");
        
        for(int i = 0; i < sources.size(); i++)
            addOrUpdateEdge(sources.get(i), destinations.get(i), distances.get(i));
    }

    public void deleteEdges(List<T> sources, List<T> destinations) {
        if(sources.size() != destinations.size())
            throw new IllegalArgumentException("The provided edges are not valid");
        
        for(int i = 0; i < sources.size(); i++)
            deleteEdge(sources.get(i), destinations.get(i));
    }

    

    protected abstract void addVertex(T vertex);
    protected abstract void deleteVertex(T vertex);
    protected abstract boolean containsVertex(T vertex);

    protected abstract void addOrUpdateEdge(T source, T destination, D distance);
    protected abstract void updateEdge(T source, T destination, D distance);
    protected abstract void deleteEdge(T source, T destination);
    protected abstract boolean containsEdge(T source, T destination);
}