import java.util.HashSet;

public class Main {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        HashSet<Integer> set = new HashSet<>();
        while (a != null || b != null)
        {
            //System.out.println(a + " " + b);
            if (a!= null && !set.add(a.val))  return a;
            if (b!= null && !set.add(b.val)) return b;

            if (a!= null) a = a.next;
            if (b!= null) b = b.next;
        }
        return null;
    }


    public static void main(String[] args) {
	Main m = new Main();
	ListNode n = m.getIntersectionNode(new ListNode(1),null);
        System.out.println(n.val);
    }
}
