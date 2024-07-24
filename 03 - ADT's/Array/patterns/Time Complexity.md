| Operation         | Big-O     | Note                                                                                                 |
| ----------------- | --------- | ---------------------------------------------------------------------------------------------------- |
| Access            | O(1)      | Can index array in constant time                                                                     |
| Search (unsorted) | O(n)      | No better way than to iterate through array                                                          |
| Search (sorted)   | O(log(n)) | Use binary search to find value in array                                                             |
| Insert at start   | O(n)      | Insertion would require shifting all the subsequent elements to the right by one and that takes O(n) |
| Insert at end     | O(1)      | Special case of insertion where no other element needs to be shifted (may require resizing)          |
| Remove at start   | O(n)      | Removal would require shifting all the subsequent elements to the left by one and that takes O(n)    |
| Remove at end     | O(1)      | Special case of removal where no other element needs to be shifted                                   |


