Technical questions form the basis for how many of the top tech company’s interview.

Many candidates are intimidated by the difficulty of these questions, but there are logical ways to approach them.
## **Walking Though a Problem**

When working your way through a problem, use the approach outlined in the flowchart below.

**L**isten -> **E**xample -> **L**ist Constraints -> **B**rute Force -> **O**ptimize -> **W**alk Through -> **I**mplement -> **T**est

When in doubt, **ELBOW IT**
(We leave out Listen to make the acronym work and because it is the most obvious step)

##### 1. Listen Carefully

**Relevant Information**
Pay attention to any **relevant** or **unique** information.
    This goes beyond the standard "make sure you hear the problem correctly" advice.
    Yes, you do want to listen to the problem and make sure you heard it correctly, but we want to listen carefully to the problem and be sure that you've mentally recorded any **unique information** in the problem

For example: "Given two arrays that are sorted, find ..:'
    It's reasonable to assume that the information is there for a reason.
    You probably need to know that the data is **sorted** and that the optimal algorithm for the sorted situation is probably different than the optimal algorithm for the unsorted situation.

**Look Back on Information**
Many candidates will hear the problem correctly, but may eventually find that when developing an algorithm, something doesn’t work.
    Here it is important to often **look back at all the information** you were given and ask yourself if you've used all the information in the problem.

**Take Notes**
If possible, you should record all the possible information such as:
- **Input**: Input parameters and relevant information/constraints about them
- **Goal(s)**: The goals of what you are actually trying to do or solve
- **Return**: What you are returning is based on the parameters and your goal.

These should all be presented to you in the problem.

##### 2. Draw an Example

Drawing an example can help **visualize** the algorithm you want to make.
Often, this goes hand in hand with step 3/4, when you try and create a **brute force** solution.
When you hear a question, get out of your chair, and go draw an example on the whiteboard. 

**Start Simple**
You want to start out by drawing out a **common example**.
An ideal example will be
1. **Specific**.
    It should use real numbers or strings (if applicable to the problem).

2. **Sufficiently large**.
    Most examples are too small, by about 50%.

3. **Not a special case**.
    Be careful. It's very easy to inadvertently draw a special case.

If there's any way your example is a special case, you should fix it.
Try to make the best example you can. If it later turns out your example isn't quite right, you can and should fix it.

##### 3. List Constraints

Clearly defining the problem statements and drawing/writing out example should bring you to
1. **Ask Clarifying Questions**: 
    ask questions about anything you're unsure about
2. **Define Constraints**: 
    write down possible constraints from the problem description
3. **Define Edge Cases:**
    once you draw/write out a simple example, think about common and special edge cases

##### 4. State a Brute Force

We will often intermix steps 1/2/3 when creating a brute force solution.

**Throw Out Ideas**
**Ideate and state** a solution that **first comes to your mind**.
State a brute force even if it's obvious and terrible.

You don’t have to implement it yet, just get your idea out there.
It's okay if your initial algorithm is not optimal (will get fixed later).

Even if the brute force obvious for you, it's not necessarily obvious for all candidates.
You don't want your inter­viewer to think that you're struggling to come up with an easy solution.

**Brute Force Process**
Here is the usual thought process for a brute force:
1. Create an example and think of a brute force way to solve the problem.
2. Walk through the brute force solution while marking the example.
3. Explain what the space and time complexity is.

Despite being possibly slow, a brute force algorithm is valuable to discuss.
It's a **starting point for optimiza­tions**, and it helps you wrap your head around the problem.

When coming up with brute force solutions, you often want to think of solving a problem in its most basic form. Try DIY to think about a problem intuitively first before thinking about it like a programmer. 
##### 5. Optimize

Once you have a brute force algorithm, you should work on optimizing it.
Walk through the brute force ideas with these following techniques in mind:

1. **Look for any unused information**
    You usually need all the unique/relevant information to solve a problem
    How can you leverage that information?

2. **Solve it on an example drawing**
    Use your algorithm to solve an example.

3. **Use a fresh example**
    Sometimes, just seeing a different example will unclog your mind or help you see a pattern in the problem.

4. **Solve it "incorrectly"**
    Just like having an inefficient solution can help you find an efficient solution, having an incorrect solution might help you find a correct solution. Think Simplify and Generalize.

5. **Precompute information.**
    Is there a way that you can reorganize the data (sorting, etc.) or compute some values upfront that will help save time in the long run?

6. **Use a hash table.**
    Hash tables are widely used in interview questions and should be at the top of your mind.

