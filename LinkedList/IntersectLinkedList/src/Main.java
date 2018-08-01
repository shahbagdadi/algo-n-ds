import java.util.HashSet;

public class Main {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if (a == null || b == null) return null;
        ListNode p1 = a , p2 = b;
        while (p1 != p2) {
            p1 = (p1 == null) ? b : p1.next;
            p2 = (p2 == null) ? a : p2.next;
        }
        return p1;
    }


    public static void main(String[] args) {
        Main m = new Main();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        b.next = c;
        a.next = b;
        ListNode n = m.getIntersectionNode(a, b);
        System.out.println(n.val);
    }
}
