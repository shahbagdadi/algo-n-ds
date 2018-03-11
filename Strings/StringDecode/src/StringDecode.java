import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDecode {
    static Pattern p = Pattern.compile("-?\\d+");

    public static String decode(String str) {
        Stack<Integer> ns = new Stack<Integer>();
        Stack<String> cs = new Stack<String>();
        char [] a = str.toCharArray();
        int i=0, N= str.length();
        while (i < N)
        {
            char c = a[i];
            String d = "";
            if (isDigit(c))
            {
                d += c;
                while (isDigit(a[++i]))
                    d +=c;
                int num = Integer.parseInt(d);
                ns.push(num);
                cs.push("[");
            } else if ( c == ']')
            {
                int n = ns.pop();
                String sp = "";
                while (!cs.peek().equals("["))
                    sp = cs.pop() + sp;
                cs.pop();
                cs.push(multiplyString(n,sp));
            }
            else
                cs.push(String.valueOf(c));
            i++;
        }
        // Empty the stack to get full decoded string
        String result = "";
        while (! cs.isEmpty())
            result = cs.pop() + result;
        return result;
    }

    private static String multiplyString(int n, String rs) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++)
            sb.append(rs);
        return sb.toString();
    }

    public static boolean isDigit(char c)
    {
        if (c >= '1' && c <= '9')
            return true;
        return false;
    }


    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decode(s));

        s = "3[a2[c]]";
        System.out.println(decode(s));

        s = "3[abc]2[cd]ef";
        System.out.println(decode(s));
    }
}
