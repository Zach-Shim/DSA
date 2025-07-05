import java.util.Iterator;

public interface Stack<E> extends Iterable<E> {
	void push(E value);
	E pop();
	E peek();
	boolean isEmpty();
	Iterator<E> iterator();
	int size();
}