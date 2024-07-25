import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
public class LinkedList<E> implements List<E>, Deque<E> {

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E element, Node<E> prev, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    Node<E> head;
    Node<E> tail;
    private int size;
    
    /* ------------------------------------------------------------------------ */

    public LinkedList() {
        Node<E> head = new Node<E>(null, null, null);
        Node<E> tail = new Node<E>(null, null, null);
        head.next = tail;
        tail.prev = head;
    }

    /* ------------------------------------------------------------------------ */

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        linkBefore(element, getNode(index));
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
                
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
                
        return false;
    }

    @Override
    public void addFirst(E e) {
        linkBefore(e, this.head.next);
    }

    @Override
    public void addLast(E e) {
        linkBefore(e, this.tail);
    }

    private void linkBefore(E e, Node<E> succ) {
        Node<E> newNode = new Node<E>(e, null, null);    
        succ.prev.next = newNode;
        succ.prev = newNode;
        size++;
    }

    private boolean rangeCheckForAdd(int index) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return true;
    }

    /* ------------------------------------------------------------------------ */

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
                
        return false;
    }

    /* ------------------------------------------------------------------------ */

    @Override
    public void clear() {
        this.head.next = tail;
        this.tail.prev = head;
        size = 0;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if(o == null) {
            for(Node<E> curr = head.next; curr != tail; curr = curr.next) {
                if(curr.item == null)
                    return index;
                index++;
            }
        }
        else {
            for(Node<E> curr = head.next; curr != null; curr = curr.next) {
                if(o.equals(curr.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E element() {
        return getFirst();
    }

    /* ------------------------------------------------------------------------ */

    @Override
    public boolean offer(E e) {
        add(e);            
        return true;
    }

    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }
    /* ------------------------------------------------------------------------ */

    @Override
    public E poll() {
        final Node<E> n = head.next;
        return (n == tail ? null : pollFirst());
    }

    @Override
    public E pollFirst() {
        if(isEmpty()) return null;
        return unlink(head.next);
    }

    @Override
    public E pollLast() {
        if(isEmpty()) return null;        
        return unlink(tail.prev);
    }

    private E unlink(Node<E> e) {
        e.prev.next = e.next;
        e.next.prev = e.prev;
        size--;
        return e.item;
    }

    /* ------------------------------------------------------------------------ */

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> n = getNode(index);
        return unlink(n);
    }

    @Override
    public boolean remove(Object o) {
        if(o == null) {
            for(Node<E> curr = head.next; curr != tail; curr = curr.next) {
                if(curr.item == null) {
                    unlink(curr);
                    return true;
                }
            }
        }
        else {
            for(Node<E> curr = head.next; curr != null; curr = curr.next) {
                if(o.equals(curr.item)) {
                    unlink(curr);
                    return true;
                }
            }
        }
        return true;
    }

    @Override
    public E removeFirst() {
        return unlink(head.next);
    }

    @Override
    public E removeLast() {
        return unlink(tail.prev);
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        remove(o);
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
                
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
                
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
                
        return false;
    }

    /* ------------------------------------------------------------------------ */

    @Override
    public E get(int index) {
        rangeCheck(index);            
        return getNode(index).item;
    }

    @Override
    public E getFirst() {
        final Node<E> first = head.next; 
        if(first == tail) throw new NoSuchElementException();
        return first.item;
    }

    @Override
    public E getLast() {
        final Node<E> last = tail.prev; 
        if(last == head) throw new NoSuchElementException();
        return last.item;
    }

    private Node<E> getNode(int index) {
        if(index < size / 2) {
            Node<E> curr = head.next;
            for(int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr;
        }
        else {
            Node<E> curr = tail.prev;
            for(int i = size; i > index; i++) {
                curr = curr.next;
            }
            return curr;
        }
    }

    private boolean rangeCheck(int index) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return true;
    }

    /* ------------------------------------------------------------------------ */

    @Override
    public E peek() {
        return peekFirst();
    }

    @Override
    public E peekFirst() {
        return (isEmpty() ? null : head.next.item);
    }

    @Override
    public E peekLast() {
        return (isEmpty() ? null : tail.prev.item);
    }

    /* ------------------------------------------------------------------------ */

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    /* ------------------------------------------------------------------------ */

    @Override
    public Iterator<E> iterator() {
                
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    /* ------------------------------------------------------------------------ */

    @Override
    public int size() {
        return size;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        return null;
    }

    /* ------------------------------------------------------------------------ */

    @Override
    public Object[] toArray() {
                
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
                
        return null;
    }

    /* ------------------------------------------------------------------------ */

    @Override
    public int lastIndexOf(Object o) {
                
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
                
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
                
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
                
        return null;
    }
    
}
