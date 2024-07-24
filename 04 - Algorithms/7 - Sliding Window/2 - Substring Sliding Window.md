Sliding window problems that involve strings can be broken down into a number of steps.
## **1. Identify the Problem Constraint**

We need to identify what will be the main constraint/condition will be to **grow** and **shrink** the window.
## **2. Grow and Shrink the Window**
In the sliding window technique, we maintain a window.

We grow or shrink the window depending on if we meet certain conditions (usually the main problem constraint).

This usually involves keeping two pointers on either end of the window.

That window itself can be in 3 different states:

**1.** **Growing**

While the window continues to meets satisfy the problem constraint, we continue to grow the window, updating the global/local tracker variables along the way. 

**2.** **Constraint No Longer Met**

Once the update the window and check that the problem constraint is no-longer satisfied, we begin to shrink until it is met again.

**3.** **Shrinking**

We now shrink the window UNTIL the constraint is satisfied again.

**4.** **Repeat:**

Now that the window constraint is no longer satisfied, we are back to State 1 and repeat this process until reaching the end of the collection

The window is unstable if it violates the problem constraints, and it tries to stabilize by increasing or decreasing its size.
## **3. Find Global and Local Tracker Variables**

Most sliding window techniques require you to keep global and local tracker variables.

These variable types will vary depending on the problem statement.

**‘Find the minimum value’**
1. keep a **min** value **global** tracker variable
2. keep a **min** value **local** value tracker variable to compare against the global

**‘Find the maximum value’**
1. keep a **max** value **global** tracker variable
2. keep a **max** value **local** value tracker variable to compare against the global

**‘Find the longest subset/substring’**
1. keep pointer to the front of the solution substring
2. keep pointer to the back of the solution substring 
3. take the substring between front and back once the algorithm has finished executing.

**‘Find the shortest subset/substring’**
1. keep pointer to the front of the solution substring
2. keep pointer to the back of the solution substring 
3. take the substring between front and back once the algorithm has finished executing.
## **Algorithm Flow**

1. Use two pointers: start and end to represent a window.
2. Iterate the end pointer in a loop until find a valid/invalid window.
3. When a valid/invalid window is found, store global/local variable trackers.
4. Move start to try and shrink the smallest window possible find a smaller window.
