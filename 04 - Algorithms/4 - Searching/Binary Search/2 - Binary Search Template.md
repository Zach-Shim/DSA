## Binary Search Template

Binary Search helps us reduce the search time from linear O(n) to logarithmic O(log n). 

Some of the most common problems include:
1. Problem Space:
    How to initialize the boundary variable `start` and `end`?

2. When to exit the loop? 
    Should we use `left < right` or `left <= right` as the while loop condition?

3. Update Problem Space:
    How to update the boundary? 
    How do we correctly choose the appropriate combination from: 
	- `start = mid` , 
	- `start = mid + 1` 
	    and 
	- `end = mid`, 
	- `end = mid - 1`

Suppose we have a search space. It could be an array, a range, etc. It's sorted in a **monotonic** manner. 

For most tasks, we can generalize this task into the following algorithm:

```java
private boolean condition(int value) {
	// do something	
}

public int binarySearch(int[] nums) {
	int front, back = 0, nums.length-1;
	while(front < back) {
		int mid = front + ((back - front) / 2);
		if(condition(mid)) {
			back = mid;
		} else {
			start = mid+1;
		}
	}
	return start;
}
```

For most binary search problems, we only need to modify three parts after copy-pasting this template, and never need to worry about corner cases and bugs in code any more:
- Correctly initialize the boundary variables `front` and `back`. 
    Only one rule: set up the boundary to **include all possible elements**;
- Decide return value. 
    Is it `return front` or `return front - 1`? 
    Remember this: **after exiting the while loop, `front` is the minimal k​ satisfying the `condition` function**;
- Design the `condition` function. 
    This is the most difficult and most beautiful part. Needs lots of practice.

## Updating The Problem Space

Determining what condition we choose for halving the problem space is the most difficult part to writing a binary search algorithm.

Traditionally, we search a sequence container. This is usually a contiguous monotonic sequence such as a sorted array. 

However, our problem space is not restricted to this. We can also search values that are not in the given sequence.

A great example of this is Koko loves to eat bananas. 

There are `N` piles of bananas, the `i`-th pile has `piles[i]` bananas. The guards have gone and will come back in `H` hours. Koko can decide her bananas-per-hour eating speed of `K`. Each hour, she chooses some pile of bananas, and eats K bananas from that pile. If the pile has less than `K` bananas, she eats all of them instead, and won't eat any more bananas during this hour.

Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back. **Return the minimum integer `K` such that she can eat all the bananas within `H` hours**.

**Example :**

```java
Input: piles = [3,6,7,11], H = 8
Output: 4
```

```java
Input: piles = [30,11,23,4,20], H = 5
Output: 30
```

```java
Input: piles = [30,11,23,4,20], H = 6
Output: 23
```


The lower bound of the search space is 1, and upper bound is `max(piles)`, because Koko can only choose one pile of bananas to eat every hour. 

Our mid would usually be an index in a data structure (like an array). However, our mid in this case would be the mid value between the low and max pile in the array. 

In the third example, our first mid calculation would be the value 15 instead of index 3.