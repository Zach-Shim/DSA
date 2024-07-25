## List Operations

The following are a common set of operations we can perform on a List ADT.

| Operation | Description |
| --------- | ---------- |
| `add(E e)` | add an element at last position. |
| `add(int index, E e)` |add an element to the specified index. |
| `remove(int index)` | remove an element at the specified index. |
| `get(int index)` | returns the element at the specified index. |
| `set(int index)` | sets the element at the specified index. |
| `findKth(int kth)` | returns the element at the kth index. |
| `toString()` | returns a String representation of the List. |

The runtime of these operations depend on the data structure we use.

What data structure you use depends on what your goals are. Some data structures are more efficient in certain operations than others. There is always a tradeoff in runtime depending on which one you choose.

For example, will your program be performing a lot of get/set operations? An ArrayList would be more efficient than a LinkedList. LinkedLists are better suited for front/back list insertions/removals.
## ArrayList Implementation

| Operation | Best Runtime | Worst Runtime | Description |
| --------- | ------------ | ------------- | ----------- |
| `add(E e)` | O(1) | O(1) | add an element at last position. |
| `add(int index, E e)` | O(1) | O(N) | add an element to the specified index. |
| `remove(int index)` | O(1) | O(N) | remove an element at the specified index. |
| `get(int index)` | O(1) | O(1) | returns the element at the specified index. |
| `set(int index)` | O(1) | O(1) | sets the element at the specified index. |
| `findKth(int kth)` | O(1) | O(1) | returns the element at the kth index. |
| `toString()` | O(N) | O(N) | returns a String representation of the List. |

> In an ArrayList, the runtime of **add** and **remove** operations depend on **_where_** in the List they occur (front, middle, or back?).

| Operation | Where | Runtime | Case | Description |
| --------- | ----- | ------- | ---- | ----------- |
| `add` | front | O(N) | Worst Case | inserting into position 0 requires pushing the rest of the array right one spot to make room. |
| `add` | middle | O(N) | Average Case | on average, half of the list must be moved right. O(N/2) is still equal to O(N) if we drop the constants, so linear time is still required. |
| `add` | back | O(1) | Best Case | unless the array needs to be resized, adding to the back of an array requires no shifting, resulting in constant time. |
| `remove` | front | O(N) | Worst Case | deleting the first element requires shifting all the elements in the list left one spot. |
| `remove` | middle | O(N) | Average Case | on average, half of the list must be moved left. O(N/2) is still equal to O(N) if we drop the constants, so linear time is still required. |
| `remove` | back | O(1) | Best Case | removing the last element requires no shifting or resizing, resulting in constant time. |

> Since the underlying implementation of an ArrayList uses an actual array, **set** and **get** operations are extremely efficient, taking constant time to perform, no matter where in the list these operations occur.
##### **Tradeoffs**

**Advantages:**
1. **get** and **set** opertaions take constant time O(1).
2. **add** and **remove** are O(1) if you are only inserting/removing at the **end** of a list.

An array implementation is suitable if a list is built up by insertions at the high end and have rare deletions. They are also suitable if you only need to repetitively retrieve/set data in a List with stable data.

**Disadvantages:**
1. add and remove are O(N) if you are inserting/removing at the beginning or middle of a list because you must shift all succeeding values in the array down 1 index.

An array implementation is not suitable if insertions/deletions/gets/sets occur in the middle of the list, and in particular, at the front of the list.

## **Linked List Implementation**

Java's LinkedList is a doubly linked list implementation of the List ADT.

| Operation | Best Runtime | Worst Runtime | Description |
| --------- | ------------ | ------------- | ----------- |
| `add(E e)` | O(1) | O(1) | add an element at last position. |
| `add(int index, E e)` | O(1) | O(N) (special cases) | add an element to the specified index. |
| `remove(int index)` | O(1) | O(N) (special cases) | remove an element at the specified index. |
| `get(int index)` | O(1) | O(N) | returns the element at the specified index. |
| `set(int index)` | O(1) | O(N) | sets the element at the specified index. |
| `findKth(int kth)` | O(1) | O(k) | returns the element at the kth index. |
| `toString()` | O(N) | O(N) | returns a String representation of the List. |

A LinkedList implementation fixes a major runtime issue with ArrayLists.

>**add** and **remove** operations ***at the front of the list*** can now be done in constant time O(1) instead of **linear time** O(N). Inserting to the middle of the List will still be O(N) in the worst case.

In order to avoid the linear cost of insertion and deletion at the **head of a list**, we need to ensure that the list is not stored contiguously, since otherwise entire parts of the list will need to be moved.

A linked list solves this issue for use, because a linked list consists of a series of **nodes**, which are **_not necessarily adjacent in memory_**.

This, however, comes with the clear tradeoff of possibly inefficient **get** and **set** operations. Since elements are not stored contiguously, we cannot index a LinkedList like we can an array, since they could be anywhere in memory.

This illustrates why it is very important to know what the **goals** of your program are. There are clear tradeoffs depending on which data structure you choose.

