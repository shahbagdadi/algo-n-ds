public class Main {


    public ListNode reverseList(ListNode head) {
      return reverseListInt(head,null);
    }


    ListNode reverseListInt(ListNode head, ListNode newHead)
    {
        if (head == null) return newHead;

        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode nl = new ListNode(0);
        ListNode root = nl;
        while (l1 != null && l2 != null)
        {
            if (l2.val < l1.val)
            {
                nl.next = l2;
                l2 = l2.next;
            }
            else
            {
                nl.next= l1;
                l1 = l1.next;
            }
            nl = nl.next;
        }
        // drain
        if (l2 != null)
            nl.next = l2;
        else if (l1 != null)
            nl.next = l1;
        return root.next;

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast )
                return true;
        }
        return false;
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
        //n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = null;

        Main m = new Main();
        //ListNode h = m.removeNthFromEnd(n1, 1);
        //ListNode h = n1;
        //ListNode h = m.reverseList(n1);
        ListNode h = m.mergeTwoLists(n1,n4);
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }

    }
}
