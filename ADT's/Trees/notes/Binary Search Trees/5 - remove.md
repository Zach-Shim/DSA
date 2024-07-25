**Goal:**
Remove item X in tree T.

**Returns:**
Nothing

**Algorithm:**
There are four potential cases when deleting a node:

| Node to Delete | Action |
| -------------- | ------ |
| 1. A leaf | replace with null |
| 2. Node with left child only | replace with left child |
| 3. Node with right child only | replace with right child |
| 4. Node with both children | replace with min from right subtree |

**Example 1 - 3:**
![[Pasted image 20230906111003.png]]

**Example 4:**
![[Pasted image 20230906111039.png]]

**Deleting A Node with Two Children**
The general strategy is to a delete a node with two children is to replace the data of the node with the smallest data of the right subtree and delete that smallest right subtree node. 

Because the smallest node in the right subtree cannot have a left child, we know that removing the smallest right subtree node will always be a scenario where it has a single right node for a child. 

**Implementation:**

**First Try:**
The following code performs deletion. It is inefficient, because it makes two passes down the tree to find and delete the smallest node in the right subtree when this is appropriate. 
```Java
private BinaryNode<T> remove(T key, BinaryNode<T> root) {
	if(root == null) {
		return root;
	} else if(key.compareTo(root.element) < 0) {               // traverse left subtree
		root.left = remove(key, root.left);
	} else if(key.compareTo(root.element) > 0) {               // traverse right subtree
		root.right = remove(key, root.right);
	} else if(root.left != null && root.right != null) {       // two children
		root.element = findMin(root.right).element;
		root.right = remove(root.element, root.right);
	} else {                                                   // leaf or single child
		t = 
	}
}

private BinaryNode<T> findMin(BinaryNode<T> root) {
	if(root == null) {
		return null;
	} else if(root.left == null) {
		return root;
	}
	return findMin(root.left);
}
```


**Improved:**
We can improve this inefficiency by writing a special removeMin method.
```Java
private BinaryNode<T> remove(T key, BinaryNode<T> root) {
	if(root == null) {
		return root;
	} else if(key.compareTo(root.element) < 0) {               // traverse left subtree
		root.left = remove(key, root.left);
	} else if(key.compareTo(root.element) > 0) {               // traverse right subtree
		root.right = remove(key, root.right);
	} else if(root.left != null && root.right != null) {       // two children
		root.right = removeMin(root.right);
	} else {                                                   // leaf or single child
		
	}
}

private BinaryNode<T> removeMin(BinaryNode<T> root) {
	if(root == null) {
		return null;
	} else if(root.left == null) {
		return root;
	}
	return findMin(root.left);
}
```


**Lazy:**
If the number of deletions is expected to be small, then a popular strategy to use is lazy deletion: When an element is to be deleted, it is left in the tree and merely marked
```Java

```