7. **Make time vs. space tradeoff**
    Sometimes storing extra state about the problem can help you optimize the runtime.

8. **Think about the best conceivable runtime.**
    Walk through the brute force with these ideas in mind and look for BUD.

##### 6. Walk Through

**Solidify Your Understanding Before Coding**
After you've gotten an optimal algorithm, **don't immediately start coding**.
Take a moment to solidify your understanding of the algorithm.

**Whiteboard coding is slow, very slow**. 
It takes even longer once you have to test and fix it.
As a result, you need to make sure that you get your algorithm as close to "perfect" in the beginning as possible.

**Write Down A Walkthrough**
Write down a high-level walkthrough of your algorithm through words, pseudocode, and drawings.
This will help you get a feel for the structure of the code. Know what the variables are and when they change.

If you don't understand exactly what you're about to write, you'll struggle to code it.
It will take you longer to finish the code, and you're more likely to make major errors.

Remember that you only have a limited amount of time, though. So, while this step is important, do not spend too much time here.

##### 7. **Implement**

**Code Starting On Top Left**
Now that you have an optimal algorithm and you know exactly what you're going to write, go ahead and implement it.

Start **coding in the far top left corner of the whiteboard** (you'll need the space).
Avoid "line creep" (where each line of code is written an awkward slant). It makes your code look messy and can be very confusing.

**Write Beautiful Code**
Remember that you only have a short amount of code to demonstrate that you're a great developer. 

Everything counts.

**Beautiful code means:**
1. **Modularized code.**
    This shows good coding style. It also makes things easier for you.
    If your algorithm uses a matrix initialized to {{1, 2, 3}, {4, 5, 6}, ...}, don't waste your time writing this initialization code. Just pretend you have a function initlncrementalMatrix(int size). Fill in the details later if you need to.

2. **Error checks.**
    Some interviewers care a lot about this, while others don't.
    A good compromise here is to add a todo and then just explain out loud what you'd like to test.

3. **Use other classes/structs where appropriate.**
   If you need to return a list of start and end points from a function, you could do this as a two-dimensional array. It's better though to do this as a list of StartEndPair (or possibly Range) objects. You don't necessarily have to fill in the details for the class. Just pretend it exists and deal with the details later if you have time.

4. **Good variable names.**
   Code that uses single-letter variables everywhere is difficult to read.
   That's not to say that there's anything wrong with using i and j, where appropriate (such as in a basic for-loop iter­ating through an array).
   However, be careful about where you do this. If you write something like int i = startOfChild ( array), there might be a better name for this variable, such as startChild.
   Long variable names can also be slow to write though. A good compromise that most interviewers will be okay with is to abbreviate it after the first usage. You can use startChild the first time, and then explain to your interviewer that you will abbreviate this as sc after this.

##### 8. **Test**

You wouldn't submit code to manager before checking it.
Likewise, you shouldn’t "submit" code in an inter­view without testing it either.

There are smart ways to test your code and not-so-smart ways.
What many candidates do is take their earlier example from Step 2 and test it against their code. That might discover bugs, but it'll take a **_really long time_** to do so.

**Hand Testing Is Very Slow**
If you really did use a nice, big example to develop your algorithm, then it'll take you a very long time to find that little off-by-one error at the end of your code.

Instead, try this approach:
1. **Start with a "conceptual" test.**
    A conceptual test means just **reading and analyzing what each line of code does**.
    Think about it like you're explaining the lines of code for a code reviewer.
    Does the code do what you think it should do?

2. **Weird looking code.**
    Double check that line of code that says x = length - 2.
    Investigate that for loop that starts at i = 1.
    While you undoubtedly did this for a reason, it's really easy to get it just slightly wrong.

3. **Hot spots.**
    You've coded long enough to know what things are likely to cause problems.
    - Base cases in recursive code.
    - Integer division. Integer Overflow.
    - Null nodes in binary trees, linked list, and graph.
    - The start and end of iteration through a linked list.
	
	Double check that stuff.

4. **Small test cases.**
    This is the first time we use an actual, specific test case to test the code.
    Don't use that nice, big 8-element array from the algorithm part.
    Instead, use a 3 or 4 element array.
    It'll likely discover the same bugs, but it will be much faster to do so.

5. **Special cases.**
    Test your code against null or single element values, the extreme cases, and other special cases.
    When you find bugs (and you probably will), you should of course fix them.
    But don't just make the first correction you think of.
    Instead, carefully analyze why the bug occurred and ensure that your fix is the best one.