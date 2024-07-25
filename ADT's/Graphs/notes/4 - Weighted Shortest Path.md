A common graph operation is finding the shortest path between two nodes.
The methodology to find the shortest path depends on the type of graph.
## **Types of Shortest Path Problems**

There are two general types of shortest path algorithms:

1. Shortest Path in Unweighted Graphs

	Unweighted Shortest-Path Problem 
	O(|E|+|V|) time

2. Shortest Path in Weighted Graphs

	Weighted Shortest-Path Problem assuming there ***are no* negative edges**
	O(|E| log |V|) time
	
	Weighted Shortest-Path Problem assuming there ***are* negative edges**
	O(|E| · |V|) time
	
	Weighted Shortest-Path Problem assuming an **acyclic graph** 
	O(|V|) time
## **Path Algorithms**

1. DFS is suitable for finding if a path exists
2. BFS is suitable for finding the shortest path in unweighted graphs
3. Dijkstra's is suitable for finding the shortest path in weighted graphs
## Dijkstra's Algorithm

Dijkstra's algorithm was made by famous computer scientist Edsger Dijkstra (look him up!).

Dijkstra's algorithm finds the minimum-weight path between a pair of vertices in a weighted graph.
Dijkstra's solves the "single-source shortest-path" problem in weighted graphs.

Example: In a graph where vertices are cities and weighted edges are roads between cities, Dijkstra's algorithm can be used to find the shortest route from one city to any other
## Dijkstra's Algorithm Pseudocode

We break the algorithm into three steps:
1. Initialize the vertex information
2. Initialize a minheap
3. While the minheap is not empty
	1. Get the  update the weights of the nodes in the minheap - we visit the adjacent node with the smallest weight + edge

```Java
public void dijkstras(v1, v2) {
	
	// Initialize vertex info
	for each Vertex v { 
		v.cost = infinity;
		v.previous = null;
	}
	
	// Initialize map to hold vertices
	map = new map
	for each Vertex v {
		map.put()
	}
	
	v1.cost = 0;
	pq = {all vertices, ordered by distance}.
	
	while pqueue is not empty {
		
		v = pq.removeMin();
		
		for each unvisited neighbor n of v {
			cost = v.cost + weight of edge (v, n).
			if cost < n.cost {
				n.cost = cost;
				n.previous = v;
				pq.insert(n);
			}
		}
	}
	
	reconstruct path from v2 back to v1, following previous pointers.
```


