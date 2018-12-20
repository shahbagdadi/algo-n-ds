import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        //res.add(word);
        backtrack(word, "", 0, res, 0);
        return res;
    }

    public void backtrack(String wd, String tmp, int start, List<String> res, int cnt) {
        if (start == wd.length()) {
            if (cnt > 0) tmp += cnt;
            //System.out.println(tmp);
            res.add(tmp);
        } else {
            // for every start char keep it abbrv
            backtrack(wd, tmp, start + 1, res, cnt + 1);

            // For every start chara keep it
            backtrack(wd, tmp + (cnt > 0 ? cnt : "") + wd.charAt(start), start + 1, res, 0);
        }
    }



    public static void main(String[] args) {

        Main m = new Main();
        List<String> lst = m.generateAbbreviations("word");
        System.out.println(Arrays.toString(lst.toArray()));
        System.out.println();
    }
}
