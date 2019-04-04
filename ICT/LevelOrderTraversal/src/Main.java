
public class Main {

    public void connectTree(Node cur)
    {
        while(cur != null){
            Node rowHead = new Node(0);
            Node prev = rowHead;
            while(cur!=null){
                if(cur.left != null) { prev.nextRight = cur.left; prev = prev.nextRight;}
                if(cur.right != null) { prev.nextRight = cur.right; prev = prev.nextRight;}
                cur = cur.nextRight;
            }
            cur = rowHead.nextRight;
            print(cur);
        }

    }

    void print(Node node){
        while (node != null){
            System.out.print(node.data + " -> ");
            node = node.nextRight;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Main m = new Main();
        Node n20 = new Node(20);
        Node n30 = new Node(30);
        Node n40 = new Node(40);
        Node n50 = new Node(50);
        Node n60 = new Node(60);
        Node n70 = new Node(70);
        Node n80 = new Node(80);
        Node n90 = new Node(90);
        Node n99 = new Node(99);
        n20.left = n30; n20.right = n40;
        n30.left = n50; n30.right = n60;
        n40.left = n70; n40.right = n80;
        n60.left = n90; n70.right = n99;
        m.connectTree(n20);
    }
}
