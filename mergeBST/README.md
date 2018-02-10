#Merge 2 BST Trees
Given two Binary Search Trees(BST), print the elements of both BSTs in sorted form.
The expected time complexity is O(m+n) where m is the number of nodes in first tree and n is the number of nodes in second tree.
Maximum allowed auxiliary space is O(height of the first tree + height of the second tree).
The output above is a tree that's printed level by level.

```
First BST
       3
    /     \
   1       5

Second BST
    4
  /   \
2       6
Sorted : 1 2 3 4 5 6

Printed Output :    3
                1     5
                 2   4  6




First BST
          8
         / \
        2   10
       /
      1
Second BST
          5
         /
        3
       /
      0
Sorted : 0 1 2 3 5 8 10

Printed Output :   3
                1     8
              0  2  5   10

```

[Solution](./src/MergeBST.java)