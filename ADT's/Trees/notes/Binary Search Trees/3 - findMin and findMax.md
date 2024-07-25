## findMin and findMax 

**Goal:**
Find the minimum/maximum node in a tree.

**Returns:**
Returns a reference to the node containing the smallest and largest elements in the tree, respectively. 

**Algorithm:**
To perform a findMin, start at the root and go left as long
as there is a left child. The stopping point is the smallest element. 

The findMax routine is the same, except that branching is to the right child.

This is so easy that many programmers do not bother using recursion. We will code the routines both ways by doing findMin recursively and findMax nonrecursively.

![[Pasted image 20230906102059.png]]

**Implementation:**
```Java
private BinaryNode<T> findMin(BinaryNode<T> n) {
	if(n == null) {
		return null;
	} else if(n.left == null) {
		return n;
	} return findMin(n.left);
	
}
```

```Java
private BinaryNode<T> findMax(BinaryNode<T> n) {
	if(n != null) {
		while(n.right != null) {
			n = n.right;
		}
	}
	return n;
}
```

Notice how we carefully handle the degenerate case of an empty tree. Although this is always important to do, it is especially crucial in recursive programs. 

Also notice that it is safe to change t in findMax, since we are only working with a copy of a reference. Always be extremely careful, however, because a statement such as t.right = t.right.right will make changes.

**Time Complexity:**
Worst case running time is O(N).

![[Pasted image 20230906100717.png]]

Average running time is O(logN) if tree is balanced.

**Space Complexity:**
Same as time complexity. At most, we will have n nodes on the stack, so O(N). Best case, we will have logN nodes on the stack, so O(log N). We must travel all the way left or right, so the number of nodes on the stack will be equal to the height of the leftmost or rightmost leaves. 