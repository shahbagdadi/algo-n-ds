import java.util.HashMap;

public class Main {

    HashMap<Integer,Integer> map = new HashMap<>();
    int min , max;
    public int[] vertical(Node n)
    {
        verticalSum(n,0);
        int[] ans = new int[max - min];
        for (int i = min, k=0 ; i< max; i++, k++)
            ans[k] = map.get(i);
        return ans;
    }


    public void verticalSum(Node n,int col)
    {
        if (n == null) return ;
        min = (col < min) ? col : min;
        max = (col > min) ? col : max;
        int sum = map.getOrDefault(col,0) + n.data;
        map.put(col,sum);
        verticalSum(n.left,col-1);
        verticalSum(n.right,col+1);
    }

    public static void main(String[] args) {

        Main m = new Main();

        System.out.println();
    }
}
