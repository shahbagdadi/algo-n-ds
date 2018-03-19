# BalancedPartition
Find if an array can be partitioned into two equal partitions, Each of the two partition can be of different size.
* Assume that the sum of all elements in the array is even.
* Numbers can be positive or negative, viz non-zero integers
* Numbers can repeat.
* If there are multiple such partitions possible, then print any one.



``` 
e.g.
Input: 4, 1, -5, 6, -11, 3
Output:  True   (4, 6, -11 and 1, -5, 3 =>Both sum to -1)

Input: 2, 4, 6, 

Output: True (2, 4 and 6 => both sum to 6)

Input: 2, 4, 16

Output: False

Input: 3, 4, 2

Output: False

```

[Solution](./src/Main.java)