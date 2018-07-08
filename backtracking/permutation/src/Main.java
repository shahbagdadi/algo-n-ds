/**
 *  Time - O(N!) - where n is number of characters
 *  Space - O(N) - where n is number of characters
 */
public class Main {

    public void printPerm(char[] a, int i)
    {
        if (i == a.length)
        {
            print(a);
            return;
        }

        for (int j = i; j < a.length; j++) {
            swap(a,i,j);
            printPerm(a,i+1);
            swap(a,i,j);

        }

    }

    void print(char[] a)
    {
        for (int j = 0; j < a.length; j++)
            System.out.print(a[j]);
        System.out.println();
    }

    void swap(char[] a, int i , int j)
    {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {

        Main m = new Main();
        char[] ca = new char[]{'a','b','c'};
        m.printPerm(ca,0);
    }
}
