import java.util.Arrays;
import java.util.Comparator;

public class BinaryHeap<E extends Comparable<? super E>> implements PriorityQueue<E>
{
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    
    /* ------------------------------------------------------------ */

    private E[] heap;
    private int size = 0;
    
    /* ------------------------------------------------------------ */

    private Comparator<? super E> comparator;

    /* ------------------------------------------------------------ */
    
    public BinaryHeap()
    {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public BinaryHeap(int initCapacity)
    {
        if(initCapacity < 1 || initCapacity > MAX_ARRAY_SIZE)
            throw new IllegalArgumentException();
        
        clear();
    }

    @SuppressWarnings("unchecked")
    public BinaryHeap(E[] items)
    {
        // initialize heap
        size = items.length;
        this.heap = (E[]) new Object[size];
        
        // create complete binary tree
        int i = 1;
        for(E e : items) heap[i++] = e;

        // restore heap order
        for(int j = size / 2; j > 0; j--) percolateDown(i);
    }

    public BinaryHeap(Comparator<? super E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    public BinaryHeap(int capacity, Comparator<? super E> comparator) {
        this(capacity);
        this.comparator = comparator;
    }

    /* ------------------------------------------------------------ */

    /**
     * Inserts the specified element into this priority queue.
     * @param e - the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws ClassCastException if the specified element cannot be
     *         compared with elements currently in this priority queue
     *         according to the priority queue's ordering
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean add(E e) 
    {
        // error check size
        if(size == heap.length - 1)
            ensureCapacity(heap.length * 2 + 1);

        // 1. create hole
        int hole = ++size;

        // 2. percolate up
        for(heap[0] = e; e.compareTo(heap[hole / 2]) < 0; hole /= 2)
            heap[hole] = heap[hole / 2];    
        
        // 3. do not insert item until the end
        heap[hole] = e;

        return true;
    }

    /* ------------------------------------------------------------ */

    @Override
    public void clear()
    {
        // create new array and no values copied over from previous heap
        size = 0;
        ensureCapacity(DEFAULT_INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int capacity)
    {
        // no point in shrinking array capacity if size is larger
        if(capacity < this.size)
            return;
        
        // copy over old contents to new larger array
        E[] oldHeap = this.heap;
        this.heap = (E[]) new Object[capacity];
        for(int i = 0; i < size; i++)
            this.heap[i] = oldHeap[i];
    }

    /* ------------------------------------------------------------ */

    @Override
    public boolean contains(Object o) 
    {
        return indexOf(o) != -1;
    }

    private int indexOf(Object o) 
    {
        if(o != null) {
            for(int i = 0; i < size; i++) {
                if(o.equals(heap[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* ------------------------------------------------------------ */

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    /* ------------------------------------------------------------ */

    /**
     * Removes and returns the minimum element from the heap
     * @param none
     * @return {@code E} the top element in the heap
     * @throws UnderflowException if the heap is empty
     */
    @Override
    public E remove()
    {
        // error check size
        if(isEmpty())
            throw new NullPointerException("Empty collection");

        // 1. save and delete minimum root element from heap
        E minItem = peek();

        // 2. replace and delete root item with last leaf (size is equal to index value because whole heap array is shifted one index forward to leave room at heap[0])
        heap[1] = heap[size--];

        // 3. percolate the root down the tree to restore heap order
        percolateDown(1);

        // 4. return the min item from the heap
        return minItem;
    }

    /**
     * Removes and returns the minimum element from the heap
     * @param hole the index of the item in the tree to percolate down
     */
    private void percolateDown(int hole)
    {
        int child;
        E temp = heap[hole];
        while(hole < size)
        {
            child = hole * 2;

            // extra test in case node only has one child. child to swap is smaller of two children
            if(child != size && heap[child+1].compareTo(heap[child]) < 0)
                child++;
            
            // if child is smaller than parent, place the child in the hole
            if(heap[child].compareTo(heap[hole]) < 0)
                heap[hole] = heap[child];

            // if child is larger than parent, we are restored heap order
            else 
                break;
            
            hole = child;
        }
        
        // place saved original object to hole
        heap[hole] = temp;
    }

    /* ------------------------------------------------------------ */

    @Override
    public E peek()
    {
        return heap[1];
    }

    /* ------------------------------------------------------------ */
    /**
     * Builds a heap from scratch using the values in a collection by running successive inserts O(nlogn)
     * @param items
     */
    @SuppressWarnings("unchecked")
    public void buildHeap(E[] items)
    {
        // copy size and elements from items to heap O(N)
        size = items.length;
        this.heap = (E[]) new Object[size];
        for(int i = 0; i < size; i++)
        {
            this.heap[i] = items[i];
        }

        // restore heap order O(N)
        for(int i = size / 2; i > 0; i--)
        {
            percolateDown(i);
        }
    }

    /* ------------------------------------------------------------ */
    
    public Object[] heapSort(E[] items)
    {    
        BinaryHeap<E> minheap = new BinaryHeap<E>(items);

        int n = items.length;
        for(int i = 0; i < n; i++) 
        {
            minheap.heap[n - i - 1] = minheap.peek();
            minheap.remove();
        }

        return minheap.toArray();
    }

    /* ------------------------------------------------------------ */

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();
        output.append("{");
        for(int i = 0; i < size; i++) output.append(heap[i] + ",");
        output.deleteCharAt(output.length() - 1);
        output.append("}");
        return output.toString();
    }

    /* ------------------------------------------------------------ */

    public Object[] toArray()
    {
        return Arrays.copyOf(this.heap, this.heap.length);
    }

    @Override
    public int size() {
        return size;
    }
}