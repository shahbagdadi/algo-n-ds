import java.util.Arrays;

public class Main {

    void sort(int[] a)
    {
        sort(a,0,a.length-1);
    }

    private void sort(int[] a, int l, int r) {
        if (l <r)
        {
            int m = (l+r)/2;
            sort(a,l,m);
            sort(a,m+1,r);
            merge(a,l,m,r);
        }
    }

    private void merge(int[] a, int l, int m, int r) {
        int nl = m - l + 1;
        int nr = r-m;

        //tmp array
        int[] L = new int[nl];
        int[] R = new int[nr];

        for (int i = 0; i < nl; i++)
            L[i] = a[l+i];
        for (int j = 0; j < nr; j++)
            R[j] = a[m +1 +j];

        int i=0, j=0, c=l;
        while(i < nl && j < nr)
        {
            if (L[i] < R[j])
                a[c++] = L[i++];
            else
                a[c++] = R[j++];
        }

        //copy remaining
        while(i < nl)
            a[c++] = L[i++];
        while(j < nr)
            a[c++] = R[j++];
    }

    public static void main(String[] args) {
        // write your code here
        Main m = new Main();
        int[] a = {12, 11, 13, 5, 6, 7};
        m.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
