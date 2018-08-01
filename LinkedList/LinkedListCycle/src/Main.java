public class Main {

    public ListNode detectCycle(ListNode head) {
        ListNode intNode = getIntersection(head);
        if (intNode == null) return intNode;
        ListNode ptr1 = head , ptr2 = intNode;
        while (ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    private ListNode getIntersection(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return slow;
        }
        return null;
    }


    public static void main(String[] args) {

        Main m = new Main();

        System.out.println();
    }
}
