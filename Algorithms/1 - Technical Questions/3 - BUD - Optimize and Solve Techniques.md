Once you have a brute force algorithm and are working through optimizing it, there are a number of techniques you can use.

## Technique 1: Look for BUD

BUD is an acronym for:
1. Bottlenecks
2. Unnecessary Work
3. Duplicated Work

These are three of the most common things that an algorithm can 'waste' time doing. 
You can walk through your brute force looking for these things. When you find one of them, you can then focus on getting rid of it.

If it's still not optimal, you can repeat this approach on your current best algorithm.

##### 1. Bottlenecks

A bottleneck is a part of your algorithm that slows down the overall runtime. There are two common ways this can occur:

1. **A Clog In The Pipeline:**
    You have one-time work that slows down your algorithm.
    For example, suppose you have a two-step algorithm where you first sort the array and then you find elements with a particular property. The first step is O(N log N) and the second step is O(N). 
    Perhaps you could reduce the second step to O(logN) or O(1), but would it matter? Not too much. 
    It's certainly not a priority, as the O(N log N) is the bottleneck. Until you optimize the first step, your overall algorithm will be O(N log N).

2. **Work goes through the pipeline repeatedly:**
    You have a chunk of work that's done repeatedly.
    For example, a searching algorithm that you could reduce from O(N) to O(logN) or even O(1). That will greatly improve your overall runtime.

**Example:** 
Given an array of distinct integer values, count the number of pairs of integers that have difference k. 

For example, given the array { 1, 7, 5, 9, 2, 12, 3} and the difference k = 2,there are four pairs with difference2: (1, 3), (3, 5), (5, 7), (7, 9).

A brute force algorithm is 
1. go through the array, starting from the first element
2. search through the remaining elements (which will form the other side of the pair)
3. for each pair, compute the difference
4. if the difference equals k, increment a counter of the difference

The bottleneck here is the repeated search for the "other side" of the pair. This takes O(N<sup>2</sup>) to calculate. 
It's therefore the main thing to focus on optimizing.

How can we more quickly find the right "other side"? Well, we actually know the other side of ( x, ? ). 
It's `x + k` or `x - k`. 

Therefore, we can slightly improve our algorithm to run in O(NlogN) time.
1. sort the input array
2. use binary search to find the other side for each of the N elements in O(logN) time by doing a binary search

We now have a two-step algorithm, where both steps take O(N log N) time. 
Now, sorting is the new bottleneck. Optimizing the second step won't help because the first step is the longer portion slowing us down anyway.

We just see if we can just get rid of the first step entirely and operate on an unsorted array to improve runtime. 
How can we find things quickly in an unsorted array? With a **`hash table`**.

Throw everything in the array into the hash table. Then, to look up if `x + k` or `x - k` exist in the array, we just look it up in the hash table. 

This is a classic time vs. space tradeoff. We can run this algorithm on an unsorted array in O(N) time by taking up to O(N) space using the hash table. 

##### 2. Unnecessary Work

We will often encounter problems where we come up with a valid solution, but one that may have a lot of unnecessary work that is done.

**Example:** 
Print all positive integer solutions to the equation a<sup>3</sup> + b<sup>3</sup> = c<sup>3</sup> + d<sup>3</sup> where a, b, c, and d are integers between 1 and 1000.

A brute force solution will just have four nested for loops. Something like:
```
n = 1000
for a from 1 to n
	for b from 1 to n
		for c from 1 to n
			for d from 1 to n
				if a3 + b3 == c3 + d3
					print a, b, c, d
```

This algorithm iterates through all possible values of a, b, c, and d and checks if that combination happens to work.

It's unnecessary to continue checking for other possible values of d. Only one could work. We should at least break after we find a valid solution.

```
n = 1000
for a from 1 to n
	for b from 1 to n
		for c from 1 to n
			for d from 1 to n
				if a3 + b3 == c3 + d3
					print a, b, c, d
					break // break once we find the single possible value
```

This won't make a meaningful change to the runtime-our algorithm is still O(N<sup>4</sup>)-but it's still a good,
quick fix to make.

Is there anything else that is unnecessary? Yes. 
If there's only one valid d value for each (a, b, c), then we can just compute it.
This is just simple math: 
![[Pasted image 20230925120404.png]]

n = 1 000
	for a from 1 to n
	for b from 1 to n
	for c from 1 to n
		d = pow(a3 + b3 - c3 , 1 / 3)   // Will round to int
		if a3 + b3 == c3 + d3              // Validate that the value works
			print a, b, c, d

The if statement on line 6 is important. 
Line 5 will always find a value for d, but we need to check that it's the right integer value.
This will reduce our runtime from O(N<sup>4</sup>) to O(N<sup>3</sup>).

##### 3. Duplicated Work

Using the same problem and brute force algorithm as above, let's look for duplicated work this time.

The algorithm operates by essentially iterating through all (a, b) pairs and then searching all (c, d)
pairs to find if there are any matches to that (a, b) pair.

Why do we keep on computing all (c, d) pairs for each (a, b) pair? 
We should just create the list of (c,d) pairs once.
Then, when we have an (a, b) pair, find the matches within the (c, d) list. 

We can quickly locate the matches by inserting each (c, d) pair into a hash table that maps from the sum to the pair (or, rather, the list of pairs that have that sum).

```
n = 1000
for c from 1 to n
	for d from 1 to n
		result = c3 + d3
		append (c, d) to list at value map[result]

for a from 1 to n
	for b from 1 to n
		result = a3 + b3
		list = map.get(result)
		for each pair in list
			print a, b, pair
```

Actually, once we have the map of all the (c, d) pairs, we can just use that directly. 
We don't need to generate the (a, b) pairs. Each (a, b) will already be in the map.

```
n = 1000
for c from 1 to n
	for d from 1 to n
		result = c3 + d3
		append (c, d) to list at value map[result]

for each result, list in map
	for each pairl in list
		for each pair2 in list
			print pairl, pair2
```

This will take our runtime to O(N<sup>2</sup>).

