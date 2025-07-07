## Tree Definition

A tree is a collection of **nodes**.

A **node** is a basic unit of a data structure. A node represents the information (value or condition) contained in a single structure.

We can define a tree **recursively**:
`T` is a tree if either
1. `T` has no nodes (is empty)
	or
2. `T` is of the form
   
   ![[Pasted image 20250704194555.png]]
   
   where we have a node at the top of the tree called the `root`
   where `T1`, `T2`, `...`, and `Tk` are also trees (subtrees)

From this definition, we can say a tree is a collection of
	**_N_** **nodes**, one of which is the root
	and
	**_N_** **− 1 edges**

We know there are **_N_ − 1** edges because each edge connects some node to its parent, and every node except the root has one parent.

An **edge** is what connects nodes together and gives them relation (parent-child).
## **Tree Hierarchies**

All trees are **hierarchical** in nature.
“**Hierarchical**” means that a “**parent-child**” relationship exists between the nodes in the tree.
##### **Parent-Child**
**Relationship:**
Node **_n_** is a **parent** of node **_m_** if an **edge** exists between them.
Node **_n_** (parent) is **directly above** node **_m_** (child) in the tree and are connected by a link (edge).

Conversely, we can say that **_m_** is a **child** of node **_n_** if an **edge** exists between them.
Node **_m_** (child) is **directly below** node **_n_** (parent) in the tree and are connected by a link (edge).

**Siblings:**
The leftmost child on a **level** in the tree is called the **oldest child**, or **first child**.
Nodes with the same parent are **siblings**.

**Parent:**
Each node in a tree has **one parent**.
The **root** of the tree is the only exception to this rule, it has no parent.

**Child:**
Each node may have an **arbitrary number of children**, possibly zero.
Nodes with no children are known as **leaves**.
##### **Ancestor-Descendant**
If two nodes have a path between them, (can trace one or more edges between them) they are said to have an **ancestor-descendant** relationship. This is analogous to a family tree.

The **root** is the **ancestor of every node** in the tree.

A **parent-child** relationship between nodes can be generalized to an **ancestor-descendant** relationship.

![[Pasted image 20250706171159.png]]

In Figure 15-1, the following nodes in tree (a) have an ancestor-descendant relationship:
1. A is an ancestor of D
2. B is an ancestor of E
3. D is a descendant of A
4. F is a descendant of B

In Figure 15-1, the following nodes in tree (a) do not have an ancestor-descendant relationship:
1. B and C do not have an ancestor-descendant relationship, but are siblings
##### Subtrees
A **subtree** is any node in a tree that satisfies the properties of a tree. 
A **subtree of a node _n_** is a subtree rooted at a child of **_n_**.

**Example 1:**
Figure 15-1b shows a subtree of the tree in Figure 15-1a.
This subtree has _B_ as its root and is a subtree of the node _A_.

**Example 2:**
![[Pasted image 20250706171257.png]]

**root:**                        _A_

**Siblings**:                 _B, C, D, E, F, G_ are siblings
                                 _H_ has no siblings
                                 _I, J_ are siblings
                                 _K_ _L_, _M_ are siblings
                                 _N_ has no siblings
                                 _P, Q_ are siblings

**Leaves**:                   _B_, _C_, _H_, _I_, _P_, _Q_, _K_, _L_, _M_, and _N_.

**Parent of Node _F_**: _A_

**Children of Node _F_**: _K_, _L_, and _M_

**Parent of Node _J_**:    _E_

**Children of Node _J_**: _P_ and _Q_
## **Path, Length, Depth, and Height**

**Path:**
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

**Length:**
The **length** of this path is the **number of edges on the path**, namely _k_ − 1.
There is a path of length zero from every node to itself.

**Depth:**
For any node _ni_, the **depth** of _ni_ is the length of the unique path from the **root to _ni_**.
Thus, the root is at depth 0.

**Height:**
The **height** of _ni_ is the length of the longest path from **_ni_ to a leaf**.
The height of a tree is equal to the height of the root.
All leaves are at height 0.

**Example:**
![[Pasted image 20250706171347.png]]

**Node _F_**
Depth 1
Height 1

**Node _E_**
Depth 1
Height 2

**Height of the tree**
The height of the tree is equal to the height of the root.
The height of node A is 3, which means that the height of the tree is 3.

**Depth of the tree**
The depth of a tree is equal to the depth of the deepest leaf; this is always equal to the height of the tree.
Therefore, the depth of the tree is also 3.