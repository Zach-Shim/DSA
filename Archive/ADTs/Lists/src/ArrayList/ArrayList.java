import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ArrayList<E> implements List<E>, Iterable<E> {

    private static final int DEFAULT_CAPACITY = 101;
    private E[] elements;
    private int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);   
    }

    public ArrayList(int capacity) {
        if(capacity < 1 || capacity > Integer.MAX_VALUE - 1)
            throw new IllegalArgumentException();
        internalClear(capacity);
    }

    @Override
    public boolean add(E e) {
        add(this.size, e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        // check index range
        rangeCheckForAdd(index);

        // ensure we have enough capacity for insert
        if(elements.length-1 == size) 
            ensureCapacity(size * 2 + 1);

        // shift all elements greater than index up 1
        for(int i = size; i > index; i--)
            elements[i] = elements[i-1];

        // insert new element
        elements[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        // convert collection to array
        Object[] a = c.toArray();

        // ensure we have enough space for current element array + new collection array
        int numNew = a.length;
        ensureCapacity(size + numNew);  
        
        // copy contents of c to end of elements array
        System.arraycopy(a, 0, elements, size, numNew);

        // add size of c to elements
        size += numNew;
        return numNew != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        // ensure index is not beyond range
        rangeCheckForAdd(index);

        // convert collection to array
        Object[] a = c.toArray();

        // ensure we have enough space for current element array + new collection array
        int numNew = a.length;
        ensureCapacity(size + numNew);  // Increments modCount

        // a
        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(elements, index, elements, index + numNew, numMoved);

        // copy contents of c to end of elements array
        System.arraycopy(a, 0, elements, index, numNew);

        // add size of c to elements
        size += numNew;
        return numNew != 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    private void internalClear(int capacity) {
        ensureCapacity(capacity);
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] a = c.toArray();
        for(Object o : a) 
            if(!contains(o)) return false;
        return true;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elements[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<E> {
        private int current = 0;

        public boolean hasNext() {
            return current < size;
        }

        public E next() {
            if(!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return elements[current++];
        }

        public void remove() {
            ArrayList.this.remove(--current);
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size-1; i >= 0; i++)
                if (elements[i]==null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i++)
                if (o.equals(elements[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        
        E removedItem = elements[index];

        // can do fastRemove(index); or the following
        for(int i = index; i < size - 1; i++) {
            elements[i] = elements[i+1];
        }

        elements[--size] = null;
        return removedItem;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        fastRemove(index); 
        return true;
    }

    private void fastRemove(int index) {
        int numMoved = (this.size - 1) - index;
        if(numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        elements[size--] = null;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E oldVal = elements[index];
        elements[index] = element;
        return oldVal;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {     
        // Make a new array of a's runtime type, but my contents:
        if (a.length < size)
            return (T[]) Arrays.copyOf(elements, size, a.getClass());

        System.arraycopy(elements, 0, a, 0, size);

        if (a.length > size)
            a[size] = null;
            
        return a;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < size; i++) {
            if(elements[i] == null) sb.append("null,");
            else sb.append(elements[i].toString() + ",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int newCapacity) {
        // overflow-conscious code
        if(size < Integer.MAX_VALUE - 1 && newCapacity >= Integer.MAX_VALUE) 
            newCapacity = Integer.MAX_VALUE - 1;
        else if(size == Integer.MAX_VALUE - 1 && newCapacity >= Integer.MAX_VALUE)
            throw new OutOfMemoryError();
        
        // create new array and copy old data
        // elements = Arrays.copyOf(elements, newCapacity);

        // copy old items to new array
        E[] oldItems = elements;
        elements = (E[]) new Object[newCapacity];
        for(int i = 0; i < size; i++) {
            elements[i] = oldItems[i];
        }
    
    }

    private void rangeCheckForAdd(int index) {
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void rangeCheck(int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
    
}
