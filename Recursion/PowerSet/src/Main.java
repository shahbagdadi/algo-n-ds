public class Main {


    public void printAllSubsets(char[] a)
    {
        char[] output = new char[a.length];
        helper(a,output,0,0);
    }

    public void helper(char[] a , char[] o, int r, int w)
    {
        if (r == a.length) {
            System.out.print("{");
            for (int i = 0; i < w; i++)
                System.out.print(o[i] + " ");
            System.out.println("}");
            return;
        }
        helper(a,o, r+1,w);
        o[w] = a[r];
        helper(a, o,r+1,  w+1);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.printAllSubsets(new char[]{'a','b','c'});
    }
}
