#Dutch National FLag
Given balls of these three colors (Red, Green and Blue) arranged randomly in a line (the actual
number of balls does not matter), the task is to arrange them such that all balls of the same
color are together and their collective color groups are in the correct order (Red first, Green
next and Blue last). These are the colors similar to the Dutch National Flag, hence the
name. This is a popular sorting problem.

**Solution constraints**
- Use array as your data-structure to represent the balls, not linked lists.
- Do this in ONE pass over the array - not two passes, just one pass
- Your solution can only use O(1) extra memory i.e. you have to do this in-place. (For Java/C#,
it's okay to convert incoming String to a character Array or a buffer/builder, but don't use any
other memory for processing)
- Minimize the number of swaps.

Input: A string of letters, where each letter represents a ball with color. R = Red Ball, G =
Green Ball. B = Blue Ball
Output: A string of letters, in sorted order
e.g.
```
Input: GBGGRBRG
Output: RRGGGGBB
```
A naive solution to this problem, is to simply count how many balls of each color, and then
overwrite the array with that many balls in the expected order of colors. However, realize that
that is not how it's practically feasible to do with actual balls. i.e. you can overwrite variables in
a program, but there is no way to "overwrite" a ball of a certain color with another color. i.e.
that is an invalid solution.

[Solution](./src/DutchNationalFlag.java)
