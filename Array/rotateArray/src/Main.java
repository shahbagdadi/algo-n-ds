public class Main {


     static void rotateArray(int[] a, int k)
     {
         int l = a.length-1;
         int i=0, t1, t2;
         while (i < k)
         {
             t1 = a[l];
             for (int j = 0; j < a.length; j++) {
                 t2 = a[j];
                 a[j] = t1;
                 t1 = t2;
             }
             i++;
         }
     }
    public static void main(String[] args) {
         int[] ip = new int[] {1,2,3,4,5,6,7};
	    rotateArray(ip,3);
        for (int i = 0; i <ip.length ; i++) {
            System.out.print(ip[i] + " , " );
        }
    }
}
