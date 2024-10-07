## **Definition**

A **topological sort** is an ordering of vertices in a **_directed acyclic graph (DAG)_**.

Given digraph _G_ = (_V_, _E_), find a linear ordering of vertices such that for all edges (_v_, _w_) in _E_, _v_ precedes _w_ in the ordering.

A **topological ordering** is any node sequence that does not violate this ordering.
## DAG

In a DAG, **Cycles Are Not Possible**.

A **topological ordering is not possible if the graph has a cycle**, since for two vertices _v_ and _w_ on the cycle, _v_ precedes _w_ and _w_ precedes _v_.

These two nodes would be in a deadlock since you v would need to be before w, and w would need to be before v. It is impossible for both to be true at once.
## Invariants

**Invariant 1:**
If G has a topological order, then G is a DAG.
If G is a DAG, then G has a topological order.

![[Pasted image 20241003115156.png]]

**Invariant 2:**
If G is a DAG, then G has at least one node with no incoming edges (a source node).
If G were to not have any nodes with no incoming edges, that would imply it has cycles.
## **Example: Course Prerequisites**

The following **DAG** represents a course prerequisite structure at UW.

![[Pasted image 20241003113457.png]]

The following graph is a possible (one of many possible) **topological orderings**.

![[Pasted image 20241003114833.png]]

A directed edge (_v_, _w_) indicates that course _v_ must be completed before course _w_ may be attempted. This means that _v_ is a prerequisite to _w_.

For example, CSE142 and CSE143 (in that order) are prerequisites to CSE374.

A **topological ordering** of these courses is **_any course_ _sequence_** that does not violate the prerequisite requirement. This means that there may be **more than one possible ordering**.

For example, you could first take MATH126 and CSE143 instead if you wanted to take CSE374.
## Algorithm

We will have three main data structures:
1. Adjacency list (represents graph)
2. In-Degree array
3. In-Degree 0 Queue
#### **Step 1:** Initialize in-degree in an array. (O|E|)

We define the **in-degree** of a vertex _v_ as the **number of incoming edges** (_u_, _v_).

Iterate over all vertices in the graph, and store their in-degree in an array. 
We call this our **in-degree array**.

#### Step 2: Initialize a queue with all in-degree 0 vertices. (O|V|)

We first need to identify vertices that have **no incoming edges**.

Since a DAG will naturally one or more nodes with no incoming edges, these will be the starting points of our topological sorting algorithm.

If all vertices have incoming edges (no vertices with in-degree 0), then the graph has at least one **cycle** (cyclic graph).

![[Pasted image 20241003131513.png]]

The in-degree of A and F are **zero**.

For all vertices with in-degree 0, we add them to a **queue**. 

This queue keeps track of nodes that have an in-degree of 0. We only ever process nodes with an in-degree of 0. This ensures a topological ordering.

While running the algorithm, we will decrease the in-degree of a node N's adjacent neighbors anytime we process N. 

If any of these neighbors reach an in-degree of 0, we add them to the queue.
#### Step 3: While the queue is not empty: (O|V|)

##### Step 3a: Deque and output/save a vertex. (O|1|)
##### Step 3b: Reduce the in-degree of all adjacent vertices by 1. (O|E|)
##### Step 3c: Enqueue any vertices whose in-degree became 0. (O|E|)

![[Pasted image 20241003140555.png]]
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

**Total:** 
(O|E|) + (O|V|) + ((O|E|) + (O|V|))

**Actual:** 
(O|E|) + (O|V|)

The time complexity is **linear**!
## **Topological Sort Implementation**

##### **Data Structures**

**In-degree Array:** We store each vertex’s in-degree (# of incoming edges) in an array.

**Adjacency List:** Read graph into an adjacency list, and each vertex is the head of a list which holds all edges adjacent to the vertex.

Queue: Keep track of current in-degree 0 nodes we want to process. This ensures we process vertices in a topological sorted order.
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

