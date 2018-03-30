import java.util.*;

public class Main {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val < n2.val) return -1;
                else if (n1.val == n2.val) return 0;
                else return 1;
            }
        });

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                q.offer(lists[i]);
        }
        ListNode root = result;
        while (!q.isEmpty()) {
            root.next = q.poll();
            root = root.next;
            if (root.next != null)
                q.offer(root.next);
        }
        return result.next;
    }


    public static void main(String[] args) {
        Main m = new Main();
        m.mergeKLists(new ListNode[0]);
    }
}
