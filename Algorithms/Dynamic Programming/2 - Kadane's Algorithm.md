[Kadanes Algorithm Source](https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d)
## **Dynamic Programming**

Dynamic Programming is a method for solving a complex problem by
1. **Subproblems:** Breaking the problem down into a collection of simpler subproblems,
2. **Solve Once:** Solving each of those subproblems just once,
	and
3. **Store in Data Structure:** Storing their solutions using a memory-based data structure (array, map, etc.)

Each time we solve a subproblem, we cache its solution in a data structure.
So, the next time the same sub-problem occurs, instead of re-computing its solution, one simply looks up the previously computed solution, thereby saving computation time.

>_Dynamic Programming_ is just a fancy way to say 'remembering stuff to save time later
>
>*writes down "1+1+1+1+1+1+1+1 =" on a sheet of paper*  
>"What's that equal to?"  
>"one plus one plus one plus ..."
>*counting* "Eight!"   
>*writes down another "1+" on the left*  
>"What about that?"  
>*quickly* "Nine!"  
>"How'd you know it was nine so fast?"  
>"You just added one more"  
>"So you didn't need to recount because you remembered there were eight 1's! 

## Kadane's Algorithm

Kadane's algorithm is a greedy/dynamic programming algorithm that can be used on array problems to bring the time complexity down to O(n). 

It is used to calculate the maximum sum subarray ending at a particular position.

## **Maximum Subarray Problem**

The **maximum subarray problem** is the task of finding the largest possible sum of a **contiguous subarray**, within a given **one-dimensional array** of numbers.

Note that the description of a problem may provide useful hints.
- Contiguous subarray (adjacent elements in a linear data structure)
- One-dimensional array 
- Array data type is numbers

Given these constraints, Kanade’s Algorithm seems like a good solution.
Kanade’s Algorithm can be used on **arrays** that are:
1. One-dimensional
    and
2. Unsorted
… to find **contiguous subarrays** with some kind of **condition**

## **Example**

Find the contiguous subarray with the largest sum in the following integer array:

![[Pasted image 20231108124913.png]]

In this case, looking at the photo, we know that this contiguous subarray [4, -1, 2, 1] gives us the maximum possible sum, which is 6.

Let’s explore some of the possible ways to solve this algorithm.

#### **Brute Force Approach**

Let's solve this manually in a logical way.
Initially, you may go from left to right summing up all possible subsets using a nested loop. 
This brute force approach calculates the sum of every possible subarray and stores the max value.

Note that a single element is a subarray itself.

We can start from index **_0_** and calculate the sum of every possible subarray starting with the element **_A[0]_**
	Then, we would calculate the sum of every possible subarray starting with **_A[1]_**
	Then, we would calculate the sum of every possible subarray starting with **_A[2]_** 
	We could continue this up to **_A[n-1]_**, where **_n_** denotes the size of the array (n = 9 in our case).

Yellow = current index
Green = current subarray
![[Pasted image 20231108125232.png]]
… and so on for every i in the array.

As you may have noticed, the runtime for this algorithm compares each element against every other element starting at index i. This calculates the value of every possible subarray in the array.

The runtime complexity of this solution is **_O(n²)_**.

```java

int maxSum = Integer.MIN_VALUE;

for(int i = 0; i < nums.length; i++) {
	int currentSum = 0;	
	for(int j = i; j < nums.length; j++) {
		currentSum += nums[i];
		maxSum = Math.max(maxSum, currentSum);
	}
}
```

**We can clearly do better, but how?**

If you look at the example image above, you will see a lot of **repeated work**, where re-calculate subset sums even just for the first two indices.

We can save on runtime by **caching** information we already know for future calculations.

For example, how did you calculate the currentSum when going from index to index?
	You took the previous currentSum, then added the next index’s value onto it.
	We can cache this currentSum in index 0, so we dont have to recalculate it for index 1.

#### Optimized Solution

Let’s try the brute force approach again, but this time we start **backwards**.
	We start from the last element in the array **_A[n-1]_** and calculate the sum of every possible subarray going backwards.
	Then, we would calculate the sum of every possible subarray ending with **_A[n-2]_** then **_A[n-3]_** and so on up to **_A[0]_**.

  Yellow = current index
  Green = current subarray
![[Pasted image 20231108125729.png]]

**Algorithm**
We will call the maximum sum of subarrays starting with element **_A[i]_** the **_local_maximum_** at index **_i_**.
We iterate over every possible subarray in the array, comparing two subarrays to see which is greater at each iteration in the loop.

During each iteration, we find a **_local_maximum_** for the current two subarrays we are comparing and compare that to a **_global_maximum_**.
That way if there were earlier subarray with a greater maximum value, we would cache it in **global_maximum** while we explore the rest of the array using **local_maximum**.

**Example**
As an example, let’s focus on the subarrays ending with the element **_A[4]_** (=-1) and **_A[5]_**(=2) shown in the figure below.

![[Pasted image 20231108125938.png]]

From the figure, we see that the **_local_maximum[4]_** is equal to 3 which is the sum of the subarray [4, -1].

Now have a look at the subarrays ending with **_A[5]_**.
You’ll notice that these subarrays can be divided into two parts
1. the subarrays ending with **_A[4]_** (highlighted with yellow)
    and
2. the single element subarray **_A[5]_** (in green).

Let’s say somehow I know the **_local_maximum[4]_**.
Then we see that to calculate the **_local_maximum[5]_**, we don’t need to compute the sum of all subarrays ending with **_A[5]_** since we already know the result from arrays ending with **_A[4]_**.

Note that if array [4, -1] had the maximum sum, then we only need to check the arrays highlighted with the red arrows to calculate **_local_maximum[5]_**.

**Kadane’s Algorithm**
This leads us to the principle on which Kadane’s Algorithm works:

>_local_maximum at index i is the maximum sum subarray of all subarrays up to A[i] 

We will call the maximum sum of subarrays starting with element **_A[i]_** the **_local_maximum_** at index **_i_**.

Thus, after going through all the indices, we would be left with a _local_maximum_ for all the indices. Finally, we can find the maximum of these _local_maximum_s and we would get the final solution, _i.e_. the maximum sum possible. We would call this the _global_maximum_.

```java
public int kadanes(int[] nums) {
	
	int actualMaxSum = Integer.MIN_VALUE;
	int localMaxSum = 0;
	
	for(int i = 0; i < nums.length; i++) {
		
		localMaxSum = Math.max(localMaxSum+nums[i], nums[i]);
		actualMaxSum = Math.max(actualMaxSum, localMaxSum);
		
	}
	
	return actualMaxSum;
}
```

