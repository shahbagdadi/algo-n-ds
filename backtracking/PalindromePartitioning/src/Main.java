import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backTrack(s, new ArrayList<String>(), 0, ans);
        return ans;
    }

    private void backTrack(String s, List<String> tmp, int start, List<List<String>> ans) {
        if (tmp.size() > 0 && start >= s.length())
            ans.add(new ArrayList<>(tmp));
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)){
                if (start == i)
                    tmp.add(Character.toString(s.charAt(i)));
                else
                    tmp.add(s.substring(start,i+1));
                backTrack(s,tmp,i+1,ans);
                tmp.remove(tmp.size()-1);
            }
        }

    }

    private boolean isPalindrome(String str, int l, int r) {
        if (l == r) return true;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Main m = new Main();
        List<List<String>> r = m.partition("aab");
        for (List<String> lst :r)
            System.out.println(Arrays.toString(lst.toArray()));
    }
}
