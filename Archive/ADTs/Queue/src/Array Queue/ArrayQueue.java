import exception.*;
import java.util.*;

public class ArrayQueue<E> implements QueueADT<E> 
{
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int rear;
    private E[] queue;

    /* ------------------------------------ CONSTRUCTORS ------------------------------------ */

    //-------------------------------------------------------------------------------
    //  Creates an empty queue using the default capacity.
    //-------------------------------------------------------------------------------
    public ArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }

    //-------------------------------------------------------------------------------
    //  Creates an empty queue using the specified capacity.
    //-------------------------------------------------------------------------------
    public ArrayQueue(int initCapacity)
    {
        if(initCapacity < 0) 
            throw new IllegalArgumentException("IllegalCapacity: " + initCapacity);
        clear();
    }

    //-------------------------------------------------------------------------------
    //  Adds the specified element to the rear of the queue.
    //  Expands the capacity of the queue array if necessary.
    //-------------------------------------------------------------------------------
    public void enqueue (E e)
    {
        // test if queue is full
        if(size == queue.length) ensureCapacity(size * 2 + 1);
        queue[rear] = e;
        rear++;
        size++;
    }

    //-------------------------------------------------------------------------------
    //  Removes the element at the front of the queue and returns a reference to it. 
    //  Throws an EmptyCollectionException if the queue is empty.
    //-------------------------------------------------------------------------------
    public E dequeue() throws EmptyCollectionException
    {
        if(isEmpty()) throw new EmptyCollectionException("queue");
        
        // save front of queue
        E result = queue[0];
        
        // shift the elements left
        for (int scan = 0; scan < rear; scan++)
            queue[scan] = queue[scan+1];
        
        // update size and rear pointer    
        queue[rear] = null;
        rear--;
        size--;

        return result;
    }

    //-----------------------------------------------------------------
    //  Returns a reference to the element at the front of the queue.
    //  The element is not removed from the queue.  Throws an
    //  EmptyCollectionException if the queue is empty.  
    //-----------------------------------------------------------------
    public E peek() throws EmptyCollectionException
    {
        if(isEmpty()) throw new EmptyCollectionException("queue");
        return queue[0];
    }

    //-------------------------------------------------------------------------------
    // Empties the array
    //-------------------------------------------------------------------------------
    public void clear()
    {
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    //-------------------------------------------------------------------------------
    // Initalizes a new array with specified capacity
    //-------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    private void ensureCapacity(int capacity)
    {
        if(capacity < queue.length) return;
        E[] old = queue;
        this.queue = (E[]) new Object[capacity];
        for(int i = 0; i < this.size; i++)
        {
            this.queue[i] = old[i];
        }
    }

    //-----------------------------------------------------------------
    //  Returns true if this queue is empty and false otherwise. 
    //-----------------------------------------------------------------
    public boolean isEmpty()
    {
        return (rear == 0);
    }
    
    //-----------------------------------------------------------------
    //  Returns the number of elements currently in this queue.
    //-----------------------------------------------------------------
    public int size()
    {
        return rear;
    }

    //-----------------------------------------------------------------
    //  Returns a string representation of this queue. 
    //-----------------------------------------------------------------
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rear; i++) 
            result.append(queue[i].toString() + "\n");
        return result.toString();
    }
}
