A Binary Tree is balanced if:
1. The difference in height between the root's left and right subtrees is not greater than 1.
2. Both the left and right subtrees are balanced binary trees.

**Top-Down Recursion**
We can check to see if a binary tree is balanced by using top-down recursion.
During each iteration, we check the height of the current node's left and right subtrees.

```Java
public bool isBalanced(TreeNode root) {
	if(root == null) {
		return true;
	}
	
	int leftHeight = depth(root.left);
	int rightHeight = depth(root.right);
	return  Math.abs((leftHeight - rightHeight) <= 1 && 
			isBalanced(root.left) && 
			isBalanced(root.right));
}

private int depth(TreeNode root) {
	if(root == null) {
		return 0;
	}
	
	return 1 + Math.max(root.left, root.right);
}
```

**Bottom-Up Recursion**
