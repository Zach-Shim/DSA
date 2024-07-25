## **Definition**

A **topological sort** is an ordering of vertices in a **_directed acyclic graph (DAG)_**.

Given digraph _G_ = (_V_, _E_), find a linear ordering of vertices such that for all edges (_v_, _w_) in _E_, _v_ precedes _w_ in the ordering.

A **topological ordering** is any node sequence that does not violate this ordering.
## **Cycles Are Not Possible**

A **topological ordering is not possible if the graph has a cycle**, since for two vertices _v_ and _w_ on the cycle, _v_ precedes _w_ and _w_ precedes _v_.

These two nodes would be in a deadlock since you v would need to be before w, and w would need to be before v. It is impossible for both to be true at once.
## **Example: Course Prerequisites**

The following graph in represents a course prerequisite structure at a Miami University.

![[Pasted image 20230830145939.png]]

A directed edge (_v_, _w_) indicates that course _v_ must be completed before course _w_ may be attempted. This means that _v_ is a prerequisite to _w_.

For example, MAC3311 and MAD2104 (in that order) are prerequisites to COP3530.
A **topological ordering** of these courses is **_any course_ _sequence_** that does not violate the prerequisite requirement.

This means that there may be **more than one possible ordering**.
For example, you could first take COP3210 and COP3337 if you wanted to take COP3530.
## Example 2: Full Topological Ordering

Let’s say we want to find a topological ordering for _v6_ the following graph

![[Pasted image 20230830150244.png]]

v1, v2, v5, v4, v3, v7, v6 is a possible topological ordering
v1, v2, v5, v4, v7, v3, v6 is a possible topological ordering

## Example 3: Plating Food

Let’s say we want to find a topological ordering for _plating food_ in following graph
Notice how all _w_ (adjacent nodes) come after a _v_ (prerequisite):
- Butter Toast comes after Toast Bread.
- Plate Food transitively comes after Butter Toast.
- etc.

![[Pasted image 20230830150433.png]]

![[Pasted image 20230830150438.png]]

## Algorithm

1. **Steph 1:** Identify vertices that have **no incoming edges**.
    
    We define the **indegree** of a vertex _v_ as the **number of incoming edges** (_u_, _v_).
    
    ![[Pasted image 20230830150703.png]]
    
    The indegree of A and F are **zero**
    
    If all vertices have incoming edges (no vertices with indegree 0), then the graph has at least one **cycle** (cyclic graph).
    
    ![[Pasted image 20230830150731.png]]
    
    Compute the indegrees of all vertices in the graph.
    Select any vertex with indegree 0.
    
    ![[Pasted image 20230830150813.png]]
    
2. **Step 2:** **Remove** **this vertex** of indegree 0 and all its **outgoing edges** from the graph.
    
    ![[Pasted image 20230830150841.png]]
    
    Place this vertex in the **output** or print it.

3. **Step 3:** **Reduce** the indegree of all **adjacent vertices**.

4. **Step 4:** Repeat Steps 1, 2, and 3 **until the graph is empty**

![[Pasted image 20230830151035.png]]

Repeat Step 1, we identify that B and F have an indegree of 0
Repeat Step 2, we delete B and its outgoing edges, then place it in the output

![[Pasted image 20230830151046.png]]

Repeat Step 1, we identify that C and F have an indegree of 0
Repeat Step 2, we delete F and its outgoing edges, then place it in the output

![[Pasted image 20230830151054.png]]

Repeat Step 1, we identify that C has an indegree of 0
Repeat Step 2, we delete C and its outgoing edges, then place it in the output

![[Pasted image 20230830151103.png]]

Repeat for D and E
## **Topological Sort Implementation**

##### **Variables**

**Indegree Array:** We store each vertex’s indegree (# of incoming edges) in an array.

**Adjacency List:** Read graph into an adjacency list, and each vertex is the head of a list which holds all edges adjacent to the vertex.

![[Pasted image 20230830151254.png]]

![[Pasted image 20230830151302.png]]
##### **Algorithm**

**Assumptions**
We will assume the following: 
1. The Graph is already read into an adjacency list.
2. The indegrees of all vertices are computed and stored in a separate array.
3. Each vertex has a field named topNum, in which to place its topological numbering.

To implement the box, we can use either a stack or a queue; we will use a queue.

**Pseudocode**
1. First, the indegree is computed for every vertex and placed into an array.
2. All vertices of indegree 0 are placed on an initially empty queue.
3. If the queue is empty, then there is a cycle in the graph.
4. While the queue is not empty, a vertex _v_ is removed, and all vertices adjacent to _v_ have their indegrees decremented.
5. A vertex is put on the queue as soon as its indegree falls to 0.
6. **The topological ordering is the order in which the vertices dequeue.**

**Implementation**
```Java
void topsort() throws CycleFoundException {
	Queue<Vertex> q = new Queue<Vertex();
	int counter = 0;
	
	for each Vertex v {
		if(v.indegree == 0) {
			q.enqueue(v);
		}
	}
	
	while(!q.isEmpty()) {
		Vertex v = q.dequeue();
		v.topNum = ++counter;
		
		for each Vertex w adjacent to v {
			if(--w.indegree == 0) {
				q.enqueue(w);
			}
		}
	}
	
	if(counter != NUM_VERTICES) {
		throw new CycleFoundException();
	}
}
```

**Example**
![[Pasted image 20230831094336.png]]

![[Pasted image 20230831094339.png]]
## Time Complexity

1. Initialize the indegree array by storing each vertex’s indegree (# of incoming edges)

>O(|E|)

2. Find a vertex with indegree 0 from the indegree array and output it

>O(|V|)

3. Mark and output vertex

>O(|V|)

4. Reduce indegree of all vertices adjacent to vertex

>O(|E|)

5. Time to perform topological sort (if using adjacency lists)

> O( |E| + |V| )