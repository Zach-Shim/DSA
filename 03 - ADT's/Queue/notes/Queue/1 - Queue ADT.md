Queues are known as FIFO (first in, first out) lists.
Like stacks, **queues** are lists.
- A **stack** is a list with the restriction that insertions and deletions can be performed at the **end of the list**, called the **top**.
- A **queue**, however, is a list where **insertion is done at one front**, whereas **deletion is performed at the end**.
## **Queue Model**

The two most basic operations on a queue are
- **`enqueue()`** - insert an element at the end of the list (rear)
- **`dequeue()`** - deletes (and returns) the element at the start of the list (front)

As with stacks, both an array and linked list implementation of a queue gives **O(1) runtimes for every operation**.

The following figure shows the abstract model of a queue.

![[Pasted image 20230817121855.png]]
## **Linked List Implementation of Queues**

##### **Queue** **Variables**
1. **`theArray`** – an internal array to hold objects
2. **`front`** – a pointer to the front of the queue
3. **`back`** – a pointer to the end of the queue
3. **`size`** – the number of elements in the queue
##### **Queue Operations**
| Operation | Runtime | Description |
| ---------- | --------- | --------- |
| `enqueue` | O(1) | Pushes an item onto the rear of the Queue. |
| `dequeue` | O(1) | Removes and returns the object from the front of the Queue. |
| `isEmpty` | O(1) | Tests if the Queue is empty. |
| `peek` | O(1) | Returns the object at the front of the Queue without removing it. |

## **Array Implementation of Queues**

##### **Queue** **Variables**
1. **`theArray`** – an internal array to hold objects
2. **`rear`** – a pointer to the end of the queue
3. **`size`** – the number of elements in the queue
##### **Queue Operations**
| Operation | Runtime | Description |
| ---------- | --------- | --------- |
| `enqueue` | O(1) | Pushes an item onto the rear of the Queue. |
| `dequeue` | O(N) | Removes and returns the object at the top of the Queue. |
| `isEmpty` | O(1) | Tests if the Queue is empty. |
| `peek` | O(1) | Returns the object at the top of the Queue without removing it. |
##### **Enqueue**
To enqueue an element x:
1. set theArray[rear] = x,
2. increment rear,
3. increment size,

```Java
// Basic idea only!
public void enqueue(Object x) {
	theArray[back] = x;
	rear++;
	size++;
}
```
##### **Dequeue**
To dequeue an element x:
1. save front value theArray[front] to temp variable,
2. shift all elements left one index,
3. decrement rear,
4. decrement size,
5. return theArray[front]

```Java
// Basic idea only!
public void dequeue() {
	Object x = theArray[front];
	for(int i = 0; i < rear; r++) {
		queue[i] = queue[i+1];
	}
	queue[rear] = null;
	rear--;
	size--;
	return x;
}
```

This dequeue operation seems unnecessarily costly.

What’s missing here?
What can be improved?
What is the runtime?
##### Problem
There is one potential problem with this implementation.

After 10 **enqueues**, the queue **_appears_** to be full, since **back** is now at the last array index, and the next **enqueue** would be in a nonexistent position (out of bounds index).

However, there might only be a few elements in the queue because several elements may have already been **dequeued**.

Therefore, **back** is at the end of the array (because there has been a total of 10 **enqueues**), yet the entire array is not filled (because there have been several **dequeues**).

We can’t simply increase the size of the array, because we would otherwise be wasting space, and continuing to create a bigger and bigger hole at the front of the array.

In addition, Queues, like Stacks, frequently stay small even in the presence of a lot of operations. We can take advantage of this fact.
## **Circular Array Implementation of Queues**

##### **Queue** **Variables**
1. **`theArray`** – an internal array to hold objects
2. **`front`** – a pointer to the front of the queue
3. **`back`** – a pointer to the end of the queue
3. **`size`** – the number of elements in the queue
##### **Queue Operations**
| Operation | Runtime | Description |
| ---------- | --------- | --------- |
| `enqueue` | O(1) | Pushes an item onto the rear of the Queue. |
| `dequeue` | O(1) | Removes and returns the object from the front of the Queue. |
| `isEmpty` | O(1) | Tests if the Queue is empty. |
| `peek` | O(1) | Returns the object at the front of the Queue without removing it. |
##### **Enqueue Improved**
What if **_queue_** is full?
To enqueue an element x:
1. check if queue is full,
2. set theArray[back] = x,
3. increment back,
4. increment size,
```Java
public void enqueue (T x) {
	if (size() == queue.length) { expandCapacity(); }
	theArray[back] = x;
	back = (back + 1) % theArray.length;      // allows wrapping
	size++;
}
```
##### **Dequeue Improved**
What if **_queue_** is empty?
To dequeue an element x:
1. check if queue is empty,
2. save front value theArray[front] to temp variable,
3. set old theArray[front] value to null
4. increment front,
5. decrement currentSize,
6. return theArray[front]

```Java
public void dequeue () throws EmptyCollectionException {
	if (isEmpty()) { throw new EmptyCollectionException("queue is empty"); }
	
	T x = theArray[front];
	theArray[front] = null;
	
	front = (front + 1) % theArray.length;      // allows wrapping
	count--;
	return x;
}
```
##### Mental Model
Our mental model of our Queue now looks a little different.
Here is how **theArray** would look after **7 enqueues** and **3 dequeues**:

![[Pasted image 20230817125631.png]]
##### Wraparound Solves our Problems
Whenever **front** or **back** gets to the end of the array, it is **wrapped around to the beginning**.

If incrementing either **back** or **front** causes it to go past the array, the value is reset to the **first position** in the array.

```Java
front = (front + 1) % theArray.length;

back = (back + 1) % theArray.length;
```

This is known as a **circular array** implementation.

The following figures show the queue during some operations.

![[Pasted image 20230817130602.png]]

![[Pasted image 20230817130607.png]]

##### **Checking Queue Size**
Some programmers use different ways of representing the **front** and **back** of a queue.

For instance, some do not use an entry to keep track of the **size**, because they rely on the base case that when the queue is empty, back = front-1.

This is a very tricky way to go, because there are some special cases.

If the **size** is not maintained as an explicit data field, then the queue is full when there are **theArray.length-1** elements, since only theArray.length different sizes can be differentiated, and one of these is 0.

Pick any style you like and make sure that all your routines are consistent. Since there are a few options for implementation, it is probably worth a comment or two in the code, if you don’t use the currentSize field.
## **Array vs. Linked List Implementation of Queues**

**Array:**
- May waste unneeded space or run out of space
- Space constants per element/object is small
- Operations are simple/fast

**Operations not in Queue ADT:**
- Constant-time O(1) “access to kth element”
- For operation “insertAtPosition” must shift all later elements

**List:**
- Always just enough space (we do not overestimate or waste unnecessary space or run out of space)
- Much higher space constant per element/object
- Operations are simple/fast

**Operations not in Queue ADT:**
- No constant-time “access to kth element”. O(i)
- For operation “insertAtPosition” must traverse all earlier elements