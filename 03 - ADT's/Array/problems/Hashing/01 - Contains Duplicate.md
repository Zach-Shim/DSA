## 1. Listen

**Problem Statement:**
Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.

**Input:**
Integer array `nums`

**Goal:**
Determine if there is at least one pair of duplicate numbers (any value that appears at least twice) in the array

**Return:**
return `true` if any value appears **at least twice** in the array
return `false` if every element is distinct
## 2. Example

**Example 1: True with one duplicate**
**Input:** nums = [1,2,3,1]
**Output:** true

**Example 2: False with no duplicates**
**Input:** nums = [1,2,3,4]
**Output:** false

**Example 3: True with multiple duplicates**
**Input:** nums = [1,1,1,3,3,4,3,2,4,2]
**Output:** true
## 3. List Constraints

**Observations & Assumptions:**
- `nums` is unsorted
- There can be more than one duplicate
- A value is a duplicate if it has >= 2 appearances

**Constraints:**
- 1 <= nums.length <= 10^6
- -10^9 <= nums[i] <= 10^9

**Edge Cases:**
- `nums` length 1
## 4. Brute Force

**Solution 1: Check Element Against Every Other Element**
We can use a nested loop to check the current element we are viewing against every other element in the array.

Time: O(N<sup>2</sup>)
Space: O(1)

**Solution 2: Sort**
Sort the array and then iterate over the array checking neighboring elements for equality.
Sorting takes O(NlogN) time and O(N) space. Iterating over the array takes O(N) time.

Time: O(NlogN)
Space: O(N)

**Solution 3: Binary Search**
For every element in the array, we use binary search to see if we can find its duplicate.

Time: O(NlogN)
Space: O(N)

**Solution 4: HashSet**
We can use an auxiliary Data Structure (Extra Space) to store numbers we have already iterated over.
Each iteration checks the HashSet to see if the current element we are viewing has been checked before.
O(N) time to iterate over array. HashSet takes O(N) space.

Time: O(N)
Space: O(N)
## 5. Optimizations

Best possible time complexity is O(N) and best possible space complexity is O(N).

1. O(N) time complexity is possible: 
    You can achieve O(N) time complexity by iterating through the array once and using a data structure like a HashSet or a sorting algorithm to store previously seen items. 
    A HashSet can help you quickly determine if there are duplicates in the array in O(1) time for each element, and you can do this for all elements in the array, resulting in O(N) time complexity. 
    
2. O(1) space complexity is not possible: 
    Achieving O(1) space complexity for this problem is not possible because you need to store information about the elements you have seen to check for duplicates. 
    If you try to use a constant amount of memory (O(1) space), you would lose information about the elements you have encountered, and you wouldn't be able to determine if there are duplicates.

## 6. Walkthrough

HashSet set
for every element in `nums`:
	if !set.contains(element):
		set.add(element)
	else:
		return true
return false
## 7. Implement

```Java
public boolean containsDuplicate(int[] nums) {
	return solution3(nums);
}

// O(N^2) time
// O(1) space
public boolean solution1(int[] nums) {
	for(int i = 0; i < nums.length; i++) {
		for(int j = i+1; j < nums.length; j++) {
			if(nums[i] == nums[j]) {
				return true;
			}
		}
	}
	return false;
}

// O(NLOGN) time
// O(LOGN) space
public boolean solution2(int[] nums) {
	Arrays.sort(nums);
	for(int i = 0; i < nums.length-1; i++) {
		if(nums[i] == nums[i+1]) {
			return true;
		}
	}
	return false;
}

// O(N) time
// O(N) space
public boolean solution3(int[] nums) {
	HashSet<Integer> duplicates = new HashSet<>(nums.length);
	for(int i = 0; i < nums.length; i++) {
		if(duplicates.contains(nums[i])) return true;
		else duplicates.add(nums[i]);
	}
	return

```
## 8. Test
