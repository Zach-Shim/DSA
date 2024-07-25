[**https://leetcode.com/problems/reorder-list/**](https://leetcode.com/problems/reorder-list/)
## 1. Listen

**Problem Statement:**
You are given the **head** of a **singly linked-list**.

The list can be represented as:
L0 → L1 → … → Ln - 1 → Ln

_Reorder the list to be on the following form:_
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes references/links may be changed.

**Input:**
Head of a singly **linked list**
L0 → L1 → … → Ln - 1 → Ln

**Goal:**
**Reorder** the list to be on the following form
L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

**Return:**
Head of reordered list.
## 2. Example

**Example 1: Odd length list**
**Input:** head = [1,2,3,4]
**Output:** [1,4,2,3]

**Example 2: Even length list**
**Input:** head = [1,2,3,4,5]
**Output:** [1,5,2,4,3]
## 3. List Constraints

**Assumptions:**
- You may **not modify** the **values** in the list's nodes. Only the position (next pointers) may be changed.
- List cannot be null

**Constraints:**
- 1 <= List.length <= 5000
- 1 <= Node.val <= 1000

**Edge Cases:**
- List of length 1
- List of length 5000
## 4. Brute Force

**Solution 1: O(N)**
Step 1: go to middle of list
Step 2: reverse second half of list (one pointer to head and one pointer to reversed half head)
Step 3: build new list by doing a 'follow me' type of traversal, switching between the front and second half of the list.

O(N/2) + O(N/2) + O(N) = O(2N) = O(N)
## 5. Optimizations

No optimizations
## 6. Walkthrough

Step 1: Get pointer to middle of list
slow pointer and fast pointer
while fast pointer is not null
	iterate slow one forward
	iterate fast two forward

Step 2: Reverse second half of list
curr is equal to slow and prev is equal to null
while curr is not null
	temp next is curr.next
	curr.next is equal to prev
	prev is equal to curr
	curr = temp next

Step 3: 'Follow me' pointers
curr = head, next = prev
while curr is not null
	Listnode temp = curr.next
	curr.next = next
	curr = next
	next = temp

## 7. Implement

```Java
public void reorderList(ListNode head) {
	// Step 1: Iterate to middle of list
	ListNode slow = head, fast = head;
	while(fast.next != null && fast.next.next != null) {
		slow = slow.next;
		fast = fast.next.next;
	}
	
	// Step 2: Reverse second half of list
	ListNode curr = slow.next, prev = null;
	while(curr != null) {
		ListNode temp = curr.next;
		curr.next = prev;
		prev = curr;
		curr = temp;
	}
	
	slow.next = null;
	
	// Step 3: 'Follow me' pointers to build list
	ListNode current = head, next = prev;
	while(current != null) {
		ListNode temp = current.next;
		current.next = next;
		current = next;
		next = temp;
	}
}
```
## 8. Test
