public class Main {
    public TreeNode buildTree( int[] inorder, int[] postorder) {
        return formTree(postorder.length-1,inorder.length-1,0,postorder,inorder);
    }

    TreeNode formTree(int ps, int is, int ie,int[] ap, int[]ai)
    {
        if(is < ie || ps < 0) return null;
        TreeNode root = new TreeNode(ap[ps]);
        int index =0;
        for (int i = is; i >= ie; i--) {
            if (ap[ps] == ai[i]) {
                index = i;
                break;
            }
        }
        root.left = formTree(ps-(is-index)-1,index-1,ie,ap,ai);
        root.right = formTree(ps-1,is,index+1,ap,ai);
        return root;
    }


    public static void main(String[] args) {
        int[] ap = new int[]{9,15,7,20,3};
        int[] ai = new int[]{9,3,15,20,7};
        Main m = new Main();
        TreeNode n = m.buildTree(ai,ap);
        TreeNode.printInorder(n);

    }
}
