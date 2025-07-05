import { Stack } from './StackADT'

class ArrayStack<Type> implements Stack<Type>
{
    private size: number;
    private items: Type[];

    constructor()
    {
        this.size = 0;
        this.items = []
    }

    push(item: Type) : void
    {
        this.items[this.size++] = item;
    }

    pop() : Type
    {
        if(this.isEmpty()) throw new RangeError("Stack is empty.");
        const item = this.items[--this.size];
        this.items.length = this.size;
        return item;
    }

    peek() : Type
    {
        if(this.isEmpty()) throw new RangeError("Stack is empty.");
        return this.items[this.size-1];
    }

    isEmpty() : boolean
    {
        return this.size === 0;
    }

    filter(fn: (e: Type) => boolean): Type[]
    {
        let filtered: Type[] = [];
        for(let item of this.items)
            if(fn(item))
                filtered.push(item);
        return filtered;
    }

    map(fn: (e: Type) => Type): Type[]
    {
        let mapped: Type[] = [];
        for(let i = 0; i < this.size; i++)
        {
            mapped.push(fn(this.items[i]));
        }
        return mapped;
    }

    toString(): string
    {
        return JSON.stringify(this.items.slice(0, this.size));
    }
}

let stack = new ArrayStack<string>();
stack.push("spray");
stack.push("elite");
stack.push("pedantic");
stack.push("exuberant");
stack.push("present");
stack.push("belligerent");

console.log(stack.toString());

let filtered = stack.filter((word: string) => word.length > 6);
console.log(filtered);

let stackNums = new ArrayStack<number>();
stackNums.push(1);
stackNums.push(2);
stackNums.push(3);
stackNums.push(4);

console.log(stackNums.toString());

let mapped = stackNums.map((num: number) => num * 2);
console.log(mapped);

export { ArrayStack }