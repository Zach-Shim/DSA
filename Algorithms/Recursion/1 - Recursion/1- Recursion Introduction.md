## What is Recursion?
Recursion is an extremely powerful problem-solving technique.
Problems that at first appear to be quite difficult often have simple recursive solutions.
## Divide and Conquer
A recursive solution solves a problem by solving a smaller instance of the same problem.

This technique is known as a ***divide-and-conquer*** approach, where you break a problem into smaller versions of itself that are the exact same type of problem as the original.

For example, suppose we are trying to solve problem P<sub>1</sub> recursively.
1. We could solve problem P<sub>1</sub> if we had the solution to problem P<sub>2</sub>, which is a smaller instance of P<sub>1</sub>.
2. We could also solve P<sub>2</sub> if we had the solution to problem P<sub>3</sub>, which is a smaller instance of P<sub>2</sub>.
3. If you knew the solution to P<sub>3</sub> because it was small enough to be trivial, you would be able to solve P<sub>2</sub>. You could then use the solution from P<sub>2</sub> to solve the original problem P<sub>1</sub>. 
## Recursion Properties
Recursive solutions have the following form:
1. A recursive function calls itself
2. Each recursive call solves an identical, but smaller, problem
3. Testing for a base case enables recursive calls to eventually stop (and not run forever)
4. Eventually, one of the smaller problems must be the base case

Questions to keep in mind as you build recursive solutions:
1. How can you define the problem in terms of a smaller problem of the same type?
2. How does each recursive call diminish the size of the problem?
3. What instance of the problem can serve as the base case?
4. As the problem size diminishes, will you eventually reach this base case or come to a solution?
## Recursion vs. Iteration
Recursion is an alternative to iteration.
	An iterative solution involves loops and an explicit Stack data structure.
	A recursive solution involves a function's repeated calls to itself using an implicit Call Stack.

Any recursive solution can be made into an iterative one.
Often, recursive solutions are impractical because they are so inefficient compared to their iterative counterpart.
However, recursion can be an elegant, simple solution to a problem of greater complexity.

>Iteration is more efficient, but recursion can be shorter and easier to understand.
