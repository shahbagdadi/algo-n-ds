public class Main {

    public boolean increasingTriplet(int[] a) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : a) {
            if (n <= min1) min1 = n;
            else if (n <= min2) min2 = n;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Main m = new Main();
        int[] a = {5,4,7,6,3,8};
        System.out.println(m.increasingTriplet(a));
    }
}
