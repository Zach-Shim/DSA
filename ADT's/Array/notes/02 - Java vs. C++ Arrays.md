## **C++ vs. Java Arrays**

Java itself is based on the C++ language but has several distinct differences. 
How arrays are implemented is one such difference.

---
##### **Initialization**
There are two kinds of arrays in C++
1. Static stack-allocated (fixed) array
2. Dynamic heap-allocated array

Java arrays are essentially the same as a C++ dynamic arrays.
C++ dynamic arrays are pointers to an array allocated on the **_heap_**.

```Java
int[] a = new int[100];             // Java initialization
```

is not the same as

```C++
int a[100];                         // C++ fixed array initialization
```

but rather, it is equivalent to

```C++
int* a = new int[100];             // C++ dynamic array initalization
```

in other words, `Java Array == C++ Dynamic Array`

The main distinction is obviously the simpler syntax and the ability to not worry about memory usage with pointers because Java has automatic garbage collection.

---
##### **Implementation**

**C++ Arrays**
An array in C++ is basically a pointer to the address of a variable.
An array itself is a sequence of contiguous blocks of allocated memory.
Access to subsequent elements is done through pointer arithmetic.

**Java Arrays Are Objects**
An array in Java is an object.
It has instance variables and functions.
Since an array in Java is an object, they must be dynamically declared/allocated.

**You cannot allocate a Java array onto the stack (like C++) because it is an object, and all objects must be dynamically declared onto the heap in Java.**

Furthermore, there is no pointer arithmetic—you can’t increment a to point to the next element in the array. This follows suit, because C++ array use pointer arithmetic to implement the functionality of arrays—whereas Java arrays are higher-level objects.

---
##### **Size**

**Java Array Size**
Since an array in Java is an object, it may have instance fields.
Every Java array has a field defined as **`public int length`** that stores the **size** of an array.

```Java
int[] scores = new int[10];
for (int i = 0; i < scores.length; i++)
	. . . scores[i] . . .;
```

The size (or length) of an array is simply the number of elements that it was defined to be able to hold.

**C++ Array Size**
C++ programmers must maintain a separate, distinct variable to track the size of an array.

```cpp
const int size = 10;
int scores[size];
for (int i = 0; i < size; i++)
	. . . scores[i] . . .;
```
---
##### **Bounds Checking**

Arrays, in both the C++ and Java programming languages, are zero-indexed, meaning that legal index values range from 0 to size - 1 (where size is the maximum number of elements in the array).

**C++ Bounds Checking**
C++ offers no bounds checking.
If you were to index an out-of-bounds element, C++ would do nothing to stop you.
This of course, would result in undefined behavior.

**Java Bounds Checking**
If a program attempts to index an out-of-bounds element, the Java virtual machine (JVM) aborts the program by throwing an exception, **IndexOutOfBoundsException**.

While bounds checking in Java makes your code less error prone, it does come with its share of overhead. Therefore, C++ programs will always outperform similar Java programs in this regard.

---
##### **Storage Allocation**

**C++ Storage Allocation**
In C++, storage for a static array is allocated at compile time.
In C++, storage for a dynamic array is allocated on the heap at run time.

```C++
int A[10];            // A is an array allocated onto the stack at compile time
int* B = new int[10]; // B is a dynamic array allocated onto the heap at runtime 
```

**Java Storage Allocation**
Unlike C++, Java arrays cannot be allocated onto the stack.
Java arrays are a special type of object, hence they can only be dynamically allocated via "new” operator, and are therefore allocated on the heap at runtime.

In Java, when you declare an array, you are really only declaring a pointer to an array.
Storage for the array itself is not allocated until you use "new".

```java
int[] A = new int [10];   // A is a pointer to an array
```

**Arrays of Objects**

In C++ it is possible to create an array of fully constructed objects in a single operation; Java requires multiple operations to create an array of objects

---
## Sources:
[Java To C++ - Stack Allocated Arrays](https://people.eecs.ku.edu/~jrmiller/Courses/JavaToC++/StackAllocatedArrays.html)
[C++ vs. Java Arrays](https://pages.cs.wisc.edu/~hasti/cs368/JavaTutorial/NOTES/Java_vs.html#arrays)
[Arrays: C++ vs. Java](https://icarus.cs.weber.edu/~dab/cs1410/textbook/7.Arrays/cpp_v_java.html)
[Java Arrays](https://docs.oracle.com/javase/specs/jls/se7/html/jls-10.html)
