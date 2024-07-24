## What Is A Binary Heap

A **binary heap** is a data structure that is commonly used for priority queue implementations.

A heap is a concrete implementation of the priority queue abstract data type
	ADT = Priority Queue
	Data Structure = Binary Heap

Binary heaps are a type of ***binary tree*** and usually just referred to as **_heaps_**_._
	They are unrelated to the memory pool used for dynamic allocation

Heaps make a tradeoff for node priority values instead of being good at other types of operations like searching and sorting in conventional binary search trees.
## Binary Heap Properties

A binary heap is a type of **binary tree** with two important properties:

1. **Completeness**
2. **Heap Order**

These properties are what make a **binary tree** a **priority queue**.
An operation on a heap can disturb one of these properties, so a heap operation must not terminate until all heap properties are in order.
##### Completeness
A binary heap is a **_complete binary tree_**.
A complete binary tree has every level, except possibly the bottom, completely filled with nodes. If the bottom level is not filled, the nodes are as ***far left*** as possible.

![[Pasted image 20230830100115.png]]
##### Heap Order
There are two main types of heaps:
1. **Minheap** – the **root** contains the **smallest** item in the tree
    A **minheap** is a **_complete binary tree_** whose **root** is either **empty** or
	1. Contains a value **less than** **or equal to** the value of both of its children
	    and
	2. Has heaps as its subtrees
	
	In a minheap, for every node _X_, the key (value) in the parent of _X_ is smaller than (or equal to) the key in the current node _X_, with the exception of the root (which has no parent).
	
	The minheap-order property ensures the **minimum** element is always found at the root. Thus, we get the operation **findMin()**, in **constant time**.

2.  **Maxheap** – the **root** contains the **largset** item in the tree
    A **maxheap** is a **_complete binary tree_** whose **root** is either **empty** or
	1. Contains a value **greater than** **or equal** to the value in each of its children
	    and
	2. Has heaps as its subtrees
	
	In a maxheap, for every node _X_, the key (value) in the parent of _X_ is greater than (or equal to) the key in the current node _X_, with the exception of the root (which has no parent).
	
	By the maxheap-order property, the **maximum** element can always be found at the root. Thus, we get the extra operation **findMax()**, in **constant time**.

##### Minheap and Maxheap Example

![[Pasted image 20230830101030.png]]

In Figure 17-1, we see that both trees are **complete**.
Tree (a) is a maxheap, which has the largest value in the tree at its root.
Tree (b) is a minheap, which has the smallest value in the tree at its root.
## **Binary Heap vs. Binary Search Tree**

A binary heap is similar to a binary search tree, although it differs from a binary search tree in two significant ways:

1. **Completeness**
	While binary search trees come in many different shapes and sizes, heaps are always complete binary trees.

2. **Heap Order**
	**T is a Binary Search Tree if:**
	1. T is empty
	    or
	2. Everything in its left subtree is smaller than it and everything in its right subtree is larger than it.
	this is true if the left subtree and right subtree are binary trees.
	
	This causes really bad behavior in the worst case (skewed BST).
	
	While you can view a BST as being in sorted order, a heap is ordered slightly differently. You cannot traverse a binary heap to output the items in sorted order.
	
	**T is a Binary Heap if:**
	1. T is a Complete Binary Tree
	    and
	2. Every node is less than or equal to all of its children
	
	This is true if the smallest element is in the root and results in no degenerate trees.
	
	The difference here is that:
		BST = Left subtree is < Node and Right subtree > Node
		Heap = Node < both child subtrees

3. **insert and removeMin operations**
	**Binary Search Tree Worst Case:**
	**insert = O(N)**
	**removeMin = O(N)**
	
	BSTs have really bad behavior in the worst case when they are fully skewed left or right.
	But is it actually a common problem?
	Fact: On average, the height of a BST is 𝑂(log 𝑛) (for some suitable definition of “average”). However, its properties allow a worst case of height n.
	
	Can we somehow enforce an O(log n) behavior in the worst case for priority queues?
	Yes! This is what completeness + heap order accomplishes.
	
	**Binary Heap Worst Case:**
	**insert = O(log N)**
	**removeMin = O(log N)**
	
	A binary heap will maintain a height of logn, which therefore results in a worst case runtime of O(log N) for these operations.
## Array Implementation

A complete binary tree of height _h_ has between 2<sup>h</sup> and 2<sup>h+1</sup>−1 nodes (whether the bottom row has one node or is fully filled). This implies that the **height** of a **complete binary tree** is (log *N*).

Because a heap is a complete binary tree, it can be represented easily in an array without the need for links (pointers).

This array-based implementation saves memory because the elements in a complete binary tree are always **contiguous**.

We can skip index 0 in the array to make the math simpler.
Therefore, index 0 can be a good place to store the current size of the heap.

>From node _i_, we can find
>   - The left child at position 2i
>   - The right child at position 2i + 1
>   - The parent at position i / 2

![[Pasted image 20230830102024.png]]

**Example**: Calculate/Find the left child, right child, and parent of vertex E
- E is located at index 5.
- The left child is at 2·5=10. This means J is E's left child. 
- The right child is at 2·5+1=11. This means K is E's right child.
- The parent is at 5/2=2. This means B is E's parent.

By looking at the following diagram, we can see all of these calculations are correct.

![[Pasted image 20230830102028.png]]