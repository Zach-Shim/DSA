#include <iostream>

/* Writes the characters in an array backward.
@pre The array anArray contains size characters, where size >= 0. @post None.
@param anArray The array to write backward.
@param first The index of the first character in the array.
@param last The index of the last character in the array. */
void printBackwards(int arr[], int first, int last)
{
    if(first <= last)
    {
        std::cout << arr[last--] << " ";
        printBackwards(arr, first, last);
    }
}

int main()
{
    int arr[] = {43, 62, 7, 19, 23, 80, 12, 50, 2, 34};
    int size = sizeof(arr) / sizeof(arr[0]);

    std::cout << "Array printed forwards:\n";
    for(auto num : arr)
        std::cout << num << " ";
    std::cout << "\n\n";

    std::cout << "Array printed backwards:\n";
    printBackwards(arr, 0, size - 1);
}