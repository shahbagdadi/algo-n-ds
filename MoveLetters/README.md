# Move Letters

You're given a character array, which may contain alphabet letters (a to z or A to
Z) as well as numbers (0 to 9, represented as characters), in random order.  
You have to make alphabet letters appear on left side, inside the same array.

e.g. If your input is [0,a,1,9,3,z,b,r,6], then in your output, letters a, z, b, and r,
should be seen on left side in the array.
* Original order of letters needs to be preserved.
* Order of numbers doesn't need to be preserved. If a test-case fails, then check if
it's only because the order of numbers is different. If so, then the failure is
irrelevant and can be ignored.
* Repeats are allowed.
* An in-place linear solution is expected
* For languages that have immutable strings, convert the input string into a
Character Array and work in-place on that array. Convert it back to the string
before returning. (For the purpose of this problem, ignore the extra linear space
used in that conversion, as long as you're only using constant space after
conversion to character array)
* Extension: Minimize the number of array-writes in your solution. i.e. Re-read the
problem-statement, and think whether you really need to write/over-write that
letter/number.

[Solution](./src/MoveLetters.java)