The **sliding window technique** is an algorithm that sequentially iterates over a contiguous sequence of elements.

It is based on the two-pointer technique, where we move a fixed or variable-size **window** over a data structure (e.g. array or string) to find contiguous subsets of elements based on conditions. 

We 'slide' (move pointers) a 'window' (contiguous subsequence) until we satisfy our problem statement.

A **contiguous sequence** consists of elements that occur one after another in a linear sequence of data.

A contiguous sequence can be:
1. One object
    or
2. Two or more adjacent objects

A **window** is a contiguous sequence which is a subset of a larger data structure.

The window slides (moves forward or expands/shrinks) over the collection to satisfy certain conditions.
Some operations are performed on elements within this window, and then the window is slid further down the collection.

Using this technique, we can convert a nested for loop which takes O(N<sup>2</sup>) time to a single loop.
## When Should We Use It?
We should use the sliding window technique on any collection that can be linearly iterated over.
Examples:
- Strings
- Arrays
- Linked Lists
- Trees
- Etc.

Algorithms that can be solved using the sliding window technique usually involve finding:
- Subarray with Minimum value
- Subarray with Maximum value
- Longest substring/subset
- Shortest substring/subset
- Contains value(s)

## Question Variants

1. Fixed-Length Window Size
    Find the ___ sum subarray of size k

   The general steps to solve these questions by following below steps:
	A) Find the size of the window required, say K.
	B) Compute the result for 1st window, i.e. include the first K elements of the data structure.
	C) Then use a loop to slide the window by 1 and keep computing the result window by window.

2. Fixed-Length Window with Auxiliary Data Structure

3. Dynamic-Length Window
    ```java
    // global variable you are tracking (i.e. max sum in ds)
	// local variable to track current window constraint (i.e. current max sum)
	
	// tracker variables for front and back of window
	for(int i = 0; i < arr.length; i++) {
	    // update local variable
	    while(local variable constraint does not meet problem constraint)
	        update window size by updating start
	}
	```

4. Dynamic-Length Window with Auxiliary Data Structure
	```java
	// global data structure you are tracking (i.e. max sum in ds)
	// local variable to track current window constraint (i.e. current max sum)
	
	// tracker variables for front and back of window
	for(int i = 0; i < arr.length; i++) {
	    // update local variable
	    while(local variable constraint does not meet problem constraint)
	        update window size by updating start
	}
	```

5. String Permutations
	1. Everything is grouped sequentially (substring, subarray, etc…)
	2. Longest/smallest/contains/maximum/minimum value/sub
	3. There are some criteria to build the window around

## Time Complexity

**Time Complexity**:
The sliding window technique takes O(n) time, where n is the size of the input data structure (e.g., array or string)
This is because you process each element once as the window slides through the data.

**Space Complexity:**
The sliding window technique takes O(1) space.
This is because you’re maintaining a fixed-size window and a few additional variables to perform calculations or store intermediate results. 
The amount of extra memory used doesn’t grow with the input size; it remains constant regardless of the input size.

## Advantages

1. **Efficiency:** The sliding window technique often reduces time complexity from a naive brute-force approach to linear or nearly linear, making it well-suited for processing large datasets.
2. **Optimization**: Related to efficiency. By maintaining a window of elements, the technique avoids redundant calculations and comparisons, leading to optimized computations.
3. **Constant Space Complexity**: The sliding window technique often requires only a constant amount of additional memory, making it memory-efficient.
