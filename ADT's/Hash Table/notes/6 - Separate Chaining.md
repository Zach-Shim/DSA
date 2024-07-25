## Separate Chaining with Linked Lists

**Separate Chaining** is a collision resolution strategy that keeps a **list** of all elements that **hash to the same value**.

We can now think of the hash table as an **array of linked lists**.
We can use Java’s standard library List implementations to accomplish this.

Each entry table[i] is the head pointer to a list of linked nodes containing the items that the hash function has mapped into location i.

![[Pasted image 20230907164208.png]]

**Advantages:**
	1. **Dynamic Space:**
		The size of the dictionary is dynamic and can exceed the size of the hash table, because each linked chain can be as long as necessary.


**Disadvantages**:
	1. Linear Time Operations.
	   The length of linked list chains affects the efficiency hash table operations. The worst case for all hash table functions still resolves to a worst-case linear time complexity because everything we insert may go to a single bucket in the array (if we have really bad luck or a bad hash function).
		Insert: Linear O(N)
		Search: Linear O(N)
		Removal: Linear O(N)
	2. Space
	   Linked lists have a high constant space factor. Therefore, if space is tight, it might be preferable to avoid using a linked list use (since those lists are doubly linked and waste space).

If all keys were to map to the same index in the array, the add, remove and retrieval operations could all take up to O(N) time.

Even so, separate chaining is the more time-efficient collision-resolution scheme compared to closed hashing.
## **Example**

We assume, for this section, that the keys are the first 10 perfect squares and that the hashing function is simply _hash_(_x_) = _x_ mod 10. (The table size is not prime but is used here for simplicity.) Figure 5.5 should make this clear.

![[Pasted image 20240305174638.png]]

**Search:**
To perform a search, we use the hash function to determine which list to traverse. 
We then search the appropriate list. 

**Insert:**
To perform an insert, we check the appropriate list to see whether the element is already in place (if duplicates are expected, an extra field is usually kept, and this field would be incremented in the event of a match). 
If the element turns out to be new, it is inserted at the front of the list, since it is convenient and also because frequently it happens that recently inserted elements are the most likely to be accessed in the near future.

In the insertion routine, if the item to be inserted is already present, then we do nothing;
Otherwise, we place it in the list. 
The element can be placed anywhere in the list; using add is most convenient in our case.

```java
public class SeparateChainingHashTable<AnyType> {

private static final int DEFAULT_TABLE_SIZE = 101;
private List<AnyType>[] theLists; 
private int currentSize;

public SeparateChainingHashTable() {
	this(DEFAULT_TABLE_SIZE);
}

public SeparateChainingHashTable(int size) {
	theLists = new LinkedList[nextPrime(size)];
	for(int i = 0; i < theLists.length; i++) {
		theLists[i] = new LinkedList<AnyType>();
	}
}

public void insert(AnyType key) {
	List<AnyType> keyList = theLists[myHash(key)];
	if(!keyList.contains(key)) {
		keyList.add(x);
		//rehash
		if(++currentSize > theLists.length)
			rehash();
	}
}

public void remove(AnyType key) {
	List<AnyType> keyList = theLists[myHash(key)];
	if(keyList.contains(key)) {
		keyList.remove(key);
		currentSize--;
	}
}

public boolean contains(AnyType key) {
	List<AnyType> keyList = theLists[myHash(key)];
	return keyList.contains(key);
}

public void makeEmpty() {
	for(int i = 0; i < theLists.length; i++) {
		theLists[i].clear();
	}
	currentSize = 0;
}


private void rehash() {

}

private int myhash(AnyType x) {
	int hashVal = x.hashCode();
	hashVal %= theLists.length;
	if(hashVal < 0) {
		hashVal += theLists.length;
	}
	return hashVal;
}

private static int nextPrime(int n) { 
	while(true) {
		if(isPrime(n))
			return n;
		else
			n++;
	}
}

private static boolean isPrime(int n) {  
	for (int i = 2; i < number; i++) {
		if((number% i) == 0) {
			return false;
		}
	}
	return true;
}

}
```

If all keys were to map to the same index in the array, the add, remove and retrieval operations could all take up to O(N) time.

Even so, separate chaining is the more time-efficient collision-resolution scheme compared to closed hashing.

But can we do better?

## Separate Chaining using Balanced Trees

When we use a linked list implementation for separate chaining, we cannot iterate over values in a sorted order. Our average operation time is O(1) and is worst case O(N).

We can have a better average by ensuring O(logN) operation times using a balanced AVL tree. This is called a TreeMap in the Java Standard LIbrary. This also allowed us to iterate over our TreeMap in a sorted order.