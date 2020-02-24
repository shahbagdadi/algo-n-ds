/**
 * Created by sbagdadi on 1/27/18.
 */
public class Pow {
     int ipow(int base, int exp) {
        int result = 1;
        while (exp != 0) {
            if ((exp & 1) != 0)
                result *= base;
            exp >>= 1;
            base *= base;
        }
        return result;
    }

    int rpow(int x, int n)
    {
        if (n == 0) return 1;
        if ( n < 0 ) return 1 / rpow(x, -1*n);
        if ( n % 2 == 1) return rpow(x,n-1) * x;
        if ( n % 2 == 0) {
            int y =  rpow(x,n/2);
            return y * y;
        }
        return 0;
    }


    public static void main(String[] args) {
        Pow p = new Pow();
        System.out.println("Ans = " + p.ipow(3, 4));
        System.out.println("Ans = " + p.rpow(3, 4));
    }
}
