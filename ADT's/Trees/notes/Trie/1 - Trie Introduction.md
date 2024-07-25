## Trie Definition

A **_Trie_** is a general tree, meaning that each node can have **_any number of children_**.
It is a type of **dictionary** made for storing "words'' (types made up of letters).

This is based on the tree data structure but does not necessarily store keys. Here, each node only has a value, which is defined based on the position.

So, the value of each node denotes the **prefix** of a word, because it is the point from the root node after a series of matches. We call such matches as **prefix matches**.

Tries are often called **prefix trees**.
## Trie Example

A **Trie** is a tree that stores a set of strings. 
Each string starts at the root, and each **edge** in the tree represents a single character.

![[Pasted image 20230919092529.png]]

This trie represents the dictionary: {adam, add, app, bad, bag, bags, beds, bee, cab}.

If we start from the root and traverse the tree in a dfs order, we read in letters until we hit a "true'' node. This traversal forms a word.
## Trie Node

A Trie Node has two main components:
1. Children: 
    A Trie is a type of general tree, meaning it can have a variable number of children. Therefore, unlike a binary tree where there are only two child pointers, we store the children of a node in an array.
    If we are storing words, then we know that there are only 26 letters in the alphabet. Therefore, we can make the children array size 26.
    If we needed to store other kinds of characters, we could just use a map.
2. Leaf Node Marker:
    Each node contains a boolean indicating whether the labels in the path from the root to that node form a word in the set. It is marked True if it is the end of a prefix.

```Java
private static class TrieNode<T> {
	
	char data;
	TrieNode* children[26];
	boolean isLeaf;
}
```

