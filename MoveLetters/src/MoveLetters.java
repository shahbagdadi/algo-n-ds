public class MoveLetters {

    public static char[] moveLetters(char[] a)
    {
        int ptc =0, ptn =0, l=a.length-1;
        while (ptc <= l && ptn <= l)
        {
            // Find ptr to next char
            while ( (a[ptc] < '0' || a[ptc] > '9') && ptc <= l)
                ptc++;
            // Find ptr to next number
            while (a[ptn] >= '0' && a[ptn] <= '9' && ptn < l )
                ptn++;
            if (ptn > ptc)
            {
                swap(a, ptn, ptc);
                ptc++;
            }
            ptn++;
        }
        return a;
    }

    private static void swap(char[] a, int ptn, int ptc) {
        char tmp = a[ptn];
        System.out.println("Swapping " + a[ptn] + " and " + a[ptc]);
        a[ptn] = a[ptc];
        a[ptc] = tmp;
    }

    public static void main(String[] args) {
	    //String s = "0a193zbr6";
        String s = "5azbr7l89k0p";
        char[] a = s.toCharArray();
        char[] b = moveLetters(a);
        for (char c : b)
            System.out.print(c);
    }
}
