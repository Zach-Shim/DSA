There are four main types of binary trees depending on how the nodes are structured:
1. Perfect Binary Tree
2. Complete Binary Tree
3. Full Binary Tree
4. Degnerate Tree
## **Perfect Binary Tree**

A **perfect binary tree** is a type of binary tree in which

1. **All nodes have exactly two children**
2. **All the leaf nodes are at the same level**

![[Pasted image 20250706173316.png]]

**Number of Nodes**
A perfect binary tree of height _h_ has the following properties:
1. 2<sup>h</sup> total nodes at **current level** _h_ (number of nodes only on this row)
2. 2<sup>h+1</sup>−1 total nodes **up to level _h_** (number of nodes in this and all previous rows)

From this, we can see a pattern.
The number of nodes on a level is based on a power of 2.
Meaning for every level we go down, we double the number of nodes.

1. Level 0 has 1 node.
2. Level 1 has 2 nodes.
3. Level 2 has 4 nodes.
4. and so on…

The top level contains the root, which is the only node which contains no parent.
1. **Total Nodes At Current Level:** We account for this in the calculation of total nodes at current height h (2<sup>h</sup>) if we call the top level of tree height 0. 
   The number of nodes at height 0 is 2<sup>0</sup> = 1.
2. **Total Nodes Up To Current Level:** We account for this in the calculation of total nodes at height h (2<sup>h+1</sup>−1) by adding that extra – 1 after the 2<sup>h+1</sup>−1. The – 1 account for the top level, which only has 1 node

![[Pasted image 20250706174006.png]]

Looking at the diagram, we can derive that the number of nodes on **level 𝑖** of a binary tree is 2<sup>h</sup>.
The total number of nodes in a perfect binary tree of height h can be formalized to: 

![[Pasted image 20250706174029.png]]

**Proof**
If we have 𝑛 nodes in a perfect tree, we can use the formula 𝑛 = 2<sup>h+1</sup>−1 to conclude that h = 𝑂(log 𝑛).

We use the formula          
2<sup>h</sup> = n         ->        log<sub>2</sub>n = h

A perfect tree with 𝑛 nodes has height 𝑂(log 𝑛).

**Examples**
Example 1: number of nodes of height 3 is 2<sup>3</sup> = 8 nodes
Example 2: total number of nodes of height 4 is 2<sup>4+1</sup>–1 = 8 nodes
## **Complete Binary Tree**

A complete binary tree has every level, except possibly the deepest, completely filled.
If the last level is not filled, then the nodes in the last level are as far left as possible.

![[Pasted image 20250706173732.png]]

**Complete Binary Tree Properties**

A perfect binary tree of height _h_ has the following property:

>There are **between** 2<sup>h</sup> and 2<sup>h+1</sup>−1 nodes at height _h_.

This implies that the height of a complete binary tree is _O_(log _N_).

This property is especially true when using the total height of the tree _h_ to try and find the number of leaves a binary tree has.

**Example**
We can say for certain that this complete binary tree with height 3 has between 2<sup>3</sup> and 2<sup>3+1</sup>-1 nodes.
This means that the tree can have between 8 and 15 nodes, which holds to be true.

![[Pasted image 20250706174140.png]]

H is the first possible node that holds the completeness property at level 3, and 15 is the rightmost node we could put in the tree at height 3.

## **Full Binary Tree**

In a **full binary tree** of height _h_, all nodes that are at a **level less than _h_** have two children each.
Each node in a full binary tree has no nodes with one child; they all have zero or two.

>Intuitively, **a full binary tree has no missing nodes, meaning all possible leaves are filled**.

**T is a full binary tree if either**
- All nodes at a level less than _h_ have two children each
- All leaves (zero children) are filled at height _h_

Each node in a full binary tree has left and right subtrees of the same height.
Among binary trees of height _h_, a full binary tree has as many leaves as possible, and they all are at level _h_.

![[Pasted image 20250706174440.png]]
## Degenerate Trees

Each binary tree in Figure 15-5 contains the same number of nodes, though their structures are quite different. We would consider 15-5 {d} a degenerate tree.
  ![[Pasted image 20250706170715.png]]

A **degenerate** tree is where each parent node has only one associated child node.

This means that the tree will behave like a linked list. In this case, an advantage of using a binary tree is significantly reduced because it is essentially a linked list which time complexity is O(_n_) and it has more data space than the linked list due to two pointers per node, while the complexity of O(log2 _n_) for data search in a balanced binary tree is normally expected.

