import java.util.List;

public class Main {


    public void printAllSubsets(char[] a)
    {
        char[] output = new char[a.length];
        PASHelper(a,0,output,0);
    }

    public void PASHelper(char[] a , int r, char[] output, int w)
    {
        if (r == a.length) {
            System.out.print("{");
            for (int i = 0; i < w; i++)
                System.out.print(output[i] + " ");
            System.out.println("}");
            return;
        }
        PASHelper(a,r+1,output,w);
        output[w] = a[r];
        PASHelper(a, r+1, output, w+1);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.printAllSubsets(new char[]{'a','b','c'});
    }
}
