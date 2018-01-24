
public class StringMultiply {

    public static String multiply(String s1, String s2) {
        int[] i1 = toIntArray(s1);
        int[] i2 = toIntArray(s2);

        int result[] = new int[i1.length + i2.length];
        int rp =result.length-1;


        for (int i = i1.length-1 ; i >= 0 ; i--, rp--) {
            for (int j = i2.length-1, p=0; j >= 0 ; j--, p++) {

                int pd = i1[i] * i2[j];
                int m = pd  % 10;
                int c = pd / 10;
                result[rp - p] =  result[rp -p] + m;
                result[rp - (p +1) ] = result[rp -(p+1)] + c;
            }
        }
        return intToString(result);
    }

    static String intToString(int[] a){
        StringBuffer sb = new StringBuffer();
        int c =0 , sum =0;

        for (int j = a.length-1; j >=0; j--) {
            sum = a[j] + c;
            c=0;
            if (sum >= 10)
            {
              c = sum / 10;
              a[j] = sum % 10;
            }
            else
                a[j] = sum;
        }
        for (int j = 0; j < a.length; j++) {
                sb.append(a[j]);
        }
        return sb.toString();
    }


    public static int[] toIntArray(String s) {
        int[] a = new int[s.length()];
        for (int i = s.length()-1; i >=0 ; i--) {
            a[i]=Character.getNumericValue(s.charAt(i));
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(multiply("999", "99"));
    }
}


