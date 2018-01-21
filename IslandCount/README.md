# Island Count

Given a boolean 2D matrix, find how many islands it has.
An island is a group of connected '1's.  
For example, the matrix below has 5 islands:  
{1, 1, 0, 0, 0},  
{0, 1, 0, 0, 1},  
{1, 0, 0, 1, 1},  
{0, 0, 0, 0, 0},  
{1, 0, 1, 0, 1}  
* Input matrix may or may not be square
* Group of connected '1's can be in any direction i.e. up, down, sideways or diagonally. There
are 8 of these possible directions
* Individual '1s' are considered an island by themselves. There are 3 of those above, in the last
line
* You don't have to provide co-ordinates of islands; just have to tell the total count of islands
About expected solution
* You are allowed to modify the input matrix
* Use as little extra memory as you can 

[Solution](./src/Island.java)