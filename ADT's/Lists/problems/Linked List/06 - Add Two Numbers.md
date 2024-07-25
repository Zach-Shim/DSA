[https://leetcode.com/problems/add-two-numbers/](https://leetcode.com/problems/add-two-numbers/)
## 1. Listen

**Problem Statement:**
You are given two **non-empty** **linked lists** representing **two non-negative integers**.
The digits are stored in **reverse order**, and each of their nodes contains a **single digit**.
Add the two numbers and **return the sum** as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Input**:
**l1** is the head of a **linked list** representing a number
**l2** is the head of a **linked list** representing a number

**Goal**:
Add the two numbers in l1 and l2

**Return**:
return the **sum** of l1 and l2 as a singly linked list
## 2. Example

Example 1: Length of two lists are equal with no carry
![[Pasted image 20230913141908.png]]

Example 2: Length of two lists are equal with carry

Example 3: Length of two lists differ by 1 or more with no carry

Example 4: Length of two lists differ by 1 or more with carry
## 3. List Constraints

Assumptions:
- Assume list represents a number that does not have leading zeros (except for the number 0 itself).
- We cannot manipulate the input lists and need to create and return a new list.

Constraints:
- The number of nodes in each linked list is in range [1, 100]
- Digits are stored in reverse order in the list.
- Each node contains a single digit and cannot be negative (0-9 value). 0 <= Node.val <= 9
- Lists cannot be empty (head !- null).

Edge Cases:
- One or both lists have one node that has value 0.
- Length of two lists differ by a large amount.
## 4. Brute Force

Solution 1: O(O(2*(max(N, M)))) 
1. We start by creating a new list by declaring a list pointer, newList.
2. We initialize newList with the values from the larger of the two input list values max(list1, list2). 
3. We then iterate over smaller number while keeping a 'current place' pointer in the new list. Each time we iterate to the next node in the smaller number, we add the current digit to the corresponding newList digit, carrying extra values along the way.

If we say N is the length of list1 and M is the length of list2, it will result in a worst-case runtime of 
O(2*(max(N, M))), because we may have to iterate the entire larger list values if a bunch of carries percolate down the list once we are done adding the smaller number.

Something important to note is that the max carry value we can ever have is 1. Since the we go one digit place at a time, the highest output we can get is 9+9=18, meaning we keep 8 and carry 1 over to the next digit place. 
## 5. Optimizations

Solution 2: O(N, M)
We can improve on our brute force by iterating over both lists in one pass instead of iterating over them individually.
1. We start by creating a new list by declaring a list pointer, newList.
2. We add each digit in list1 and list2 together, outputting the result as a new node in newList.
3. Once we reach the end of one of the lists, if the other list still has nodes left (extra digits because it is a larger number), simply link the end of newList to the current list2 traversal pointer node.
4. If there is still a carry, we simply percolate as many carries over as we need to down the longer list. If we assume list2 is the longer list with length M, then this will potentially take M time to finish.

This allows us to solve this problem in O(N, M)).
## 6. Walkthrough

1. We start by creating a new list by declaring a list pointer, newList.
2. We keep position pointers to keep track of which digits we are currently adding and a carry flag.
3. While(ptr1 and ptr2 are not null)
	1. We add the current digit in list1 and list2 together, outputting the result as a new node in newList. If the carry flag is true, add 1 to this number.
	2. If there is a carry, set a flag to true for the next iteration. Else, set it to false.
4. if one of the lists still has nodes left (extra digits because it is a larger number)
		1. if there is no carry, simply link the end of newList to the current list2 position pointer.
		2. If there is still a carry, we must percolate as many carries over as we need to down the longer list. If we assume list2 is the longer list with length M, then this will potentially take M time to finish.
5. if there is a carry, create and add a new node with value 1 to the end of the list
## 7. Implement
```Java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	// dummy node for list creation
	ListNode l3 = new ListNode(0, null);
	
	// position pointers
	ListNode c1 = l1, c2 = l2, c3 = l3;
	
	// carry flag
	boolean carry = false;
	
	// iterate over lists
	while(c1 != null || c2 != null) {
		// add current digit
		int digit = (c1 != null ? c1.val : 0) + (c2 != null ? c2.val : 0); 
		
		// add carry if flag is set
		if(carry == true)
			++digit;
		
		// check if we need to carry
		if(digit >= 10) { 
			digit -= 10;
			carry = true;
		} else {
			carry = false;
		}
		
		c3.next = new ListNode(digit, null);
		
		// iterate list pointers
		c1 = (c1 != null ? c1.next : null);
		c2 = (c2 != null ? c2.next : null);
		c3 = c3.next;
	}
	
	// if there still still a final carry, create a new node of value 1
	c3.next = (carry == true ? new ListNode(1, null) : null);
	
	// return head (excluding dummy node)
	return l3.next;
}
```
## 8. Test

Test 1:
l1 = [2,4,3]
l2 = [5,6,4]
output = [7,0,8]

Test 2:
l1 = [0]
l2 = [0]
output = [0]

Test 3:
l1 = [9.9.9.9.9]
l2 = [9.9.9]
output = [8,8,8,0,0,1] 