public interface QueueADT<E> {
    // adds one element to the rear of the queue
    public void enqueue(E e);

    // removes and returns the element at the front of the queue
    public E dequeue();

    // return the head of the queue without removing it
    public E peek();

    // returns true if the queue contains no elements
    public boolean isEmpty();

    // returns the number of elements in the queue
    public int size();

    // returns a string representation of the queue
    public String toString();
}
