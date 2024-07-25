## **Arrays and Loops**

Once an array is created, you can fill the elements in an array using loops.

```Java
int[] a = new int[100];

for (int i = 0; i < 100; i++) {
	a[i] = i;   // fills the array with numbers 0 to 99
}
```

To find the number of elements of an array, use **_array_.length**.

```Java
for(int i = 0; i < a.length; i++) {
	System.out.println(a[i]);
}
```

Once you create an array, you cannot change its size. However, you can create a new array with a bigger size and copy over the contents from the old array to the new array.

If you frequently need to expand the size of an array while your program is running, you should use a different data structure called an **_array list_.**

## **The “for each” Loop**

Java has a powerful looping construct that allows you to loop through each element in an array (or any other collection of elements) without having to fuss with index values.

The name for this loop is an **_enhanced_** for loop
```java
for (variable : collection) {
	statement
}
```

This is syntactic sugar for an iterator over a *collection*. The _collection_ expression must be an array or an object of a class that implements the `Iterable` interface, such as `ArrayList`.

The loop iterates over each element in collection and assigns it to the given _variable_ on each iteration of the loop. 

It then executes the _statement_ (which, of course, may be a block of statements).

>[!Note]
>The loop _variable_ of the “for each” loop traverses the elements of the array, not the *index values*. If you want index values, you must use a traditional for loop.

**Example**
```
for (int element : a)
    System.out.println(element);
```

This code prints each element of the array a on a separate line. 
You should read this loop as “**for each element in a**”.
