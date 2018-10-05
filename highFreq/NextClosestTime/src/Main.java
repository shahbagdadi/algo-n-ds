import java.util.HashSet;

public class Main {

    // T - O(1) (4 * 4 * 4 * 4)    S - O(1)
    public String nextClosestTime(String time) {
        HashSet<Integer> allowed = new HashSet<>();
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));
        int start = 60 * hours + minutes;
        int dayMinutes = 60 * 24;
        int ans = Integer.MAX_VALUE, minNum = Integer.MAX_VALUE;

        for (char c : time.toCharArray()) {
            if (c != ':') {
                int n = c - '0';
                allowed.add(n);
                if (minNum > n) minNum = n;
            }

        }

        for (int h1 : allowed) {
            for (int h2 : allowed) {
                if (h1 * 10 + h2 < 24) {
                    for (int m1 : allowed) {
                        for (int m2 : allowed) {
                            if (m1 * 10 + m2 < 60) {
                                int elapsed = 60 * (h1 * 10 + h2) + (m1 * 10 + m2);
                                int since = elapsed - start;
                                if (since > 0 && since <= dayMinutes && elapsed < ans) {
                                    ans = elapsed;
                                }

                            }
                        }
                    }
                }
            }
        }
        if (ans == Integer.MAX_VALUE)
            return (minNum * 10 +  minNum) + ":" + (minNum * 10  +  minNum);
        else
            return String.format("%02d:%02d", ans / 60, ans % 60);
    }


    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.nextClosestTime("23:59"));
    }
}
