/*
------------------
Problem Statement:
------------------
You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:

    An integer x.
        Record a new score of x.
    '+'.
        Record a new score that is the sum of the previous two scores.
    'D'.
        Record a new score that is the double of the previous score.
    'C'.
        Invalidate the previous score, removing it from the record.

Return the sum of all the scores on the record after applying all the operations.
The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.

-------
Inputs:
-------
An array of scores and operations.

--------
Outputs:
--------
Return the sum of all the scores on the record after applying all the operations.

------------
Constraints:
------------
1 <= operations.length <= 1000
operations[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 104, 3 * 104].
For operation "+", there will always be at least two previous scores on the record.
For operations "C" and "D", there will always be at least one previous score on the record.

--------
Example:
--------
Input: ops = ["5","2","C","D","+"]
Output: 30
Explanation:
"5" - Add 5 to the record, record is now [5].
"2" - Add 2 to the record, record is now [5, 2].
"C" - Invalidate and remove the previous score, record is now [5].
"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
The total sum is 5 + 10 + 15 = 30.

----------
Algorithm:
----------
These operations match push and pop operations of a stack.

push(x)
    We can push new scores (x) onto the stack

pop()
    return the top score (x) from the stack

plus()
    call pop() two times and sum them, then push() the sum

double()
    call pop(), double the score, then push()

invalidate()
    pop() the most recent score
*/

import { ArrayStack } from '../src/Typescript/ArrayStack';

class BaseballStack
{
    private size: number;
    private scores: string[];

    constructor()
    {
        this.size = 0;
        this.scores = []
    }

    push(score: string) : void
    {
        this.scores[this.size++] = score;
    }

    pop() : string
    {
        if(this.isEmpty()) throw new RangeError("Stack is empty.");
        const item = this.scores[--this.size];
        this.scores.length = this.size;         // Truncate array
        return item;
    }

    peek() : string
    {
        if(this.isEmpty()) throw new RangeError("Stack is empty.");
        return this.scores[this.size-1];
    }

    plus() : void
    {
        try
        {
            if(this.size < 2) throw new RangeError("Stack is empty.");

            const score1: number = Number(this.pop());
            const score2: number = Number(this.pop());
            const sum = score1 + score2;
            
            this.push(score2.toString());
            this.push(score1.toString());
            this.push(sum.toString());
        }
        catch(e: unknown)
        {
            console.log(e);
        }
    }

    double() : void
    {
        try
        {
            if(this.isEmpty()) throw new RangeError("Stack is empty.");

            const score: number = Number(this.peek());
            const doubleScore = score * 2;
            this.push(doubleScore.toString());
        }
        catch(e: unknown)
        {
            console.log(e);
        }
    }

    invalidate() : void
    {
        try
        {
            if(this.isEmpty()) throw new RangeError("Stack is empty.");
            this.pop();
        }
        catch(e: unknown)
        {
            console.log(e);
        }
    }

    isEmpty() : boolean
    {
        return this.size === 0;
    }

    sum(): number
    {
        let sum: number = 0;
        for (let score of this.scores) {
            sum += Number(score);
        }
        return sum;
    }

    getScores()
    {
        return this.scores;
    }
}

function calPoints(operations: string[])
{
    let stack: BaseballStack = new BaseballStack();
    for(const op of operations)
    {
        if(!isNaN(Number(op)))
            stack.push(op);
        else if(op == "+")
            stack.plus();
        else if(op == "D")
            stack.double();
        else if(op == "C")
            stack.invalidate();

        console.log(stack.getScores());
    }
    return stack.sum();
}

const ops = ["5","-2","4","C","D","9","+","+"]
const sum = calPoints(ops)
console.log(sum);
