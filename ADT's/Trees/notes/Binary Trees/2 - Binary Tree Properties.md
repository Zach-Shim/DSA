## **Path**
A **path** from node n1 to nk is defined as
	A sequence of nodes n1, n2, ..., nk
	such that
	ni is the parent of ni+1 for 1 ≤ _i_ < _k_

Notice that in a tree there is exactly **one path** **from the root to each node**.
Paths in a tree are found using traversal algorithms such as DFS or BFS.

If there is a path from n1 to n2, then
	n1 is an **ancestor** of n2
	and
	n2 is a **descendant** of n1.

If n1 != n2
	n1 is a **proper ancestor** of n2
	and
	n2 is a **proper descendant** of n1.
## **Length**
The **length** of a path is the **number of edges on the path**.

From the recursive definition, we find that a tree is a collection of
- **_N_ nodes**, one of which is the root
    and
- **_N_ − 1 edges**

We know there are _N_ − 1 edges because each edge connects some node to its parent, and every node except the root has one parent.

Therefore, if there is a path from _n1_ to _nk_, then the path length will be equal to **_k_ − 1**
There is a path of length **zero** from every **node to itself**.
## **Depth**
For any node **_ni_**, the **depth** of **_ni_** is the length of the **_unique path_** from the **root to _ni_**.

The depth of a tree is equal to the depth of the deepest leaf.
This is always equal to the height of the tree.

The **root is at depth 0**.
## **Height**
The **height** of **_ni_** is the **_length_** of the **_longest path_** from **_ni_** to the **_furthest leaf node_**.

The **height of a tree** is equal to the **height of the root**.

Height of **_T_** (tree) is equal to height of **_r_** (root).

The height of a tree would be
- the height of its root node  
    or equivalently,
- the depth of its deepest leaf

All **leaves** are at height 0.
## **Width**
The diameter (or width) of a tree is the number of **_nodes_** on the **longest path between any two leaf nodes**.
Note that this path **does not have to pass through the root**.
## **Example**
![[Pasted image 20250706171536.png]]

Height of tree = 3
Width of tree = 6
## **Depth vs. Height**
The depth of a node is synonymous to the **level** of a node (depending on who you ask).

Two nodes may have the same depth (or be at the same level) but can vary in height.
This is because they are the same distance from the root but may have varying depths to leaves.

This is made clearer in the following figure.

![[Pasted image 20250706171603.png]]

Notice how nodes D and G are at the same depth, which is 2, but have different heights.
D has a height of 0, because it has no children, and G has a height of 1, because it has one child, I.
