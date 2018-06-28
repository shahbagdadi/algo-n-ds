import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    List<Integer> values = new ArrayList<>();
    Map<Integer,Integer> multiplyMap = new HashMap<>();

    int multiplyFactor = 1;

    public void add(int value) {
        multiplyMap.put(values.size(), multiplyFactor);
        values.add(value);
    }

    public int get(int index) {
        return values.get(index) * (multiplyFactor/multiplyMap.get(index)) ;
    }

    public void multiplyToAll(int number) {
        multiplyFactor*=number;
        System.out.println("MF =" + multiplyFactor);
    }

    public static void main(String[] args) {

        Main m = new Main();
        Main list = new Main();
        list.add(2);
        System.out.println("get 0 should be 2="+list.get(0));
        list.multiplyToAll(2);
        System.out.println("get 0 should be 4="+list.get(0));
        list.add(3);
        System.out.println("get 1 should be 3="+list.get(1));
        list.multiplyToAll(-3);
        System.out.println("get 0 should be 12="+list.get(0));
        System.out.println("get 1 should be 9="+list.get(1));
        list.add(4);
        System.out.println("get 2 should be 4="+list.get(2));
        list.multiplyToAll(-4);
        System.out.println("get 0 should be 48="+list.get(0));
        System.out.println("get 1 should be 36="+list.get(1));
        System.out.println("get 2 should be 16="+list.get(2));
        list.add(5);
        System.out.println("get 0 should be 48="+list.get(0));
        System.out.println("get 1 should be 36="+list.get(1));
        System.out.println("get 2 should be 16="+list.get(2));
        System.out.println("get 3 should be 5="+list.get(3));
        System.out.println();
    }
}
