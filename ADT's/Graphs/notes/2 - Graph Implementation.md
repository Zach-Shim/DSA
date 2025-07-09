## **Graph Representations**

A Graph is an Abstract Data Type (ADT). 
There are two common data structures we can use to represent it:

1. **Adjacency Matrix**
2. **Adjacency List**

Notice the **adjacency** term. What does it mean for two vertices to be adjacent?

Two vertices are said to be **_adjacent_** if they simply share an **_edge_**.
That is, vertex **_j_** is **_adjacent_** to vertex **_i_** if and only if (_i_, _j_) ∈ _E_.

In a digraph (directed graph), edges are a **_one-way_** connection between vertices _v_ -> _w_.
An edge is an ordered pair, thus, _j_ is adjacent to _i_, but _i_ is not adjacent to _j_.

In an undirected graph, _j_ is adjacent to _i_ AND _i_ is adjacent to _j_. 

---
## **Adjacency Matrix**

##### ADT
An **adjacency matrix** for a graph with _n_ vertices numbered 0, 1, . . ., _n_ – 1 is an _n_ x _n_ array **two-dimensional array** (matrix).

matrix[i], where i = n, is a list of n length arrays that represents edges in the graph.

The matrix holds all possible edges in the set _E_.
If a graph has **_V_** vertices, how many distinct edges can it have?
- The first vertex **_V<sub>1</sub>_** can have an edge to every vertex (including itself): **_V_** edges
- The second vertex **_V<sub>2</sub>_** can have an edge to every vertex (including itself): **_V_** edges
- … and so on for each of the **_V<sub>i</sub>_** vertices

Therefore, a graph that has **_V_** vertices can have a maximum **_V_**<sup>2</sup> edges (_E_ = _V x V_ = _V<sup>2</sup>_)
- A graph with “all” **_V_**<sup>2</sup> edges is considered **_complete_** (the matrix is completely filled)
- A graph with “close to” **_V_**<sup>2</sup> edges is considered **_dense_**
- A graph with “closer to” **_V_** edges is considered **_sparse_**

**Example:** A graph has **_5_** vertices, how many distinct edges can each node have?
- Each node can have up to **_5_** edges
- The graph can have up to **_25_** edges

![[Pasted image 20241004155655.png]]
![[Pasted image 20241004155613.png]]
##### Time & Space Complexity

![[Pasted image 20241004155835.png]]

An adjacency matrix is an appropriate representation if the graph is **complete** or **dense**.
The space required for an adjacency matrix is **|_E_| = O(V<sup>2</sup>)**
##### Weighted vs. Unweighted
**Unweighted Matrix**
In an **unweighted graph**, we can let `matrix[i][j]` be the **number of edges** joining vertex **_i_** and **_j_**. This value is usually 1 or 0, but there can be more than one edge between two nodes.

- If there is single edge between vertices _i_ and _j_, the value will be ***1***.
- If there is no edge between vertices _i_ and _j_, the value will be ***0***.

**Weighted Matrix**
In a **weighted graph**, we can let `matrix[i][j]` be the **weight** that is between vertices **_i_** and **_j_**.
If there is an edge between vertices _i_ and _j_, the value will be the **_weight_** value that labels the edge.

- If there is a single edge between vertices _i_ and _j_, the value stored will be the ***weight of the edge***.
- If there is no edge between vertices _i_ and _j_, the value stored will be **_infinity_** (or a very large number, in practice).

> [!Diagonal Entries]
> The diagonal entry `matrix[i][i]` corresponds to the number of loops (self-connecting edges) at vertex **_i_**. 
> 
> This is often disallowed in graph implementations, therefore, there will often be a diagonal strike from the top left to the bottom right of matrix with 0 values.
##### Directed vs. Undirected
**Undirected Matrix**
Remember that in an **undirected graph**, each edge can be traversed in either direction.
An undirected graph with edge (_v_, _w_) also has edge (_w_, _v_). 
Both of these edges will have the same value in the adjacency matrix:

- _v_ -> _w_
- _w_ -> _v_

An adjacency matrix for an **undirected graph is symmetrical** (across the diagonal strike).
For every index in the matrix, `matrix[i][j]`, there is a symmetrical pair at `matrix[j][i]`.

- `matrix[i][j]`
  has the same value as
- `matrix[j][i]`

**Directed Matrix**
In a **directed graph**, we simply list all of the edges between nodes, without the symmetry. 
The edge value between two nodes will depend on whether the graph is weighted vs. unweighted.
##### Example 1: Undirected Weighted Graph
The following figure is an example of a **_weighted_** **_undirected_** graph and adjacency matrix.
For nodes that don’t have an edge, their values are infinity.
Notice the symmetry in the graph:

![[Pasted image 20241007100646.png]]
##### Example 2: Undirected Unweighted Graph
The following figures are examples of **_unweighted_** **_undirected_** graph and adjacency matrix.
For vertices that don’t have an edge between them, the weight is 0.
Again, notice the symmetry:

