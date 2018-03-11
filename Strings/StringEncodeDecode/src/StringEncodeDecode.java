import java.util.StringTokenizer;

public class StringEncodeDecode {

    public static void main(String[] args) {
        String[] input = new String[]{"1hello", "world", "!", "", "hi", ",", "bye"};
        //String[] input = null;
        String encoded = encodedString(input);
        System.out.println(encoded);
        String[] decoded = decodedString(encoded);
        for (String w : decoded)
            System.out.println(w);
    }

    private static String[] decodedString(String encoded) {
        if (encoded == null || encoded.length() == 0 ) return new String[0];
        int sep = encoded.indexOf("|");
        if (sep == -1) return new String[] {encoded};
        String mdata = encoded.substring(0,sep);
        String data = encoded.substring(sep+1);
        StringTokenizer st = new StringTokenizer(mdata,",");
        String[] result = new String[st.countTokens()];
        int i=0,s=0;
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            result[i++] = data.substring(s,s+n);
            s +=n;
        }
        return result;
    }

    private static String encodedString(String[] a) {
        if (a == null || a.length == 0) return null;
        String mdata = "";
        String result = "";
        for (String w : a) {
            mdata += w.length() + ",";
            result += w;
        }
        return mdata + "|" + result;
    }
}
