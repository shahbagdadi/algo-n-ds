public class Main {
    public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;

    }

    public static void main(String[] args) {

        Main m = new Main();

        System.out.println();
    }
}
