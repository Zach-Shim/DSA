A **graph traversal** is an algorithm that visits all vertices that it can reach in a graph, G, from a starting vertex **_v_**.

In other words, a graph traversal that starts at vertex **_v_** will visit all vertices **_u_** for which there is a path between **_v_** and **_u_**.

The **_order_** vertices are traversed in depends on the **_type_** of graph you are traversing.
## Types of Graphs

1. **Connected Graph**
	A connected graph traversal can visit every vertex in the graph.
	The starting vertex does not matter.
	Thus, you can use a graph traversal to determine whether a graph is connected.

2. **Not Connected**
	If a graph is not connected, a graph traversal that begins at vertex v will visit only a subset of the graph’s vertices.
	This subset is called the _connected component_ containing _v_.
	You can determine all of the connected components of a graph by repeatedly starting a traversal at an unvisited vertex.

3. **Cycle**
	If a graph contains a cycle, a graph-traversal algorithm can loop indefinitely.
	To prevent such a misfortune, the algorithm must mark each vertex during a visit and must never visit a vertex more than once.

A **tree traversal** always visits all nodes in a tree.
There are different ways to traverse a tree, such as inorder, preorder, and postorder.

A graph traversal may or may not visit all nodes in a graph, depending on the type of graph and the problem constraints.

## Graph Traversal Problems

