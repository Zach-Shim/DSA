## The Three Laws of Recursion

All recursive algorithms must obey three important laws:
1. A recursive algorithm must have a **base case**.
2. A recursive algorithm must change its state and move toward the base case.
3. A recursive algorithm must call itself, recursively.

## Calculating the Sum of a List of Numbers

Suppose that you want to calculate the sum of a list of numbers such as: [1,3,5,7,9]. 

Let's solve a problem we already know how to solve without using recursion.
Here is an iterative solution:
```Java
private int listSum(List<Integer> numList) {
	int sum = 0;
	for(Integer i : numList) {
		sum += i;
	}
	return sum;
}
```
The function uses an accumulator variable (`theSum`) to compute a running total of all the numbers in the list by starting with 0 and adding each number in the list.

Pretend for a minute that you do not have `while` loops or `for` loops. How would you compute the sum of a list of numbers? If you were a mathematician you might start by recalling that addition is a function that is defined for two parameters, a pair of numbers. 

To redefine the problem from adding a list to adding pairs of numbers, we could rewrite the list as a fully parenthesized expression. Such an expression looks like this:
<math xmlns="http://www.w3.org/1998/Math/MathML" display="block">
  <mo stretchy="false">(</mo>
  <mo stretchy="false">(</mo>
  <mo stretchy="false">(</mo>
  <mo stretchy="false">(</mo>
  <mn>1</mn>
  <mo>+</mo>
  <mn>3</mn>
  <mo stretchy="false">)</mo>
  <mo>+</mo>
  <mn>5</mn>
  <mo stretchy="false">)</mo>
  <mo>+</mo>
  <mn>7</mn>
  <mo stretchy="false">)</mo>
  <mo>+</mo>
  <mn>9</mn>
  <mo stretchy="false">)</mo>
</math>
We can also parenthesize the expression the other way around:
<math xmlns="http://www.w3.org/1998/Math/MathML" display="block">
  <mo stretchy="false">(</mo>
  <mn>1</mn>
  <mo>+</mo>
  <mo stretchy="false">(</mo>
  <mn>3</mn>
  <mo>+</mo>
  <mo stretchy="false">(</mo>
  <mn>5</mn>
  <mo>+</mo>
  <mo stretchy="false">(</mo>
  <mn>7</mn>
  <mo>+</mo>
  <mn>9</mn>
  <mo stretchy="false">)</mo>
  <mo stretchy="false">)</mo>
  <mo stretchy="false">)</mo>
  <mo stretchy="false">)</mo>
</math>
Notice that the innermost set of parentheses, (7+9), is a problem that we can solve without a loop or any special constructs. In fact, we can use the following sequence of simplifications to compute a final sum.
<math xmlns="http://www.w3.org/1998/Math/MathML" display="block">
  <mtable displaystyle="true" columnalign="right" columnspacing="0em" rowspacing="3pt">
    <mtr>
      <mtd>
        <mi>t</mi>
        <mi>o</mi>
        <mi>t</mi>
        <mi>a</mi>
        <mi>l</mi>
        <mo>=</mo>
        <mtext>&#xA0;</mtext>
        <mo stretchy="false">(</mo>
        <mn>1</mn>
        <mo>+</mo>
        <mo stretchy="false">(</mo>
        <mn>3</mn>
        <mo>+</mo>
        <mo stretchy="false">(</mo>
        <mn>5</mn>
        <mo>+</mo>
        <mo stretchy="false">(</mo>
        <mn>7</mn>
        <mo>+</mo>
        <mn>9</mn>
        <mo stretchy="false">)</mo>
        <mo stretchy="false">)</mo>
        <mo stretchy="false">)</mo>
        <mo stretchy="false">)</mo>
      </mtd>
    </mtr>
    <mtr>
      <mtd>
        <mi>t</mi>
        <mi>o</mi>
        <mi>t</mi>
        <mi>a</mi>
        <mi>l</mi>
        <mo>=</mo>
        <mtext>&#xA0;</mtext>
        <mo stretchy="false">(</mo>
        <mn>1</mn>
        <mo>+</mo>
        <mo stretchy="false">(</mo>
        <mn>3</mn>
        <mo>+</mo>
        <mo stretchy="false">(</mo>
        <mn>5</mn>
        <mo>+</mo>
        <mn>16</mn>
        <mo stretchy="false">)</mo>
        <mo stretchy="false">)</mo>
        <mo stretchy="false">)</mo>
      </mtd>
    </mtr>
    <mtr>
      <mtd>
        <mi>t</mi>
        <mi>o</mi>
        <mi>t</mi>
        <mi>a</mi>
        <mi>l</mi>
        <mo>=</mo>
        <mtext>&#xA0;</mtext>
        <mo stretchy="false">(</mo>
        <mn>1</mn>
        <mo>+</mo>
        <mo stretchy="false">(</mo>
        <mn>3</mn>
        <mo>+</mo>
        <mn>21</mn>
        <mo stretchy="false">)</mo>
        <mo stretchy="false">)</mo>
      </mtd>
    </mtr>
    <mtr>
      <mtd>
        <mi>t</mi>
        <mi>o</mi>
        <mi>t</mi>
        <mi>a</mi>
        <mi>l</mi>
        <mo>=</mo>
        <mtext>&#xA0;</mtext>
        <mo stretchy="false">(</mo>
        <mn>1</mn>
        <mo>+</mo>
        <mn>24</mn>
        <mo stretchy="false">)</mo>
      </mtd>
    </mtr>
    <mtr>
      <mtd>
        <mi>t</mi>
        <mi>o</mi>
        <mi>t</mi>
        <mi>a</mi>
        <mi>l</mi>
        <mo>=</mo>
        <mtext>&#xA0;</mtext>
        <mn>25</mn>
      </mtd>
    </mtr>
  </mtable>
</math>
How can we take this idea and turn it into a program? 

First, let’s restate the sum problem in terms of Python lists. We might say the the sum of the list `numList` is the sum of the first element of the list (`numList[0]`), and the sum of the numbers in the rest of the list (`numList[1:]`). 

To state it in a functional form:
```Java
private int listSum(List<Integer> numList, int i = 0) {
	if(numList.length() == i) {
		return 0;
	}
	return numList[i] + listSum(numList, i+1);
}
```

There are a few key ideas in this listing to look at. First, on line 2 we are checking to see if the list is one element long. This check is crucial and is our escape clause from the function. The sum of a list of length 1 is trivial; it is just the number in the list. Second, on line 5 our function calls itself! This is the reason that we call the `listsum` algorithm recursive. A recursive function is a function that calls itself.

[Figure 1](https://runestone.academy/ns/books/published/pythonds/Recursion/pythondsCalculatingtheSumofaListofNumbers.html#fig-recsumin) shows the series of **recursive calls** that are needed to sum the list [1,3,5,7,9]. You should think of this series of calls as a series of simplifications. Each time we make a recursive call we are solving a smaller problem, until we reach the point where the problem cannot get any smaller.
(https://runestone.academy/ns/books/published/pythonds/_images/sumlistIn.png)

When we reach the point where the problem is as simple as it can get, we begin to piece together the solutions of each of the small problems until the initial problem is solved. [Figure 2](https://runestone.academy/ns/books/published/pythonds/Recursion/pythondsCalculatingtheSumofaListofNumbers.html#fig-recsumout) shows the additions that are performed as `listsum` works its way backward through the series of calls. When `listsum` returns from the topmost problem, we have the solution to the whole problem.
(https://runestone.academy/ns/books/published/pythonds/_images/sumlistOut.png)