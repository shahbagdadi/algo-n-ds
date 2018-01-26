public class LongestSubWithKChar {

    public static String getLongestSubstring(String s, int k)
    {
        char[] a = s.toCharArray();
        int ki=1 , p=0 , q=0 , pmax=p , qmax=q;
        while (q < s.length()-1)
        {
            //System.out.println(p + " " + q + " " + ki);
            if (a[q] != a[q+1])
                ki++;
            if (ki <= k)
            {
                q++;
                if (  (q - p) > (qmax - pmax) ){
                    pmax = p; qmax = q;
                }
            }
            else {
                // Exhaust all equal on p side
                while (a[p] == a[p+1])
                p++;
                ki--;
                p++; // move to next one as we did ki-- above
                q++; // since ki < K now move q
            }

        }
        if (ki < k)
            return "ERROR";
        else
            return s.substring(pmax,qmax+1);
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(getLongestSubstring("aabbcc", 3));
    }
}
