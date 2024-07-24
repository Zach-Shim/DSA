```java
import java.util.Arrays;

public class MyHashMap<K, V> implements MyMap<K, V> {

	private final int INIT_CAPACITY = 10001;
	private Node[] elements;
	private int size;
	
	static class Node<K,V> implements MyMap.Entry<K,V> {
		
		int hash;
		K key;
		V value;
		Node<K,V> next;
		
		Node(int hash, K key, V value, Node<K,V> next) {
			this.hash = hash;
			this.key = key;
			this.value = value;	
			this.next = next;
		}
		
		public final K getKey() { return key; }
		public final K setKey(K key) { this.key = key; return key; }
		
		public final V getValue() { return value; }
		public final V setValue(V value) { this.value = value; return value; }
		
		public final String toString() { return key + "=" + value; }
		
		public final int hashCode() { 
			return key.hashCode() ^ value.hashCode(); 
		}
	}
	
	@SupressedWarnings("unchecked")
	public MyHashMap() {
		elements = (Node[]) new Node[INIT_CAPACITY];
		size = 0;
	}
		
	/**
	* Associates the specified value with the specified key in this map.
	* If the map previously contained a mapping for the key, the old
	* value is replaced.
	
	* @param key key with which the specified value is to be associated
	* @param value value to be associated with the specified key
	
	* @return the previous value associated with key, or
	* null if there was no mapping for key.
	
	* (A null return can also indicate that the map previously 
	* associated null with key.)
	*/
	
	public V put(K key, V value) {
		remove(key);
		int idx = hash(key);
		Node<K, V> newHead = new Node(key, value, elements[hash]);
		elements[hash] = newHead;
		return value;
	}
	
	public boolean containsKey(K Key) {
		int idx = hash(key);
		Node<K, V> current = elements[idx];
		while (current != null) {
			if (equals(key, current.key)) {	
				return true;
			} else {
				current = current.next;
			}
		}
		return false;
	}
	
	public V remove(K key) {
		int idx = hash(key);
		Node<K, V> prev, current = null, elements[idx];
		while (current != null) {
			if (key == current.key) {	
				prev.next = current.next;
				current.next = null;
				size--;
				return current.value;
			} else {
				prev = current;
				current = current.next;
			}
		}
		return null;
	}
```