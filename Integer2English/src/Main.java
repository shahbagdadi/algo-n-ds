public class Main {

    private final String[] l10 = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] l20 = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] l100 = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    private String helper(int n)
    {
        String result = "";
        if (n <10) result = l10[n];
        else if ( n < 20 ) result = l20[n-10];
        else if (n < 100) result = l100[n/10] + " " + helper(n %10);
        else if (n < 1000) result = helper(n/100) + " Hundred " + helper(n %100);
        else if (n < 1000000) result = helper(n/1000) + " Thousand " + helper(n % 1000);
        else if (n < 1000000000) result = helper(n/1000000) + " Million " + helper(n % 1000000);
        else result =  helper(n / 1000000000) + " Billion " + helper(n % 1000000000);
        return result.trim();
    }


    public static void main(String[] args) {

        Main m = new Main();
        String s = m.numberToWords(765276350);
        System.out.println(s);
    }
}

