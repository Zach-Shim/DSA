##### **Array Definition**
An array is a data structure that stores a collection of values of the same type.
It is a flexible structure for storing a sequence of values that are all of the same type.

##### **Array Subscripts**
The values stored in an array are called **_elements_**_._
Each individual element has it's own ***index*** in the array. An index is essentially it's position in the array with an offset of 1 (because the first element in the array is at index 0).

Formally, an **_index_** is an integer indicating the **_position_** of a particular value in a data structure.
In Java, an array ***index*** must always be an ***integral*** type. 

An index can be in any of the following forms:
1. a variable (constant or non-constant) holding an integral value,
2. a literal integral value (byte, short, int, long),
3. an expression that evaluates to an integral type.

**For Example:** if `a` is an array of integers, then `a[i]` is the `i`th integer in the array.

##### **Array Declaration**
To declare an array, specify:
1. the **type** of elements that will be stored in the array,
2. **brackets ([ ])** to show that it is an array of that type,
3. a **name** for the array.

Declarations are of the following syntax:

            `type[] name;`

Here is an example of a declaration of an array of integers named `arr`:

            `int[] arr;`

Arrays are ***objects***, which means that this statement only **_declares_** the variable arr. 
This declaration is a ***reference*** to an integer array type object.

Simply declaring a variable isn’t enough to bring the object into existence.
**A declaration does not initialize an array. We must *initialize* it.**
Therefore, `arr` not yet initialized.

##### **Array Initialization**
To initialize an array, declare it, and then following an equal sign, use:
1. the **new** keyword
2. followed by the **type**
3. followed by the **size** of the array in **square brackets**

Initialization of arrays are of the following syntax:

            <type>[] <name> = new <type>[<length>]

You can use any type, although the left and right sides of this statement have to match (in terms of inheritance and polymorphism).

Here is an example initialization of an array arr of three double values:

            `double[] temperature = new double[3];`

This statement **_declares and initializes_** an array of 3 doubles.
The _temperature_ variable now holds a reference to the array object.

When Java executes this line of code to construct the array of temperatures, it will construct an array of three double values, and ***return a reference*** to the variable temperature. 

![[Pasted image 20230823132419.png]]

As you can see, the variable _temperature_ is not itself the array. Instead, it stores a **reference** to the array.
The array length does not need to be a constant: new int[n] creates an array of length n.

**Anytime we initialize an array, it returns a reference to the front of the array. Indexing this array implicitly calculates the offset of the element you are trying to get.**

##### **Default Initialization Values**
When you create an array of numbers, the elements are filled with default values.

**_Default Initialization in Class Fields_**
It's not always necessary to initialize a class field.
Fields that are declared but not initialized will be set to a **reasonable default by the compiler**.
Relying on such default values, however, is generally considered **bad programming style**.

|**Data Type**|**Default Value (for fields)**|
|---|---|
|byte|0|
|short|0|
|int|0|
|long|0L|
|float|0.0f|
|double|0.0d|
|char|'\u0000'|
|String (or any object)|null|
|boolean|false|

**_Default Initialization of Local Variables - compile-time error_**
Local variables are slightly different than class fields.
The compiler **never assigns a default value to an uninitialized local variable**.

If you cannot initialize your local variable where it is declared, make sure to **assign it a value before you attempt to use it**.
Accessing an uninitialized local variable will result in a compile-time error.

**_Default Value for Objects - null_**
Arrays of objects are initialized with the special value **null**, which indicates that they do not (yet) hold any objects.

For example: The following snippet creates an array of ten strings, all of which are null.
```Java
String[] names = new String[10];
```

If you want the array to hold empty strings, you must supply them like follows:

```Java
for (int i = 0; i < 10; i++) names[i] = "";
```

##### **How Elements Are Stored**
When you create an array of a **primitive type** (like int) with initial values specified, space is allocated for the specified number of items of that type and the values in the array are set to the specified values.

When you create an array of an **object type** (like String) with initial values, space is set aside for that number of object references. The objects are created, and the object references set so that the objects can be found in the array.

![[Pasted image 20230823132747.png]]

Accessing a primitive from an array copies the value (two different primitive variables).
Accessing a object from an array copies its reference (same object, two references). 
##### **Array Initializers and Anonymous Arrays**

**Array Initializers**
Java has a **shortcut** for creating an array object and supplying initial values at the same time called **array initializers**. 

In this case you don’t specify the size of the array, it will be determined from the number of values that you specify.

Place every value you want in the array between a pair of **curly brackets** **{ }**.
            
            `type[] name = {,,,};`

Notice that you **do not call new** when you use this syntax.

Here’s an example of the syntax at work:
```Java
int[] highScores = { 99, 98, 98, 88, 68};

String[] names = {"Jamal", "Emily", "Destiny", "Mateo", "Sofia"};
```

**Anonymous Arrays**
An array in Java without a name is known as an **_anonymous array_**. 
It is an array just for creating and using once/instantly.

For Example:
```Java
new int[] { 17, 19, 23, 29, 31, 37 }
```

This expression allocates a new array and fills it with the values inside the braces.
It counts the number of initial values and sets the array size accordingly. You can use this syntax to reinitialize an array without creating a new variable.

For example,
```Java
smallPrimes = new int[] { 17, 19, 23, 29, 31, 37 };

// is shorthand for

int[] anonymous = { 17, 19, 23, 29, 31, 37 };

smallPrimes = anonymous;
```

##### **All Ways to Initialize Array**

Here are all the legal (and illegal) ways to declare and initialize an array

![[Pasted image 20230823133215.png]]