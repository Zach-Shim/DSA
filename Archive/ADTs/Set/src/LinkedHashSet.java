import java.util.Arrays;

public class LinkedHashSet<E> implements Set<E> {
    
    private static final double MAX_LOAD = 0.75;   // load factor on which to rehash
	
	private Node[] elements;
	private int size;
	
	// Constructs a new empty set of integers.
	@SuppressWarnings("unchecked")
	public LinkedHashSet() {
		elements = (Node[]) new LinkedHashSet.Node[10];
		size = 0;
	}

    private class Node {
		public E data;
		public Node next;
		
		public Node(E data) {
			this.data = data;
		}
	}

    // Adds the given value to this set, if it was not already contained in the set.
	public void add(E value) {
		// linear probing to find proper index
		if (!contains(value)) {
			int h = hash(value);
			Node newNode = new Node(value);
			newNode.next = elements[h];
			elements[h] = newNode;
			size++;
		}

		// resize if necessary
		if (loadFactor() > MAX_LOAD) {
			rehash();
		}
	}

	// Returns whether the given value is found in this set.
	public boolean contains(E value) {
		// linear probing to find proper index
		int h = hash(value);
		Node current = elements[h];
		while (current != null) {
			if (current.data.equals(value)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

    // Returns true if there are no elements in this set.
	public boolean isEmpty() {
		return size == 0;
	}
	
	// Returns the hash table's "load factor", its ratio of size to capacity.
	public double loadFactor() {
		return (double) size / elements.length;
	}

    // Removes the given element value from this set, if it was found in the set.
	public void remove(E value) {
		// linear probing to find proper index
		int h = hash(value);
		
		if (elements[h] != null) {
			// front case
			if (elements[h].data.equals(value)) {
				elements[h] = elements[h].next;
			} else {
				// non-front case
				Node current = elements[h];
				while (current.next != null && !current.next.data.equals(value)) {
					current = current.next;
				}
				
				// current.next == null 
				// || current.next.data == value
				if (current.next != null) {
					current.next = current.next.next;
					size--;
				}
			}
		}
	}

    // Returns the number of elements in this set.
	public int size() {
		return size;
	}
	
    // hash function for mapping values to indexes
    private int hash(E value) {
        return Math.abs(value.hashCode()) % elements.length;
    }

    // Resizes the hash table to twice its original capacity.
    @SuppressWarnings("unchecked")
    private void rehash() {
        Node[] newElements = (Node[]) new LinkedHashSet.Node[2 * elements.length];
        Node[] old = elements;
        elements = newElements;
        size = 0;
        for (Node node : old) {
            while (node != null) {
                add(node.data);
                node = node.next;
            }
        }
    }
}
