public class Main {

    public int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length()-1,new Integer[s.length()][s.length()]);
    }

    // S - O(n)  T - O(n)
    public int helper(String str, int s, int e, Integer[][] memo)
    {
        if (s > e) return 0;
        if (s == e) return 1;
        if (memo[s][e] != null) return memo[s][e];
        if (str.charAt(s) == str.charAt(e))
            memo[s][e] = helper(str,s+1,e-1,memo) +2;
        else
            memo[s][e] = Integer.max(helper(str,s,e-1,memo),helper(str,s+1,e,memo));

        return memo[s][e];
    }


    public static void main(String[] args) {

        Main m = new Main();

        System.out.println(m.longestPalindromeSubseq("bbbab"));
    }
}