##### **Searching for Paths**
A common operation on graphs is searching for a path from one vertex to another.
1. Sometimes, we just want **any** path (or want to know if a path exists).
2. Sometimes, we want to minimize path length (# of edges).
3. Sometimes, we want to minimize path cost (sum of edge weights).

>[!Important]
>There are 3 main traversal algorithms we want to implement:
>1. s-t connectivity problem	
>	1. Does a path exist?
>	   
>2. s-t ***unweighted*** shortest path problem
>	1. Unweighted
>	2. Shortest path
>	   
>3. s-t ***weighted*** shortest path problem
>	1. Weighted
>	2. Shortest path

## **Graph Traversal Algorithms**

##### Graph Traversal Algorithms
From these use cases, there are three main types graph-traversal algorithms:
1. **Depth-First Traversal (DFS)**
2. **Breadth-First Traversal (BFS)**
3. **Dijkstra's Algorithm**

Are there other ways to solve these use cases? Of course, but these are the most common graph traversal algorithms you must know.

These algorithms apply to both directed and undirected graphs.

>[!Important]
>While there are many graph traversal algorithms, DFS, BFS, and Dijkstra's Algorithm are the most common for specific use cases.
>1. DFS - Does any path exist
>2. BFS - What is the shortest path (# edges)
>3. Dijkstra's - What is the shortest path (sum of weighted edges)

##### DFS vs BFS
These algorithms actually are similar, but visit vertices in **different orders**. 
However, **_if they both start at the same vertex_**, they will **_visit the same set of vertices_**, just in different orders.

>[!Important]
>DFS and BFS visit the same set of vertices in different orders.

**Example**
The following figure shows the traversal order of DFS vs. BFS on an undirected graph.
Both algorithms begin at vertex _s_.

![DFS|300](https://courses.grainger.illinois.edu/cs225/sp2024/assets/notes/bfs_dfs/dfs.png)![BFS|300](https://courses.grainger.illinois.edu/cs225/sp2024/assets/notes/bfs_dfs/bfs.png)
## **Depth-First Search**

##### **Algorithm Overview**
**Depth-First Search (DFS)** is a graph traversal strategy often implemented **_recursively_** (but can be implemented iteratively using a stack).

**DFS** finds a path between two vertices by exploring each possible path as far as possible before backtracking.

DFS is **guaranteed** to find a path **if one exists**. 
This does not mean it finds the most optimal (i.e, shortest) path.

>[!Important]
>**DFS** explores each possible path as far as possible before backtracking to another path.

**Example**
![[Pasted image 20240917171130.png]]

Depth-first paths from **_a_** to all other vertices (assuming ABC edge order):
- to b: {a,b}
- to c: {a,b,e,f,c}
- to d: {a,d}
- to e: {a,b,e}
- to f: {a,b,e,f}
- to g: {a,d,g}
- to h: {a,d,g,h}
##### **Mark Visited Nodes**
DFS marks **_visited_** nodes so it does not revisit the same node twice.

If we perform DFS on a graph:
- We need to be careful to **_avoid cycles_**.
- To do this, when we visit a vertex _v_, we **_mark it visited_**, since now we have been there, and we recursively call depth-first search on all adjacent vertices that are not already marked.

>[!Important]
> We mark nodes as visited so we know which ones we have already visited. This helps us avoid cycles.
##### **DFS Properties
1. **Discovery:**
    DFS is guaranteed to find a path if one exists.
    This does not mean it finds the most optimal (i.e, shortest) path.
    Example: dfs(a,f) returns {a,b,e,f} rather than {a,e,f}.

2. **Retrieval:**
   It is easy to retrieve exactly what the path taken (sequence of edges) is if we find it.

3. **Optimality:**
   If the graph is undirected and unconnected, or directed and not strongly connected, this strategy might fail to visit some nodes.

If this process is performed on a **binary tree**
- All tree vertices are systematically visited in a total of _O_(|_E_|) time, since |_E+1_| = _O_(|_V_|).
  (note this case is not the same for graphs, because nodes are not required to have an out-degree of 2)
##### **Traversal Order**
How do we determine **which unvisited adjacent vertex to visit**?
- A vertex may have more than one adjacent neighbor we need to visit.

DFS does not have a standard for the order in which vertices adjacent to _v_ are visited.
- One possibility is to visit the vertices adjacent to _v_ in ***natural sorted order*** (e.g., alphabetic, or numerically increasing).
- This possibility is natural either when an adjacency matrix represents the graph or when the nodes in each linked chain of an adjacency list are linked in sorted order.

>[!Important]
> DFS does not have a standard for the order in which unvisited adjacent nodes are visited. A common solution is use natural sorted order.
##### **DFS Recursive Algorithm**

**Proposed Solution:**
```Java
// Main function that calls helper DFS function
public void dfs(Vertex s, Vertex t) {
	path = dfs(s, t, {});
}

// Traverses a graph beginning at vertex v using recursive DFS
private bool dfs(Vertex s, Vertex t, Path path) {	
	path.add(s);
	
	if(s == t) {      // if current node is equal to target node
		return true;
	}
	
	for(Vertex v : s.neighbors) {   // each Vertex v adjacent to Vertex u
		if(dfs(v, t, path)) {       // if v has not been visited
			return true;
		}
	}
	return false;
}
```

The **_path_** parameter above is used if you want to have the path available as a list once you are done.

There is a clear problem with this proposed solution. 

![[Pasted image 20241007111729.png]]

It does not check for nodes we have already visited? This will result in an infinite loop.

Let's say we traverse the next neighbor with the lowest vertex value.

Does 0 == 7? No; if(connected(1, 7) return true; 
Does 1 == 7? No; if(connected(0, 7) return true; 
Does 0 == 7? ...

```Java
// Main function that calls helper DFS function
public void dfs(Vertex s, Vertex t) {
	path = dfs(s, t, {});
}

// Traverses a graph beginning at vertex v using recursive DFS
Set<Vertex> visited;
private bool dfs(Vertex s, Vertex t, Path path) {	
	path.add(s);
	
	if(s == t) {      // if current node is equal to target node
		return true;
	}
	
	visited.add(s);
	
	for(Vertex v : s.neighbors) {   // each Vertex v adjacent to Vertex u
		if(!visited.contains(s)) {  // checked if neighbor has been visited 
			if(dfs(v, t, path)) {   // if v has not been visited
				return true;
			}
		}
	}
	return false;
}
```

By recursively calling the procedures **only on nodes that have not been visited**, we guarantee that we do not loop indefinitely (in the case of cyclic graphs).

We then search for an unmarked node, apply a depth-first traversal there, and continue this process until there are no unmarked nodes.

It will explore one option “all the way down” before coming back to try other options - Many possible orderings: 
	{0, 1, 2, 5, 6, 9, 7, 8, 4, 3} or {0, 1, 4, 3, 2, 5, 8, 6, 7, 9} are both possible.
##### **Example**
Figure 20-12 shows the contents of the stack (either recursive call stack or iterative data structure stack) as we traverse the graph in Figure 20-11 using DFS. 

Since 20-11 is a connected graph, DFS will visit every vertex in the graph.
The traversal visits the vertices in the following order: _a, b, c, d, g, e, f, h, i_.

The vertex from which a depth-first traversal embarks is the vertex that it visited most recently.
This _last visited, first explored_ strategy is reflected both in the explicit stack of vertices that the iterative dfs uses and in the implicit stack of vertices that the recursive dfs generates with its recursive calls.

![[Pasted image 20241007112156.png]]
![[Pasted image 20241007112209.png]]
##### **Runtime**
Because this strategy guarantees that each edge is encountered only once, the total time to perform the traversal is _O_(|_E_| + |_V_|), as long as adjacency lists are used.

___
## **Breadth-First Search**

##### **Algorithm Overview**
**Breadth-First Search (BFS)** is a graph traversal strategy that can only be implemented **iteratively**.

BFS always returns the **shortest path** (the one with the **fewest edges**) between the start and the end vertices.
   In **unweighted graphs**, finds **optimal cost path**.
   In **weighted graphs**, **not always optimal cost**

Breadth-First Search finds a path between two nodes by 
1. taking **one step down all paths** (visiting all **adjacent** vertexes) 
2. adding all of the adjacent nodes to a queue
3. processing the next node from the queue

It is often implemented by maintaining a **queue** of **vertices to visit**.
This allows us to explore a graph **“layer by layer”**.
We can visit closer nodes first, instead of following one choice all the way to the end like DFS.

![[Pasted image 20241007112513.png]]

>[!Important]
>BFS is an iterative graph traversal algorithm that finds the shortest path between two nodes in an unweighted graph. It is implemented by adding a nodes adjacent neighbors to a queue.

##### **Mark Visited Nodes**
Just like DFS, it is important that BFS marks nodes as **_visited_** so it does not revisit the same node twice. This allows us to avoid ***cycles***.
##### BFS Properties
1. **Optimality**
   Always finds the **shortest path** (fewest edges).
   In **unweighted graphs**, finds **optimal cost path**.
   In **weighted graphs**, **not always optimal cost**

2. **Retrieval**
   Harder to reconstruct the actual sequence of vertices or edges in the path once you find it.
   Conceptually, BFS is exploring many possible paths in parallel, so it's not easy to store a path array/list in progress.
   Solution: We can use extra space to keep track of the path by storing predecessors for each vertex in an array/list (each vertex can store a reference to the previous vertex on a path).
##### **Implementing BFS**

```java
// Main function that calls helper DFS function
public void bfs(Graph graph, Vertex s) {
	path = dfs(graph, s);
}

// Traverses a graph beginning at vertex v using recursive BFS
private bool bfs(Graph graph, Vertex s) {
	Queue<Vertex> perimeter = new Queue<>(); // keep track of 'outer edge'
	Set<Vertex> visited = new Set<>();
	
	perimeter.add(s);  // kick of algorithm by adding start
	visited.add(s);
	
	while(!perimeter.isEmpty()) {          // grab one element at a time
	    Vertex from = perimeter.remove();  // get next node to process
		for(Edge edge : graph.edgesFrom(from)) {  // look at all neighbors 
			Vertex to = edge.to();
			if(!visited.contains(to)) {    // has neighbor been visited
			    perimeter.add(to);         // add unvisited neighbors
				visited.add(s);
			}
		}
	}
	
	return graph.size() == visited.size();
}
```

The ***properties of a queue*** are exactly what gives us this incredibly cool behavior.
As long as we explore an ***entire layer*** before moving on (and we will, with a queue) the next layer will be fully built up and waiting for us by the time we finish!
Keep going until perimeter is empty.

![[Pasted image 20241007114008.png]]
## **DFS vs BFS**

DFS and BFS are extremely similar, the only difference is the data structure we use for node traversal.

DFS and BFS are just two approaches for ordering a graph traversal. They are really just techniques for iterating over a set of nodes.

We can change the BFS Queue to a Stack to make it become DFS! (and vise versa)

![[Pasted image 20241007112928.png]]

![[Pasted image 20241007113032.png]]
## **DFS and BFS Runtime**

DFS uses less memory than BFS
DFS is easier to reconstruct the path when found
DFS does not always find the shortest path (for unweighted graphs). BFS does.

**Adjacency List**
What is the expected runtime of DFS and BFS, in terms of the number of vertices V and the number of edges E?

Answer: O(|V| + |E|)
- where |V| = number of vertices, |E| = number of edges
- Must potentially visit every node and/or examine every edge once.

Assuming that the graph is connected, each vertex is placed on the queue/stack exactly once.
(We mark the vertex as visited immediately after we put it on the queue/stack and this prevents it from every being placed on the queue/stack again.)

When we examine each vertex, we consider each of its edges exactly once.
This implies that the algorithm requires O(V + E) time for an adjacency list, where
- V is the number of vertices
  and
- E is the number of edges

This is O(E) if the graph is connected, since there must be at least O(V) edges in that case.

An adjacency matrix holds O(V<sup>2</sup>) indices. We must visit every index, even if it does not hold a vertex. Therefore, DFS/BFS for an adjacency matrix requires O(V<sup>2</sup>) time.
## Level-Order Traversal

Level-order traversal is an extension of BFS.

Sometimes you have an algorithm that does not simply have a single start point like the s-t connectivity problem.

If there are multiple vertices you must traverse at each BFS interval, traverse over every node that is currently in the queue. 

This use case is a common use case in tree traversal.

We call this **level-order traversal**. Each time we process a node, we process all of it's neighbors at once.

You can think of it as processing the ***entire layer*** before moving on to the next one, instead of just processing one node in the layer at a time.

```java
// Main function that calls helper DFS function
public void bfs(Graph graph, Vertex s) {
	path = dfs(graph, s);
}

// Traverses a graph beginning at vertex v using recursive BFS
private bool bfs(Graph graph, Vertex s) {
	// add all starting vertices
	Queue<Vertex> perimeter = new Queue<>(); 
	for(Vertex vertex : graph.vertices()) {
		if(vertex meets started condition i.e. in-degree of 0) {
			perimeter.add(vertex);
		}
	}
	
	Set<Vertex> visited = new Set<>();
	while(!perimeter.isEmpty()) {
		    Vertex from = perimeter.remove();  
			for(Edge edge : graph.edgesFrom(from)) {
				Vertex to = edge.to();
				if(!visited.contains(to)) {
				    perimeter.add(to);
					visited.add(s);
				}
			}
	}
	
	return graph.size() == visited.size();
}
```

## Unweighted Shortest Path Problem

**Problem Statement:**
Given source vertex s and a target vertex t, how long is the shortest path from s to t? What edges make up that path?

This is a little harder, but still totally doable! We can use a traversal algorithm, but just need a way to keep ***track of how far each node is from the start***. 

Sounds like a job for BFS! We just need to add a couple mode tracker data structures.

**Data Structures:**
1. **`Visited`** 
   Tracks if a node has been visited.
   
2. **`edgeTo`**
   Map stores ***backpointers***: each vertex remembers what vertex was used to arrive at it! 
   Allows us to print the path from t to s.
   
   Another implementation option: store them as fields of the nodes themselves

3. **`distTo`**
   Map that tracks the distance from a starting node to the current node. 

**Implementation:**
```java
// Main function that calls helper DFS function
public void bfs(Graph graph, Vertex s) {
	path = dfs(graph, s);
}

// Traverses a graph beginning at vertex v using recursive BFS
private Map<Vertex, Edge> bfs(Graph graph, Vertex s) {
	Queue<Vertex> perimeter = new Queue<>();
	Set<Vertex> visited = new Set<>();
	
	perimeter.add(s);
	visited.add(s);
	
	Map<Vertex, Edge> edgeTo = new HashMap<>();
	Map<Vertex, Double> distTo = new HashMap<>();
	
	edgeTo.add(s);  // kick of algorithm by adding start
	distTo.add(s);
	
	while(!perimeter.isEmpty()) {          // grab one element at a time
	    Vertex from = perimeter.remove();  // get next node to process
		for(Edge edge : graph.edgesFrom(from)) {  // look at all neighbors 
			Vertex to = edge.to();         // get unvisited neighbor
			if(!visited.contains(to)) {    // has neighbor been visited
				edgeTo.put(to, edge); 
				distTo.put(to, distTo.get(from) + 1);
			    perimeter.add(to);         // add unvisited neighbors
				visited.add(s);
			}
		}
	}
	
	return edgeTo;
}
```

![[Pasted image 20241007135458.png]]

The closest layer gets processed first, then the next, then the next.

>[!Key Intuition] 
>BFS works because: 
>1. IF we always process the closest vertices first,
>2. THEN the first path we discover to a new vertex will always be the shortest!

As soon as BFS enqueues a vertex, the final path to that vertex has been chosen! Never re-evaluate its path.

**What about the Target Vertex?**
This modification on BFS didn’t mention the target vertex at all! 

Instead, it calculated the shortest path and distance from start to every other vertex 
This is called the ***shortest path tree*** (SPT)
In this implementation, the SPT is made up of distances and backpointers.

What is the length of shortest path from A to D?
1. Lookup D in distTo map. You get the path length 2 returned.
2. Lookup D in edgeTo map. You get D's backpointer (previous node in path). 
3. Build up backwards from edgeTo map.
	1. start at D, 
	2. follow backpointer to B, 
	3. follow backpointer to A
4. Our shortest path is A -> B -> D

All our shortest path algorithms will have this property - If you only care about a specific target node, you can sometimes stop building the SPT early!

Thus, we have solved the **Single-Source Unweighted Shortest-Path Problem**.

## Weighted Shortest Path Problem

**Problem Statement:**
Given source vertex s and target vertex t, what path from s to t minimizes the total weight of its edges? How long is that path, and what edges make it up?

1. DFS is suitable for finding if a path **exists**
2. BFS is suitable for finding the shortest path in **unweighted** graphs
3. ??? is suitable for finding the shortest path in **weighted** graphs

![[Pasted image 20241007140449.png]]
##### Dijkstra's Algorithm
Dijkstra's algorithm was made by famous computer scientist Edsger Dijkstra.

Dijkstra's solves the "**single-source shortest-path** (SSSP)" problem in weighted graphs.
The algorithm finds the **minimum-weight path** between a pair of vertices in a weighted graph. SSSP is one of the most frequent graph problem encountered in real-life. 

Example: In a graph where vertices are cities and weighted edges are roads between cities, Dijkstra's algorithm can be used to find the shortest route from one city to any other

>[!Main Idea]
>Reminiscent of BFS, but adapted to handle weights.
>Grow the set of nodes whose shortest distance has been computed.
>Nodes not in the set will have a “best distance so far”.

BFS processed nodes in a level-by-level order. Each level got processed before the next level. In Dijkstra's, it is similar, except we process nodes in order of their shortest paths. 

In BFS, each time we process a node, it will be the ***next edge in the layer***.
In Dijkstra's, each time we process a node, it will be the ***edge with the next smallest weight***.

Therefore, the weight of the shortest path from **s** to **v** where **(s, v) ∈ E** is not necessarily the weight of their shared edge **(s, v)**. This single shared edge may have a larger weight than taking an alternative path with more edges that have smaller total weights.
##### Dijkstra’s Algorithm: Idea

![[Pasted image 20241007142841.png]]

The objective of the SSSP problem is to find the shortest path weight from **s** to each vertex **u**, where **s** ∈ **V** and **u** ∈ **V**, denoted as **δ(s, u)** (δ is pronounced as 'delta') and also the actual shortest path from **s** to **u**.

The path weight of a path **p** is simply the summation of edge weights along that path.

The weight of the shortest path from **s** to **s** is trivial: 0.
The weight of the shortest path from **s** to any unreachable vertex is also trivial: +∞.

At each step: 
1. Pick closest unknown vertex v
2. Add it to the “cloud” of known vertices
3. Update “best-so-far” distances for vertices with edges from v
## Dijkstra's Algorithm Pseudocode

```Java
public void dijkstras(Graph graph, Vertex start) {
	Map<Vertex, Edge> edgeTo = new HashMap<>();
	Map<Vertex, Double> distTo = new HashMap<>();
	
	// Initialize distTo with all nodes mapped to INF, except start to 0
	for (Vertex v in graph) { 
		distTo.put(distTo.get(v), INF);
	}
	distTo.replace(start, 0);
	
	// all vertices, ordered by distance
	PriorityQueue<Vertex> pq = new PriorityQueue<>();
	
	while (!pq.isEmpty()) {
		
		Vertex u = pq.removeMin();  // let u be the closest unknown vertex
		
		for(Edge edge : graph.edgesFrom(from)) {  // look at all neighbors 
			
			Vertex v = edge.to();                 // get neighbor
			
			int oldDist = distTo.get(v);
			int newDist = distTo.get(u) + edge.weight;
			if (oldDist < newDist) {
				
				distTo.replace(v, newDist);  // update min distance
				edgeTo.put(v, u);            // update backpointer
				
				if (pq.contains(v))
					pq.changePriority(v, newDist);
				else
					pq.add(v, newDist);
			}
		}
	}
	
	reconstruct path from v2 back to v1, following previous pointers.
```

A minheap data structure is required to make Dijkstra's work.
- DFS requires a Stack
- BFS requires a Queue
- Dijkstra's requires a minheap

A minheap gives them each vertex a distance “priority” value.
This makes it fast to grab the one with the smallest distance and lets us update that distance as we discover new, better paths.

We break the algorithm into three steps:
1. Initialize the vertex information
2. Initialize a minheap
3. While the minheap is not empty
	1. Get the updated weights of the nodes in the minheap - we visit the adjacent node with the smallest weight + edge

##### Dijkstra's Runtime

![[Pasted image 20241007150552.png]]

**O(|V| log |V| + |E| log |V|)**

Why can’t we simplify further? 
We don’t know if |V| or |E| is going to be larger, so we don’t know which term will dominate. 
Sometimes we assume |E| is larger than |V|, so |E|log|V| dominates. But not always true!
##### **Runtime of Shortest Path Problems**

There are two general types of shortest path algorithms:

1. Shortest Path in Unweighted Graphs

	Unweighted Shortest-Path Problem 
	O(|E|+|V|) time

2. Shortest Path in Weighted Graphs

	Weighted Shortest-Path Problem assuming there ***are no* negative edges**
	O(|V| log |V| + |E| log |V|) time