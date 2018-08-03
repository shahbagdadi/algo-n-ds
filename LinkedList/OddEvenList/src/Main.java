public class Main {

    public ListNode oddEvenList(ListNode head) {
        ListNode ohead = new ListNode(-1);
        ListNode ehead = new ListNode(-1);
        ListNode c = head, o=ohead, e = ehead;
        int i=1;
        while (c!=null) {
            if (i % 2 == 0) {
                e.next = c;
                e = e.next;
            }
            else
            {
                o.next = c;
                o = o.next;
            }
            c = c.next;
            i++;
        }
        e.next = null;
        o.next = ehead.next;
        return ohead.next;
    }

    public static void main(String[] args) {
        Main m = new Main();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next =n5;
        ListNode h = m.oddEvenList(n1);
        while (h != null) {
            System.out.print( h.val + " ");
            h = h.next;
        }

    }
}
