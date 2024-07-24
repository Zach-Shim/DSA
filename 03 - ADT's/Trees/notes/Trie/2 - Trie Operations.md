## Trie Insertion

Let's say we store the word _candle_ in a Trie. It will look like this:

![[be88c949-f16a-4565-8fa2-cdb4de8ff7a9_1604920212.9642513.png]]

Words that share the same **prefix** (beginning of a word) will also share some Trie edges and nodes. 
For example, trie storing words _candle_ and _canary_ will look like this:

![[68ad008b-38fb-4e6a-b771-285131a36154_1604920399.3017237.png]]

We store both words _candle_ and _canary_, but save on the memory by sharing the common elements.

Let's say we add the word _can_ to the set. It will not require any additional edges or nodes, but now we will need to somehow know where the word in the trie ends. 

We can mark the end of a word in the trie with a boolean indicator each node will have. The nodes that have a True value here are blue. 

![[a5d337f7-707d-4c1b-a36f-f2a08a5b349d_1604920420.1003854.png]]

If we add a word that doesn't share any prefix with the words already in the trie, we will have a new branch from the root node. Here is the previous trie with the word _lion_ added:

![[c33460d9-8c0d-4e16-b5dc-f1a32fc2f15e_1604920448.662362.png]]

To insert a new word into the Trie, we start from the root and iterate over the characters of the new word while moving along the nodes and edges of the Trie. If the prefix of the word already exists, go to the next character, else create a new node and edge.

```Java
// Using a childrens array
public void insert(TrieNode root, String word) {
	TrieNode current = root;
	for(char c : word.toCharArray()) {
		if(current.children[c - 'a'] == null) {
			current.children[c - 'a'] = new TrieNode();
		}
		current = current.children[c - 'a'];
	}
	current.isLeaf = true;
}

// Using a childrens map
public void insert(TrieNode root, String word) {
	TrieNode current = root;
	for(char c : word.toCharArray()) {
		if(!current.children.containsKey(c)) {
			current.children.put(c, new TrieNode());
		}
		current = current.children.get(c);
	}
	current.isLeaf = true;
}
```

## Trie Search

Searching a trie is similar to insertion with the caveat that we are searching for a leaf node and do not create anything.

```Java
// Using a childrens array
public void search(TrieNode root, String word) {
	TrieNode current = root;
	for(char c : word.toCharArray()) {
		if(current.children[c - 'a'] == null) {
			return false;
		}
		current = current.children[c - 'a'];
	}
	return current.isLeaf;
}

// Using a childrens map
public void insert(TrieNode root, String word) {
	TrieNode current = root;
	for(char c : word.toCharArray()) {
		if(!current.children.containsKey(c)) {
			return false;
		}
		current = current.children.get(c);
	}
	return current.isLeaf;
}
```

