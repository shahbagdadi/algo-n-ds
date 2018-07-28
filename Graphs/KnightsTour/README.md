# Knights Tour
Assume you're given a normal chessboard and a knight that moves like in normal chess. You
are then given two inputs: starting location and ending location in the form of x,y co-ordinates.
The goal is to calculate the shortest number of moves that the knight can take to get to the
target location.  

![Sample](http://cdncontribute.geeksforgeeks.org/wp-content/uploads/KnightChess.jpg)

Input: (All the coordinates start with 0 and end with (rows-1) or (cols -1)).  
For a 8x8 board the first cell will be (0,0) and the corresponding opposite corner cell will be (7,7)  
```
Input:
rows
cols
startx
starty
endx
endy
Output:
-1 if there is no solution
OR
num (num = 0 or num > 0)
```

[Solution](./src/KnightsTour.java)