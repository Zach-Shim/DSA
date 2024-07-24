## 1. Listen

**Problem Statement:**
You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return _the maximum profit you can achieve from this transaction_. If you cannot achieve any profit, return `0`.

**Input:**
array of integers `prices` 
`prices[i]` is the price of a given stock on the `ith` day

**Goal:**
**maximize** your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock

**Return:**
_the maximum profit you can achieve from this transaction_. 
If you cannot achieve any profit, return `0`.

## 2. Example

**Example 1:**
**Input:** prices = [7,1,5,3,6,4]
**Output:** 5
**Explanation:** Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

**Example 2:**
**Input:** prices = [7,6,4,3,1]
**Output:** 0
**Explanation:** In this case, no transactions are done and the max profit = 0.
## 3. List Constraints

**Observations & Assumptions:**
- We want to find the maximum subarray. Not a sum of all the elements within the subarray like maximum subarray, but two different endpoints.
- We should use Kadane's algorithm and a two-pointer technique approach.

**Constraints:**
- `1 <= prices.length <= 105`
- `0 <= prices[i] <= 104`

**Edge Cases:**
- if we cannot achieve any profit

## 4. Brute Force

**Solution 1: All subsets**
A brute force approach would be to calculate all possible subsets to find all possible stock price differences using a nested loop.

We can simply keep the maxProfit in a variable outside of the loop and update it when we find a new largest profit.

Time: O(N^2)
Space: O(1)

## 5. Optimizations

**Solution 2: Kadane's Algorithm**
For the sliding window:
We keep a left pointer that updates when we find a new lowest price.
We keep a right pointer that iterates over the rest of the array.
When array[right] < array[left], left = right

For result tracking:
Keep a variable named maxProfit that stores the difference between the right and left pointer array values (array[right] - array[left]). 

Time: O(N)
Space: O(1)
## 6. Walkthrough

**Input:** prices = [7,1,5,3,6,4]

currentSum = integer.min_value
maxSum = integer.min_value
left = 0
right = 1

currentSum = -6
maxSum = -6
left = 1
right = 1

currentSum = 4
maxSum = 4
left = 1
right = 2

currentSum = 2
maxSum = 4
left = 1
right = 3

currentSum = 5
maxSum = 5
left = 1
right = 4

currentSum = 3
maxSum = 5
left = 1
right = 5

return 5
## 7. Implement

```Java
public int maxProfit(int[] prices) {
	int maxProfit = Integer.MIN_VALUE;
	int currProfit = Integer.MIN_VALUE;
	int left, right = 0, 1;
	while right < prices.length 
	{
		currProfit = prices[right] - prices[left];
		maxProfit = Math.max(maxProfit, currProfit);
		if (prices[right] < prices[left]) left = right;
		right++;
	}
	return maxProfit != Integer.MIN_VALUE ? maxProfit : 0;
}
```
## 8. Test

```Python
def solution2(self, prices: List[int]) -> int:
	minPrice = sys.maxsize
	maxProfit = 0
	for price in prices:
		minPrice = min(minPrice, price)
		maxProfit = max(maxProfit, (price - minPrice))
	return maxProfit
```