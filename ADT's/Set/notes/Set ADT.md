A **`set`** is a collection of unique values (no duplicates) that can perform the following operations:
1. `add`
2. `remove`
3. `contains`

The client doesn't think of a **`set`** as having indices like a list.
We just add things to the **`set`** and don't worry about the order.

![[Pasted image 20230817131701.png]]
##### Implementation Strategies
| Data Structure | add | remove | contains |
| ---------- | --------- | --------- | --------- |
| Unsorted Collection | O(1) | O(n) | O(n) |
| Sorted Collection | O(n) | O(n) | O(logn) |
| Balanced BST | O(logn) | O(logn) | O(logn) |
##### **Unsorted Collection Set**
It doesn't really matter what order the elements appear in a set, so long as they can be added, removed, and searched quickly.

If we add new elements to the end of the collection (either add a node or add to the next available index) like we do in a list, then
1. **add** takes O(1) because we simply append to the end of the list
2. **remove** takes O(N) because we must shift elements down
3. **contains** takes O(N) because we must search the whole array

![[Pasted image 20230817131835.png]]
##### **Sorted Collection Set**
Suppose we ordered the elements in the array in sorted order instead of insertion order.

If we add new elements to the end of the list (or the next available index), as we do in a list, then
1. **add** takes O(N) because we must shift elements up to make room
2. **remove** takes O(N) because we must shift elements down to make room
3. **contains** takes O(logN) because we can perform binary search on a sorted array to find a value

![[Pasted image 20230817131924.png]]

Is there a way we can efficiently get these operations down to O(1) time?