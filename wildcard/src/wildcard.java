import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * Time - O(2^n) where n is the number of ?
 * Space - O(n) where n is the number of ?
 */
public class wildcard {

    private static void resolveString(String s) {
        if (s.contains("?")) {
            resolveString(s.replaceFirst(Pattern.quote("?"), "0"));
            resolveString(s.replaceFirst(Pattern.quote("?"), "1"));
        } else
            System.out.println(s);
    }

    public static void main(String[] args) {
        resolveString("1?0?");
    }

}
