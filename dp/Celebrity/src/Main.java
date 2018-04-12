public class Main {


    public int findCelebrity(int n) {
        int c = 0;
        for (int i = 1; i < n; i++) {
            if (knows(c,i)) c=i;
        }

        for (int i = 0; i < n; i++) {
            if ( i < c && (knows(c,i)) || !knows(i,c)) return -1;
            if ( i > c &&  !knows(i,c)) return -1;
        }
        return c;
    }

    boolean knows(int a, int b)
    {
        if (b == 3) return true;
        else return false;
    }

    public static void main(String[] args) {

        Main m = new Main();

        System.out.println();
    }
}
