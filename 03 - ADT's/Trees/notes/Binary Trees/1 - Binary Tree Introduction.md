## **N-ary Tree**

An **n-ary tree** is a set **_T_** of nodes that is either empty or partitioned into disjoint subsets:
- A single node **_r_**, the root
- n possibly empty sets that are n-ary subtrees of **_r_**

Each node can have no more than **n children**. (But can have <= n children!)
The following tree is an example of an n-ary tree with n = 3.

![[Pasted image 20230901103121.png]]

An n-ary tree is **not a special kind of general tree**.
- An **n-ary tree can be** **empty**
- A **general tree** **cannot be empty**.

If an n-ary tree has the restriction that every node has at most two children, it is a **binary tree.**
## **Binary Tree**

A **binary tree** is a set **_T_** of nodes that is either empty or partitioned into disjoint subsets:
- A single node r, the root
- Two possibly empty sets that are binary trees, called left and right subtrees of r

A binary tree is **a special kind** of n-ary tree.
Each node in a binary tree can have no more than **two children**. (can have 0, 1, or 2 children at any point)

**Example**
The following is an example of a binary tree:
![[Pasted image 20230901103330.png]]
This tree has a total of six nodes (n) and 5 edges (n-1).

Some people joke that computer scientists view the world upside down, so imagine turning the diagram around the other way:
![[Pasted image 20230901103341.png]]

## **Intuitive Definition of a Binary Tree**

**T is a binary tree if either**
- T has no nodes
    or
- T is of the form

![[Pasted image 20230901104709.png]]

where **_r_** is a node and **_TL_** and **_TR_** are both binary trees

Notice that the formal definition agrees with this intuitive one:
	If **_r_** is the root of **_T_**, then
	- the binary tree **_TL_** is the **left** **subtree** of node **_r_**
	    and
	- the binary tree **_TR_** is the **right** **subtree** of node **_r_**

If _TL_ is not empty, its **root** is the **left child** of **_r_**
If _TR_ is not empty, its **root** is the **right child** of **_r_**

Notice that if **both subtrees of a node are empty**, that node is a **leaf**.