## **Floyd's Cycle Detection Algorithm ('Hare-Tortoise')**

Cycle problems are common when dealing with linked lists.
We will most often use the two-pointer 'hare-tortoise' technique to solve them.

Floyd's Cycle Detection Algorithm is used to detect if a **cycle (loop)** *exists* in a linked list. 

We have two pointers:
1. Slow pointer - moves one step
2. Fast pointer - moves two steps

We have the following conditions:
1. If the fast pointer is null, there is no loop, end algorithm.
2. If slow pointer is equal to fast pointer, there is a loop, end algorithm.
3. Else, iterate pointers.

If the fast pointer reaches the end of the list, it will become null, meaning there is no link from the end of the list to somewhere earlier in the list, meaning there is no loop.

If the fast pointer reaches the slow pointer at some point, there is a loop in the linked list.

**Example:**
![[Pasted image 20231003110759.png]]

**Input:** head = [3,2,0,-4], pos = 1
**Output:** true
**Explanation:** There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

This linked list very clearly has a cycle because there is no node pointing to null, and we can see the last node loop back earlier into the list.

Here is the code:
```Java
ListNode slow = head, fast = head;
while(fast != null && fast.next != null) {
	slow = slow.next;
	fast = fast.next.next;
	if(slow == fast) return true;
}
return false;
```

The time complexity for this algorithm is O(N)
The space complexity for this algorithm is O(1)

## Where Cycle Begins

Where Floyd's Cycle Detection Algorithm is used to detect if a **cycle (loop)** *exists* in a linked list, it does not necessarily allow us to find ***where*** the cycle begins or ends.

We still use two pointers:
1. Slow pointer - moves one step
2. Fast pointer - moves two steps

Here is an overview of the algorithm:

**Step 1: Determine cycle exists**
1) while (fast->next == NULL || fast->next->next == NULL), there has no cycle.
	1) Use a slow pointer that moves forward 1 step each time
	2) Use a fast pointer that moves forward 2 steps each time
	3) If the slow pointer and fast pointer both point to the same location after several moving steps, there is a cycle.

![[Pasted image 20231003111652.png]]

**Step 2: Determine where cycle starts

1) **L1** is the distance between
	the head pointer
	and
	the start of the cycle

2) **L2** is the distance between
	the start of the cycle
	and
	the meeting point of the slow and fast pointers

3) **L3** is the distance between
	the meeting point of the slow and fast pointers
	and
	the start of the cycle

![[Pasted image 20231003112233.png]]

**According to the definition of L1, L2 and L3, we can obtain:**
1) Distance traveled by the slow pointer when the slow and fast pointers meet:

	**L1+L2**  

2) Distance traveled by the fast pointer when the slow and fast pointers meet:

	**L1+L2+L3+L2**

3) We can set these two equations equal to each other to find a relationship between L1 and L3.

	We know that the total distance traveled by the slow pointer is **L1+L2**
	We know the total distance traveled by the fast pointer is **L1+L2+L3+L2**
	
	Remember, that we had two pointers. 
	1. A slow pointer that moves one step. 
	    and 
	2. A fast pointer that moves two steps at a time. 
	
	This means that the fast pointer traveled twice the distance of the slow pointer.
	
	If we double the distance the slow pointer traveled, it should be equal to the total distance the fast pointer traveled. Therefore, we can say:
	
	**2(L1+L2) = L1+L2+L3+L2**
	
	Now, we can simplify:
	
	**2(L1)+2(L2) = L1+L2+L3+L2**      (take away the L2’s from each side)
	**2(L1) = L1+L3**                             (take away the L1’s from each side)
	**L1 = L3**
	
	We now know that L1 = L3:
		L1 = the distance between the head pointer and start of the cycle
		is **equal to**
		L3 = the distance between the slow and fast pointer meeting point and the start of the cycle

Example:

![[Pasted image 20231003221808 1.png]]

Fast Pointer Distance Traveled = **L1+L2+L3+L2**
Fast Pointer Distance Traveled = 6

![[Pasted image 20231003221830 1.png]]

Slow Pointer Distance Traveled = **L1+L2**
Slow Pointer Distance Traveled = 3

We can see that the distance traveled by the fast pointer is double the distance traveled by the slow pointer.

**Step 3: Keep Three Pointers**
We can define a pointer "entry" that point to the head of the linked list.

When the slow pointer and the fast pointer encounter in the cycle, this "entry" pointer and either the slow or fast pointer move one step at a time at the same time.

            entry = entry.next;
            slow = slow.next;

This works because we know that

the distance between the head pointer and start of the cycle

is **equal to**

the distance between the slow and fast pointer meeting point and the start of the cycle

Therefore, if we check for when the entry and slow pointer meet

            while(slow != entry)

Then we know that they will meet at the start of the cycle

**Code**
```Java
public ListNode detectCycle(ListNode head) {
	ListNode slow = head, fast = head;
	while(fast != null && fast.next != null) {
		slow = slow.next;
		fast = fast.next.next;
		if(slow == fast) {
			ListNode entry = head;
			while(slow != entry) {
				slow = slow.next;
				entry = entry.next;
			}
			return entry;
		}
	}
	return -1;
}
```


**Runtime**

This solution runs in O(N) time with O(1) space.