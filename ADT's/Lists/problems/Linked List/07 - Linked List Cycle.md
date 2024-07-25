## 1. Listen

**Problem Statement:**
Given `head`, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. 

Internally, `pos` is used to denote the index of the node that tail's `next` pointer is connected to. **Note that `pos` is not passed as a parameter**.

**Input:**
`head`, the head of a linked list.

**Goal:**
Determine if there is a **cycle** in the linked list.

**Return:**
Return `true` _if there is a cycle in the linked list_. Otherwise, return `false`.
## 2. Example

**Example 1: Cycle**
**Input:** head = [3,2,0,-4], pos = 1
**Output:** true
**Explanation:** There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

**Example 2: No Cycle**
**Input:** head = [1], pos = -1
**Output:** false
**Explanation:** There is no cycle in the linked list.
## 3. List Constraints

**Assumptions:**
- The cycle always starts at the tail of the list.

**Constraints:**
- Number of nodes in the list range from 0 <= list.length <= 10^4
- -10^5 <= Node.val <= 10^5
- pos is -1 or a valid index in the linekd-list

**Edge Cases:**
- List is empty
- List has one node
## 4. Brute Force

**Solution 1: Tortoise-Hare Algorithm**
We can use a two-pointer approach to determine if there is a cycle.
We have a slow pointer and a fast pointer. We iterate the slow forward one and fast forward two. We do this while they are not equal to each other.
## 5. Optimizations

**Solution 2: No possible optimizations**
## 6. Walkthrough

**Solution 1: Tortoise-Hare Algorithm**
ListNode slow = head and fast = head
while fast is not null and fast.next is not null
	slow = slow.next
	fast = fast.next.next
	if slow is equal to fast
		return true
return false

## 7. Implement

```Java
public boolean hasCycle(ListNode head) {
	ListNode slow = head, fast = head;
	while(fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;
		if(slow == fast) {
			return true;
		}
	}
	return false;
}
```
## 8. Test
