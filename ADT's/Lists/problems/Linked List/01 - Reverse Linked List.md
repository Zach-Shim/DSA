[https://leetcode.com/problems/reverse-linked-list/](https://leetcode.com/problems/reverse-linked-list/)
## 1. Listen

**Problem Statement:**
Given the **head** of a **singly linked list**, **reverse** the list, and return _the reversed list_.

**Input:**
Head of a **singly linked list**.

**Goal:**
**Reverse** singly linked list.

**Return:**
The **head** of the reverse list.
## 2. Example

**Example 1: Odd Length list [1,2,3,4,5]**
![[Pasted image 20230913152026.png]]

**Example 2: Even Length List [1,2,3,4]**
## 3. List Constraints

**Assumptions:**
- We can manipulate the input list.

**Constraints:**
- LinkedList length is range [0, 5000]
- -5000 <= Node.val <= 5000

**Edge Cases:**
- List of length 0
- List of length 5000
## 4. Brute Force

**Solution 1: O(N)**
Iterate over linked list using the inchworm approach. We have two pointers, current and previous, that point to the current and previous nodes were are currently iterating over. We change the current node's next pointer to point to the previous pointer's node. We then set previous to current, and then iterate current forward. 
## 5. Optimizations

No optimizations.
You could implement this iteratively to save on stack space.
You could implement this recursively to simplify code.
## 6. Walkthrough

1. Declare two pointers. ListNode current points to list head. ListNode previous points to null.
2. While current is not null
	1. set current.next equal to previous
	2. set previous equal to current
	3. current equals the next node
## 7. Implement

```Java
// Recursive:
public ListNode reverseList(ListNode head) {
	helper(head, null)
}

private ListNode helper(ListNode curr, ListNode prev) {
	if(head == null) 
		return head;
	
	ListNode temp = curr.next;
	curr.next = prev;
	prev = curr;
	curr = temp;
	
	helper(curr.next, curr);
}

// Iterative:
public ListNode reverseList(ListNode head) {
	ListNode curr = head, prev = null;
	while(curr != null) {
		ListNode temp = curr.next;
		curr.next = prev;
		prev = curr;
		curr = temp;
	}
	return head;
}
```
## 8. Test
