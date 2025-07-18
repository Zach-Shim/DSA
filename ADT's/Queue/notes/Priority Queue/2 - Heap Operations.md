## Strategy

For all heap operations, our strategy is outlined like the following:
1. Perform heap operation
2. Preserve **complete tree structure** property
3. This may break **heap order property**
4. Percolate up/down to restore **heap order property**

An important observation is that because a complete binary tree contains no gaps (other than the right side of the array), it can be represented in an array and no links are necessary.

![[Pasted image 20250715103622.png]]

**The only problem with this implementation is that an estimate of the maximum heap size is required in advance.**

However, this is typically not a problem because we can always resize the array if necessary.
## Heap Data Members

A heap data structure will consist of the following private data members:

1. An array (of **Comparable<>** objects) called **items**.
2. An integer representing the current heap **size**.
3. A constant variable representing the default capacity for the array **DEFAULT_CAPACITY**.
## Heap Insertion

**High-Level Heap Insertion Algorithm:**
1. Insert element _X_ into the heap at the last leaf position to preserve completeness.
2. While heap order is violated, percolate _X_ up by repeatedly exchanging key values with its parent until the heap order is restored.

**More-Detailed Heap Insertion Algorithm:**
1. To insert an element _X_ into the heap, we create a ‘**hole**’. 
	
	This 'hole' can be described like the following:
	2. The next available leaf position, characterized as the lowest and right-most position in the tree.
	3. This index is found at size + 1 in the items array (may require resizing). 
	
	We need to do this to maintain a complete tree.

2. If X can be placed in the hole without violating heap order (is X’s value smaller/larger than its parent's?), then we do so and are done.

3. Otherwise, we slide (swap) the element that is in the hole’s parent node into the hole, thus bubbling the hole up toward the root.

4. We continue this process until X can be placed (assigned) in the hole.

**Example 1: Insert 14**
Consider inserting a node with value 14 into the minheap pictured in Figure 6.6. 

We first create a 'hole' in the next available leaf position. We therefore satisfy the complete-tree property.

Inserting 14 in this hole, however, would violate the heap-order property.
We slide (swap) the hole's parent into the hole, thus bubbling the hole up toward the root.

![[Pasted image 20250715103833.png]]

We repeat the same percolation same steps with the hole's new parent.
Since 14 is less than 21, we swap the hole with its parent.

![[Pasted image 20250715103842.png]]

Since 14 is greater than 13, we no longer have to percolate the bubble up, since doing so would violate out minheap's order property.

We now have a valid minheap after inserting 14.
##### Percolating Up
This general strategy of repeatedly exchanging key values with a parent node until the heap order is restored is known as **percolating up**.
The new element is percolated up the heap until the correct location is found.
##### Insert Implementation
```Java
public void insert(T x) {
	
	// resize internal array if we go past capacity
	if(currentSize == array.length - 1) {
		enlargeArray(array.length * 2 + 1);
	}
	
	// Create hole (complete tree)
	int hole = ++currentSize;
	 
	// Percolate up
	for(array[0] = x; x.compareTo(array[hole / 2]); hole /= 2) {
		array[hole] = array[hole / 2];
	}
	
	// Restored heap-order
	array[hole] = x;
}
```

There are several optimization we make here:
1. Do not insert the new item until the end
    We could have implemented the percolation in the insert routine by performing repeated swaps until the correct order was established, but a swap requires three assignment statements.
    If an element is percolated up _d_ levels, the number of assignments performed by the swaps would be 3*d*. Our method uses _d_ + 1 assignments.
    If the element to be inserted is the new minimum, it will be pushed all the way to the top.
    If this is the case, then at some point, _hole_ will be 1 and we will want to break out of the loop.

2. **Initialize the value at position zero in the heap to the new item.**
    We could create an explicit test to test if we have reached the top of the array, or we can put a reference to the inserted item in position 0 in order to make the loop terminate.
    The loop will terminate when the item in position 0 is compared against itself, resulting in a loop terminating condition.
    We elect to place _x_ into position 0 in our implementation.
##### Time Complexity
The time to do the insertion could be as much as _O_(log _N_), if the element to be inserted is the new minimum and is percolated all the way to the root.

On average, the percolation terminates early.

It has been shown that 2.607 comparisons are required on average to perform an insert, so the average insert moves an element up 1.607 levels.
## **Heap Removal**

A heap removal operation **removes and returns the minimum element in the heap**.

**High-Level Heap Removal Algorithm:**
1. Save then delete the minimum (root) element from the heap.
2. Replace the now deleted root item with the last item _X_ (rightmost leaf).
3. If _X_ can be placed in the hole while maintain the tree’s heap-order, then we are done.
4. Else, percolate root element _X_ down by swapping with the smaller of its two children repeatedly until the heap order is restored.

**More-Detailed Heap Removal Algorithm:**
1. When the minimum is removed, a hole is created at the root.
2. In order to fill the hole, and to maintain completeness of the tree, we remove the last leaf in the tree. Since the heap now becomes one smaller, it follows that the last element _X_ in the heap must move somewhere in the heap.
3. If _X_ can be placed in the hole and not violate minheap-order, then we are done.
4. If it does, then we slide the smaller of the hole’s children into the hole, thus pushing the hole down one level. We repeat this step until _X_ can be placed in the hole.
5. Thus, our action is to place _X_ in its correct spot along a path from the root containing _minimum_ children.

**Example: A call to removeMin()**
1. Save and remove the minimum value 13 from the tree.
	After removing the minimum value, a hole is created at the root.

![[Pasted image 20250715105337.png]]

2. Since the heap now becomes one smaller, it follows that the last element _31_ in the heap must move to the hole.

3. The heap-order property is not maintained, since 31 is greater than both of its children.

4. Percolate the smaller of _X_’s children into the hole. Push the hole down one level.

![[Pasted image 20250715105341.png]]

5. We repeat this step until _X_ can be placed in the hole.

![[Pasted image 20250715105346.png]]

6. Return 13.
##### removeMin Implementation

```Java
public T deleteMin() 
{	
	// throw excpetion if heap is empty
	if(isEmpty()) {
		throw new UnderflowException();
	}
	
	// 1. Create hole at root
	T minItem = findMin();
	
	// 2. Remove last leaf from tree
	array[1] = array[currentSize--];
	
	// 3. Percolate down
	percolateDown(1);
	
}

private void percolateDown(int hole) 
{
	int child;
	AnyType tmp = array[hole];
	
	while(hole <= currentSize) {
		
		child = hole * 2;
		
		// see if right child is less than left child
		if(child != currentSize && array[child].compareTo(array[child+1]) < 0) {
			child++;
		}
		
		// swap hole with lesser child if it is less than child 
		if(array[child].compareTo[tmp] < 0) {
			array[hole] = array[child];
		} 
		else {
			break;
		}
		
		hole = child;
		
	}
	
	array[hole] = tmp;
	
}

```
##### Common Pitfall
A frequent implementation error in heaps occurs when there are an even number of elements in the heap, and the one node that has only one child is encountered.

>You must make sure **not to assume that there are always two children**, so this usually involves an extra test.

In the code depicted in Figure 6.12, we’ve done this test at line 29.

##### Time Complexity
The worst-case running time for this operation is _O_(log _N_).

On average, the element that is placed at the root is percolated almost to the bottom of the heap (which is the level it came from), so the average running time is _O_(log _N_).
