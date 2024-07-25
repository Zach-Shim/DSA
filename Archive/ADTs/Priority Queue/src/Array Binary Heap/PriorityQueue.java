public interface PriorityQueue<E> {
	boolean add(E value);
    boolean contains(Object o);
	void clear();
	boolean isEmpty();
	E peek();
	E remove();
	int size();
}