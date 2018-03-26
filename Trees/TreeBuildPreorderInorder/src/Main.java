public class Main {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return formTree(0,0,preorder.length-1,preorder,inorder);
    }

    TreeNode formTree(int ps, int is, int ie,int[] ap, int[]ai)
    {
        if(ie < is || ps > ap.length-1) return null;
        TreeNode root = new TreeNode(ap[ps]);
        int index =0;
        for (int i = is; i <= ie; i++) {
            if (ap[ps] == ai[i]) {
                index = i;
                break;
            }
        }
        root.left = formTree(ps+1,is,index-1,ap,ai);
        root.right = formTree(ps+1+index-is,index+1,ie,ap,ai);
        return root;
    }


    public static void main(String[] args) {

        int[] ap = new int[]{3,9,5,6,10,20,15,7};
        int[] ai = new int[]{5,6,9,10,3,15,20,7};
        Main m = new Main();
        TreeNode n = m.buildTree(ap,ai);
        TreeNode.printInorder(n);

    }
}
