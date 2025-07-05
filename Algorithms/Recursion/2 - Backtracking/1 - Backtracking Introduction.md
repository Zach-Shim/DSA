Many programming problems can be solved by systematically **searching a set of *all possibilities***.
## **Formal Definition**
**Backtracking** is a general algorithm that recursively iterates over all possible configurations of a ***search space*** to find solutions to a problem.

Depending on our problem constraints, we attempt to find a ***solution space*** by exploring **possible candidate solutions** in the search space and **abandoning** (“backtracking”) once a given candidate is deemed unsuitable.

We try to view a ***problem*** as a sequence of **_choices_**. Therefore, we can think of this **_search space_** of possible answers that you want to explore as a **_decision tree_**.

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
Backtracking is essentially **depth-first search (DFS)** on an **implicit graph or tree** of possible configurations (also sometimes called a _state space_ or _search tree_).

**Backtracking** explores all possible configurations of a problem in a systematic way.

It builds up solutions **incrementally**, abandoning (backtracking from) a partial solution as soon as it determines that this partial solution **cannot possibly lead to a valid complete solution**.

This process is analogous to performing a **DFS traversal** on an **implicit graph**, where:   
**Nodes** represent **partial solutions** (configurations).
**Edges** represent **choices** or **transitions** that extend the partial solution.
The traversal **backtracks** when it reaches a node that cannot be extended to a valid solution.
## Goals of Backtracking
- Find ***a*** path to success
- Find ***all*** paths to success
- Find ***the best*** path to success

**Not all problems are exactly alike**, and finding one success node may not be the end of the search. Certain problems match certain patterns based on the problem constraint/goals.
## Algorithm

Pseudo code for recursive backtracking algorithms – **looking for *a* solution**

```Python
function backtrack(current_state):
	if at a solution or reached end/null state
		store/report success
		return
		
	for(each possible choice from current state) {
		make choice (modify state)
		backtrack(modified state)
		undo choice (backtrack to original state)
	}
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
https://courses.cs.washington.edu/courses/cse143/20wi/notes/notes17.html