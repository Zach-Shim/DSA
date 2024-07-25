In Java, you can create a Min Heap and Max Heap using the PriorityQueue class. 

`PriorityQueue<E>` in Java is implemented as a priority heap, which is by **default a Min Heap** but can be modified to behave as a **Max Heap** by providing a **custom Comparator**.
## Min Heap

1. Use the default implementation:
```Java
PriorityQueue<E> heap = new PriorityQueue<>()
```
By default, a Java Priority Queue implements a Min Heap. 

2. Pass in Comparator
```Java
PriorityQueue<E> maxHeap = 
							new PriorityQueue<>(Comparator.naturalOrder());
```
The 'natural order' of elements only applies to certain types. integers and characters may have a natural order, but a user defined object like an 'Employee' may not have a natural order due to their many members and complexities.

3. Use a custom lambda Comparator
```Java
PriorityQueue<E> heap = new PriorityQueue<>((a, b) -> a - b)
```
This is best suited for simple comparisons.

4. Define Comparator in heap Constructor
```Java
PriorityQueue<E> minHeap = new PriorityQueue<>(
	new Comparator<E>() {
	    @Override
	    public int compare(E a, E b) {
	        return a - b;
	    }
	}
);
```
The lambda is essentially a shorter version of this, but this way is better if you have more complicated comparison logic (such as comparing multiple object members) you can create an **anonymous inner class** that implements the Comparator interface.

The `compare` method returns different values to indicate the order of elements in the priority queue:
1. A negative value (`a - b`) results in `a` coming before `b`. It's used for ascending order (e.g., Min Heap).
2. Zero indicates that `a` and `b` are considered equal.
3. A positive value (`b - a`) results in `a` coming after `b`. It's used for descending order (e.g., Max Heap).
## Max Heap
1. Pass in Comparator
```Java
PriorityQueue<Integer> maxHeap = 
							new PriorityQueue<>(Comparator.reverseOrder());
```

2. Use a custom lambda Comparator
```Java
PriorityQueue<E> heap = new PriorityQueue<>((a, b) -> b - a)
```

3. Define Comparator in heap Constructor
```Java
PriorityQueue<E> minHeap = new PriorityQueue<>(
	new Comparator<E>() {
	    @Override
	    public int compare(E a, E b) {
	        return b - a;
	    }
	}
);
```
The lambda is essentially a shorter version of this, but this way is better if you have more complicated comparison logic (such as comparing multiple object members) you can create an **anonymous inner class** that implements the Comparator interface.

The `compare` method returns different values to indicate the order of elements in the priority queue:
1. A negative value (`a - b`) results in `a` coming before `b`. It's used for ascending order (e.g., Min Heap).
2. Zero indicates that `a` and `b` are considered equal.
3. A positive value (`b - a`) results in `a` coming after `b`. It's used for descending order (e.g., Max Heap).