| Operation | Where | Runtime | Case | Description |
| --------- | ----- | ------- | ---- | ----------- |
| `add` | front | O(1) | Best Case | inserting into the front of the list can be done in constant time with linking. |
| `add` | middle | O(N) | Worst Case | on average, we must traverse half of the list. O(N/2) is still equal to O(N) if we drop the constants, so linear time is still required. |
| `add` | back | O(1) | Best Case | inserting into the back of the list can be done in constant time with linking. |
| `remove` | front | O(1) | Best Case | removing the first element of the list can be done in constant time by unlinking the first item. |
| `remove` | middle | O(N) | Worst Case | on average, we must traverse half of the list. O(N/2) is still equal to O(N) if we drop the constants, so linear time is still required. |
| `remove` | back | O(1) | Best Case | removing the first element of the list can be done in constant time by unlinking the first item. |
##### Remove End Item
Removing the last item is in a List is slightly tricky. 

We need to have access to the next-to-last item, change its _next_ link to null, and then update the link that maintains the last node.

In the classic linked list, where each node stores a link to its next node, having a link to the last node provides no information about the next-to-last node.

This would result in an O(n-1) runtime every time we deleted an item from the end of the list.

![[Pasted image 20230912105246.png]]

**Solution:**
The obvious idea of maintaining a third link to the next-to-last node doesn’t work, because it too would need to be updated during a remove.

Instead, we have every node maintain a link to its previous node in the list, while also maintain links to both ends of the list.

This is shown in Figure 3.4 (above) and is known as a **doubly linked list.**
##### Tradeoffs

**Add or Remove Item To Front or End**
The special cases of adding/removing a node to/from the front/end of a list is a constant-time operation, presuming we have some way to access the front and end of the list. 

>Thus, a typical linked list **keeps links to both ends of the list (a head and tail pointer)**.

In principle, if we know where a change is to be made, inserting or removing an item into a linked list does not require moving lots of items and instead involves only a **constant** number of changes to node links.

**Advantages:**
1. **add** and **remove** remove operations take constant time if done at the ends of a list. 
2. **get** and **set** operations take constant time if done at the ends of the list. 

Again, this means that these operations are **constant-time** operations **only if** we maintain **links to the front and back of the list** (head and tail pointers) in a doubly linked list.

Java’s LinkedList class takes advantage of this fact by providing the following methods to efficiently add, remove, and access the items at both ends of the list:
- addFirst(E e) and addLast(E e)
- removeFirst() and removeLast()
- getFirst() and getLast()

Therefore, if you have an application that frequently accesses the head and tail of a collection, and accesses the middle portions less frequently, use a linked list.

**Disadvantages:**
1. **add** and **remove** operations take O(N) time if performed in the middle of a list.
2. **get** and **set** operations take O(N) time if performed in the middle of a list.

The runtimes are access to the middle of a list are linear because a LinkedList is **not easily indexable** **like an array**, and traversal must be done from either the beginning or end of the list.
##### Using an Iterator

If we are looping for a List, we can actually reduce the runtime for get and set operations using an enhanced for loop. Enhanced for loops implicitly call a class's Iterator implementation, which will make the running time _O_(_N_) for any List, because the iterator will efficiently advance from one item to the next.
## **ArrayList vs. LinkedList Runtime Examples**

##### 1. Add Items To End

```Java
public static void makeListEnd(List<Integer> list, int n) {
	list.clear();
	for(int i = 0; i < n; i++) {
		list.add(i);
	}
}
```

Regardless of whether an ArrayList or LinkedList is passed as a parameter, the running time of makeListEnd is _O_(_N_). We run through all N items in the list which takes _O_(_N_) runtime.

Each call to add() appends items to the end of the list, which takes _O_(_1_) constant time (the occasional expansion of the ArrayList is amortized, so it is safe to ignore). We do this for N items.
##### 2. Add Items To End

```Java
public static void makeListFront(List<Integer> list, int n) {
	list.clear();
	for(int i = 0; i < n; i++) {
		list.add(0, i);
	}
} 
```

We run through all N items in the list which takes _O_(_N_) runtime.
Each call to add(int index, E e) adds a value to the front of the list.

For a LinkedList, this only required moving pointers, which takes _O_(_1_) constant time.
For an ArrayList, adding at the front requires to move all other elements down an index, which is an _O_(_N_) operation.

LinkedList runtime = O(N)
ArrayList runtime = O(N<sup>2</sup>)

##### 3. Get Item

```Java
public static int sum(List<Integer> list) {
	int total = 0;
	for(int i = 0; i < n; i++) {
		total += list.get(i);
	}
	return total;
}
```

We run through all N items in the list which takes _O_(_N_) runtime. Each call to get(int index) queries for a value at each index in the list.

For a LinkedList, because in a LinkedList, calls to get are _O_(_N_) operations because a they are not easily indexable.
For an ArrayList, the underlying data structure is an array, which is easily indexable in _O_(_1_) constant time.

LinkedList runtime = O(N<sup>2</sup>)
ArrayList runtime = O(N)

**If we wanted to reduce the runtime for a LinkedList from _O_(_N<sup>2</sup>_) to _O_(_N_) runtime, we could instead use an enhanced for loop, which will make the running time _O_(_N_) for any List, because the iterator will efficiently advance from one item to the next.**

Both ArrayList and LinkedList are inefficient for searches, so calls to the Collection contains(AnyType E) method and remove(AnyType E) methods (that take an AnyType as parameter) take linear time O(N).