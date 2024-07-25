The first time you heard about how to find an element in a sorted array (before being taught binary search), you probably didn't jump to, 

> "Ah ha! We'll compare the target element to the midpoint and then recurse on the appropriate half! Duh!'

And yet, you could give someone who has no knowledge of computer science an alphabetized pile of
student papers and they'll likely implement something like binary search to locate a student's paper.
They'll probably say, "Gosh, Peter Smith? He'll be somewhere in the bottom of the stack: 'They'II pick a
random paper in the middle(ish), compare the name to "Peter Smith'; and then continue this process on the remainder of the papers. Although they have no knowledge of binary search, they intuitively "get it.'

Our brains are funny like this. Throw the phrase "Design an algorithm" in there and people often get all
jumbled up. But give people an actual example-whether just of the data (e.g., an array) or of the real-life
parallel (e.g., a pile of papers)-and their intuition gives them a very nice algorithm.

I've seen this come up countless times with candidates. Their computer algorithm is extraordinarily slow,
but when asked to solve the same problem manually, they immediately do something quite fast. (And it's
not too surprisingly, in some sense. Things that are slow for a computer are often slow by hand. Why would you put yourself through extra work?)

Therefore, when you get a question, try just working it through intuitively on a real example. Often a bigger example will be easier.

> **Example:** Given a smaller strings and a bigger string b, design an algorithm to find all permutations of the shorter string within the longer one. Print the location of each permutation.

Permutations are all possible rearrangements of a string. If the length of a String is N, there are N! possible permutations for that String. Each permutation must be contiguous (not split by other characters).

Think for a moment about how you'd solve this problem. 

If you're like most candidates, you probably thought of something like: Generate all permutations of `s` and then look for each in `b`. Since there are `S!` permutations, this will take `O(S! * B)` time, where `S` is the length of `s` and `B` is the length of `b`.

This works, but it's an extraordinarily slow algorithm. It's actually worse than an exponential algorithm. 
If s has 14 characters, that's over 87 billion permutations. 
Add one more character into s and we have 15 times more permutations. Ouch!

Approached a different way, you could develop a decent algorithm fairly easily. 
Give yourself a big example, like this one:

s: abbc
b: cbabadcbbabbcbabaabccbabc

Where are the permutations of s within b? 
Don't worry about how you're doing it. Just find them. 

Even a 12 year old could do this!
(No, really, go find them. I'll wait!)

I've underlined below each permutation.
![[Pasted image 20230925134336.png]]
Did you find these? How?

Few people, even those who earlier came up with the O(S! * B) algorithm-actually generate all the
permutations of abbc to locate those permutations in b. 

Almost everyone takes one of two (very similar) approaches:
1. Walk through b and look at sliding windows of 4 characters (since s has length 4). 
    Check if each window is a permutation of s.
2. Walk through b. Every time you see a character in s, check if the next four (the length of s) characters
are a permutation of s.

Depending on the exact implementation of the "is this a permutation" part, you'll probably get a runtime of either O(B S), O(B SlogS), or O(B S<sup>2</sup>).

None of these are the most optimal algorithm(there is an O(B) algorithm), but it's a lot better than what we had before.

Try this approach when you're solving questions. Use a nice, big example and intuitively-manually, that
is-solve it for the specific example. Then, afterwards, think hard about how you solved it. Reverse engineer
your own approach.

Be particularly aware of any "optimizations" you intuitively or automatically made. 
For example, when you were doing this problem, you might have just skipped right over the sliding window with "d" in it since "d" isn't in abbc. 
That's an optimization your brain made, and it's something you should at least be aware of in your algorithm.


