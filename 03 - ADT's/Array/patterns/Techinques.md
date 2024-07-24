## Common Terms

**Subarray** - A range of contiguous values within an array.
    - Example: given an array `[2, 3, 6, 1, 5, 4]`, `[3, 6, 1]` is a subarray while `[3, 1, 5]` is not a subarray.

**Subsequence** - A sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.
    - Example: given an array `[2, 3, 6, 1, 5, 4]`, `[3, 1, 5]` is a subsequence but `[3, 5, 1]` is not a subsequence.

## Sliding window

The sliding window technique applies to many subarray/substring problems. 

In a sliding window, two pointers usually move in the same direction. 
These pointers surround a subarray, or a '**window**', and will never overtake each other.
If the pointers do overtake each other, this is usually a condition to end the algorithm. 
This ensures that each value is only visited at most twice and the time complexity is still O(n). 

Examples: 
[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/), 
[Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/), 
[Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)

---
## Two pointers

The two pointers technique is a more general version of sliding window where the pointers can cross each other and can be on different collections (like two different arrays). 

When you are given two arrays to process, it is common to have one pointer per array to traverse/compare the contents of both of them, incrementing one of the pointers when relevant. 

Examples: 
[Sort Colors](https://leetcode.com/problems/sort-colors/), 
[Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)
[Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)

---
## Traversing from the right (Reverse Order)

Sometimes you can traverse the array starting from the right instead of the conventional approach of from the left. 

Examples: 
[Daily Temperatures](https://leetcode.com/problems/daily-temperatures/), 
[Number of Visible People in a Queue](https://leetcode.com/problems/number-of-visible-people-in-a-queue/)

---
## Traversing the array more than once

This might be obvious, but traversing the array twice/thrice (as long as fewer than n times) is still O(n). 

Sometimes traversing the array more than once can help you solve the problem while keeping the time complexity to O(n).

```java
O(N)
for(...) {

}

O(2N)
for(...) {

}

O(3N)
for(...) {

}
```

---
## Sorting the array

Is the array sorted or partially sorted? 
If it is, some form of binary search should be possible.
This also usually means that the interviewer is looking for a solution that is faster than O(n).

**Can you sort the array?** 
Sometimes sorting the array first may significantly simplify the problem. 
Obviously this would not work if the order of array elements need to be preserved. 
Be warned, however, because sorting takes O(NlogN). Double check you cannot beat this runtime with another solution.

Examples: 
[Merge Intervals](https://leetcode.com/problems/merge-intervals/), 
[Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)

---
## Precomputation

For questions where summation or multiplication of a subarray is involved, pre-computation using hashing or a prefix/suffix sum/product might be useful. 

Examples: 
[Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/), 
[Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/), 
[LeetCode questions tagged "prefix-sum"](https://leetcode.com/tag/prefix-sum/)

---
## Index as a hash key

If you are given a sequence and the interviewer asks for O(1) space, it might be possible to use the array itself as a hash table. 

For example, if the array only has values from 1 to N, where N is the length of the array, negate the value at that index (minus one) to indicate presence of that number. 

Examples: 
[First Missing Positive](https://leetcode.com/problems/first-missing-positive/), 
[Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)

