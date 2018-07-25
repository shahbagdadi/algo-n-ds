import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Time Complexity: O(A^N + D) where A is the number of digits in our alphabet (0-9 in our case),
 * N is the number of digits in the lock, and D is the size of deadends.
 * We might visit every lock combination, plus we need to instantiate our set dead.
 *
 * Space Complexity: O(A^N + D) for the queue and the set dead
 */
public class Main {

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet();
        for (String d : deadends) dead.add(d);

        Queue<String> queue = new LinkedList();
        queue.offer("0000");
        queue.offer(null); // A marker to indicate that a dial needs to turn

        Set<String> seen = new HashSet();
        seen.add("0000");

        int depth = 0;
        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (node == null) {
                depth++; // increment dial turn counter
                if (queue.peek() != null)
                    queue.offer(null);
            } else if (node.equals(target)) {
                return depth;
            } else if (!dead.contains(node)) {
                for (int i = 0; i < 4; ++i) { // for each of the dials turn 1 step forward and back
                    char c = node.charAt(i);
                    String s1 = node.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + node.substring(i + 1);
                    if (!seen.contains(s1)) {
                        seen.add(s1);
                        queue.offer(s1);
                    }
                    String s2 = node.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + node.substring(i + 1);
                    if (!seen.contains(s2)) {
                        seen.add(s2);
                        queue.offer(s2);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int cnt = m.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202");
        System.out.println(cnt);

        int cnt1 = m.openLock(new String[]{"8888"}, "0009");
        System.out.println(cnt1);

        int cnt2 = m.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888");
        System.out.println(cnt2);
    }
}
