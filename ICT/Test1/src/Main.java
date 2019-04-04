public class Main {

    public boolean isPalindrome(String s)
    {
        if (s.length() <=1) return true;
        if  (s.charAt(0) == s.charAt(s.length()-1))
            return isPalindrome(s.substring(1,s.length()-1));
        return false;
    }
    public static void main(String[] args) {

        Main m = new Main();
        System.out.println(m.isPalindrome("aaaa"));
    }
}
