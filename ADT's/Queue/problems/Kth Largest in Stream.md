Some problems ask us to find the `kth` largest element in some stream or structure.
`k` should be given as an input variable.

Algorithm:
1. Initialize a minheap with a maximum size of k.
2. As elements arrive in the stream, add them to the minheap.
3. If the size of the heap exceeds k, remove the smallest element (top element) from the heap.
4. At any time, the top element of the min heap will be the kth largest element in the stream.

Something to note, we intentionally make the size of the priority queue size k+1 when we try to insert into a full priority queue. That way, we can remove the largest element from the queue.

This follows the `add` function code:
```Java
public int add(int val) {
	pq.offer(val);
	if(pq.size() > cap)
		pq.poll();
	return pq.peek();
}
```

