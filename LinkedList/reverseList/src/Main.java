public class Main {

    public ListNode reverseList(ListNode head) {
        ListNode prev=null, cur = head, tmp = null;
        while (cur!=null) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    public ListNode rReverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode newHead=rReverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        Main m = new Main();
        ListNode h = m.reverseList(n1);
//        ListNode h = m.rReverseList(n1);
        while (h!=null) {
            System.out.print(h.val + " -> ");
            h = h.next;
        }

    }
}
