## Array vs. Linked List

**Arrays**
Because arrays are stored in one large contiguous block of memory, we can quickly locate any particular element of the array. This ability to quickly jump around in the array is called **random access**. 

There are two clear weaknesses with the array approach:
1. We can’t easily insert values in or remove values from the beginning or middle without shifting other values
2. We can’t easily enlarge the size of the structure without constructing a brand-new array with a larger capacity.

**Linked Lists**
The linked list structure has the opposite properties. 
It is not a random access structure, so it is not easy to jump around in the structure.

It has the kind of sequential access we associate with a cassette tape. If you are playing a tape and want to skip forward 10 songs, you have to fast forward through the songs. 
You can’t quickly skip to the position where you want to be on the tape. Linked lists have this property as well.

But where arrays are weak, linked lists are strong. 
1. We can quickly insert values in or delete values from the middle of a linked list without any shifting. 
2. It is also easy to make the list larger or smaller.
## Nodes

##### Node Definition
Linked lists are composed of individual elements called ***nodes***.

> [!Node]
> A single element of a structure such as a linked list; each node contains one data value.

A node is like a Lego building block. It looks unimpressive by itself, but once you
put a bunch of them together, it can form an interesting structure.

A basic list node looks like this:
![[Pasted image 20230913101011.png]]

##### Node Implementation
A Node is an object with two fields: 
1. one for storing a single item of data 
    and 
2. one for storing a reference to the next node in the list

To store a list of integer values we’d declare the node class as follows:
```Java
public class ListNode {
	public int data;
	public ListNode next;
}
```

This is a recursive data structure. 
The ListNode class is defined in terms of itself because it has a field of type ListNode. As a result, it is often possible to solve linked list programming problems more effectively by writing recursive methods.

___
## C++ Arrow vs. Java Dot Operator

##### C++ Arrow
Take the following code:

```Cpp
int main()
{
    struct Node {
        int val;
        Node* next;
    };
    struct Node head {1, nullptr};
    Node* p = &head;
}
```

In C++ `.` is the standard member access operator.  It has higher precedence than the `*` dereference operator.

Therefore, in order to access the member of an object/struct through a pointer, we must prioritize the dereferencing operation first by wrapping it in parentheses. 

Since we now have access to the actual object, we can use the dot operator to access individual members. 

```Cpp
    // Dereference first, then access member variable:
    std::cout << "ID:\t" << (*p).id << std::endl;
    std::cout << "ID:\t" << (*p).name << std::endl;
```

The arrow `->` operator essentially is a shorthand for using both the dereferencing and dot notation.

`(*ptr).member` is equal to `ptr->member`

```Cpp
	// Equivalent:
    std::cout << "ID:\t" << p->id << std::endl;
    std::cout << "Name:\t" << p->name << std::endl;
    return 0;
```

##### Java Dot
The Java Dot operator is essentially the same as the C++ arrow operator. 
References in Java are essentially the same as C++ pointers, and all dereferencing is done automatically.

Therefore, `ptr->member` in C++ is equivalent to `ptr.member` in Java.

___
## Constructing a List

Let’s construct a series of nodes that store the sequence of values [3, 7, 12]. 
There are three values meaning we need three nodes that are linked together.
##### **Head Pointer**
Keeping a Node pointer that points to the 'head' of a list allows us to traverse it.
This pointer is kept as a member variable in the LinkedList class, where Node is an inner class of LinkedList.

```Java
ListNode head;
```

The variable list is not itself a node. 
It’s a variable that is capable of referring to a node. 
You haven’t yet given it a value, so you would draw the following picture for
memory at this point in the program:

![[Pasted image 20230913102937.png]]

The “?” will be replaced with a reference to a node, which means that this box does
not have a data field or a next field. It’s a box where you can store a reference to such
an object. You don’t have an actual node yet. 
##### **Creating A Node**
We can construct a new node and tell Java that we want the head pointer to refer to it:

```Java
list = new ListNode();
```

Recall that when objects are constructed, Java initializes the fields to the zero-
equivalent for the type. 
- That's why the node's data field has the value 0
    and 
- the next field has the value null . 

Notice that we use a slash through the box to indicate a null value.

![[Pasted image 20230913102928.png]]

Let's now fill in our new node's data members.
- We will store 3 in its `data` field (list.data) 
    and 
- We will refer to a new node in its `next` field (list.next)

```Java
list.data = 3;
list.next = new ListNode();
```

The addition of these lines of code makes our linked list appear as follows:

![[Pasted image 20230913103146.png]]
##### **Creating A List of Nodes**
With arrays, we can use random access to index individual elements in a list.
How do we access the different elements in a linked list? 
We can accomplish this by following `next` references to the node we want to access.

The variable list stores a reference to the first node.
You can get inside that node with the dot notation ( list.data and list.next ). 

So list.next is the way to refer to the next box of the first node (the second node). 
You wrote code to assign it to refer to a new node, which is why list.next is pointing at this second node.

Let's now fill in our new node's data members:
- We will store 7 in its `data` field (list.data) 
    and 
- We will refer to a new third node in its `next` field (list.next)

```Java
list.data = 3;
list.next = new ListNode();
```

The addition of these lines of code makes our linked list appear as follows:

![[Pasted image 20230913103510.png]]

Let's now fill in our new node's data members:
- We will store 12 in its `data` field (list.data) 
    and 
- This is the last node we want in the list. Therefore, we want to set its `next` field to null (list.next)

![[Pasted image 20230913103706.png]]


