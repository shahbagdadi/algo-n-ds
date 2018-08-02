public class Main {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p0 = new ListNode(0);
        p0.next = head;
        ListNode p1 = p0, p2=p0;
        int i = 0;
        while(i++ <= n)
            p1 = p1.next;
        while(p1!=null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return p0.next;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        Main m = new Main();
        ListNode h = m.removeNthFromEnd(n1, 2);
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }

    }
}
