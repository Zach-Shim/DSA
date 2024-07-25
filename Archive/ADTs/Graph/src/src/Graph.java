/**
 * A Graph is a collection of vertices and edges between vertices. A graph can be directed or undirected (indicating whether edges are one-directional or bidirectional, respectively), and weighted or unweighted (indicating whether edges have different or uniform cost, respectively).
 *
 * A Graph does not allow null vertices, but it does allow null edges, which corresponds to an edge with no extra information stored in it.
 * 
 * A Graph can have at most one edge with the same start and end vertex; in other words, it is not permitted to have two edges between the same vertices, except in a directed graph it is allowed to have an edge A,B and an edge B,A. Loops (edges from a vertex directly back to itself) are prohibited; an IllegalArgumentException will be thrown on an attempt to add a loop.
 * 
 * Implementations of the Graph interface do not allow edges with negative weights. If a negative edge weight is passed, an IllegalArgumentException is thrown. A weight of 0 is allowed.
 * 
 * @author Zach Shim
*/

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.lang.String;

public interface Graph<V,E> {

    // ---------------------------- ADD EDGE ----------------------------

    /**
     * Adds an edge (v1, v2) to this graph.
     * If the graph is undirected, (v2, v1) is also added.
     * @param v1 The first vertex in the edge
     * @param v2 The second vertex in the edge
     */
    void addEdge(V v1, V v2);
    void addEdge(V v1, V v2, E e);
    void addEdge(V v1, V v2, E e, int weight);
    void addEdge(V v1, V v2, int weight);

    // ---------------------------- ADD VERTEX ----------------------------
    void addVertex(V v);
    
    // ---------------------------- CLEAR ----------------------------
    void clear();
    void clearEdges();
    
    // ---------------------------- CONTAINS ----------------------------
    void containsEdge(E e);
    void containsEdge(V v1, V v2);
    void containsVertex(V v);

    // ---------------------------- COST ----------------------------
    int cost(List<V> path);

    // ---------------------------- DEGREE ----------------------------
    int degree(V v);

    // ---------------------------- EDGES ----------------------------
    E edge(V v1, V v2);
    int edgeCount();
    Collection<E> edges();
    int edgeWeight(V v1, V v2);
    
    // ---------------------------- INDEGREE ----------------------------
    int inDegree(V v);

    // ---------------------------- DIRECTED UNDIRECTED ----------------------------
    boolean isDirected();
    boolean isUndirected();

    // ---------------------------- EMPTY ----------------------------
    boolean isEmpty();

    // ---------------------------- REACHABLE ----------------------------
    boolean isReachable(V v1, V v2);

    // ---------------------------- WEIGHTED ----------------------------
    boolean isWeighted();
    boolean isUnweighted();

    // ---------------------------- DIJKSTRAS ----------------------------
    List<V> minimumWeightPath(V v1, V v2);

    // ---------------------------- NEIGHBORS ----------------------------
    Set<V> neightbors(V v);

    // ---------------------------- OUTDEGREE ----------------------------
    int outDegree(V v);

    // ---------------------------- REMOVE ----------------------------
    void removeEdge(E e);
    void removeEdge(V v1, V v2);
    void removeVertex(V v);

    // ---------------------------- SHORTEST UNWEIGHTED PATH ----------------------------
    List<V> shortestPath(V v1, V v2);

    // ---------------------------- toString ----------------------------
    String toString();
    String toStringDetailed();

    // ---------------------------- VERTEX ----------------------------
    int vertexCount();
    Set<E> vertices();
}
