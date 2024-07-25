## Monotonic Stack Definition

A **monotonic stack** has two parts to the definition:
1. **Stack:** A data structure where we can push or pop elements.
2. **Monotonic:** A function that entirely increases or decreases.

Sometimes we store the index of the elements in the stack and make sure the elements corresponding to those indexes in the stack forms a mono-sequence.

An **increasing monotonic stack** is a stack where all elements are **nondecreasing**. 
Example: [9,8,7,6,5,4,3,2,1]

If we wanted to add a number to the stack, we would pop all smaller elements than the number we are trying to insert in order to hold the monotonic stack property.
Example: insert 4
[9,8,7,6,5,4,4]

A **decreasing monotonic stack** is a stack where all elements are **nonincreasing**. 
Example: [1,2,3,4,5,6,7,8,9]

If we wanted to add a number to the stack, we would pop all larger elements than the number we are trying to insert in order to hold the monotonic stack property.
Example: insert 7
[1,2,3,4,5,6,7,7]
## Next Greater Element

The **next greater element** of some element `x` in an array is the **first greater** element that is **to the right** of `x` in the same array.

Suppose we have a decreasing sequence followed by a greater number  
Example: `[5, 4, 3, 2, 1, 6]` 

Then the greater number `6` is the next greater element for all previous numbers in the sequence, because those previous numbers make up a decreasing monotonic stack.
	1. If the next element in the subsequence `y` is **less than** the current top of the stack (`stack.peek()`), then the monotonic property holds, and we continue to look for the next largest/smallest sequence by pushing to the stack.
	2. If the next element in the subsequence `y` is **greater than** the current top of the stack (`stack.peek()`), we have broken the monotonic property, and need to pop all numbers from the stack that are less than the current number. 


We use a stack to keep a **decreasing** sub-sequence, whenever we see a number `x` greater than `stack.peek()` we pop all elements less than `x`.
For all the popped elements, their next greater element is `x`, because `x` broke out monotonic property.

For example `[9, 8, 7, 3, 2, 1, 6]`  
The stack will first contain `[9, 8, 7, 3, 2, 1]` and then we see `6` which is greater than `1` so we pop `1 2 3` whose next greater element should be `6`.

## Next Greater Element Circular Array

Each element needs to know about every other element in the array. An obvious approach is to use a nested loop which is O(N<sup>2</sup>) in time.

