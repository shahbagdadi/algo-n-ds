public class MajorityElement {

    public static void main(String[] args) {
        int[] input = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        printMajority(input);
    }

    private static void printMajority(int[] input) {

        int max_cnt = 0;
        int max_element = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != input[max_element]) {
                if (max_cnt > 0)
                    max_cnt--;
                else {
                    max_element = i;
                    max_cnt = 1;
                }
            } else
                max_cnt++;
        }
        // validate if max_element has majority
        int max = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[max_element] == input[i])
                max++;
        }
        if (max >= input.length/2)
            System.out.println(input[max_element]);
        else
            System.out.println("NONE");
    }
}
