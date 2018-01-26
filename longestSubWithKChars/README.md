#  Longest substring with k unique characters
Given a string you need to print longest possible substring that has exactly M unique characters.  
If there are more than one substring of longest possible length, then print any one of them.


"aabbcc", k = 1 
Max substring can be any one from {"aa" , "bb" , "cc"}.

"aabbcc", k = 2
Max substring can be any one from {"aabb" , "bbcc"}.

"aabbcc", k = 3
There are substrings with exactly 3 unique characters
{"aabbcc" , "abbcc" , "aabbc" , "abbc" }
Max is "aabbcc" with length 6.

"aaabbb", k = 3
There are only two unique characters, thus show error message.
 
 [Solution](./src/LongestSubWithKChar.java)