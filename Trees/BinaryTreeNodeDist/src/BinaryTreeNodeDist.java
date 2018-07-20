/**
 * Created by sbagdadi on 1/21/18.
 */
public class BinaryTreeNodeDist {

    static int dst =0;
    
    /**
     * 1. Ask each child to return the node found (i.e return either p or q) or null(MAX_VALUE) if they found neither
     * 2. The first node that has a child which has both child returning a not null is the ancestor
     */
    static int commonAncestor(int[] adj, int root, int p , int q)
    {
        if ( root > adj.length-1 || adj[root] == -1 ) return Integer.MAX_VALUE;

        if (adj[root] == p && adj[root] == q)
        {
            return root;
        }
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        int x = commonAncestor(adj,left,p,q);
        if (x != Integer.MAX_VALUE && adj[x] != p && adj[x]!=q) return x;

        int y = commonAncestor(adj,right,p,q);
        if (y != Integer.MAX_VALUE && adj[y] != p && adj[y]!=q) return y;

        if (x != Integer.MAX_VALUE && y != Integer.MAX_VALUE)
        {
            dst = dst + 2;
            return root;
        }
        else if (adj[root] == p || adj[root] == q) return root;
        else
        {
            if (x != Integer.MAX_VALUE || y != Integer.MAX_VALUE) dst++;
            return x == Integer.MAX_VALUE ? y : x;
        }

    }

    
    public static void main(String[] args) {
        int[] adj = {1,2,3,4,5,6,7,-1,-1,-1,-1,-1,8};

        commonAncestor(adj,0,4,5);
        System.out.println(" distance : " + dst);
        dst=0;
        commonAncestor(adj,0,4,6);
        System.out.println(" distance : " + dst);
        dst=0;
        commonAncestor(adj,0,3,4);
        System.out.println(" distance : " + dst);
        dst=0;
        commonAncestor(adj,0,2,4);
        System.out.println(" distance : " + dst);
        dst=0;
        commonAncestor(adj,0,8,5);
        System.out.println(" distance : " + dst);
        dst=0;

    }
}
