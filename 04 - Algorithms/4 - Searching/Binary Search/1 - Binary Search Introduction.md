https://usaco.guide/silver/binary-search?lang=cpp
### Real life problem

Imagine you have a dictionary, and want to find some words in it. But you want to do this without going through the whole dictionary. So what do you do?
### The Binary Search Model

How are you supposed to use a dictionary? 

You open it right down in the middle, and check a random word from the page where you opened it. 

Now, if your word starts with the letter `Q` and the word you found in the middle starts with letter `G`, you know that the whole first half of the dictionary is useless to you right now, since the word is definitely in the second half. So you only need to search further in the second half. 

You can treat the second half as a whole dictionary, and do the same thing: open at 3/4 of the dictionary, check a random word and split in half again, and so on.

This method might seem like something straight-forward, but if you take a more in-depth look at it, it truly is amazing: if your dictionary has 1000 pages, it will take you no more than 10 checks to find the page that contains your word! 

This is called the **_binary_** search method because at every step you split the domain in which you need to search in half. 

Therefore, to execute k checks, the initial domain must be of length at least 2k; so if the initial domain has length N, the number of checks required to find your desired element is log2N.
## Abstract

When we binary search on an answer, we start on a search space of size **N**.
Each iteration of binary search cuts the search space in half, so the algorithms tests logN values and takes O(logN) time to execute.

Binary search only works if the answer function is ***monotonic***, meaning that it is always non-decreasing or non-increasing.
## Binary Search On Monotonic Functions

Similarly to how binary search on an array only works on a sorted array, binary search on the answer only works if the answer function is [monotonic](https://en.wikipedia.org/wiki/Monotonic_function), meaning that it is always non-decreasing or always non-increasing.
