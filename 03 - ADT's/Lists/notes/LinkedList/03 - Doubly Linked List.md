What makes a doubly linked list different than a singly linked list is that each node contains data and two links (or pointers) to the next and previous nodes in the list. 

The head node is the node at the beginning of the list, and the tail node is the node at the end of the list. The head node’s previous pointer is set to `null` and the tail node’s next pointer is set to `null`.

If the head node’s previous pointer was set to the tail, and the tail node’s next pointer was set to the head, this would be a ***circular linked list***.
## **Class Design**

In considering the design, we will need to provide three classes:

1. **List Class**
    Contains references to the head and the tail.
    Contains the size of the list.
    Contains a host of other methods.

2. **Node Class**
    A private nested class of MyLinkedList.
    Contains the data and links to the previous and next nodes, along with appropriate constructors.

3. **Iterator Class**
    A private nested class of MyLinkedList.
    Implements the Iterator interface.
    Abstracts the notion of a position in the list by providing implementations of next(), hasNext(), and remove().

Making a singly linked list doubly linked gives us the luxury of **adding or removing an element from the end of a list in O(1) instead of O(N-1) time.**
## **Sentinel Nodes**

A sentinel node is a node we use to make special cases easier to deal with.
We usually use two sentinel nodes in a linked list:
1. the node at the front is the **header node**
2. the node at the end is the **tail node**

The advantage of using these extra nodes is that they greatly simplify the coding by removing a number of special cases for add and remove operations.

For instance, if we do not use a header node, then removing the first and last node from the list become special cases.
Without a head sentinel node, we would have to reset the list’s head pointer if we removed the first node. This also allows us to have a previous node for the first node in the list, making the removal easier. 
```Java
current.next = current.next.next;
current.next.prev = current;
```
## **Class Visualization**

Figure 3.22 shows a doubly linked list with header and tail nodes.
![[Pasted image 20230913113232.png]]

Figure 3.23 shows an empty list.
![[Pasted image 20230913113235.png]]
## **Node Class**

Instead of keeping the Node class as a separate class, the LinkedList class includes it as a **nested** class.
In this case, the individual node objects don’t need access to the outer (LinkedList) object, so it is best to declare the class to be a ***private static inner class***. 

Providing access to the outer class takes some extra storage and because we’re likely to construct thousands and perhaps even millions of node objects, we want to be more efficient about the space that they take up. Declaring the class to be static accomplishes that goal.

The Node class contains:
1. an item,
2. reference to previous Node
3. reference to next Node,
4. constructor(s)

```Java
private static class Node<E> {
	
	public E data;
	public Node<E> next;
	public Node<E> prev;
	
	public Node(E e) {
		this(e, null, null);
	}
	
	public Node(E e, Node<E> n, Node<E> p) {
		this.data = e;
		this.next = n;
		this.prev = p;
	}
}
```

In general public fields are a bad idea. But they’re not of great concern in this case. 
When we are writing code to interact with a client, we want everything to be completely encapsulated. But when we are writing code that is seen only by the data structure implementation, we can be more relaxed. 

Since the **Node** class itself is static and private, the visibility of its data members does not matter.
It doesn’t matter what access specifiers you give your static-nested class fields, because the class acts as a private static variable of the outer class. Classes outside of LinkedList cannot see the Node class at all.

In summary, we have two classes: one for individual nodes of a list and one for the list itself.
- The MyLinkedList methods can see all Node data members
- Classes outside of MyLinkedList cannot see the Node class at all
## **MyLinkedList Fields and Methods**

MyLinkedList contains four main class fields
1. **head**: a reference to the header node
2. **tail**: a reference to the tail node
3. **size**: the size of the list
4. **modCount**: an iterator variable called modCount to track changes in the list

modCount represents the number of changes to the linked list since construction. Each call to add or remove will update modCount. The idea is that when an iterator is created, it will store the modCount of the collection.

Each call to an iterator method (next or remove) will check the stored modCount in the iterator with the current modCount in the linked list and will throw a ConcurrentModificationException if these two counts don’t match.

The rest of the MyLinkedList class consists of
1. constructors,
2. the implementation of the iterator,
3. insert and remove methods
4. other useful methods (any of the methods are one-liners).
## Resources

Different Version of Doubly Linked Lists: [https://www.cct.lsu.edu/~sidhanti/tutorials/data_structures/page163.html](https://www.cct.lsu.edu/~sidhanti/tutorials/data_structures/page163.html)
[https://www.cs.dartmouth.edu/~scot/cs10/lectures/6/6.html](https://www.cs.dartmouth.edu/~scot/cs10/lectures/6/6.html)

Why Have Sentinel Nodes?
[https://stackoverflow.com/questions/5384358/how-does-a-sentinel-node-offer-benefits-over-null](https://stackoverflow.com/questions/5384358/how-does-a-sentinel-node-offer-benefits-over-null)
[https://stackoverflow.com/questions/61683371/sentinel-node-in-doubly-linked-list](https://stackoverflow.com/questions/61683371/sentinel-node-in-doubly-linked-list)
