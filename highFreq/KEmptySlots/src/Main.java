public class Main {

    public int kEmptySlots(int[] flowers, int k) {
        int[] days = new int[flowers.length];

        // record the day for each flower bloom
        for (int i = 0; i < flowers.length; i++)
            days[flowers[i] - 1] = i + 1;

        // Create a sliding window of K (flowers) elements
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;

        for (int i = 0; right < days.length; i++) {
            // For a day find if there is a day on the right which is k bloom apart
            if (days[i] < days[left] || days[i] <= days[right]) {
                if (i == right) res = Math.min(res, Math.max(days[left], days[right]));   //we get a valid subarray
                left = i;
                right = k + 1 + i;
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    public static void main(String[] args) {
        int[] ip = {1, 3, 2};
        Main m = new Main();
        System.out.println(m.kEmptySlots(ip,1));
    }
}
