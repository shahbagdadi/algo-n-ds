import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public boolean isNumber(String s) {
        HashSet<Character> prefix = new HashSet<>();
        prefix.addAll(Arrays.asList('+', '-', '.'));

        HashSet<Character> digit = new HashSet<>();
        digit.addAll(Arrays.asList('0', '1','.', '2', '3', '4', '5', '6', '7', '8', '9'));
        HashSet<Character> allowed = new HashSet<>();
        allowed.addAll(Arrays.asList( 'e','.', ' '));
        int i = 0, l = s.length();

        if (!prefix.contains(s.charAt(i)) || !digit.contains(s.charAt(i)))
            return false;
        else
            i++;


        // System.out.println("first digit " + s.charAt(i));
        while (i < l)
            if (body.contains(s.charAt(i))) i++;
            else return false;

        return true;
    }

    public static void main(String[] args) {
        Main m = new Main();
        boolean b = m.isNumber("1d0");
        System.out.println(b);
    }
}
