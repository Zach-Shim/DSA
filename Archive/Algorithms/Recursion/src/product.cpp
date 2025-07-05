#include <iostream>

/*
Recursive function that computes and returns the product of the first n ≥ 1 real numbers in an array.
*/
int productOfFirstN(int arr[], int index, int n)
{
    if(index < n)
    {
        return arr[index] * productOfFirstN(arr, index + 1, n);
    }
    return 1;
}

int main()
{
    int arr[] = {2, 3, 5, 10, 34, 64, 13};
    int size = sizeof(arr) / sizeof(arr[0]);

    std::cout << "Product of first n real numbers in the array:\n";
    std::cout << productOfFirstN(arr, 0, 4);
}