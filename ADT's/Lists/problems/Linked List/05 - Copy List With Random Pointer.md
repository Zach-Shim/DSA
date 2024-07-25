## 1. Listen

**Problem Statement:**
A **linked list** of **length n** is given such that each node contains an **additional random pointer**, which could **point to any node in the list, or null**.

Construct a **deep copy** of the list.

The deep copy should consist of exactly **n** **brand new** nodes, where each new node has its value set to the **value** of its **corresponding original node**.

Both the **next and random pointer** of the new nodes should point to **new nodes** in the copied list such that the pointers in the original list and copied list represent the same list state. 

**None of the pointers in the new list should point to nodes in the original list**.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return _the head of the copied linked list_.

The linked list is represented in the input/output as a list of n nodes.

Your input is an array of arrays of length 2. Each inner array represents a node with the following values:
1. val: an integer representing Node.val
2. random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node

Your code will **only** be given the head of the original linked list.

**Input**:
**head** of original singly **linked list** with extra random pointer

**Goal**:
Deep copy the **original linked list** with all new nodes

**Return**:
**head** of the deep copied linked list

## 2. Example

**Example 1: Sufficiently large example with null random pointer and regular random pointers**
**Input:** head = `[[7,null],[13,0],[11,4],[10,2],[1,0]]`
**Output:** `[[7,null],[13,0],[11,4],[10,2],[1,0]]`

**Example 2: Random pointer to self node**
**Input:** `[[1,1], [2,1]]`
**Output:** `[[1,1], [2,1]]` 

Example 3: Empty List
**Input:** `[]`
**Output:** `[]`
## 3. List Constraints

**Assumptions:**
- A node can have a random pointer that points to itself

**Constraints:**
- 0 <= list.length <= 1000
- -10^4 <= node.val <= 10^4
- Node.random is either null or pointing to some node in the linked list

**Edge Cases:**
- There are loops in the list
- There are null random pointers
- null (list is empty)
## 4. Brute Force

**Solution 1: Iterate Over Map and Store Nodes in HashMap**

We have to think about everything a random pointer can point to:
- null
- its own node
- another node

At first thought, a DFS approach may seem plausible, but for a brute force, it would be easiest if we iterate over the list and store a copy of all nodes in a hash map. We store their index in the key and the node in the value. For now, we store the real/actual version of the node in the pointer positions.

We then iterate over all of the nodes in the hash map and update their random/next pointers to the copies in the hash map instead of the original nodes.

Now that the list is built, we can simply return the head of the list (by returning the first index in the map).

We iterate over the list twice, meaning this will take O(2N) time to complete, where N is the list length.
Without counting the return problem space, this will take O(N) extra space when we use the map.

TIME: O(2N)
SPACE: O(N)
## 5. Optimizations

**Solution 2: DFS**
We can make this algorithm simpler using a DFS algoirhtm to iterate over the linked list.
We assign the next and random pointer for each node during each iteration.

This will take O(N) time and O(N) space.

**Solution 3: DNA Replication**
Can we solve this problem in O(1) space? Turns out we actually can.
We take three passes over the linked list. 
1. The first pass, we duplicate each node. We make this duplicated node the 'next' node for the original node.
2. The second pass, we assign the random pointers of the duplicated nodes. We can do this by following the original's random pointer and assigning the duplicated random pointer to the original's random.next.
3. The third pass, we build the duplicated linked list by reassigning the next pointers.

## 6. Walkthrough

**Solution 1: HashMap**
initialize HashMap
for every node in the linked list
	put node in the HashMap (key = original node, value = new duplicate node(value, null, null))

for every node in the HashMap
	duplicate.next = HashMap.get(node.next).next
	duplicate.random = HashMap.get(node.random).random

return HashMap.get(head)

**Solution 2: DFS**
if next is null
	return

ListNode copy = new ListNode(copy of original)
copy.next = DFS(original.next)
copy.random = DFS(original.random)

return copy

**Solution 3: DNA**
ListNode current = head
while current is not null
	current.next = new ListNode(copy of current, null, null)
	current = current.next.next

current = head
while current is not null
	current.next.random = current.random.next

newHead = head.next
current = newHead
while current is not null
	current.next = current.next.next
	current = current.next.next

return newHead

## 7. Implement

Solution 1: HashMap
```Java
public Node copyRandomList(Node head) {
	
	HashMap<Node, Node> map = new HashMap<>();
	
	Node curr = head;
	while(curr != null) {
		map.put(curr, new Node(curr.val));
		curr = curr.next;
	}
	
	curr = head;
	while(curr != null) {
		Node copy = map.get(curr);
		copy.next = map.get(curr.next);
		copy.random = map.get(curr.random);
		curr = curr.next;
	}
	
	return map.get(head);
}
```

Solution 2: DFS
```Java
public Node copyRandomList(Node head) {
	HashMap<Node, Node> map = new HashMap<>();
	return helper(head, map);
}

private Node helper(Node curr, HashMap<Node, Node> map) {
	if(curr == null) {
		return null;
	}
	
	if(map.containsKey(curr)) {
		return map.get(curr);
	}
	
	Node copy = new Node(curr.val);
	map.put(curr, copy);
	copy.next = helper(curr.next, map);
	copy.random = helper(curr.random, map);
	
	return copy;
}
```

Solution 3: DNA
```Java
public Node copyRandomList(Node head) {
	Node curr = head;
	while(curr != null) {
		Node temp = curr.next;
		curr.next = new Node(curr.val);
		curr.next.next = temp;
		curr = curr.next.next;
	}
	
	curr = head;
	while(curr != null) {
		if(curr.random != null) {
			curr.next.random = curr.random.next;
		}
		curr = curr.next.next;
	}
	
	Node newHead = new Node(0);
	Node original = head, copy = newHead;
	while(original != null) {
		Node temp = original.next.next;
		copy.next = original.next;
		
		original.next = temp;
		original = temp;
		copy = copy.next;	
	}
	
	return newHead.next;
}
```
## 8. Test
