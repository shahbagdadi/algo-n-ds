import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int len = s.length();
        for (int i = 1; i < 4 && i < len -2; i++) {
            for (int j = i+1; j < i + 4 && j < len - 1; j++) {
                for (int k = j+1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, s.length());
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4))
                        ans.add(s1 + "." + s2 + "." + s3 + "." + s4);
                }
            }
        }
        return ans;
    }

    private boolean isValid(String s) {
//        System.out.println(s);
        if (s.length() == 0 || s.length()>3 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        String str = "2192455873";
        Main m = new Main();
        List<String> lst = m.restoreIpAddresses(str);
        for (String s : lst)
            System.out.println(s);
    }
}
