Some people find it confusing to write code that involves expressions like `current.next.data`. 

Another approach is to use a pair of pointers that keep track of a `current` and a `previous` position in the list. In effect, the pointers keep track of a ***two element window*** on the list.

![[Pasted image 20230913112144.png]]

As an analogy, consider an inchworm that is two nodes in length. 
When the inchworm stretches out, its back half is on one node and the front half is on another node.
To move forward, it scoots its back half up to where the front half is, then scoots the
front half onto the next node. 

This is exactly analogous to the code you’d use to move this pair of variables forward one spot:

```Java
prev = current;
current = current.next;
```

You can set `prev` equal to `null` initially in order to eliminate the special case for the front of the list. 
