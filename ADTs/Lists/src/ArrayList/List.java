import java.util.Collection;
import java.util.Iterator;

public interface List<E> {
    
    public boolean add(E e);
    public void add(int index, E element);
    public boolean addAll(Collection<? extends E> c);
    public boolean addAll(int index, Collection<? extends E> c);

    public void clear();
    public boolean contains(Object o);
    public boolean containsAll(Collection<?> c);
    
    public boolean equals(Object o);

    public E get(int index);
    public int indexOf(Object o);

    public boolean isEmpty();
    public Iterator<E> iterator();

    public int lastIndexOf(Object o);

    public E remove(int index);
    public boolean remove(Object o);

    public E set(int index, E element);
    public int size();

    public Object[] toArray();
    public <T> T[] toArray(T[] a);
}
