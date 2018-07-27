import java.util.Stack;

public class Main {

    public String decodeString(String s) {
        String ans = "";
        Stack<Integer> cnt = new Stack<>();
        Stack<String> sstk = new Stack<>();
        int i = 0, n = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                n=0;
                while (Character.isDigit(c)) {
                    n = 10 * n + c - '0';
                    i++;
                    c = s.charAt(i);
                }
                cnt.push(n);
            }
            else if (c == '[') {
                sstk.push(ans);
                //System.out.println("n = " + n + " ans = " + ans);
                i++;
                ans = "";
            } else if (c == ']') {
                int r = cnt.pop();
                StringBuilder st = new StringBuilder(sstk.pop());
                for (int j = 0; j < r; j++)
                    st.append(ans);
                ans =  st.toString();
                i++;
            }
            else
            {
                ans += c;
                i++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.decodeString("3[a]2[bc]"));
        System.out.println(m.decodeString("3[a2[c]]"));
        System.out.println(m.decodeString("2[abc]3[cd]ef"));
    }
}
