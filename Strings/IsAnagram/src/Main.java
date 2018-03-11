public class Main {

    boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] ch = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            ch[c1 - 'a']++;
            ch[c2 - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (ch[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";
        Main m = new Main();
        boolean r = m.isAnagram(s1, s2);
        System.out.println(r);
    }
}
