import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {


    void wordBreak(String s, Set dict)
    {
        helper(s,dict,0,"");
    }

    private void helper(String s, Set dict, int i, String result) {
        if ( i >= s.length()) return;
        int j = i+1;
        while (j <= s.length()){
            System.out.println("checking " + s.substring(i,j));
            if (!dict.contains(s.substring(i,j)))
                j++;
            else
            {
                result = result + " " + s.substring(i,j);
                System.out.println(result);
                if (j == s.length()) {
                    System.out.println("==> " + result);
                    return;
                }
                helper(s,dict,j,result);

            }
        }
    }


    public static void main(String[] args) {

        Main m = new Main();
        String [] a = { "i", "like", "sam", "sung", "samsung", "mobile", "ice",
                "cream", "icecream", "man", "go", "mango"};
        Set<String> dict = new HashSet<>(Arrays.asList(a));
        m.wordBreak("ilikesamsungmobile", dict);
    }
}
