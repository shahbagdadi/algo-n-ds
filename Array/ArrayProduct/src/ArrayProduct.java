public class ArrayProduct {


    public static int[] arrayProduct(int[] a) {
        int l = a.length;
        int[] product = new int[l];
        int p = 1;
        for (int i = 0; i < l; i++) {
            product[i] = p;
            p *= a[i];
        }
        p=1;
        for (int i = l-1; i >=0; i--) {
            product[i] *=p;
            p *= a[i];
        }

        return product;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int[] output = arrayProduct(input);
        for (int i : output) {
            System.out.print(i + " ,");
        }
    }
}
