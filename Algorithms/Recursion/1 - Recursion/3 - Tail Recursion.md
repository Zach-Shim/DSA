## Traditional Recursion
In **traditional recursion**, the typical model is that you perform your recursive calls first, and then you take the return value of the recursive call and calculate the result. 

Therefore, you don't get the result of your calculation until you have returned from every recursive call.
## Tail Recursion

In **tail recursion**, you perform your calculations first, and then you execute the recursive call, passing the results of your current step to the next recursive step. 

**Basically, the return value of any given recursive step is the same as the return value of the next recursive call**.

>Tail recursion refers to a recursive call at the last line. 
>By the time you reach the base case, the same return value will cascade back down the call stack. Tail recursion can b directly translated to loops.

This is because we will be done with calculations when we reach the base case, so when we start returning, no matter how far we are into the stack, we return the same value from the base case all the way to the beginning.

**How to Eliminate Tail Recursion?**
Tail recursion can be mechanically eliminated by enclosing the body in a while loop and replacing the recursive call with one assignment per method argument. 

This simulates the recursive call because nothing needs to be saved; after the recursive call finishes, there is really no need to know the saved values. Because of this, we can just go to the top of the method with the values that would have been used in a recursive call.

Consider a simple function that adds the first N natural numbers. (e.g. `sum(5) = 0 + 1 + 2 + 3 + 4 + 5 = 15`).

Here is a simple Java implementation that uses non-tail recursion:

```java
public int recsum(int x) {
    if (x === 0) {
        return 0;
    } else {
        return x + recsum(x - 1);
    }
}
```

If you called `recsum(5)`, this is what the Java interpreter would evaluate:

```java
recsum(5)
5 + recsum(4)
5 + (4 + recsum(3))
5 + (4 + (3 + recsum(2)))
5 + (4 + (3 + (2 + recsum(1))))
5 + (4 + (3 + (2 + (1 + recsum(0)))))
5 + (4 + (3 + (2 + (1 + 0))))
5 + (4 + (3 + (2 + 1)))
5 + (4 + (3 + 3))
5 + (4 + 6)
5 + 10
15
```

Note how every recursive call has to complete before the JavaScript interpreter begins to actually do the work of calculating the sum.

Here's a tail-recursive version of the same function:

```java
public int tailrecsum(int x, int running_total = 0) {
    if (x === 0) {
        return running_total;
    } else {
        return tailrecsum(x - 1, running_total + x);
    }
}
```

Here's the sequence of events that would occur if you called `tailrecsum(5)`, (which would effectively be `tailrecsum(5, 0)`, because of the default second argument).

```java
tailrecsum(5, 0)
tailrecsum(4, 5)
tailrecsum(3, 9)
tailrecsum(2, 12)
tailrecsum(1, 14)
tailrecsum(0, 15)
15
```

In the tail-recursive case, with each evaluation of the recursive call, the `running_total` is updated.

**Difference between Traditional vs. Tail**
The difference is that
- With **_tail recursion_**, the final answer is calculated by the LAST invocation of the method alone. This final answer is returned, meaning all the frames on the stack return the same value.
- With **_traditional recursion_**, the final answer is calculated at the beginning, rather than the end. We need to keep the state of all recursive call return results for all frames to calculate the answer.