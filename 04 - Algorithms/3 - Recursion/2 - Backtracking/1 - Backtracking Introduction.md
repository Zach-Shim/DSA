Many programming problems can be solved by systematically **searching a set of *all possibilities***.
## **Formal Definition**

Recursive Backtracking is a general algorithm for finding solutions to a problem 

Backtracking is a systematic method of iterating through all possible configurations of a search space.

Depending on our problem constraints, we attempt to find a ***solution space*** by exploring **possible candidate** solutions and **abandoning** (“backtracking”) once a given candidate is deemed unsuitable.

We try to view a problem as a sequence of **_choices_**.
From this sequence of choices, there is **_solution space_** of possible answers that you want to explore which allows us to think of the solution space as a **_decision tree_**.

Backtracking involves searching all possibilities, so it can be an **expensive** technique to use.
But many problems are small enough in scope that they are nicely solved with a backtracking approach.
## Examples

If you want to find a path through a maze from a starting point to an exit point, you can explore **all possible paths** through the maze until you find one that works.

If you want to find all possible moves and countermoves in a game of tic-tac-toe, you can explore all possible moves to see if there is some move that guarantees that you a win.

Some more examples include:
1. Place N Queens on an N by N chessboard so that none of them can attack each other.
2. Fill out the rest of a partially solved 9x9 Sudoku board. 
3. Find all subsets/combinations
4. Solve minesweeper
## Backtracking and DFS

Backtracking is really just depth-first search on an implicit graph of configurations.
- Backtracking can easily be used to iterate through all subsets or permutations of a set.
- Backtracking ensures correctness by enumerating all possibilities.
- For backtracking to be efficient, we must **prune** dead or redundant branches of the search space whenever possible.

## Recursive Backtracking

Many of these **exhaustive search problems** can be solved with an approach called **_backtracking_**. 
It is a problem-solving approach that is nicely expressed using **recursion**.
As a result, it is sometimes referred to as _recursive backtracking_.
- **Recursive** because later versions of the problem are just slightly simpler versions of the original
- **Backtracking** because we may have to try different alternative paths
## Goals of Backtracking

Possible goals:
- Find ***a*** path to success
- Find ***all*** paths to success
- Find ***the best*** path to success

**Not all problems are exactly alike**, and finding one success node may not be the end of the search. Certain problems match certain patterns based on the problem constraint/goals.
## Algorithm

Pseudo code for recursive backtracking algorithms – **looking for *a* solution**

```Java
if at a solution
	store/report success
	
for(every possible choice from current state) {
	make a choice and take one step along that choice path
	use recursion to try and solve the problem for the new state
	if the recursive call succeeds
		report the success to the previous level
	else
		back out of the current choice to restore the state at the start of the loop
}

if no solution space is found, report failure
```

At each step in the backtracking algorithm, we start from a given partial solution, and try to
extend it by adding another element at the end.
After extending it, we test whether what we have so far is a complete solution.
If not, the critical issue is whether the current partial solution is potentially extendible to a solution.
	• If so, recur and continue.
	• If not, delete the last element from a and try another possibility for that position if one exists.
## Runtime

When you have a recursive function that makes multiple calls, the runtime will often (but not always) look like O(branches<sup>depth</sup>).

where branches is the number of times each recursive call branches.
where depth is the farthest the call stack goes in DFS.


**Good Resources:**
https://www.cs.utexas.edu/~scottm/cs314/handouts/slides/Topic13RecursiveBacktracking.pdf
https://cs.lmu.edu/~ray/notes/backtracking/
