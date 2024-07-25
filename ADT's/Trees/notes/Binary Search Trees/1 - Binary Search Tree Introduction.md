## **Binary Tree Definition**

**T is a binary tree if either**
- T has no nodes
    or
- T is of the form
```
     r
   /   \
  TL    TR
where r is a node and TL and TR are both binary trees
```

If **_r_** is the root of **_T_**, then
- the binary tree **_TL_** is the **left** **subtree** of node **_r_**
    and
- the binary tree **_TR_** is the **right** **subtree** of node **_r_**

If _TL_ is not empty, its **root** is the **left child** of **_r_**
If _TR_ is not empty, its **root** is the **right child** of **_r_**

Each node in a binary tree can have no more than **two children**.
Notice that if **both subtrees of a node are empty**, that node is a **leaf**.
# **Binary Search Tree Definition**

A **binary search tree** is a type of **binary tree** whose nodes are sorted according to the values in its nodes.

As its name suggests, a binary search tree organizes data in a way that facilitates **searching** it for a particular data item.

For each **node n**, a binary search tree satisfies the following three properties:

1.      **n’s value is** **greater than** **all values in its** **left subtree TL**.
2.      **n’s value is less than all values in its right subtree TR**.
3.      **Both TL and TR are binary search trees.**

This organization of data enables you to search a binary search tree for a particular data item, given its value instead of its position.
## Binary Search Tree Properties

1. Structure Property
    Each node has <= 2 children. This is the meaning behind binary.
2. Order Property
    All keys in left subtree are smaller than node's keys.
    All keys in right subtree are larger than node's keys.
## **Example**

Let’s consider a binary search tree whose nodes contain people’s names.
Suppose that these objects are Alan, Bob, Elisa, Jane, Nancy, Tom, and Wendy.

Figure 15-13 illustrates one binary search tree that we can form with these names.

![[Pasted image 20230901131635.png]]

Different binary search trees can contain the same data. 
However, the **time of insertion** matters when it comes to the **order** of the nodes in the tree.

![[Pasted image 20230901131646.png]]

All of these are valid binary search trees yet have different shapes.

The following properties make a binary tree into a binary search tree.
For every node X, in the tree:
1. the values of all the items in its left subtree are smaller than the item in X,
    and 
2. the values of all the items in its right subtree are larger than the item in X

This implies that all the elements in the tree can be ordered in some consistent manner. 

In Figure 4.15, the tree on the left is a binary search tree, but the tree on the right is not. 
The tree on the right has a node with item 7 in the left subtree of a node with item 6 (which
happens to be the root).

![[Pasted image 20230901132004.png]]
## BinaryNode Class

The binary search tree requires that all the items can be ordered. 
To write a generic class, we need to provide an interface type that allows us to sort objects. 
The interface `Comparable` allows us to compare two adjacent items in the tree using the compareTo method. 

From this, we can determine all other possible relationships. 
1. Item A is equal to Item B if the A.compareTo(B) returns 0.
2. Item A is less than Item B if the A.compareTo(B) returns a number < 0.
3. Item A is greater than Item B if the A.compareTo(B) returns a number > 0.

The following code shows the `BinaryNode` class that is a nested class in a `BSTree` class.

```Java
private static class BinaryNode<T> {
	
	T element;                 // data in node
	BinaryNode<T> left;        // left child
	BinaryNode<T> right;       // right child
	
	// Constructors
	BinaryNode(T element) {
		this(element, null, null);
	}
	
	BinaryNode(T element, T left, T right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
}
```

Note how each node has a left and right link. This is what gives our data structure a 'binary' property. Each node can have up to, at most, 2 children.

![[Pasted image 20230906094611.png]]
## Binary Search Tree Class

The following code shows the `BSTree` class skeleton. 

The single data field `root` is a reference to the root node. This reference is null for empty trees. 

The public methods use the general technique of calling private recursive methods.

```Java
public class BSTree(T extends Comparable<? super AnyType>) {
	private static class BinaryNode<T> {
		T element;                 // data in node
		BinaryNode<T> left;        // left child
		BinaryNode<T> right;       // right child
		
		// Constructors
		BinaryNode(T element) {
			this(element, null, null);
		}
		
		BinaryNode(T element, T left, T right) {
			this.element = element;
			this.left = left;
			this.right = right;
		}
	}
	
	private BinaryNode<T> root;
	
	public BSTree() {
		root = null;
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public boolean contains(T x) {
		return contains(x, root);
	}
	
	public T findMin() {
		if(isEmpty()) throw new UnderflowException();
		return findMin(root).element;
	}
	
	public T findMax() {
		if(isEmpty()) throw new UnderflowException();
		return findMax(root).element;
	}
	
	public void insert(T x) {
		root = insert(x, root);
	}
	
	public void remove(T x) {
		root = remove(x, root);
	}
	
	public void printTree() {	
	}
	
	private boolean contains(T x, BinaryNode<T> n) {
	}
	
	private BinaryNode<T> findMin(BinaryNode<T> n) {
	}
	
	private BinaryNode<T> findMax(BinaryNode<T> n) {
	}
	
	private BinaryNode<T> insert(T x, BinaryNode<T> n) {
	}
	
	private BinaryNode<T> remove(T x, BinaryNode<T> n) {
	}
	
	private void printTree(BinaryNode<T> n) {
	}
}
```