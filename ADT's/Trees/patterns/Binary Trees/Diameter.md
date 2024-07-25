## **Width**
The diameter (or width) of a tree is the number of **_nodes_** on the **longest path between any two leaf nodes**.

Note that this path **does not have to pass through the root**.
## **Example**
![[Pasted image 20230901105336.png]]

Height of tree = 3
Width of tree = 6

```Java
public int diameterOfBinaryTree(TreeNode root) {
	int[] maxDiameter = new int[1];
	helper(root, maxDiameter);
	return maxDiameter[0];
}

private int helper(TreeNode root, int[] maxDiameter) {
	if(root == null) {
		return 0;
	}
	
	int leftHeight = helper(root.left, maxDiameter);
	int rightHeight = helper(root.right, maxDiameter);
	maxDiameter[0] = Math.max(maxDiameter[0], leftHeight + rightHeight);
	
	return 1 + Math.max(leftHeight, rightHeight);
}
```