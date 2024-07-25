We can use the two-pointer technique to iterate over a linked list.
This allows us to solve a number of linked-list related problems.
1. Slow-Fast Pointer Traversal ("Tortoise and Hare")
2. Opposite End Pointer Traversal

## Slow-Fast Pointer Traversal

We have two pointers, `slow` and `fast` that take 1 step and 2 steps forwards, respectively.
	`slow = slow.next`
	`fast = fast.next.next`

The fast pointer will always reach the end of the list first, therefore we need a condition to check whether it has reached the end of the list.

This condition depends on whether the **list size is even or odd**.

1. Even List Size
	There are two possible middle nodes
	1. If you want the **left** of the two middle nodes, use the following condition to make the algorithm stop early:
	   `while(fast.next != null && fast.next.next != null)`
	2. If you want the **right** of the two middle nodes, use the following condition to make the algorithm stop later:
	   `while(fast != null && fast.next != null)`

2. Odd List Size
    You can use either condition used in the even list algorithm to get the middle node of an odd length list. The fast pointer will be at the last node either way:
    `while(fast.next != null && fast.next.next != null)`
    or
    `while(fast != null && fast.next != null)`

The time complexity for this algorithm is O(N)
The space complexity for this algorithm is O(1)