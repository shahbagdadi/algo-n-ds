import java.util.*;

public class Main {


    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        List<String> res = new ArrayList<>();
        int min_sum = Integer.MAX_VALUE, sum;
        for (int j = 0; j < list2.length && j <= min_sum; j++) {
            if (map.containsKey(list2[j])) {
                sum = j + map.get(list2[j]);
                if (sum < min_sum) {
                    res.clear();
                    res.add(list2[j]);
                    min_sum = sum;
                } else if (sum == min_sum)
                    res.add(list2[j]);
            }
        }
        return res.toArray(new String[res.size()]);
    }


    public static void main(String[] args) {
        Main m = new Main();
        String[] s1 = new String[]{"Shogun", "KFC", "Tapioca Express", "Burger King"};
        String[] s2 = new String[]{"KFC", "Shogun", "Burger King"};
        String[] op = m.findRestaurant(s1, s2);
        System.out.println(Arrays.toString(op));
    }
}
