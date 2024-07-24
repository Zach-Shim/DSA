https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
## 1. Listen

**Problem Statement:**
You are given the **head** of a **singly linked-list**.

The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln

_Reorder the list to be on the following form:_
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

**Input:**
head of a singly **linked list**
L0 → L1 → … → Ln - 1 → Ln

**Goal:**
Reorder the list to be on the following form
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

**Return:**
head of reordered list
## 2. Example

**Example 1: Even Length List**
**Input:** head = [1,2,3,4]
**Output:** [1,4,2,3]

**Example 2: Odd Length List**
**Input:** head = [1,2,3,4]
**Output:** [1,4,2,3]
## 3. List Constraints

**Assumptions:**
- You may not modify Node values. 
-  Only Node next pointers may be changed. 

**Constraints:**
- 1 <= list.length <= 104 * 5
- 1 <= Node.val <= 1000

**Edge Cases:**
- Linked list length if 1
## 4. Brute Force

**Solution 1:**
Reverse list and then traverse list backwards. When we get to the nth node, remove it. 
	O(2N) time
	O(N) space if we are not allowed to manipulate input list, O(1) if we are

We are allowed to manipulate Node next pointers, so this solution works. 
However, can we reduce the time at all?

**Solution 2:**
Use hashmap to keep track of (index, ListNode). Iterate over list once and jump to n-1th node from the list. Remove the nth node.
	O(N) time
	O(N) space

While we save here on time, we use extra space.
We can't get better than O(N) time, but can we improve on space?
## 5. Optimizations

**Solution 3:**
Go forward N+1 nodes from head. This is the fast pointer. We have a slow pointer starting at the end. We iterate over the list until the fast pointer reaches null. The slow pointer is now at the n-1th node from the end of the list. Remove the nth node.
	O(N) time
	O(1) space

What happens when there is only 1 node in the list?
Turns out this algorithm does not work. Removing the head of the list is a special case.
Therefore, we must use a sentinel node and have the traversal pointers start from there.
## 6. Walkthrough

// dummy node
ListNode dummy = new ListNode(0)
slow = dummy, fast = dummy

// move fast n+1 nodes forward
iterate fast pointer (n+1) nodes forward

// iterate to n+1th node from end of list 
while fast is not equal to null
	iterate slow forward one node
	iterate fast forward one node

// remove the node
slow.next = slow.next.next;

// return
return dummy.nexy
## 7. Implement

```Java
public ListNode removeNthFromEnd(ListNode head, int n) {
	ListNode dummy = new ListNode(-1, head);
	ListNode slow = dummy, fast = dummy;
	
	while(n >= 0) {
		fast = fast.next;
		--n;
	}
	
	while(fast != null) {
		slow = slow.next;
		fast = fast.next;
	}
	
	slow.next = slow.next.next;
	
	return dummy.next;
}
```
## 8. Test




