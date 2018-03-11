public class Main {


    int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        int m = 1, i = 0, n = 0;
        char sign = s.charAt(i);
        if (sign == '-')
            m = -1;
        if (sign == '-' || sign == '+' || sign == '0')
            i++;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) return n * m;
            int num = Character.getNumericValue(c);

            //check if total will be overflow after 10 times and add digit
            if (Integer.MAX_VALUE / 10 < n || Integer.MAX_VALUE / 10 == n && Integer.MAX_VALUE % 10 < num)
                return m == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            n = n * 10 + num;
        }
        return n * m;
    }


    public static void main(String[] args) {

        Main m = new Main();
        int n = m.myAtoi("-2147483648");
        System.out.println(n);
    }
}
