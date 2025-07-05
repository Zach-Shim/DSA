**Goal:**
Insert item X in tree T.

**Returns:**
Nothing

**Algorithm:**
To insert X into tree T, proceed down the tree as you would with a contains. 
If X is found, do nothing (or “update” something).
Otherwise, insert X at the last spot on the path traversed. 

New insertions only happen at **leaves**.

**Implementation:**
```Java
public void insert(T x) {
	root = insert(x, root);
}

private BinaryNode<T> insert(T x, BinaryNode<T> n) {
	// base case
	if(root == null) {
		return new BinaryNode<T>(x, null, null);
	} else if(x.compareTo(n.element) < 0) {
		n.left = insert(x, n.left);
	} else if(x.compareTo(n.element) > 0) {
		n.right = insert(x, n.right);	
	}
	return root;
}
```

Your actual implementation depends on your assumptions and what your specific rules are for a tree.

For example, what should we do with duplicates? There are many ways to handle them. 
- Duplicates can be handled by keeping an extra field in the node record indicating the frequency of occurrence. This adds some extra space to the entire tree but is better than putting duplicates in the tree (which tends to make the tree very deep). 
- Of course, this strategy does not work if the key that guides the compareTo method is only part of a larger structure. If that is the case, then we can keep all of the structures that have the same key in an auxiliary data structure, such as a list or another search tree.

Usually, you insert a new node at a leaf in the tree. 
This brings an important question into play. What if we just kept inserting nodes greater than the previous? This would essentially create a linked list. We need some way to keep the tree **balanced**.

**The x = change(x) pattern**
https://courses.cs.washington.edu/courses/cse143/11wi/lectures/02-23/20-binary-search-tree.pdf

**Time Complexity:**
Worst case running time is O(N).

![[Pasted image 20230906100717.png]]

Average running time is O(logN) if tree is balanced.

**Space Complexity:**
The use of tail recursion is justifiable here because the simplicity of algorithmic expression compensates for the decrease in speed, and the amount of stack space used is expected to be only O(log N). 