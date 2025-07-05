interface Stack<Type>
{
    push(item: Type): void;
    pop(): Type;
    peek(): Type;
    isEmpty(): boolean;
}

export { Stack };