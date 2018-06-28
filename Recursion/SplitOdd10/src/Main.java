public class Main {

    public boolean splitOdd10(int[] nums) {
        return helper(nums,0,0,0);
    }

    boolean helper(int [] num, int start, int group1, int group2)
    {
        if(start >= num.length) return (group1 %10 == 0 && group2 % 2==1);
        return helper(num,start+1,group1 + num[start],group2)
                || helper(num,start+1 , group1,group2 + num[start]);
    }

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        System.out.println(m.splitOdd10(new int[]{5, 1, 6, 5}));
    }
}
