
| Operation   | Average | Worst | Note                                                                                                 |
| ----------- | ------- | ----- | ---------------------------------------------------------------------------------------------------- |
| put         | O(1)    | O(N)  | Can index array in constant time                                                                     |
| get         | O(1)    | O(N)  | No better way than to iterate through array                                                          |
| containsKey | O(1)    | O(N)  | Use binary search to find value in array                                                             |
| remove      | O(1)    | O(N)  | Insertion would require shifting all the subsequent elements to the right by one and that takes O(n) |
| size        | O(1)    | O(1)  | Special case of insertion where no other element needs to be shifted (may require resizing)          |
If ever implementing a hash table during an interview, here are some questions which can be asked before implementing the solution:

1. Are the keys integers only (or strings, objects, etc.)?
2. For collision resolution, can we use chaining?
3. Do we have to worry about load factors?
4. Can we assume inputs are valid or do we have to validate them?
5. Can we assume this fits memory?