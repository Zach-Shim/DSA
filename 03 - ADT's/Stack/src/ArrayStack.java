import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class ArrayStack<E> {
    
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public Iterator<E> iterator() {
        return new ArrayStackIterator();
    }

    public void push(E value) {
        // check if array is full
        if(size == elements.length) {
            resize(2 * size);
        }

        elements[size++] = value;
    }

    public E pop() throws EmptyStackException {
        // check if stack is empty
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        E value = elements[--size];
        elements[size] = null;

        return value;
    }

    public E peek() throws EmptyStackException {
        // check if stack is empty
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        E value = elements[size - 1];
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for(int i = 0; i < elements.length; i++) {
            temp[i] = elements[i];
        }
        elements = temp;
    }

    private class ArrayStackIterator implements Iterator<E> {
        private int index;

        public ArrayStackIterator() {
            index = 0;
        }

        public boolean hasNext() {
            return index < size;
        }

        public E next() throws NoSuchElementException {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return elements[index++];
        }

        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }
}
