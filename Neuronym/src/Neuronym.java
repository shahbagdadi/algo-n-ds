import java.util.ArrayList;

public class Neuronym {

    public static ArrayList<String> getNeuronym(String s){
        int l = s.length()-1, cnt = l-1;
        ArrayList<String> al = new ArrayList<>();
        while (cnt >= 2)
        {
            for(int i = 1 ; i <= l-cnt; i++ )
                al.add( s.substring(0,i) + cnt + s.substring(i+cnt));
            cnt--;
        }
        return al;
    }
    public static void main(String[] args) {
        ArrayList<String> al = getNeuronym("NAILED");
        for (String s: al) {
            System.out.println(s);
        }

    }
}
