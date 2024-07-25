## Height
The **height** of **_ni_** is the **_length_** of the **_longest path_** from **_ni_** to the **_furthest leaf node_**.
	***ni*** is any node in the tree

The **height of a tree** is equal to the **height of the root**.
	Height of **_T_** (tree) is equal to height of **_r_** (root).

The height of a tree would be
- the height of its root node 
    or equivalently,
- the depth of its deepest leaf

All **leaves** are at height 0.
## Depth
For any node **_ni_**, the **depth** of **_ni_** is the length of the **_unique path_** from the **root to _ni_**.
	***ni*** is any node in the tree

The depth of a tree is equal to the depth of the deepest leaf.
	Height of **_T_** (tree) is equal to height of **_r_** (root).

The **root is at depth 0**.

>The depth of a tree is equal to the height of the tree.

```Java
public int maxHeight(TreeNode root) {
	if(root == null) {
		return 0;
	}
	return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
}
```