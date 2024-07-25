```java
import java.util.*;

/* 
-------------
Map Interface
-------------

------------
Description:
------------
- A Map is an object that maps keys to values (key: value).
- A map cannot contain duplicate keys.
- A key can map to at most one value.
- This interface takes the place of the Dictionary class, which was an abstract class rather than an interface.

-------------
Constructors:
-------------
- All map implementations should provide two "standard" constructors:
1. a void (no arguments) constructor which creates an empty map
2. a constructor with a single argument of type Map, which creates a new map with the same key-value mappings as its argument.

-----------
Exceptions:
-----------
- Some map implementations have restrictions on the keys and values they may contain.

- For example, some implementations prohibit null keys and values, and some have restrictions on the types of their keys.

- Attempting to insert an ineligible key or value throws an unchecked exception, typically NullPointerException or ClassCastException.

- Attempting to query the presence of an ineligible key or value may throw an exception, or it may simply return false; some implementations will exhibit the former behavior and some will exhibit the latter.

- More generally, attempting an operation on an ineligible key or value whose completion would not result in the insertion of an ineligible element into the map may throw an exception or it may succeed, at the option of the implementation.
  
-----
Note: 
-----
Great care must be exercised if mutable objects are used as map keys.

The behavior of a map is not specified if the value of an object is changed in a manner that affects equals comparisons while the object is a key in the map.

A special case of this prohibition is that it is not permissible for a map to contain itself as a key.

While it is permissible for a map to contain itself as a value, extreme caution is advised: the equals and hashCode methods are no longer well defined on such a map.
*/

public interface MyMap<K, V> {

	// Removes all of the mappings from this map (optional operation).
	void clear();
	
	// Returns true if this map contains a mapping for the specified key.
	boolean containsKey(K key);
	
	// Returns true if this map maps one or more keys to the specified value.
	boolean containsValue(V value);
	
	// Returns a Set view of the mappings contained in this map.
	Set<Map.Entry<K, V>> entrySet();
	
	// Compares the specified object with this map for equality.
	boolean equals(Object o);
	
	// Returns the value to which the specified key is mapped
	// Returns null if this map contains no mapping for the key.
	V get(K key);
	
	// Returns the value to which the specified key is mapped
	// Returns defaultValue if this map contains no mapping for the key.
	V put(K key, V value);
	
	interface Entry<K,V> {
		K getKey();
		V getValue();
		V setValue(V value);
		boolean equals(Object o);
		int hashCode();
	}

}
```