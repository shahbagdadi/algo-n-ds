public class alternateArray {

    public static void main(String[] args) {
        int[] input = {-2, 3, -4, -9, 1, 7, 1, 5, 6};
        printArray(input);
        alternateArray(input);
    }

    public static void printArray(int[] input) {
        for (int i : input)
            System.out.print(i + ",");
        System.out.println();
    }

    public static void alternateArray(int[] a) {
        int i = 0;
        while (i < a.length) {
            // If Mismatch then rotate
            if (!((i % 2 == 0 && a[i] > 0) || (i % 2 > 0 && a[i] < 0))) {
                int j = findRotationIndex(a, i);
                if (j >= 0) {
                    System.out.println("Rotation from " + i + " ," + j);
                    rotateArray(a, i, j);
                    printArray(a);
                } else
                    return;
            }
            i++;
        }
        return;
    }

    private static void rotateArray(int[] a, int i, int j) {
        int c, p = a[j];
        for (int k = i; k <= j; k++) {
            c = a[k];
            a[k] = p;
            p = c;
        }
    }

    private static int findRotationIndex(int[] a, int i) {
        int j = i;
        while (j < a.length) {
            if (i % 2 == 0 && a[j] > 0)
                return j;
            else if (i % 2 > 0 && a[j] < 0)
                return j;
            j++;
        }
        return -1;
    }
}
