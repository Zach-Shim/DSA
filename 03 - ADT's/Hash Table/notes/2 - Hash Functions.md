## **Hash Functions & Keys**

**Hashing** is a technique for efficiently mapping data elements to indexes in the array so that they can be added, removed, or searched in a constant amount of time O(1).

The **ordering of the elements doesn’t matter**.

A **hash function** takes in some sort of **input search `Key`** and outputs an array index.
This array index is used to map a data element to the hash table.
Ideally, we want the hash function to map each **search key _x_** into a **unique integer _i_**.

There are many ways to convert an arbitrary input (integer, string, etc.) into a constrained range of integers indexes, such as 0 through 100. Many of these functions, however, are not suitable or robust enough. We will explore several solutions as well as their tradeoffs and how to improve.
## **Integer Keys**

##### `Key % TableSize`
If the input keys are integers, then simply returning `Key % TableSize` is generally a reasonable strategy.

If the `Key` happens to have some undesirable properties, the choice of hash function needs to be carefully considered.

For instance, if the table size is 10 and the keys all end in zero, then the standard hash function is a bad choice. 

To avoid situations like the one above, it is often a good idea to ensure that the table size is **prime**. 
Basically, making our table size prime allows us **limit clustering** and have more **even distribution** of keys across our internal array.

When the input keys are random integers, then this function is not only very simple to compute but also distributes the keys evenly.
##### Folding
Folding is a hashing technique where we add the individual digits in the integer together to come up with an index to the hash table.

One way to fold is to **Add the Individual Numbers** in a search key (integer input).
For example, you can add all of the digits in 001364825 to obtain
	0 + 0 + 1 + 3 + 6 + 4 + 8 + 2 + 5 = 29 (_add the digits_)

Therefore, you would store the item whose search key is 001364825 at table[29]
Notice that if you add all of the digits from a nine-digit search key, the max value can only be ≤ 81:
	   0 ≤ _h_(_search key_) ≤ 81

To chance or increase the size range of the hash function (to match the hash table size), we can **Add Together** **Groups of Numbers** in the search key.

For example, you could form three groups of three digits from the search key 001364825 and add them as follows:
	   001 + 364 + 825 = 1,190

For this hash function, the range of possible hash table indexes is
	   0 ≤ _h_(_search key_) ≤ 3 X 999 = 2,997

 Clearly, if 2,997 is larger than the size of the hash table that you want, you can alter the groups that you choose.
##### **Key to Index**
Here’s an odd but powerful idea: What if we stored element value **_k_** at index **_k_**?
For example, if you tell the set to add the value 5, store it at index 5. 

If we used this technique, the set storing 7, 5, 1, and 9 would have the structure shown in Figure 18.3. 
![[Pasted image 20230907120314.png]]

**Hash Function**
h(i) = i

If we stored our set data using this technique, the three basic set operations (insert, search, remove) all run in constant time.

You may already be thinking of some problems with this implementation strategy.
- Search keys outside of the array size are invalid.
- A large array could be sparse (wastes memory).
##### **Modulo Arithmetic**
To get around this issue, let’s patch our storage technique.
Instead of always storing element value _k_ at index _k_, we’ll limit _k_’s value by ***modding*** it by the ***array capacity***.

So if the array length is 10, the value 23 would be inserted at index 3 because 23 % 10 equals 3. 

To fix negative numbers, we’ll take the **absolute value** of _k_ and apply the same technique. So the value -58 would be inserted at index 8.

**Hash Function**
1. ***h(x) = abs(x) % tableSize***
	
	Constraints:
	where _tableSize_ is the size of the hash table
	where _x_ is the search key
	where _h(x)_ is the calculated array index into the hash table
	
	Example:
	If _tableSize_ is 101, _h_(_x_) = _x_ mod 101 maps any integer _x_ into the range 0 through 100.
	For example, _h_ maps 001364825 into 12.

2. **_h(x) = abs(x) % primeTableSize_**
	   
	For **_h(x) = x % tableSize_**,
	many _x_’s map into table[0],
	many _x_’s map into table[1],
	and so on…
	
	That is, different search keys can be mapped to the same index, resulting in collisions.
	However, you can distribute the dictionary items evenly over all of table— thus reducing collisions—by **choosing a prime number for _tableSize_**.
	
	For example, 101 in the previous example is prime.
	However, for the typical hash table, 101 is much too small.

**Three Basic Operations**
The three basic operations are still O(1), and can now handle more edge cases.

**Problem: Collisions**
We still have one main problem, resolving collisions!
## **String Keys**

Usually, we deal with string input keys.
In this case, hash functions become more complicated, because we to find some way to convert our string into a numerical hash.
##### Add ASCII Values
Convert String characters to their **ASCII** (or Unicode) values and **add** them together.

This hash function is **simple** to implement and **computes an answer quickly**. 
However, if the table size is large, the function **does not distribute the keys well**.

For example, TableSize = 10,007 (10,007 is a prime number).
Suppose all the keys are eight or fewer characters long.
Since an ASCII character has an integer value that is always at most 127, the hash function typically can only assume values between 0 and 1,016, which is 127 ∗ 8. This is clearly not an equitable distribution!

```Java
public static int hash(String key, int tableSize) {
	int hashVal = 0;
	for(int i = 0; i < key.length(); i++) {
		hashVal += key.charAt(i);
	}
	return hashVal % tableSize;
}
```

##### Horners rule
This hash function involves all characters in the key and can generally be expected to distribute well (it computes

```java
public static int hash(String key, int tableSize) {
	int hashVal = 0;
	for(int i=0; i < key.length(); i++) 
		hashVal = 37 * hashVal + key.charAt(i);
		
	hashVal %= tableSize;
	if( hashVal < 0 )
		hashVal += tableSize;
	
	return hashVal;
```

This hash function computes a polynomial function (of 37) by use of Horner’s rule. 

The hash function takes advantage of the fact that overflow is allowed. This may introduce a negative number; thus the extra test at the end.

This hash function is not necessarily the best with respect to table distribution but does have the merit of extreme simplicity and is reasonably fast. If the keys are very long, the hash function will take too long to compute. 

A common practice in this case is not to use all the characters. The length and properties of the keys would then influence the choice. 

For instance, the keys could be a complete street address. 
The hash function might include a couple of characters from the street address and perhaps a couple of characters from the city name and ZIP code. 

Some programmers implement their hash function by using only the characters in the odd spaces, with the idea that the time saved computing the hash function will make up for a slightly less evenly distributed function.
