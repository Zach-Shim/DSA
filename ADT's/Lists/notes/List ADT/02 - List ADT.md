## Abstract Data Type (ADT) vs. Data Structure (DS)

An **Abstract Data Type (ADT)** is a high level interface of data and operations that you can perform on that data. An ADT defines the logical form of a type and is language agnostic.

A **Data Structure (DS)** is a concrete implementation of an ADT. You can implement an ADT with different types of data structures.

A data structure is a container which uses either contiguous- or node-based structures (or both) to store objects (in _member variables_ or _instance variables_) and is associated with functions (_member functions_ or _methods_) which allow manipulation of the stored objects.

Objects (or _data_) may be stored in a data structure using either
- Contiguous-based structures
    or
- Node-based structures
of which the array and the linked list are prototypical examples.
## List ADT

**Abstract Data Type:**
A ***List*** is an ADT representing an ordered sequence of elements. 
- Elements can be added to the front, back, or any index in the list. 
- Elements can be removed from the front, back, or any index 
- Each element is accessible by a zero-based index. 

**Data Structure:**
A List is usually implemented using one of the following two solutions:
1. **ArrayList**: A dynamically-resizing array 
2. **LinkedList**: A dynamically-allocated linear collection of nodes
## Sequence Container

A list is a sequence container. This means that
1. the **position** (index) of an element 
	depends on 
2. the **order** **(time and place)** of insertion.

We will deal with a general list of the form A<sub>0</sub>, A<sub>1</sub>, A<sub>2</sub>, A<sub>n-1</sub>
The first element of the list is A<sub>0</sub>, and the last element is A<sub>n</sub>−1.
The **position** of an intermediary element A<sub>i</sub> in a list is _i_.

For any list except the empty list, we say that
- A<sub>i</sub> follows (or succeeds) A<sub>i</sub>−1 (_i_ < _N_)
    and
- A<sub>i</sub>−1 precedes **A<sub>i</sub> (_i_ > 0)

We will not define the following, because they are out of range:
- the predecessor of A<sub>0</sub>
    or
- the successor of A<sub>n</sub>−1.
## List Implementation

An **ADT** **List** is formed by
1. Data: The items in a list
2. Operations: The operations that you can perform on the items

Common to any implementation is the a `size` variable that we maintain. 
- We say that the size of this list is _N_.
- We will call a list of size 0 an **empty list**.

Since a List is a type of `Collection`, we must implement it's `Iterator`.
