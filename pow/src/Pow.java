/**
 * Created by sbagdadi on 1/27/18.
 */
public class Pow {
    static int ipow(int base, int exp)
    {
        int result = 1;
        while (exp !=0){
            if ((exp & 1) !=0)
                result *= base;
            exp >>= 1;
            base *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Ans = " + ipow(3,4));
    }
}
