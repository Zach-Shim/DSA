A **graph traversal** is an algorithm that visits all vertices that it can reach in a graph, G, from a starting vertex **_v_**.

In other words, a graph traversal that starts at vertex **_v_** will visit all vertices **_u_** for which there is a path between **_v_** and **_u_**.

The **_order_** vertices are traversed in depends on the **_type_** of graph you are traversing.

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
## **Graph Traversal Algorithms**

##### **Searching for Paths**
A common operation on graphs is searching for a path from one vertex to another.
1. Sometimes, we just want **any** path (or want to know if a path exists).
2. Sometimes, we want to minimize path length (# of edges).
3. Sometimes, we want to minimize path cost (sum of edge weights).
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

DFS marks **_visited_** nodes so it does not revisit the same node twice.

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
##### **DFS Properties
1. **Discovery:**
    DFS is guaranteed to find a path if one exists.
    This does not mean it finds the most optimal (i.e, shortest) path.
    Example: dfs(a,f) returns {a,b,e,f} rather than {a,e,f}.

2. **Retrieval:**
   It is easy to retrieve exactly what the path taken (sequence of edges) is if we find it.

3. **Optimality:**
   If the graph is undirected and unconnected, or directed and not strongly connected, this strategy might fail to visit some nodes.
##### **Mark Visited Nodes**
If this process is performed on a **binary tree**
- All tree vertices are systematically visited in a total of _O_(|_E_|) time, since |_E+1_| = _O_(|_V_|).
  (note this case is not the same for graphs, because nodes are not required to have an out-degree of 2)

If we perform this process on an **arbitrary graph**
- We need to be careful to **_avoid cycles_**.
- To do this, when we visit a vertex _v_, we **_mark it visited_**, since now we have been there, and we recursively call depth-first search on all adjacent vertices that are not already marked.

We implicitly assume that for undirected graphs every edge (_v_, _w_) appears twice in the adjacency lists: once as (_v_, _w_) and once as (_w_, _v_).

>[!Important]
> We mark nodes as visited so we know which ones we have already visited. This helps us avoid cycles.
##### **Traversal Order**
How do we determine **which unvisited adjacent vertex to visit**?
- DFS does not have a standard for the order in which vertices adjacent to _v_ are visited.
- One possibility is to visit the vertices adjacent to _v_ in natural sorted order (e.g., alphabetic, or numerically increasing).
- This possibility is natural either when an adjacency matrix represents the graph or when the nodes in each linked chain of an adjacency list are linked in sorted order.

>[!Important]
> DFS does not have a standard for the order in which unvisited adjacent nodes are visited. A common solution is use natural sorted order.
##### **DFS Recursive Algorithm**
```Java
// Main function that calls helper DFS function
public void dfs(Vertex v1, Vertex v2) {
	path = dfs(v1, target, {});
}

// Traverses a graph beginning at vertex v using recursive DFS
private void dfs(Vertex current, Vertex target, Path path) {
	
	path += current;
	v.visited = true;
	
	if(current is equal to target) {
		a path is found!
	}
	
	for(each Vertex u adjacent to Vertex current) {
		if(u has not been visited) {
			dfs(u, target, path);
		}
	}
}
```

The **_path_** parameter above is used if you want to have the path available as a list once you are done.

By recursively calling the procedures **only on nodes that have not been visited**, we guarantee that we do not loop indefinitely (in the case of cyclic graphs).

We then search for an unmarked node, apply a depth-first traversal there, and continue this process until there are no unmarked nodes.
##### **DFS Iterative Algorithm**
```Java
//  Traverses a graph beginning at vertex v by using iterative depth-first search
public void dfs(Vertex v) {
	s = a new empty stack;
	s.push(v);                                         
	Mark v as visited;
	
	while(!s.isEmpty()) {
		v = s.pop();                                          // pop 
		if(no unvisited vertices adjacent to v) {
			s.pop();                                          // backtrack
		} else {
			select an unvisited vertex u adjacent to vertex v and s.push(u);
			mark u as visited;
		}
	}
}
```

Note how the iterative version is very similar to the recursive version. We simply replace the implicit call stack with an explicit stack to keep track of unvisited nodes.
##### **Example**
Figure 20-12 shows the contents of the stack (either recursive call stack or iterative data structure stack) as we traverse the graph in Figure 20-11 using DFS. 

Since 20-11 is a connected graph, DFS will visit every vertex in the graph.
The traversal visits the vertices in the following order: _a, b, c, d, g, e, f, h, i_.

The vertex from which a depth-first traversal embarks is the vertex that it visited most recently.
This _last visited, first explored_ strategy is reflected both in the explicit stack of vertices that the iterative dfs uses and in the implicit stack of vertices that the recursive dfs generates with its recursive calls.

![[Pasted image 20230828150721.png]]
![[Pasted image 20230828150724.png]]

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
3. and then immediately **backtracking**.

It is often implemented by maintaining a **queue** of **vertices to visit**.

>[!Important]
>BFS is an iterative graph traversal algorithm that finds the shortest path between two nodes in an unweighted graph. It is implemented by adding a nodes adjacent neighbors to a queue.
##### BFS Properties
1. **Optimality**
   Always finds the **shortest path** (fewest edges).
   In **unweighted graphs**, finds **optimal cost path**.
   In **weighted graphs**, **not always optimal cost**

2. **Retrieval**
   Harder to reconstruct the actual sequence of vertices or edges in the path once you find it.
   Conceptually, BFS is exploring many possible paths in parallel, so it's not easy to store a path array/list in progress.
   Solution: We can use extra space to keep track of the path by storing predecessors for each vertex in an array/list (each vertex can store a reference to the previous vertex on a path).
##### Example Walkthrough
**Input:**
We are given a starting vertex, _s_.

**Goal:**
We would like to find the shortest path from _s_ to all other vertices.

**Return:**
The **length** of the shortest path from _s_ to all other vertices.

**Constraints:**
We are only interested in the number of edges contained on the path, so there are no weights on the edges. This is a special case of the weighted shortest-path problem, since we could assign all edges a weight of 1.

For now, suppose we are interested only in the **length** of the shortest paths, not in the actual paths themselves. Keeping track of the actual paths will turn out to be a matter of simple bookkeeping.

**Diagram:**
Figure 9.10 shows an unweighted graph, _G_.

![[Pasted image 20240917224649.png]]

1. Step 1:
   Suppose we choose _s_ to be v3. 
   Immediately, we can tell that the shortest path from _s_ to v3 is then a path of length 0.
   We can mark this information, obtaining the graph in Figure 9.11.
   
![[Pasted image 20240917224704.png]]

2. Step 2:
   Now we can start looking for all vertices that are a **distance 1 away** **from** **_s_**.
   These can be found by looking at the **vertices that are** **adjacent** to **_s_**.
   If we do this, we see that v1 and v6 are one edge from _s_.
   This is shown in Figure 9.12.
   
![[Pasted image 20240917225131.png]]

3. Step 3:
   We can now find vertices whose **shortest path from _s_ is exactly 2**.
   We find all the vertices adjacent to v1 and v6 (the vertices at distance 1), whose shortest paths are not already known.
   This search tells us that the shortest path to v2 and v4 is 2.
   Figure 9.13 shows the progress that has been made so far.
   
![[Pasted image 20240917225306.png]]

4. Step 4:
   Finally, examine the vertices adjacent to the recently evaluated v2 and v4.
   This search tells us that the shortest path to v5 and v7 is 3.
   All vertices have now been calculated, and so Figure 9.14 shows the final result of the algorithm.
   
![[Pasted image 20240917225404.png]]

This strategy for searching a graph is known as **breadth-first search**.
It operates by processing vertices in layers:

1. The vertices closest to the start are evaluated first
   and
2. The most distant vertices are evaluated last

This is much the same as a **level-order traversal for trees**.
##### **Implementing BFS**

**Variables**
The following figure shows the initial configuration of the table that our algorithm will use to keep track of its progress.

| vertex | visited | distance | previous |
| --- | --- | --- | --- |
| v1 | F | INF | null |
| v2 | F | INF | null |
| v3 | F | 0 | null |
| v4 | F | INF | null |
| v5 | F | INF | null |
| v6 | F | INF | null |
| v7 | F | INF | null |

For each **vertex**, we will keep track of three pieces of information.
1. **`Visited` is a Boolean that tracks if the vertex has been processed**
   Initially, all entries are **not known**, including the start vertex.
   When a vertex is marked known, we have a guarantee that no cheaper path will ever be found, and so processing for that vertex is essentially complete.
   
2. **`Distance` from s**
   Initially all vertices are unreachable except for s, whose path length is 0.

3. **`Previous` is a tracker variable that holds the node preceding the current node in the path** 
   This will allow us to print the actual paths by tracing the path backwards from the final node.
##### BFS First Try Pseudocode

```Java
void unweighted(Vertex s) {
	for each Vertex v in Graph g {
		v.dist = INFINITY;
		v.visited = false;
	}
	
	s.distance = 0;
	
	for(int currDist = 0; currDist < NUM_VERTICES; currDist++) {
		for each Vertex v {
			if(!v.visited && v.distance == currDist) {
				v.visited = false;
				for each Vertex w adjacent to v {
					if(w.distance == INFINITY) {
						w.distance = currDist + 1;
						w.previous = v;
					}
				}
			}
			
		}
		
	}
}
```

This is a good first attempt, but there is a lot of potential repeated work.
An obvious inefficiency is that the outside for loop continues until NUM_VERTICES − 1, even if all the vertices become known much earlier.

We can remove the inefficiency by keeping a queue. 

At the start of the pass, the queue contains only vertices of distance currDist. When we add adjacent vertices of distance currDist + 1, since they enqueue at the rear, we are guaranteed that they will not be processed until after all the vertices of distance currDist have been processed. 
1. We know that we can immediately access all vertices adjacent to the source vertex with a path of length one.
2. We then search the neighbors of all of these vertices to find paths of length two.
3. … and, so on, until all edges have been considered.
##### **BFS Better Pseudocode**

```Java
public void bfs(Vertex v1, Vertex v2)
    
    // Initialize queue and add v1 (head) onto the queue and mark it visited
    queue = initialize empty queue
    add v1 to queue
    mark v1 as visited

    while(queue is not empty) {
        v = queue.removeFirst(); // remove top node
        if (v1 is v2) {          // check to find the shortest path from v1 to v2
            a path is found!     // get path by following .previous back to v
        }
        
        for(each unvisited neighbor n of v) {
            mark n as visited             // avoid cycles by marking n as visited
            queue.addLast(n);             // add n to queue
        }
    
    }
    
    // path is not found
```
##### **BFS Traversal Pseudocode**

If there are multiple vertices you must traverse at each BFS interval, traverse over every node that is currently in the queue. This is a common use case in tree traversal.

```Java
public void bfs(Graph g)

    // Initialize queue and add {vs} onto the queue and mark them as visited
    queue = initialize empty queue
    add all starter vertices {vs} from g to queue
    mark vertices in {vs} as visited

    while(queue is not empty) {
        n = queue size
        for(every node currently in queue) {
            v = queue.removeFirst();                // remove current node   
            for(each adjacent neighbor n of v) {
                if(n is unvisited) {
                    mark n as visited                // avoid cycles by marking n as visited
                    queue.addLast(n);                // add n to queue
                }
            }
        }
    }
```

##### **DFS vs BFS**
DFS uses less memory than BFS
DFS is easier to reconstruct the path when found
DFS does not always find the shortest path (for unweighted graphs). BFS does.

Thus, we have solved the **Single-Source Unweighted Shortest-Path Problem**.
## **DFS and BFS Runtime**

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

![[Pasted image 20230828161120.png]]