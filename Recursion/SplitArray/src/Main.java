import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {


    public boolean splitArray(int[] nums) {
        return helper(nums,0,0,0);
    }

    boolean helper(int [] num, int start, int group1, int group2)
    {
        if(start >= num.length) return group1 == group2;
        return helper(num,start+1,group1 + num[start],group2)
                || helper(num,start+1 , group1,group2 + num[start]);
    }


    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        System.out.println(m.splitArray(new int[]{2,2,10,10,1,1}));
    }
}
