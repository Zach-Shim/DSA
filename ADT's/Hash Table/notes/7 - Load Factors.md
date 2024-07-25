The **load factor** of a hash table is the **ratio** between the **number of elements** in the hash table to the **table size**. 

The symbol we use to define the load factor in a hash table is `λ`

![[Screenshot 2024-03-05 at 8.16.52 PM.png]]

Under chaining, the average number of elements per bucket is **λ**
So if some inserts are followed by random finds, then on average:
	Each unsuccessful find compares against λ items
	Each successful find compares against λ / 2 items

So we like to keep λ fairly low (e.g., 1 or 1.5 or 2) for chaining

In the example above, λ = 1.0. The average length of a list is λ. 
The effort required to perform a search is the constant time required to evaluate the hash function plus the time to traverse the list. In an unsuccessful search, the number of nodes to examine is λ on average. A successful search requires that about 1+(λ/2) links be traversed. To see this, notice that the list that is being searched contains the one node that stores the match plus zero or more other nodes. The expected number of “other nodes”


There will always be a trade off between space and time complexity. The bigger we make our hash table, the less likely we are to have collisions occur.