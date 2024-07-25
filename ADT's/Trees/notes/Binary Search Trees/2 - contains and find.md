## Contains

**Goal:**
Check if item X exists in tree T.

**Returns:**
Returns true if there is a node in tree T that has item X.
Returns false if there is no such node X in tree T, or if T is empty.

**Algorithm:**
If T is empty, then we can just return false. 
Otherwise, if the item stored at T is X, we can return true. 
Otherwise, we make a recursive call on a subtree of T, either left or right, depending on the relationship
of X to the item stored in T. 

Notice the order of the tests. It is crucial that the test for an empty tree be performed
first, since otherwise, we would generate a NullPointerException attempting to access a data
field through a null reference. The remaining tests are arranged with the least likely case last.

**Recursive Implementation:**
```Java
private boolean contains(T key, BinaryNode<T> root) {
	if(root == null) {
		return false;
	}
	
	int res = key.compareTo(root.element);
	
	if(res > 0) {
		return contains(key, root.right);
	} else if(res < 0) {
		return contains(key, root.left);
	} else {
		return true;
	}
}
```

Also note that both recursive calls are actually tail recursions and can be easily removed with a while loop. 

**Iterative Implementation:**
```Java
private boolean contains(T key, BinaryNode<T> root) {
	while(root != null) {
		int rootKey = key.compareTo(root.element);
		if(key > rootKey) {
			root = root.right;
		} else if(key < rootKey) {
			root = root.left;
		} else {
			return true;
		}
	}
	return false;
}
```

**Time Complexity:**
Worst case running time is O(N).

![[Pasted image 20230906100717.png]]

Average running time is O(logN) if tree is balanced.

**Space Complexity:**
The use of tail recursion is justifiable here because the simplicity of algorithmic expression compensates for the decrease in speed, and the amount of stack space used is expected to be only O(log N). 

**Find Implementation**
A find operation is just like a contains operation, except we return a node's value instead of a Boolean.

**Recursive:**
```Java
private BinaryNode<T> find(T key, BinaryNode<T> root) {
	if(root == null) {
		return null;
	}
	
	int res = key.compareTo(root.element);
	
	if(res > 0) {
		return find(key, root.right);
	} else if(res < 0) {
		return find(key, root.left);
	return root.element
}
```

**Iterative:**
```Java
private BinaryNode<T> find(T key, BinaryNode<T> root) {
	while(root != null) {
		int rootKey = key.compareTo(root.element);
		if(key > rootKey) {
			root = root.right;
		} else if(key < rootKey) {
			root = root.left;
		} else {
			return root.element;
		}
	}
	return null;
}
```

![[Pasted image 20230906102659.png]]
