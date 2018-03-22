import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<List<Integer>> generate(int n) {
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> plst = null;
        for (int i = 0; i <n; i++) {
            List<Integer> l = new ArrayList<>();
            if (i >0)
                plst = lst.get(i-1);
            for (int j = 0; j <=i ; j++) {
                if (j == 0 || j == i)
                    l.add(1);
                else
                    l.add(plst.get(j-1) + plst.get(j) );
            }
            lst.add(l) ;
        }
        return lst;
    }


    public static void main(String[] args) {
	Main m = new Main();
	List<List<Integer>> lst = m.generate(5);
        for (List<Integer> l: lst) {
            for (int i : l)
                System.out.print(i);
            System.out.println();
        }
    }
}
