import java.util.StringTokenizer;

public class Main {


    public int compareVersion(String version1, String version2) {
        StringTokenizer st1 = new StringTokenizer(version1, ".");
        StringTokenizer st2 = new StringTokenizer(version2, ".");

        while (st1.hasMoreTokens() && st2.hasMoreTokens()) {
            int tk1 = Integer.valueOf(st1.nextToken());
            int tk2 = Integer.valueOf(st2.nextToken());
            //System.out.println(tk1 + " , " + tk2);
            if (tk1 == tk2) continue;
            else if (tk1 < tk2) return -1;
            else return 1;
        }
        while (st1.hasMoreTokens()) {
            int tk1 = Integer.valueOf(st1.nextToken());
            if (tk1 > 0) return -1;
        }
        while (st2.hasMoreTokens()) {
            int tk2 = Integer.valueOf(st2.nextToken());
            if (tk2 > 0) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {

        Main m = new Main();
        int r = m.compareVersion("1.1", "1.1.2");
        System.out.println(r);
    }
}
