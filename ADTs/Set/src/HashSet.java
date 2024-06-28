public class HashSet<E> implements Set<E>
{
    private int INIT_CAPACITY = 101;
    private static final Object REMOVED = new Object();
    private Object[] elements;
    private int size;

    public HashSet() {
        this.elements = new Object[INIT_CAPACITY];
        this.size = 0;
    }

    public void add(E value)
    {
        if((double) size / elements.length >= 0.75)
        {
            rehash();
        }

        int h = hash(value);
        while(elements[h] != null && !elements[h].equals(value) && !elements[h].equals(REMOVED)) 
        {
            // collision: linear probing
            h = (h + 1) % elements.length;
        }

        // elements[h] == 0 || elements[h] == value
        if(elements[h] != value)
        {
            elements[h] = value;
            size++;
        }
    }

    public boolean contains(E value)
    {
        int h = hash(value);
        while(elements[h] != null)
        {
            // found
            if(elements[h].equals(value))
            {
                return true;
            }
            // collision
            h = (h + 1) % elements.length;
        }
        return false;
    }

    public void clear()
    {

    }

	// resize to 2x as big
	@SuppressWarnings("unchecked")
	private void rehash() {
		Object[] big = new Object[2 * elements.length];
		Object[] old = elements;
		size = 0;
		elements = big;
		
		for (Object o : old) {
			if (o != null && o != REMOVED) {
				add((E) o);
			}
		}
	}

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void remove(E value)
    {
        int h = hash(value);
        while(elements[h] != null && !elements[h].equals(value))
        {
            h = (h + 1) % elements.length;
        }

        // elements[h] == 0 || elements[h] == value
        if(elements[h] != value)
        {
            elements[h] = REMOVED;
            size++;
        }
    }

    public int size()
    {
        return size;
    }

    public int hash(E value) 
    {
        return Math.abs(value.hashCode()) % elements.length;
    }
}