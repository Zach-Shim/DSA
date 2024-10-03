Performance of recursive algorithms typically specified with **recurrence equations**  
Recurrence relations have specifically to do with **sequences** (eg Fibonacci Numbers)
##### Analyzing Performance of Non-Recursive Routines is (relatively) Easy

1. Single Loop: _T(n)_ = Θ(n)
```
for i in 1 .. n
```
2. Nested Loop: _T(n)_ = Θ(n<sup>2</sup>)
```
for i in 1 .. n
    for j in 1 .. n
```
3. Multiple Nested Loops: _T(n)_ = Θ(n<sup>3</sup>)
```

for i in 1 .. n
	for j in 1 .. n
        for k in 1 .. n
```
4. … and so on
##### Analyzing Recursive Routines

Analysis of recursive routines is not as easy: consider factorial
```
fac(n) is
    if n = 1 
		return 1
    else 
	    return n * fac(n-1) 
```

How many times is fac called for fac(_n_)?  
To find an answer, use a recurrence

A recurrence defines _T(n)_ in terms of _T_ for smaller values

Example: _T(n) = T(n-1) + 1_
_T(n)_ is defined in terms of _T(n-1)_

Recurrences are used in analyzing recursive algorithms
AKA: Recurrence Equation, Recurrence Relation

- How to think about _T(n) = T(n-1) + 1_
  
- How to find the value of a _T(k)_ for a particular _k_:

- Substitute up from _T(1)_ to _T(k)_
- Substitute down from _T(k)_ to _T(1)_
  
- Solving the recurrence and evaluate the resulting expression

  
- All three methods require having the **initial conditions** for the recurrence