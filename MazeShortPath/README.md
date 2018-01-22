# Shortest path in a Binary Maze
Given a MxN matrix where each element can either be 0 or 1.  
We need to find the shortest path between a given source cell to a destination cell.  
The path can only be created out of a cell if its value is 1.  
  
Expected time complexity is O(MN).  
  
For example –  
  
Input:  
mat[ROW][COL]  = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },  
                  {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },  
                  {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },  
                  {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },  
                  {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },  
                  {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },  
                  {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },  
                  {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },  
                  {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};  
Source = {0, 0};
Destination = {3, 4};

Output:
Shortest Path is 11 


[Solution](./src/Maze.java)