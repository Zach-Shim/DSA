/**
 * A List is an ordered collection (also known as a sequence.  
 * 
 * The user of this interface has control over where in the list each element is inserted.  
 * The user can access elements by their integer index (position in the list), and search for elements in the list.
 *
 * Unlike sets, lists typically allow duplicate elements.  
 * More formally, lists typically allow pairs of elements e1 and e2 such that e1.equals(e2)
 * They typically allow multiple null elements if they allow null elements at all.  
 *
 * Lists (like Java arrays) are zero based.  
 * Note that these operations may execute in time proportional to the index value for some implementations (for example, LinkedList class)
 * Thus, iterating over the elements in a list is typically preferable to indexing through it if the caller does not know the implementation.
 *
 * The List interface provides a special iterator, called a ListIterator, that allows element insertion and replacement.
 * The ListIterator also allows bidirectional access in addition to the normal operations that the Iterator interface provides.  
 * A method is provided to obtain a list iterator that starts at a specified position in the list.
 *
 * Note: While it is permissible for lists to contain themselves as elements.
 * Extreme caution is advised: the equals() and hashCode() methods are no longer well defined on such a list.
 *
 * @param <E> the type of elements in this list
 */

import java.util.*;

public interface MyList<E> {
    boolean add(E e);
    void add(int index, E e);

    void clear();
    boolean contains(Object o);
    
    int size();
    int indexOf(Object o);

    E get(int index);
    E set(int index, E element);

    boolean isEmpty();
    boolean equals(Object o);
    
    boolean remove(Object o);

    Iterator<E> iterator();
}
