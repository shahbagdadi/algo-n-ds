import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public String encode(List<String> strList) {
        StringBuilder sdata = new StringBuilder();
        StringBuilder smeta = new StringBuilder();
        String sep = ":";
        smeta.append(strList.size());
        for (String s : strList) {
            smeta.append(sep + s.length());
            sdata.append(s);
        }
        return smeta.toString() + "." + sdata.toString();
    }


    public List<String> decode(String decodedStr) {
        int split = decodedStr.indexOf(".");
        String meta = decodedStr.substring(0,split);
        String data = (decodedStr.length() == split ) ? "" : decodedStr.substring(split+1);
        //System.out.println("meta " + meta);
        //System.out.println("data " + data);

        String[] s = meta.split(":");
        int len = Integer.parseInt(s[0]);
        List<String> ans = new ArrayList<>();
        if (len == 0) return ans;
        String ip = data;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            int wlen = Integer.parseInt(s[i + 1]);
            String str = (wlen == 0) ? "" : ip.substring(cnt, cnt + wlen);
            ans.add(str);
            cnt += Integer.parseInt(s[i + 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Main m = new Main();
        //String[] a = {"hello1", "world", "!", ""};
        String[] a = {""};
        String dstr = m.encode(Arrays.asList(a));
        System.out.println(dstr);
        List<String> aStr = m.decode(dstr);
        System.out.println(aStr.toString());
    }
}
