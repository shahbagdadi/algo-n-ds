import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {

    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * Time - O(m^n) where m is the max number of option for a digit i.e 4 for wxyz and n is number of digits
     * Space - O(m*n)
     * Iterative solution
     */
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

    /**
     * Time - O(m^n) where m is the max number of option for a digit i.e 4 for wxyz and n is number of digits
     * Space - O(m*n)
     * @param digits - phone number as a string
     * @return list of String with all the combination of possible words
     */
    public List<String> printInWords(String digits)
    {
        int[] a = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++)
            a[i] = Character.getNumericValue(digits.charAt(i));

        List<String> ans = new LinkedList<>();
        printInWords(a,ans,"",0);
        return ans;
    }

    public void printInWords(int[]a, List<String> ans, String result, int idx)
    {
        if (idx == a.length)
        {
            ans.add(result);
            return;
        }
        char[] opts = mapping[a[idx]].toCharArray();
        for (int i = 0; i < opts.length; i++) {
            char ch = opts[i];
            printInWords(a,ans,result+ch,idx+1);
        }
    }

    public static void main(String[] args) {
	Main m = new Main();
//	List<String > r = m.letterCombinations("23");
	List<String > r =    m.printInWords("234");
        for (int i = 0; i < r.size(); i++) {
            System.out.println(r.get(i));
        }

    }
}