![[Pasted image 20241007101334.png|500]]
##### Example 3: Directed Weighted Graph
The following figure is an example of a **_weighted_ _directed_** graph and adjacency matrix.
For vertices that don’t have an edge between them, the weight is INF.

![[Pasted image 20241007101438.png|500]]
##### Example 4: Directed Unweighted Graph
The following figure is an example of an **_unweighted_ _directed_** graph and adjacency matrix.
- 0 represents false, and 1 represents true.
- Notice that the diagonal entries `matrix[i][i]` are always false(0). If a node were to point to itself, the associated diagonal entry would be true(1).

![[Pasted image 20241007100735.png|400]]  
![[Pasted image 20241007100843.png|400]]
##### Vertex (Node) Data
Our definition of an adjacency matrix so far has only been talking about edge values when it comes to storing unweighted vs. weighted values in a directed vs. undirected matrix.

We have not mentioned the value, if any, a **_vertex_** would have. 
For example, what if node A holds some value? We can't store in the adjacency matrix, because it holds the edge values.

If you need to associate values with vertices, you can use a separate 1-D array named **_values_** to represent the **_n_ vertex values**.
The array is one-dimensional, and `values[i]` represents each value in vertex _i_.

---
## **Adjacency List**

An **adjacency list** for a graph with **_n_** vertices numbered 0, 1, . . ., _n_ – 1 is a list of size **_n_**.
This list holds all vertices in the graph. For each vertex, we keep a **_linked list_** of all adjacent vertices.

This way, we don't need to keep a separate array to hold Vertex values. They can be stored in an object within the adjacency list.
##### **Tradeoffs**
There are **_V_** vertices in a graph.
We have different options on how to store those V vertices.
It is important to know how you will be using your adjacency list.

**Iterating over vertices? Use an array or list**

1. Keep an ***array*** of **_V_** vertices to represent the graph.
   Each vertex in the array is the head of a linked list.
   Each list contains a list of all vertices adjacent to the head of the list

2. Keep a ***list*** of of **_V_** vertices to represent the graph (can be linked list, array list, etc.).
   However, for very sparse graphs, when using ArrayLists, the programmer may need to start the ArrayLists with a smaller capacity than the default; otherwise there could be significant wasted space.

This implementation is better if ***order of insertion*** is important.

**Implementation Example:**
For each vertex V, create a Map from V to some Collection of E.
In an adjacency list, if (u,v) ∈ E, then v is found in the collection under key u.

Since each node maps to a list of its neighbors, in undirected graph every edge will be included twice
In directed graph, every edge from u is in list associated with key u.
   
![[Pasted image 20241007103046.png]]

![[Pasted image 20241007103056.png]]

![[Pasted image 20241007104034.png]]
   
**Need to quickly obtain the list of adjacent vertices for any vertex? Use a hashing ds.**

3. Keep a ***map*** that stores ***V*** vertices to represent the graph. 
   The keys are vertices and the values are adjacency lists.
   
4. Keep a ***set*** that stores ***V*** vertices to represent the graph.
   Create a ***Vertex*** class that maintains a vertex's adjacency list as a data member. 
   This option can be faster, because it avoids repeated lookups in the map.

What’s the tradeoff between using linked lists and hash tables for the list of neighbors?
A hash table still might hit a worst-case, and the linked list might not on average.

Graph algorithms often just need to iterate over all the neighbors, so you might get a better guarantee with the linked list.

![[Pasted image 20241007104010.png]]

![[Pasted image 20241007104021.png]]

![[Pasted image 20241007104110.png]]

**Need to quickly obtain the list of adjacent vertices for any vertex AND search for a specific neighbor? Use a hashing ds.**

5. Keep a ***set*** that stores ***V*** vertices to represent the graph.
   This set will map to another set that stores all adjacent vertices.
##### **Directed vs. Undirected**
**Undirected Graph**
The adjacency list for an **undirected graph** treats each edge as if it were **_two directed edges_ _in opposite directions_**.

If vertex A has an undirected edge with vertex B, then vertex A will have a node in its linked list pointing to B, and vertex B will have a node pointing to vertex A.

**Directed Graph**
The adjacency list for a **directed graph** simply adds a node to the end of the list for each adjacent vertex _j_ that has an edge with vertex _i_.
##### **Weighted vs. Unweighted**
**Weighted Graph**
The adjacency list for a **weighted** graph stores the **_vertex identity_** and **_edge_** values for all adjacent vertices to node _i_.

- If the edge is a dynamically allocated node, we can simply have a pointer pointing to adjacent vertex _j_.
- If the edge is not yet dynamically allocated, we need to create a new node containing the identity of the adjacent vertex, as well as the edge’s value.

**Unweighted Graph**
The adjacency list for an **unweighted** graph does not need to store any extra information other than the **_identity_** of the adjacent vertex (does not need to store edge value).
##### **Example 1: Undirected Weighted Graph**
The adjacency list for an undirected graph treats each edge as if it were two directed edges in opposite directions.

