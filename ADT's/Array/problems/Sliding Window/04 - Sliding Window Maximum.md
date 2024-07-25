
## 1. Listen

**Problem Statement:**
You are given an array of integers `nums`, there is a sliding window of size `k` which is moving from the very left of the array to the very right. You can only see the `k` numbers in the window. Each time the sliding window moves right by one position.

Return _the max sliding window_.

**Input:**
`nums`: array of integers 
`k`: size of sliding window (left to right)

**Goal:**
each time we move the window forward by 1 position forward in the array ds, find the maximum value in that window.
for each window we look at, store it in an aux data structure.

**Return:**
Return _the max sliding window_ (data structure with max values in each subarray).

## 2. Example

**Example 1:**
**Input:** nums = [1,3,-1,-3,5,3,6,7], k = 3
**Output:** [3,3,5,5,6,7]
**Explanation:** 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       **3**
 1 [3  -1  -3] 5  3  6  7       **3**
 1  3 [-1  -3  5] 3  6  7      ** 5**
 1  3  -1 [-3  5  3] 6  7       **5**
 1  3  -1  -3 [5  3  6] 7       **6**
 1  3  -1  -3  5 [3  6  7]      **7**
 
**Example 2:**
**Input:** nums = [1], k = 1
**Output:** [1]

## 3. List Constraints

**Observations & Assumptions:**
It may be useful to keep an aux data structure to keep track of the order of the largest to smallest values in each subarray.
Certain subarrays may share the same max value.

**Constraints:**
- `1 <= nums.length <= 105`
- `-104 <= nums[i] <= 104`
- `1 <= k <= nums.length`

**Edge Cases:**

## 4. Brute Force

**Solution 1:**
Simply iterate over each value in the array, while also iterating the window forward (n - k + 1) times.

Each time we move the window forward, iterate over the window of length k and store the max value in pos i in a data structure that keeps track of each window's max value.

Time: O(Nk)
Space: O(1)

While this works for most situations, it does not scale well. 
```Python
def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
	res = []
	
	left, right = 0, 0
	while(right < k):
		right += 1
	
	curr, count = 0, len(nums)-k+1
	while(curr < count):
		maxVal = -sys.maxsize-1
		subarr = nums[left:right]
		for num in subarr:
			maxVal = max(maxVal, num)
			res.append(maxVal)
			left += 1
			right += 1
			curr += 1
	return res
```

## 5. Optimizations

**Solution 2:**
To speed up the runtime, we can opt to use more space.

We can keep an auxillary data structure to keep track of the current maximum value in the current window.

Lets use a linkedlist (deque) since we will be peforming a lot of add/remove operations from the ends of the list. 

The main question is, how do we keep the elements of the deque in sorted order without actually sorting it every time we want to insert a new value? In other words, we want to avoid a nested O(N) insertion that sorts the deque and keep it O(1).

During each iteration, we can check for three things:
1. Check if the index at the front of the nums array is outside of the window. If so, we remove it from the deque. 
   
   The reason we use indexes rather than actual values is because if we only kept values in the deque, there would be no way to know if the value's index at the front of the deque were outside of the window.
   
   This way, older max window values get filtered out.
   
2. While the current index's value in nums is greater than the values at the end of the deque, pop the end of the deque. 
   So, for example, let's say you had the following values in the deque: [5, -1, -7]
   Then we want to insert -3 into the deque.
   Then this would pop -7 then -1, and the deque would now look like: [5, 3]
   Now we can place the current index's value in the deque and repeat this process on the next iteration.
   
   This filters out all of the lower values in the window.
   
3. If our window has reached a length equal to k (when first starting the algorithm, k will not be reached until we have made k iterations in the for loop) store the current maximum value in the result data structure.
   
   

Time: O(N)
Space: O(k)
## 6. Walkthrough


## 7. Implement

```Java

```
## 8. Test

```Python

```