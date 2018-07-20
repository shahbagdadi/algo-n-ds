public class Main {

    public void connect(TreeLinkNode root) {
        while(root != null){
            TreeLinkNode tmpChild = new TreeLinkNode(0);
            TreeLinkNode cur = tmpChild;
            while(root!=null){
                if(root.left != null) { cur.next = root.left; cur = cur.next;}
                if(root.right != null) { cur.next = root.right; cur = cur.next;}
                root = root.next;
            }
            root = tmpChild.next;
            print(root);
        }
    }

    void print(TreeLinkNode node){
        while (node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Main m = new Main();
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        TreeLinkNode t5 = new TreeLinkNode(5);
        TreeLinkNode t6 = new TreeLinkNode(6);
        TreeLinkNode t7 = new TreeLinkNode(7);
        t1.left = t2; t1.right = t3;
        t2.left = t4; t2.right = t5;
        //t3.left = t6;
        t3.right = t7;

        m.connect(t1);
    }
}
