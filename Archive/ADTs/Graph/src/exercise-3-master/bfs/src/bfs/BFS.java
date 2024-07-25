package bfs;

import java.io.*;
import java.util.*;

public class BFS {

    // Do not change the value of this constant.  You need this address to answer the required questions.
    private static final String SAMPLE_STARTING_POINT_FOR_10128_ZIP_CODE = "212 E  95 ST, NY";

    public static void main(String[] args) throws IOException {
        // This is an adjacency-list graph representing addresses as vertices.
        // Two address vertices a and b are connected if a and b are close enough in distance that
        // a sound wave starting at a can reach b.
        //
        // The graph is undirected because sound can travel both ways equally, so if a can reach b,
        // b can reach a.
        //
        // Recall that an adjacency list stores vertices as keys with their associated out-neighbors as values.
        // In class we saw Vertex objects in the pseudocode, but here the vertices are just String objects
        // and there are no explicit Edge types.  Also note the outer type is just a Map -- Java doesn't
        // actually provide a graph interface or type because graph models vary significantly between problems and
        // there isn't a one-size-fits-all methods list.  You'll see in future programming projects that if we want
        // one, we can define our own custom graph types.
        Map<String, List<String>> addressesToCloseAddressesGraph = LoadAddressData.getAddressData();

        // Use this as the starting point for answering the required questions.
        String start = SAMPLE_STARTING_POINT_FOR_10128_ZIP_CODE;

        // You could use this instead for a "random" starting point if you want to explore the data more afterwards.
        // String start = addressesToCloseAddressesGraph.keySet().iterator().next();

        Map<String, Integer> distances = bfs(addressesToCloseAddressesGraph, start);

        /*
        // TODO: Write any code necessary to explore the BFS output to answer the written questions
        // Here's an example loop that you can use just to view all of the addresses and their
        // hops/levels away from the start
        // Note: you can search any of these addresses in Google Maps and you'll be able to find them
        // if you want to explore the data that way for fun
        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            System.out.println("distance: " + entry.getValue() + " | addr: " + entry.getKey());
        }
        */
    }


    /**
     * Reminder: you're not turning in this code for us to grade, so don't worry about any
     * unspecified edge cases (e.g. the 'start' vertex is not in the graph). The provided tests exist
     * just to make sure your BFS implementation is reasonable.
     *
     * @param graph graph is an adjacency list where each String represents a vertex, and is the source of data
     *              for this BFS.
     *
     * @param start start is the source node for the BFS to be performed
     * @return A map of recording the amount of levels away from the start vertex inside the `graph`.
     * The keys represent the vertex and the values represent the associated distance.
     */
    public static Map<String, Integer> bfs(Map<String, List<String>> graph, String start) {
        Map<String, Integer> verticesToDistances = new HashMap<>();
        verticesToDistances.put(start, 0);

        // TODO: Implement BFS, following the pseudocode described in lecture.
        //  use the above map `verticesToDistances` to track which level each vertex is found at.
        //  We've given you the above lines to specify that `start` is at level 0.
        //  You should populate the resulting map so the start's direct neighbors
        //  are at level 1, and then the neighbors of the neighbors are at level 2
        //  (except for the nodes we've already seen that are actually at level 0), and so on.

        return verticesToDistances;
    }
}
