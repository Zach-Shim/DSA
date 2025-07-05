//********************************************************************
//  CircularQueue.java       
//
//  Represents an array implementation of a queue in which the
//  indexes for the front and rear of the queue circle back to 0
//  when they reach the end of the array.
//
// references: 
// http://www.cs.columbia.edu/~bauer/cs3134-f15/code/week4/CircularArrayQueue.java
// http://faculty.washington.edu/moishe/javademos/ch07%20Code/jss2/CircularArrayQueue.java 
//********************************************************************

import exception.*;
import java.util.*;

public class CircularQueue<E> implements QueueADT<E> 
{
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int front;
    private int back;
    private E[] queue;

    /* ------------------------------------ CONSTRUCTORS ------------------------------------ */

    //-------------------------------------------------------------------------------
    //  Creates an empty queue using the default capacity.
    //-------------------------------------------------------------------------------
    public CircularQueue()
    {
        this(DEFAULT_CAPACITY);
    }

    //-------------------------------------------------------------------------------
    //  Creates an empty queue using the specified capacity.
    //-------------------------------------------------------------------------------
    public CircularQueue(int initCapacity)
    {
        if(initCapacity < 0) 
            throw new IllegalArgumentException("IllegalCapacity: " + initCapacity);
        clear();
    }

    //-------------------------------------------------------------------------------
    //  Adds the specified element to the rear of the queue.
    //  Expands the capacity of the queue array if necessary.
    //-------------------------------------------------------------------------------
    public void enqueue(E e)
    {
        // test if queue is full
        if(size == queue.length) ensureCapacity(size * 2 + 1);
        queue[back] = e;
        back = (back + 1) % queue.length;
        size++;
    }

    //-------------------------------------------------------------------------------
    //  Removes the element at the front of the queue and returns a reference to it. 
    //  Throws an EmptyCollectionException if the queue is empty.
    //-------------------------------------------------------------------------------
    public E dequeue() throws EmptyCollectionException
    {
        if(isEmpty()) throw new EmptyCollectionException("queue");
        
        E result = queue[front];
        queue[front] = null;

        front = (front + 1) % queue.length;
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
        ensureCapacity(DEFAULT_CAPACITY);
        size = 0;
    }

    //-------------------------------------------------------------------------------
    // Initalizes a new array with specified capacity
    //-------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    private void ensureCapacity(int capacity)
    {
        if(capacity < queue.length) return;
        E[] old = this.queue;
        this.queue = (E[]) new Object[capacity];
        for(int i = 0; i < this.size; i++)
        {
            this.queue[i] = old[(front + i) % old.length];
        }
        front = 0;
        back = old.length;
    }

    //-------------------------------------------------------------------------------
    //  Returns true if this queue is empty and false otherwise. 
    //-------------------------------------------------------------------------------
    public boolean isEmpty()
    {
        return (size == 0);
    }
    
    //-------------------------------------------------------------------------------
    //  Returns the number of elements currently in this queue.
    //-------------------------------------------------------------------------------
    public int size()
    {
        return size;
    }

    //-------------------------------------------------------------------------------
    //  Returns a string representation of this queue. 
    //-------------------------------------------------------------------------------
    public String toString()
    {
        StringBuilder result = new StringBuilder("[ ");
        for(int i = 0; i < this.size; i++)
        {
            result.append(this.queue[(front + i) % queue.length]);
        }
        result.append(" ]");
    
        return result.toString();
    }
}
