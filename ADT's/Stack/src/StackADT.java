import java.util.Iterator;

public interface StackADT<E> extends Iterable<E> {
    public void push(E value);
    public E pop();
    public E peek();
    public boolean isEmpty();
    Iterator<E> iterator();
    public int size();
}