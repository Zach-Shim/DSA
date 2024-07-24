A `Map` is an interface that represents a collection of entries that consists of keys and their values. Keys must be unique, but several keys can map to the same values. 

Thus values need not be unique. In a SortedMap, the keys in the map are maintained in logically sorted order. An implementation of SortedMap is the TreeMap. The basic operations for a Map include methods such as isEmpty, clear, size, and most importantly, the following:

     boolean containsKey( KeyType key )
     ValueType get( KeyType key )
     ValueType put( KeyType key, ValueType value )

get returns the value associated with key in the Map, or null if key is not present. If there are no null values in the Map, the value returned by get can be used to determine if key is in the Map. However, if there are null values, you have to use containsKey. Method put places a key/value pair into the Map, returning either null or the old value associated with key.

Iterating through a Map is trickier than a Collection because the Map does not provide an iterator. Instead, three methods are provided that return the view of a Map as a Collection. Since the views are themselves Collections, the views can be iterated. The three methods are:

     Set<KeyType> keySet( )
     Collection<ValueType> values( )
     Set<Map.Entry<KeyType,ValueType>> entrySet( )

Methods keySet and values return simple collections (the keys contain no duplicates, thus the keys are returned in a Set). The entrySet is returned as a Set of entries (there are no duplicate entries, since the keys are unique). Each entry is represented by the nested inter- face Map.Entry. For an object of type Map.Entry, the available methods include accessing the key, the value, and changing the value:

     KeyType getKey( )
     ValueType getValue( )
     ValueType setValue( ValueType newValue )