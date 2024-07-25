## 1. Listen

**Problem Statement:**
You are given the heads of two sorted linked lists `list1` and `list2`.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

**Input:**
Pointer to head of `list1`
Pointer to head of `list2`

**Goal:**
Merge lists `list1` and `list2`.

**Return:**
Head of new linked list, that is the merged list of `list1` and `list2`
## 2. Example

**Example 1: Same length lists**

**Input:** list1 = [1,2,4], list2 = [1,3,4]
**Output:** [1,1,2,3,4,4]

**Example 2: List length differ by more than 1**
**Input:** list1 = [1,2,4,5,8], list2 = [1,3,4]
**Output:** [1,1,2,3,4,4,5,8]

**Example 3: Empty list or lists**
**Input:** list1 = [], list2 = []
**Output:** []
## 3. List Constraints

**Assumptions:**
- The space complexity of the return value does not count. 
- We do not need to do error checking that both input lists are sorted.
- A list can have repeated node values. Two lists can also also have repeated node values.

**Constraints:**
- Number of nodes in list1 and list2 range from [0, 50]
- -100 <= Node.val <= 100
- list1 and list2 are in non-decreasing order

**Edge Cases:**
- Empty list or lists
- Full list or lists
## 4. Brute Force

**Solution 1: Two-Pointer Approach**

We can take advantage of the fact that both lists are **sorted** by using the two-pointer technique.

We keep one pointer for each list. Whichever pointer's node has the lesser value, we add that to the output list. We iterate the respective pointers forward when we add it to the list.  

If the lists are equal in length, this algorithm works perfectly.
If the lists are not equal in length, we must iterate over the rest of the longer list and add those nodes onto the output list.

This algorithm takes O(max(N,M)) where N is the length of list1 and M is the length of list2.
## 5. Optimizations

**Solution 2: Assign next pointer of output list to rest of longer list**

Our solution could only use a slight optimization in the case that the two input lists are different lengths.
Instead of iterating over the rest of the longer list, we can simply assign the next pointer of the end of the output list to the rest of the longer list, thus changing our runtime to O(min(N,M)).
## 6. Walkthrough

head3 = new ListNode(dummy)
curr1 = head1, curr2 = head2, ouptut = head3
while(curr1 is not null and curr2 is not null)
	if curr1.val <= curr2.val
		output.next = curr1
		curr1 = curr1.next
	else
		output.next = curr2
		curr2 = curr2.next
	output = output.next

output.next = whichever curr is not null
return head3.next
## 7. Implement

```Java
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	
	ListNode list3 = new ListNode(-1, null);
	ListNode curr1 = list1, curr2 = list2, output = list3;
	
	while(curr1 != null && curr2 != null) {
		if(curr1.val <= curr2.val) {
			output.next = curr1;
			curr1 = curr1.next;
		} else {
			output.next = curr2;
			curr2 = curr2.next;
		}
		output = output.next;
	}
	
	output.next = (curr1 != null ? curr1 : curr2);
	return list3.next;
	
}
```
## 8. Test

1. 