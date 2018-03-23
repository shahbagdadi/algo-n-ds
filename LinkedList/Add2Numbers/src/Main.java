public class Main {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode root = new ListNode(0);
        ListNode res = root;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + c;
            if (sum > 9) {
                sum = sum - 10;
                c = 1;
            } else
                c = 0;
            ListNode n = new ListNode(sum);
            root.next = n;
            root = n;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode rest = root;
        rest = (l1 != null) ? l1 : l2;

        while (rest != null) {
            int sum = rest.val + c;
            if (sum > 9) {
                sum = sum - 10;
                c = 1;
            } else
                c = 0;
            ListNode n = new ListNode(sum);
            root.next = n;
            root = n;
            rest = rest.next;
        }
        if (c !=0)
        {
            ListNode n = new ListNode(c);
            root.next = n;
        }

        return res.next;
    }



    public static void main(String[] args) {

        Main m = new Main();

        System.out.println();
    }
}
