# Merging Intervals
Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals.  
Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }.  
The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}.  
Similarly {5, 7} and {6, 8} should be merged and become {5, 8}

## Sample Input  
{ {8,10} {6,7} {9,11} {14,15} {4,5} {13,16} }

## Output
{ {4 , 5} { 6 , 7} { 8 , 11 } { 13 : 16} }

[Solution](./src/MergingIntervals.java)