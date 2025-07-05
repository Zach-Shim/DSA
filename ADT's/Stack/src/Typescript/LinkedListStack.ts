import { Stack } from './StackADT'

class ListNode<Type>
{
    public data: Type | null;
    public next: ListNode<Type> | null;
    public prev: ListNode<Type> | null;

    constructor(data: Type | null)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    getNext(): ListNode<Type> | null { return this.next; }
    getPrev(): ListNode<Type> | null { return this.prev; }
    getData(): Type | null { return this.data; }

    setNext(next: ListNode<Type> | null) { this.next = next; }
    setPrev(prev: ListNode<Type> | null) { this.prev = prev; }
}

class LinkedListStack<Type> implements Stack<Type>
{
    private size: number;
    private head: ListNode<Type>;
    private tail: ListNode<Type>;

    constructor()
    {
        this.size = 0;
        this.head = new ListNode<Type>(null);
        this.tail = new ListNode<Type>(null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    push(data: Type)
    {
        const newNode = new ListNode<Type>(data);

        this.tail.prev!.next = newNode;
        newNode.prev = this.tail.prev;

        this.tail.prev = newNode;
        newNode.next = this.tail;

        ++this.size;
    }

    pop() : Type
    {
        if(this.isEmpty()) throw new RangeError("Stack is empty.");
        
        const output = this.tail.prev!.data;
        this.tail.prev = this.tail.prev!.prev;
        this.tail.prev!.next = this.tail;

        --this.size;

        return output!;
    }

    peek() : Type
    {
        if(this.isEmpty()) throw new RangeError("Stack is empty.");
        return this.tail.prev!.data!;
    }

    isEmpty() : boolean
    {
        return this.size === 0;
    }

    toString() : string
    {
        let output = "[";
        let curr = this.head.next!;
        while (curr.next != null)
        {
            output += curr.data + ', ';
            curr = curr.next;
        }
        output = output.slice(0, output.length-2) + ']'
        return output;
    }
}

let stack = new LinkedListStack<number>();
stack.push(5)
stack.push(3)
stack.push(7)
stack.pop()
console.log(stack.peek());
console.log(stack.toString());

export { LinkedListStack };