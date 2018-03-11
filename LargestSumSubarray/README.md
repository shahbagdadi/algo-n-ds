# Largest Sum Contiguous Subarray


Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

Example 1
![Example1](https://www.geeksforgeeks.org/wp-content/uploads/kadane-Algorithm.png)


Example 2  
For example, given the array [-2,1,-3,4,-1,2,1,-5,4],  
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

## Hints

### Brute force
```
        for (int i = 0; i < a.length; i++) {
            s =0;
            for (int j = i; j < a.length; j++) {
                s += a[j];
                if (s > max)
                    max = s;
```
O(n^2)

### Recursive
```
int maxSubArray(int[] a, int l, int h)
{
  //base
  if (h -l) < 2 return Max(a[l], a[h])
  m = h-l/2;
  ml = maxSubArray(a, l, m);
  mr = maxSubArray(a, m+1, h);
  // max subarray with suffix sum on left and prefix sum on right
  ms = maxbothSubArray(a,l, m, h); 
  return Max (ml,mr,ms);
 } 
```
O(n log n)

### Kadane
``` 
         int cmax = 0, max = 0;
         for (int i = 0; i < a.length; i++) {
             cmax += a[i];
             if (cmax < 0)
                 cmax = 0;
             else if (cmax > max)
                 max = cmax;
         }
         return max;
```
O(n)


### Kadane (optimized for -ve numbers)
``` 
        int cmax = a[0], max = a[0];
        for (int i = 0; i < a.length; i++) {
            cmax += a[i];
            cmax = Math.max(cmax,a[i]);
            max = Math.max(cmax,max);
        }
        return max;
```
O(n) - handles all -ve number


[Solution](./src/Main.java)