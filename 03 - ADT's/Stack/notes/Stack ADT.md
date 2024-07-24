## **Stack Model**

Like a list, stacks are an sequence of values with a particular ordering.
Specifically, stacks are known as LIFO (last in, first out) lists.

A **stack** is a list with the restriction that insertions and deletions can be performed in only one position, namely, the end of the list, called the **top**.
## **Stack Operations**

A minimal set of operations for a Stack would require:
1. push: add new values in the structure
2. pop: remove values from the structure
3. isEmpty: check if the structure is empty
4. peek: check what is at the top of the stack

| Operation | Runtime | Description |
| ---------- | --------- | --------- |
| `push` | O(1) | inserts a new item to the end of the list. |
| `pop` | O(1) | deletes the most recently inserted item from the end of the list. |
| `isEmpty` | O(1) | tests if the Stack is empty. |
| `peek` | O(1) | returns but does not delete the most recently inserted element. |

All of these operations are performed in O(1) constant-time.

A pop or top on an empty stack is generally considered an error in the stack ADT.
Running out of space when performing a push is an implementation limit and not an ADT error.
## **Implementation of Stacks**

Since a stack is a list, any list implementation will do. Since ArrayList and LinkedList support stack operations they are usually the most reasonable choice.

Because stack operations are **constant-time operations** using different implementations is unlikely to yield any discernable improvement except under very unique circumstances.
## **Linked List Implementation of Stacks**

The first implementation of a stack uses a singly linked list.
1. We perform a `push()` by inserting at the front of the list.
2. We perform a `pop()` by deleting the element at the front of the list.
3. We perform a `peek()` operation by examining and returning the value at the front of the list.
## **Array Implementation of Stacks**

An alternative implementation avoids links and is probably the more popular solution.
Mimicking the ArrayList add operation, we associate the an array and top index for each stack:
- `theArray`: an internal array that will hold the objects for the Stack ADT
- `topOfStack`: the index of the current top element, which is −1 for an empty stack (this is how an empty stack is initialized).

1. To **`push()`** some element `x` onto the stack, we increment `topOfStack` and then set `theArray[topOfStack] = x`.
2. **`pop()`**, we set the return value to `theArray[topOfStack]` and then decrement `topOfStack`.
3. **`peek()`**, we simply return `theArray[topOfStack]` and do not need to touch `topOfStack`.

Notice that these operations are performed in not only **constant time**, but very fast constant time.
The fact that most modern machines have stack operations as part of the instruction set enforces the idea that the stack is probably the most fundamental data structure in computer science, after the array.