Thus, the edge between _A_ and _B_ appears as edges from _A_ to _B_ and from _B_ to _A_.

Since this graph is weighted, you can include the edge weights in the nodes of the adjacency list.

![[Pasted image 20241007104502.png]]
##### **Example 2: Directed Unweighted Graph**
You can see, that vertex 0 (_P_) has edges that point to vertex 2 (_R_) and vertex 5 (_W_).
Thus, the first linked chain in the adjacency chain contains nodes for _R_ and _W_.

Each edge is unweighted, so there is no additional information that needs to stored other than pointers to the identities of the adjacent nodes.

The following figure shows an **_unweighted_ _directed_** graph and its adjacency list.

![[Pasted image 20241007104425.png]]

If an adjacent vertex has no value, the node only needs to store some indication of the vertex’s identity.
## Matrix vs. List - Which Representation is Better?

Which of these two implementations of a graph is better?
The answer depends on how your particular application uses the graph.
##### **Performance of Common Operations**
Two of the most commonly performed graph operations are:

1. **Determine whether there is an edge from vertex _i_ to vertex _j_**

	**_Adjacency Matrix_**: 
	
	_Advantage:_
	Supports direct access in O(1) time.
	To determine whether there is an edge from _i_ to _j_ by using an adjacency matrix, you need only index the value of `matrix[i][j]`.
	
	_Disadvantage:_
	Can take up more/unnecessary space for sparse graphs.

	**_Adjacency List_**:
	
	_Advantage:_
	No need for extra space. An adjacency list will always have just enough space, but has a higher constant per vertex (because of pointers).
	
	_Disadvantage:_
	You must traverse the i<sup>th</sup> linked chain to determine whether a vertex corresponding to vertex _j_ is present. This can take up to O(N) time.

2. **Find all vertices adjacent to a given vertex _i_**

	**_Adjacency Matrix:_**
	If you use an _adjacency matrix_, you must either traverse the i<sup>th</sup> row of the array (**where there may be empty indexes**).
	
	If there were 100 vertices in a graph, but a vertex only is adjacent to 5 nodes, you still must traverse all 100 vertices at `matrix[5]`.
	
	**_Adjacency List:_**
	An _adjacency list_ supports this operation more efficiently. You need only traverse the i<sup>th</sup> linked chain to find all vertices adjacent to a given vertex _i_.
	
	For a graph with _n_ vertices, the i<sup>th</sup> row of the adjacency matrix always has _n_ entries, whereas the i<sup>th</sup> linked chain has only as many nodes as there are vertices adjacent to vertex i, a number typically far less than _n_.
	
	If there were 100 vertices in a graph, but a vertex only is adjacent to 5 nodes, you only have to traverse the 5 adjacent nodes.
##### **Runtime Comparison**
| Operations               | Adjacency List | Adjacency Matrix |
| ------------------------ | -------------- | ---------------- |
| get out-neighbors of *u* | O(deg(u))      | O(n)             |
| get out-neighbors of *v* | O(n)           | O(n)             |
| is *w* adjacent to *v*?  | O(1)           | O(1)             |
| add an edge              | O(1)           | O(1)             |
| remove an edge           | O(1)           | O(1)             |
### **Space Requirements**

**Adjacency Matrix**
An **adjacency matrix** is an appropriate representation if the graph is **dense**: |_E_| = O(|_V_|<sup>2</sup>).
The more complete a graph is, the denser it is (more edges).

**Adjacency List**
If the graph is not dense, in other words, if the graph is **sparse**, a better solution is an **adjacency list** representation.

For each vertex, we keep a list of all adjacent vertices.
The space requirement is then _O_(|_E_| + |_V_|), which is linear in the size of the graph.

The number of nodes in an adjacency list always equals the number of edges in a directed graph or twice that number for an undirected graph.

Even though the adjacency list also has n head pointers, it often requires less storage than an adjacency matrix.
##### **Space Comparison**
| Adjacency List | Adjacency Matrix |
| -------------- | -----------------|
| V + E | V<sup>2</sup> |
##### **Trade-Offs**
**Adjacency Matrix**
Pro: Allows direct access for faster indexing of adjacent vertices.
Con: Can take more space (and time) for sparse graphs.

**Adjacency List**
Pro: Is easier to manage when vertices are added to or removed from the graph
Con: We must re-examine/traverse all edges starting at the head vertex when we “visit” adjacent vertices.
##### **Which to Choose?**

When choosing a graph implementation for a particular application, you must consider such factors as **what operations you will perform most frequently** on the graph and the number of edges that the graph is likely to contain.

For example, if you are determining the sequence of flights from an origin city to a destination city. The flight map for this problem is a directed graph.

The most frequent operation would be to find all cities (vertices) adjacent to a given city (vertex). Therefore, the adjacency list would be the more efficient implementation of the flight map. The adjacency list also requires less storage than the adjacency matrix, which you can demonstrate as an exercise.