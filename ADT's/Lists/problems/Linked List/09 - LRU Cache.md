## 1. Listen

**Problem Statement:**
Design a data structure that follows the constraints of a **[Least Recently Used (LRU) cache](https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU)**.

Implement the `LRUCache` class:
- `LRUCache(int capacity)` 
	- Input: `int capacity`
	- Goal: Initialize the LRU cache with **positive** size `capacity`.
	- Return: None
- `int get(int key)` 
	- Input: `int key`
	- Return: the value of the `key` if the key exists, otherwise return `-1`.
- `void put(int key, int value)` 
	- Input: `int key, int value`
	- Goal: Update the value of the `key` if the `key` exists. Otherwise, add the `key-value` pair to the cache. If the number of keys exceeds the `capacity` from this operation, **evict** the least recently used key.
	- Return: None

The functions `get` and `put` must each run in `O(1)` average time complexity.
## 2. Example

**Example 1:**

## 3. List Constraints

**Observations & Assumptions:**


**Constraints:**
- `1 <= capacity <= 3000`
- `0 <= key <= 104`
- `0 <= value <= 105`
- At most `2 * 105` calls will be made to `get` and `put`.

**Edge Cases:**
- Capacity is 1
## 4. Brute Force

**Solution 1:**

## 5. Optimizations

**Solution 2:**

## 6. Walkthrough


## 7. Implement

```Java

```
## 8. Test
