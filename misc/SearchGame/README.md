# Search Game


Given an unsorted array of positive integers and starting index, play a game to find zero.
The rules are.  
If zero found on starting index return true.  
If zero not found, you can jump the distance equals to the number at that index either left or right to find zero.  
``` 

indices =    [0, 1, 2, 3, 4, 5, 6, 7, 8]
numbers = [1, 2, 1, 7, 0, 3, 2, 5, 2],    Length=9
                       ^       
Input/Output
playGame(numbers, 0) == False
playGame(numbers, 8) == True
```

[Solution](./src/Main.java)