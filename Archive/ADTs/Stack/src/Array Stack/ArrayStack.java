import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> 
{
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;
    
    @SuppressWarnings("unchecked")
    public ArrayStack()
    {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public Iterator<E> iterator()
    {
        return new ArrayStackIterator();
    }

    public void push(E value)
    {
        if(size == elements.length)
            resize(2 * size);
        
        elements[size] = value;
        size++;
    }

    public E pop() throws EmptyStackException
    {
        if(isEmpty())
            throw new EmptyStackException();
        
        E top = elements[size - 1];
        elements[size - 1] = null;
        size--;
        return top;
    }

    public E peek()
    {
        if(size == 0)
            throw new EmptyStackException();
        return elements[size - 1];
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    public int size()
    {
        return size;
    }

	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		E[] newElements = (E[]) (new Object[capacity]);
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
	}

    private class ArrayStackIterator implements Iterator<E>
    {
        private int index;

        public ArrayStackIterator()
        {
            index = 0;
        }

        public boolean hasNext()
        {
            return index < size;
        }        

        public E next()
        {
            if(!hasNext()) throw new NoSuchElementException();
            E result = elements[index];
            index++;
            return result;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}
