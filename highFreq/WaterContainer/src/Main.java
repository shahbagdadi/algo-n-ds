public class Main {

    public int maxArea(int[] a) {
        int i = 0, j = a.length-1, max = Integer.MIN_VALUE;
        while (i < j) {
            int area = Math.min(a[i], a[j]) * (j - i);
            max = Math.max(max, area);
            if ((a[i] > a[j]))
                j--;
            else
                i++;
        }
        return max;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(m.maxArea(a));
    }
}
