import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// This class defines an implementation of the stack ADT using a linked list as the internal data structure.
public class LinkedStack<E> implements Stack<E> {
    Node front;
    int size;

    // construct a new empty stack
    public LinkedStack()
    {
        front = null;
        size = 0;
    }

    public Iterator<E> iterator()
    {
        return new LinkedStackIterator();
    }

    // add given value to top of the stack (becomes new head of the list)
    public void push(E value)
    {
        Node newNode = new Node(value, front);
        front = newNode;
        size++;
    }

    // remove and returns the top of the stack (removes head and assigns head.next as new head)
    public E pop() throws EmptyStackException
    {
        if(isEmpty()) throw new EmptyStackException();
        E top = front.data;
        front = front.next;
        size--;
        return top;
    }
    
    // returns the top of the stack without removing it
    public E peek() throws EmptyStackException
    {
        if(isEmpty()) throw new EmptyStackException();
        return front.data;
    }

    // return true is stack is empty, false otherwise
    public boolean isEmpty()
    {
        return (size == 0);
    }

    // return size of the stack
    public int size()
    {
        return size;
    }

    // Returns a string representation of the stack, such as "bottom a b c top".
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node current = front;
        while (current != null) {
            sb.insert(0, current.data);
            sb.insert(0, ' ');
            current = current.next;
        }

        sb.insert(0, "bottom");
        sb.append(" top");
        return sb.toString();
    }

    // Each Node object stores a single element of data in the linked list
    private class Node 
    {
        private E data;
        private Node next;

        public Node(E data)
        {
            this.data = data;
            this.next = null;
        }
        
        public Node(E data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }

    // An iterator class to traverse the elements of this stack from top to bottom.
    private class LinkedStackIterator implements Iterator<E>
    {
        private Node position;

        public LinkedStackIterator()
        {
            position = front;
        }

        public boolean hasNext()
        {
            return position != null;
        }

        public E next()
        {
            if(!hasNext()) throw new NoSuchElementException();
            E result = position.data;
            position = position.next;
            return result;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}
