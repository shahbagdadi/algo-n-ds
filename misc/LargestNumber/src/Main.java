import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public String largestNumber(int[] nums) {
        String[] a = new String[nums.length];
        for(int i=0; i< nums.length; i++)
            a[i] = String.valueOf(nums[i]);

        Arrays.sort(a,new MyComp());

        String result = "";

        if (a[0].equals("0"))
            return "0";

        for(String s : a)
            result += s;

        return result;
    }

    private class MyComp implements Comparator<String>
    {
        @Override
        public int compare(String a, String b)
        {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        }
    }

    public static void main(String[] args) {

        Main m = new Main();
        int [] ip = {3,30,34,5,9};
        System.out.println(m.largestNumber(ip));
    }
}
