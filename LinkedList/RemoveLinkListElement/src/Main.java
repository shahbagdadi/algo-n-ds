public class Main {

    public ListNode removeElements(ListNode head, int val) {
        ListNode p0 = new ListNode(-1);
        p0.next = head;
        ListNode c = p0.next, p = p0;
        while (c != null) {
            if (c.val == val)
                p.next = c.next;
            else
                p = c;
            c = c.next;
        }
        return p0.next;
    }

    public static void main(String[] args) {
        Main m = new Main();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(6);
        ListNode n3 = new ListNode(6);
        n1.next = n2; n2.next = n3;
        ListNode h = m.removeElements(n1, 6);
        while (h != null) {
            System.out.print(h.val + " - > ");
            h = h.next;
        }
    }
}
