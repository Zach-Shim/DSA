A common graph operation is finding the shortest path between two nodes.
The methodology to find the shortest path depends on the type of graph.
## **Types of Shortest Path Problems**

There are two general types of shortest path algorithms:

1. Shortest Path in Unweighted Graphs

	Unweighted Shortest-Path Problem 
	O(|E|+|V|) time

2. Shortest Path in Weighted Graphs

	Weighted Shortest-Path Problem assuming there ***are no* negative edges**
	O(|V| log |V| + |E| log |V|) time

## **Path Algorithms**

1. DFS is suitable for finding if a path **exists**
2. BFS is suitable for finding the shortest path in **unweighted** graphs
3. Dijkstra's is suitable for finding the shortest path in **weighted** graphs
## Dijkstra's Algorithm

Dijkstra's algorithm was made by famous computer scientist Edsger Dijkstra (look him up!).

The algorithm finds the **minimum-weight path** between a pair of vertices in a weighted graph.
Dijkstra's solves the "**single-source shortest-path** (SSSP)" problem in weighted graphs.

SSSP is one of the most frequent graph problem encountered in real-life. 

Example: In a graph where vertices are cities and weighted edges are roads between cities, Dijkstra's algorithm can be used to find the shortest route from one city to any other
## Dijkstra's Algorithm Inputs

**Input 1:**
A weighted graph G(V, E), where
	G does not have to be connected
	**V** can be used to describe intersections, junctions, houses, landmarks, etc 
	**E** can be used to describe streets, roads, avenues with proper direction and weight/cost

**Input 2:**
A source vertex **s** ∈ **V**.
## Dijkstra's Algorithm Objective

The objective of the SSSP problem is to find the shortest path weight from **s** to each vertex **u**, where **s** ∈ **V** and **u** ∈ **V**, denoted as **δ(s, u)** (δ is pronounced as 'delta') and also the actual shortest path from **s** to **u**.

The path weight of a path **p** is simply the summation of edge weights along that path.

The weight of the shortest path from **s** to **s** is trivial: 0.
The weight of the shortest path from **s** to any unreachable vertex is also trivial: +∞.  

The weight of the shortest path from **s** to **v** where **(s, v) ∈ E** is not necessarily the weight of their shared edge **(s, v)**. This single shared edge may have a larger weight than taking more paths with smaller weights.
## Dijkstra's Algorithm Inputs

We break the algorithm into three steps:
1. Initialize the vertex information
2. Initialize a minheap
3. While the minheap is not empty
	1. Get the updated weights of the nodes in the minheap - we visit the adjacent node with the smallest weight + edge

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


