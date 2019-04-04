public class Main {

    public boolean groupSum(int[] a, int i, int t)
    {
        if ( i >= a.length || t == 0) return true;
        return groupSum(a,i+1, t-a[i]) || groupSum(a,i+1, t);
    }


    public static void main(String[] args) {

        Main m = new Main();
        int[] ip = {4,-1,2,0,5,};
        System.out.println(m.groupSum(ip,0,3));
    }
}
