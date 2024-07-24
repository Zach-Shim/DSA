## **add(E e)**

##### Overview
Once you’ve constructed an ArrayList, you can add values to it by calling its add(E e) method.
When you ask an ArrayList to add a new value to the list, **it appends the new value to the end of the list**.

Unlike with a simple array, an ArrayList can be thought of as having a **dynamic size** that automatically grows and shrinks to fit the elements you put inside it.

So, you can think of the add method as performing two major tasks:
1. **Expanding the list’s size by one to accommodate the new element**
	and
2. **Placing the new element at the end of the list**

**For Example**
```Java
// initalize arraylist
ArrayList<String> bands = new ArrayList<>();

// add values to a list
bands.add("Tool");
bands.add("Phish");
bands.add("Pink Floyd");
```

![[Pasted image 20230914122014.png]]
##### When the ArrayList is Full
The ArrayList class manages an internal array of object references.
We obviously must initialize this internal array with some pre-determined size.

When we want to add an object to the ArrayList, we **expand the list’s size by one** to accommodate the new element.
Eventually, that internal array we are maintaining will **run out of space**.

What happens then?

This is where array lists work their magic:
If you call add and the internal array is full, the ArrayList will automatically create a bigger array and copy all the objects from the smaller to the bigger array.

Therefore, you will technically never run out of space in an ArrayList since its capacity will continue grow as you insert elements.
##### Amortized Runtime
An ArrayList is implemented with an array. When the array hits max capacity, the ArrayList class will create a new array with (usually) double the capacity and copy all the elements over to the new array.

How do you describe the runtime of `add` when we only resize 'sometimes'? 
This is a tricky question. There are two cases here:
1. 'Sometimes' O(N)
    If an array of size N is full and we need to resize, then inserting a new element will take O(N) time. You will have to create a new array of size 2N and then copy N elements over.
2. 'Most of the time' O(1)
    We know that we only need to resize the array every once in a while. 
    The vast majority of the time insertion will be only take O(1) time.

We need a concept that takes both into account. This is what **amortized time** describes.
It allows us to describe a worst case that happens **every once in a while.**
But once it happens, it won't happen again for so long that the cost is "amortized'.

In this case, what is the amortized time?
- We have an array with a capacity of N elements. When we reach full capacity, we double the size of the array with a power of 2.
- Let's say we start with an array of size 1 and perform an insertion.
- 1, 2, 4, 8, 16, ..., X.
- That doubling takes, respectively, 1, 2, 4, 8, 16, 32, 64, ..., X copies.
- What is the sum of 1 + 2 + 4 + 8 + 16 + ... + X?
- If you read this sum left to right, it starts with 1 and doubles until it gets to X.
- If you read right to left, it starts with X and halves until it gets to 1.
- What is the sum of X + X/2 + X/4 + X/8 + ... + 1 ? This is roughly **2X**.

Therefore, X insertions take O(2X) time. The amortized time for each insertion is O(1)
## **add(int index, E e)**

The ArrayList class also provides an overloaded version of the add method for adding a value at a particular index in the list.

This version of add takes two parameters:
1. an index
	and
2. a value to insert

**Preserving Index**
ArrayLists **preserve the order of the other list elements**. Any elements **to the right** of the given index are shifted **one to right** to make room for the new value.

They use zero-based indexing, just as arrays and strings do, so if we insert a new object at index **_i_**, then the value that was previously at index _i_ is now at index **_i+1_** after the new element **_e_** is inserted at index **_i_**.

You can insert at either end of the list:
1. If you are adding an element to the end of the list, **_i_** would be equal to the size of the array. If you try and insert past the size, then you will get an IndexOutOfBoundsException.
2. If you are adding an element to the front of the list, **_i_** would be 0, and all subsequent elements would be pushed down the list one index (have 1 added onto their current index).

**Algorithm Flow**
You can think of this method as performing three operations:
1. expanding the list’s size by 1,
2. shifting elements right to make room for a new element,
	and
3. inserting the new element

**For Example:**
Given the preceding list, consider the effect of inserting a value at index 1:

```Java
// the arraylist bands currently holds [Tool, Phish, Pink Floyd]
bands.add(1, "U2");
// bands now holds [Tool, U2, Phish, Pink Floyd]
```

![[Pasted image 20230914122142.png]]

The call on add(int index, E e) instructs the list to insert the new element at index 1.
Therefore, the old value at index 1 and everything that follows it gets shifted to the right.
## **remove(int index)**

The ArrayList also has a remove method that accepts an integer index as a parameter and removes the value at that index.

ArrayLists **preserve the order of the other list elements**.
The method preserves the order of the list by shifting values any values **to the right** of the given index are to the **left** to fill in the empty gap.

**Algorithm Flow**
You can think of this method as performing three operations:
1. lowering the list’s size by 1,
2. removing the element at the given index,
3. shifting elements left to fill empty gap
   
**For Example**
Consider what happens to the previous list if we remove the value at position 0 and then remove the value at position 1:
```Java
bands.remove(0);
bands.remove(1);
```

![[Pasted image 20230914122217.png]]

This result is a little surprising.
We asked the list to remove the value at position 0 and then to remove the value at position 1.

You might imagine that this would get rid of the strings "Tool" and "U2", since they were at positions 0 and 1, respectively, before this code was executed.

However, an ArrayList is a dynamic structure whose values move around and shift into new positions in response to your commands.

Therefore, **timing** **matters when removing or adding objects in an ArrayList**

## **ArrayList size()**

You can pass an initial capacity to the ArrayList constructor:
```Java
ArrayList<Employee> staff = new ArrayList<>(100);
```

Doing so allocates an internal array (or linked list) of 100 objects.
Then, the first 100 calls to add will not involve any costly reallocation.

If you want to **find the number of elements** in an ArrayList, you can call its **size** method
The size() method returns the actual number of elements in the array list.

**For Example**
staff.size()
returns the current number of elements in the staff array list.

This is the equivalent of
a.length
if staff has an internal array called a.
## **get(int index) and set(int index)**

Unfortunately, the convenience we get from automatic growth convenience makes indexing the array more difficult. Instead of the pleasant [] syntax to access or change the element of an array, you use the get() and set() methods.

This is the reason the ArrayList class is not a built-in part of the Java programming language like a regular array; it is just a utility class programmed by someone and supplied in the standard library.

**Set Example**
To set the ith element, you use the following syntax:

```Java
staff.set(i, harry);
```

This is equivalent to the following when using an array:

```Java
a[i] = harry;
```

**Get Example**
To get an array list element, use the following syntax:

```Java
Employee e = staff.get(i);
```

This is equivalent to

```Java
Employee e = a[i];
```

**CAUTION:**
Do not call list.set(i, x) until the _size_ of the array list is larger than i.

For example, the following code is wrong:
```Java
ArrayList<Employee> list = new ArrayList<>(100); // capacity 100, size 0

list.set(0, x); // no element 0 yet
```

Use the add method instead of set to fill up an array, and use set only to replace a previously added element.