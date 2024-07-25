## Array Description

Arrays hold values of the same type at contiguous memory locations. 
In an array, we're usually concerned about two things 
1. the position/index of an element 
2. the value of an element 

---
## **Constraints**

With array questions, there are often common constraints we need to find to clarify a question.

- What is the array length?
	- Empty sequence
	- Full sequence

- What kind of objects are in the array?
	- Are nulls allowed?
	- What is the range of values for objects stored in the array?
	- Are we allowed to have duplicate values? 

- What is the structure of the array?
	- Do we need to extract a subarray or subsequence?

- What operation/algorithm do we need to perform on the array?
	- Does the array need to be sorted, searched rotated?

---
## Array Edge Cases

Here are some examples of array edge cases:

Length Boundary
- Length <= 0
- Length >= array.length

Element Values
- array[i] == null
- array[i].val < maxVal
- array[i].val > minVal
