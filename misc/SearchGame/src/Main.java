public class Main {

    public boolean play(int[] a, int i) {
        if (i < 0 || i > a.length-1 || a[i] < 0) return false;
        int v = a[i];
        if (v == 0) return true;
        a[i] = -1 * v;
        return play(a,i+v) || play(a,i-v);
    }


    public static void main(String[] args) {

        Main m = new Main();
        int[] ip = {1, 2, 1, 7, 0, 3, 2, 5, 2};
        System.out.println(m.play(ip, 0));
        System.out.println(m.play(ip, 8));
    }
}
