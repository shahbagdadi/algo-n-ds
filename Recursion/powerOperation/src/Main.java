public class Main {

    /**
     * Time - O(log n) where n is the exp
     * Space - O(1)
     */
    float ipow(int base, int exp) {
        int result = 1;
        while (exp != 0) {
            if ((exp & 1) != 0)
                result *= base; // if odd then multiply by base for the odd one
            exp >>= 1; // right shift 1 bit to half the exponential
            base *= base; // double the base
        }
        return result;
    }

    /**
     * Time - O(log n) where n is the exp
     * Space - O(log n) where n is the exp
     */
    float rpow(int base, int exp) {
        if (exp == 0) return 1;
        if (exp < 0){
            base = 1/base;
            return (exp %2 == 0) ? rpow(base * base, -(exp/2)) : base * rpow(base * base, -(exp/2));
        }
        //half the exponential & double the base
        return (exp % 2 == 0) ? rpow(base * base, exp/2) : base * rpow(base * base, exp/2);
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("Ans = " + m.ipow(3, 2));
        System.out.println("Ans = " + m.rpow(3, 2));
    }
}
