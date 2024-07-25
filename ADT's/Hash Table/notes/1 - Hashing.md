**Hashing** is a technique for efficiently mapping data elements to array indices.
Hashing allows us to add, remove, or search for data elements in constant time O(1).

A **hash table** is a data structure used to implement Set and Map ADT's. 
A hash table is essentially a fixed-size array that uses hashing to map data items.
Imagine an array of **_N_** items—with each array slot capable of holding a single data item.

A **hash function** is used to perform **hashing**. 
**Hashing** is an algorithm that maps **values** -> **indexes**.

A **hash function** takes in a **search key** as input and uses **hashing** to output a **hash code** that **maps** to an **array index**.
Ideally, you want the hash function to map each **search key _x_** into a **unique integer _i_**.

![[Pasted image 20230907115607.png]]

A hash function where each search key maps to a unique array index is called a **perfect hash function**. Figure 5.1 is an example of a typical perfect situation (so far).

![[Pasted image 20230907115640.png]]
_john_ hashes to 3, _phil_ hashes to 4, _dave_ hashes to 6, _mary_ hashes to 7

Ideally, a hash function should
1. Be easy and fast to compute
2. Place items evenly throughout the hash table (and attempt to ensure that any two distinct keys get different cells)

If, when an element is inserted, it hashes to the same value as an already inserted element, then we have a **collision** and need to resolve it. There are **collision resolution** methods for dealing with this.

We will discuss two of the simplest:
**1.** **Separate Chaining**
	and
**2.** **Open Addressing**