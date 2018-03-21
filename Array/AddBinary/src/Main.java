public class Main {

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0, sum = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0) {
            int p = 0, q = 0;
            if (i >= 0) p = Character.getNumericValue(a.charAt(i--));
            if (j >= 0) q = Character.getNumericValue(b.charAt(j--));
            sum = p + q + c;
            c = sum / 2;
            sum %= 2;
            sb.append(sum);
        }
        if (c>0) sb.append(c);
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        Main m = new Main();
        String s = m.addBinary("1", "11");
        System.out.println(s);
    }
}
