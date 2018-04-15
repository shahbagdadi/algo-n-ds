# Maximum Profit selling Wines


Let’s consider you have a collection of N wines placed next to each other on a shelf. The price of the ith wine is pi. (prices of different wines can be different). Because the wines get better every year, supposing today is the year 1, on year y the price of the ith wine will be y*pi, i.e. y-times the value that current year. You want to sell all the wines you have, but you want to sell exactly one wine per year, starting on this year. One more constraint - on each year you are allowed to sell only either the leftmost or the rightmost wine on the shelf and you are not allowed to reorder the wines on the shelf (i.e. they must stay in the same order as they are in the beginning). You want to find out, what is the maximum profit you can get, if you sell the wines in optimal order?

```
Input 1 
[2,4]
Max profit = 1*2 + 2 * 4 = 10 and not 1*4 + 2*2 = 8

Input 2
[2,1,5]
Max profit = 19

Input 3
[2,3,5,1,4]
Max profit = 50

```

[Solution](./src/Main.java)