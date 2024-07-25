#include <iostream>

int factorialRecursive(int n)
{
    if(n == 0) return 1;
    return n * factorialRecursive(n-1);
}

int factorialIterative(int n)
{
    int res = 1;
    for(int i = n; i > 0; i++)
    {
        res *= i;
    }
    return res;
}

int main()
{
    std::cout << factorialRecursive(4) << std::endl;
}