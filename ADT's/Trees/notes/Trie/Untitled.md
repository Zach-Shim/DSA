The basic idea of the Trie is to store the suffixes in a tree. 

1. At the root, instead of having two branches, we would have one branch for each possible first character (if just dealing with alphabet, this would be 26 possible options). 
2. Then at the next level, we would have one branch for the next character (another 26 possible options).
3. and so on for each level … 

At each level we are doing multiway branching, and thus if we wanted to find a matching word/suffix, we can do so in N time where N is the length of the match.

## Example

We look at Figure 12.25.

![[Pasted image 20230919113752.png]]
##### Left Tree
The left tree shows a Trie to store the suffixes of the string `deed`.
- internal branching nodes are drawn in circles
- the suffixes that are reached are drawn in rectangles

These suffixes are:
- d
- deed
- ed
- eed

Each branch is labeled with the character that is chosen, but the branch prior to a completed suffix has no label.

This representation could waste significant space if there are many nodes that have only one child. 
Thus in Figure 12.25, we see an equivalent representation on the right, known as a compressed trie. 
##### Right Tree

Single-branch nodes are collapsed into a single node. 
Notice that although the branches now have multicharacter labels, all the labels for the branches of any given node must have unique first characters. 

Thus it is still just as easy as before to choose which branch to take. 
Thus we can see that a search for a pattern P depends only on the length of the pattern P, as desired. (We assume that the letters of the alphabet are represented by numbers 1, 2, . . . . Then each node stores an array representing each possible branch and we can locate the appropriate branch in constant time. The empty edge label can be represented by 0.)

If the original string has length N, the total number of branches is less than 2N.

However, this by itself does not mean that the compressed trie uses linear space: The labels on the edges take up space. The total length of all the labels on the compressed trie in Figure 12.25 is exactly one less than the number of internal branching nodes in the original trie in Figure 12.25. And of course writing all the suffixes in the leaves could