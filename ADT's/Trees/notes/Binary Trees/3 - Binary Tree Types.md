There are three main types of binary trees depending on how the nodes are structured:
1. Full Binary Tree
2. Perfect Binary Tree
3. Complete Binary Tree
## **Full Binary Tree**
In a **full binary tree** of height _h_, all nodes that are at a **level less than _h_** have two children each.
Each node in a full binary tree has no nodes with one child; they all have zero or two.

>Intuitively, **a full binary tree has no missing nodes, meaning all possible leaves are filled**.

**T is a full binary tree if either**
- All nodes at a level less than _h_ have two children each
- All leaves (zero children) are filled at height _h_

Each node in a full binary tree has left and right subtrees of the same height.
Among binary trees of height _h_, a full binary tree has as many leaves as possible, and they all are at level _h_.

Figure 15-6 depicts a full binary tree of height 3.
![[Pasted image 20230901120559.png]]

When proving properties about full binary trees—such as how many nodes they have—the following recursive definition of a full binary tree is convenient:

- If _T_ is empty, _T_ is a full binary tree of height 0.
- If _T_ is not empty and has height _h_ > 0, _T_ is a full binary tree if its root’s subtrees are both full
- If _T_ is a nonempty binary tree and has height _h_ > 0, then because _T_ is of the form _r_

	![[Pasted image 20230901105806.png]]

_T_ is a full binary tree if its root’s subtrees are both full binary trees of height _h_ – 1.
## **Perfect Binary Tree**

A **perfect binary tree** is a type of binary tree in which

1. **All nodes have exactly two children**
2. **All the leaf nodes are at the same level**
![[Pasted image 20230901120932.png]]
**Number of Nodes**
A perfect binary tree of height _h_ has the following properties:
1. 2<sup>h</sup> total nodes at **current level** _h_ (number of nodes only on this row)
2. 2<sup>h+1</sup>−1 total nodes **up to level _h_** (number of nodes in this and all previous rows)

For every level we traverse down, the number of nodes double.
1. Level 0 has 1 node.
2. Level 1 has 2 nodes.
3. Level 2 has 4 nodes.
4. and so on…

From this, we can see a pattern.
The number of nodes on a level is based on a power of 2.
Meaning for every level we go down, we double the number of nodes.

The top level contains the root, which is the only node which contains no parent.
1. Total Nodes At Current Level: We account for this in the calculation of total nodes at current height h (2<sup>h</sup>) if we call the top level of tree height 0. The number of nodes at height 0 is 20 = 1.
2. Total Nodes Up To Current Level: We account for this in the calculation of total nodes at height h (2<sup>h+1</sup>−1) by adding that extra – 1 after the 2<sup>h+1</sup>−1. The – 1 account for the top level, which only has 1 node

![[Pasted image 20230901121515.png]]

Looking at the diagram, we can derive that the number of nodes on **level 𝑖** of a binary tree is 2<sup>h</sup>.
The total number of nodes in a perfect binary tree of height h can be formalized to: ![[Pasted image 20230901121601.png]]

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
![[Pasted image 20230901122934.png]]
**Complete Binary Tree Properties**

A perfect binary tree of height _h_ has the following property:

>There are **between** 2<sup>h</sup> and 2<sup>h+1</sup>−1 nodes at height _h_.

This implies that the height of a complete binary tree is _O_(log _N_).

This property is especially true when using the total height of the tree _h_ to try and find the number of leaves a binary tree has.

**Example**
We can say for certain that this complete binary tree with height 3 has between 2<sup>3</sup> and 2<sup>3+1</sup>-1 nodes.
This means that the tree can have between 8 and 15 nodes, which holds to be true.

![[Pasted image 20230901123124.png]]

H is the first possible node that holds the completeness property at level 3, and 15 is the rightmost node we could put in the tree at height 3.