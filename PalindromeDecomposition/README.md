#Palindrome Decomposition
A “Palindromic Decomposition” of string S, is a decomposition of the string into substrings,
such that all those substrings are valid palindromes. A single character is considered a valid
palindrome for this problem. Print out all possible palindromic decompositions of a given
string.
e.g.
Input: abracadabra
Output:
a|b|r|a|c|a|d|a|b|r|a|
a|b|r|a|c|ada|b|r|a|
a|b|r|aca|d|a|b|r|a|

Input: banana
Output:
b|a|n|a|n|a|
b|ana|n|a|
b|a|nan|a|
b|a|n|ana|
b|anana|

[Solution](./src/PalindromeDecomposition.java)