public class Main {

    boolean isPalindrome(String s) {
        s = s.trim();
        int l =  s.length();
        if (l == 1 ) return true;
        int i = 0;
        int j = l-1;

        while (i <= j) {
            char c1 = Character.toLowerCase(s.charAt(i));
            char c2 = Character.toLowerCase(s.charAt(j));
            //System.out.println("comparing " + c1 + " " + c2);
            if (!Character.isLetterOrDigit(c1))
                i++;
            else if ( !Character.isLetterOrDigit(c2))
                j--;
            else if (c1 != c2)
                return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        //String s = "race a car";
       //String s = "0P";
        Main m = new Main();
        boolean b = m.isPalindrome(s);
        System.out.println(b);
        //System.out.println(Character.isLetter('0'));
    }
}
