import java.util.HashMap;

public class Main {

    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int n: nums) {
            if (!map.containsKey(n))
            {
                int left = map.getOrDefault(n-1,0);
                int right = map.getOrDefault(n+1,0);
                int sum = left + right +1;
                map.put(n,sum);
                max = Math.max(max,sum);
                // set boundary
                map.put(n-left,sum);
                map.put(n+right,sum);
            }
            else // duplicate n
                continue;

        }
        return max;
    }

    public static void main(String[] args) {

        Main m = new Main();
        int[] ip = {100, 4, 200, 1, 3, 2};
        System.out.println(m.longestConsecutive(ip));
    }
}
