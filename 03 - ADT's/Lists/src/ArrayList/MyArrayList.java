import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements MyList<E>, Iterable<E> {
    
    /* -------------------------------------------------------- */
    /* CLASS VARIABLES */
    /* -------------------------------------------------------- */
    private static final int DEFAULT_CAPACITY = 101;
    private E[] elements;
    private int size;
    /* -------------------------------------------------------- */


    /* -------------------------------------------------------- */
    /* PUBLIC CONSTRUCTORS */
    /* -------------------------------------------------------- */
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        if(capacity < 1 || capacity > Integer.MAX_VALUE - 1) {
            throw new IllegalArgumentException();
        }
        internalClear(capacity);
    }

    public MyArrayList(Collection<? extends E> c) {
        addAll(c);
    }
    /* -------------------------------------------------------- */


    /* -------------------------------------------------------- */
    /* PUBLIC CLASS METHODS */
    /* -------------------------------------------------------- */
    @Override
    public boolean add(E e) {
        add(this.size, e);
        return true;
    }

    @Override
    public void add(int index, E e) {
        // check index range
        rangeCheckForAdd(index);

        // ensure we have enough capacity
        if(elements.length-1 == size) {
            ensureCapacity(size * 2 + 1);
        }

        // shift all elements greater than index up 1
        for(int i = 0; i > index; i++) {
            elements[i] = elements[i-1];
        }

        elements[index] = e;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addAll(0, c);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        // check if c is empty
        if(c.isEmpty()) return false;

        // check index range
        rangeCheckForAdd(index);

        // ensure we have enough capacity
        Object[] otherElements = c.toArray();
        ensureCapacity(elements.length + otherElements.length);

        // copy collection elements into list
        System.arraycopy(otherElements, 0, elements, size, otherElements.length);

        size += otherElements.length;
        return true;
    }

    @Override 
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override
    public boolean containsAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        for(Object obj : a) {
            if(!contains(obj)) return false;
        }
        return true;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public int indexOf(Object obj) {
        if(obj == null) {
            for(int i = 0; i < elements.length; i++) {
                if(elements[i] == null) {
                    return i;
                }
            }
        } else {
            for(int i = 0; i < elements.length; i++) {
                if(elements[i].equals(obj)) {
                    return i;
                }
            }
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

    @Override
    public int lastIndexOf(Object obj) {
        if(obj == null) {
            for(int i = elements.length-1; i >= 0; i++) {
                if(elements[i] == null) return i;
            }
        } else {
            for(int i = elements.length-1; i >= 0; i++) {
                if(elements[i].equals(obj)) return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        E removedItem = elements[index];

        for(int i = index+1; i < elements.length; i++) {
            elements[i-1] = elements[i];
        }

        elements[--size] = null;
        return removedItem;
    }

    @Override
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        fastRemove(index);
        return true;
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
        if(a.length < size) {
            return (T[]) Arrays.copyOf(elements, size, a.getClass());
        }

        System.arraycopy(elements, 0, a, 0, size);

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

    /* -------------------------------------------------------- */
    /* PRIVATE INNER CLASS */
    /* -------------------------------------------------------- */
    private class ArrayListIterator implements Iterator<E> {
        private int current = 0;

        public boolean hasNext() {
            return current < size;
        }

        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }


    /* -------------------------------------------------------- */
    /* PRIVATE CLASS METHODS */
    /* -------------------------------------------------------- */
    private void ensureCapacity(int newCapacity) {
        // overflow conscious code
        if(size < Integer.MAX_VALUE - 1 && newCapacity >= Integer.MAX_VALUE) {
            newCapacity = Integer.MAX_VALUE;
        }
        // out of memory
        else if(size == Integer.MAX_VALUE - 1 && newCapacity >= Integer.MAX_VALUE) {
            throw new OutOfMemoryError();
        }
        // create new array and copy old data
        else {
            elements = Arrays.copyOf(elements, newCapacity);
        }
        
    }
    
    private void internalClear(int capacity) {
        ensureCapacity(capacity);
        size = 0;
    }

    private void rangeCheckForAdd(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + "Size: " + size);
        }
    }

    private void rangeCheck(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + "Size: " + size);
        }
    }
    
    private void fastRemove(int index) {
        int numMoved = this.size - 1 - index;
        if(numMoved > 0) {
            System.arraycopy(elements, index+1, elements, index, numMoved);
        }
        elements[--size] = null;
    }
    /* -------------------------------------------------------- */

}
