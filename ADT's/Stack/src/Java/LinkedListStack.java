import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListStack<E> implements StackADT<E> {

    private static class Node<E> {
        
        public E data;
        public Node<E> next;
        public Node<E> prev;

        public Node(E data) {
            this(data, null, null);
        }
        
        public Node(E data, Node<E> next, Node<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    Node<E> head;
    Node<E> tail;        
    int size = 0;

    public LinkedListStack() {
        this.head = new Node<E>(null);
        this.tail = new Node<E>(null);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    
    private void addFirst(E e) {
        linkBefore(this.head.next, e);
    }

    private void linkBefore(Node<E> n, E e) {
        Node<E> newNode = new Node<E>(e);
        
        n.prev.next = newNode;
        newNode.prev = n.prev;
        n.prev = newNode;
        newNode.next = n;
    }

    public void push(E value) {
        addFirst(value);
        size++;
    }

    public E pop() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        E value = head.next.data;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return value;
    }

    public E peek() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return head.next.data;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }

    private class LinkedListStackIterator implements Iterator<E> {
        private Node<E> current;

        public LinkedListStackIterator() {
            current = head;
        }

        public boolean hasNext() {
            return current.next != null;
        }

        public E next() throws NoSuchElementException {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            
            current = current.next;
            return current.data;
        }

        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<E> iterator() {
        return new LinkedListStackIterator();
    }

}
