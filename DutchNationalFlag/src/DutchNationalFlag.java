public class DutchNationalFlag {

    public static String sortFlag(String s) {
        char[] a = s.toCharArray();
        int l = 0, m = 0, h = a.length - 1;
        while (m <= h) {
            if (a[m] == 'R') {
                swap(a, l, m);
                l++;
                m++;
            } else if (a[m] == 'G')
                m++;
            else {
                swap(a, m, h);
                h--;
            }

        }
        return String.valueOf(a);
    }

    private static void swap(char[] a, int l, int h) {
        char tmp = a[l];
        a[l] = a[h];
        a[h] = tmp;
    }

    public static void main(String[] args) {
        String s = "BGBGGRBRGR";
        System.out.println(sortFlag(s));
    }
}
