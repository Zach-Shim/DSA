## 1. Listen

**Problem Statement:**
Given an array of integers `nums` containing `n + 1` integers where each integer is in the range `[1, n]` inclusive.

There is only **one repeated number** in `nums`, return _this repeated number_.

You must solve the problem **without** modifying the array `nums` and uses only constant extra space.

**Input:**
Array of integers `nums`

**Goal:**
Find the single repeated number in `nums` 

**Return:**
The repeated number in `nums`
## 2. Example

**Example 1:**
**Input:** nums = [1,3,4,2,2]
**Output:** 2

**Example 2:**
**Input:** nums = [3,1,3,4,2]
**Output:** 3

## 3. List Constraints

**Assumptions & Observations:**
- There will always be one set of duplicate numbers.
- The input array is not sorted (possible solution is to sort).
- The value each index in the array can have ranges from [1,nums.length-1]. Notice there will not be a zero value. We can use each value to actually follow an array index since the biggest possible value is one smaller than the length of the array.

**Constraints:**
- 1 <= n <= 10^5
- nums.length == n+1
- 1 <= nums[i] <= n

**Edge Cases:**

## 4. Brute Force

**Solution 1: Double Loop**
Here we test the current index against every other index.
This is a nested loop and results in N<sup>2</sup> and does not require extra space.
Time: O(N<sup>2</sup>)
Space: O(1)

**Solution 2: Sort**
Here we first sort the array and then check neighboring elements against each other to find the duplicated array. 
This takes O(NlogN) time to sort and O(N) to iterate over the array. This also takes O(logN) space to sort.
Time: O(NlogN)
Space: O(logN)

**Solution 3: Binary Search**
Here for each element in the array we use binary search to find its duplicate number. 
This takes O(N) time to iterate over the array and O(logN) for binary search (nested). There can be up to O(logN) stack space for binary search.
Time: O(NlogN)
Space: O(logN) if recursive, O(1) if iterative

**Solution 4: Boolean Array**
Since we know that all values in the array will never be greater than nums.length, we can make a boolean array with size nums.length and index a boolean array to search for the duplicate number.
if duplicate[nums[i]] == true then we found the duplicate
else duplicate[[nums[i]] = true
Time: O(N)
Space: O(N)

**Solution 5: HashSet**
This is similar to the boolean array solution, except we just store found numbers in a HashSet. 
if the value already exists in the set, we found the duplicate
else add the value to the set
Time: O(N)
Space: O(N)
## 5. Optimizations

**Solution 6: Linked List Cycle**
We can use the same algorithm that we use to find a linked list cycle to find the duplicate number. 
Given the constraints:
1. There is exactly one pair of duplicate numbers.
2. The value each index in the array can have ranges from [1,nums.length-1]. 
We can assume that there is guaranteed to always be a cycle.

So there are two steps to this algorithm.
1. Step one: find if there is a

## 6. Walkthrough


## 7. Implement

```Java

```
## 8. Test
