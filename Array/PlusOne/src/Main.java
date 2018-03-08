public class Main {

    static int[] plusOne(int[] d) {
        int n = d.length;
        for(int i=n-1; i>=0; i--) {
            if(d[i] < 9) {
                d[i]++;
                return d;
            }

            d[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {
        int[] ip = new int[]{1,9, 9};
        int[] r = plusOne(ip);
        for (int i = 0; i < r.length; i++) {
            System.out.println(r[i] + " , ");
        }
    }
}
