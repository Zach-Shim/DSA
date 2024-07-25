## **Physical Linking**

Let’s consider a real-life example of linking:
Pretend you have a container. Inside this container is a random item with a label that says “item” on it.
Now imagine this container has a chain connecting it to another container that also has an item in it.
And imagine that container is connected to another container, and so on in a uniform line.

Indeed, this example is similar to how a train works.
A train has a head, which is connected to several containers, each of which are holding something, and are connected. Notice how the last container connects to nothing.

![[Pasted image 20230912161929.png]]

Let’s consider how these containers can be seen in code.
## **Programmatically Linking**

**Node Abstraction**
Each container is called a **node**.

Each node contains two pieces of information.
1. **A data item.**
2. **A pointer to another node.**

Since each node needs to contain multiple pieces of information, **each node is an object**.
Each node is linked either linked to
1. **nothing (nullptr)**
	or
2. **to another node**

Here, the data portion of a node contains a string. It can be any data type (primitive or user defined).

We use arrows to represent the pointers. Each pointer in a node should point to another node (not the data type held within a node).

Pointers can point to any data type except files, so this is an important distinction that a nodes pointer should point to another node.

Here is a typical Node implementation (for a linked list):
```Java
public class Node<E> {
	E item;
	Node next;
	
	public Node() {
		this(0, null)
	}
	
	public Node(E e) {
		this(e, null);
	}
	
	public Node(E e, Node n) {
		item = e;
		next = n;
	}
	
};
```

An implementation for a doubly linked list would simply add a reference to the previous node in the list:
```Java
public class Node<E> {
	E item;
	Node next;
	Node prev;
	
	public Node() {
		this(0, null, null)
	}
	
	public Node(E e) {
		this(e, null, null);
	}
	
	public Node(E e, Node n, Node p) {
		item = e;
		next = n;
		prev = p;
	}
	
};
```

Here is an example of declaring a Node of type Integer:
```Java
Node<Integer> n = new Node<Integer>(12);
