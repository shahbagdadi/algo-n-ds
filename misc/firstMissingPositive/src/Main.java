public class Main {

    public int firstMissingPositive(int[] a) {
        int i = 0;
        int sz = a.length;
        while (i < sz)
        {
            if (a[i] <=0 || a[i] > sz  || a[i] == i+1)
                i++;
            else if (a[a[i]-1] != a[i]) // avoid infinite swapping for dups
                swap(a,i,a[i]-1);
            else
                i++;
        }
        i = 0;
        while (i < sz && a[i] == i+1 ) i++;
        return i+1;
    }

    public void swap(int[] a, int i , int j)
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static void main(String[] args) {

        Main m = new Main();
        int [] ip = {3,5,2,1};
        System.out.println(m.firstMissingPositive(ip));
    }
}
