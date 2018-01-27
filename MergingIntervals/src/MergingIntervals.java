import java.util.ArrayList;
import java.util.Collections;

public class MergingIntervals {

    public static Interval merge(Interval prev , Interval curr)
    {
        int end = prev.end >= curr.end ? prev.end : curr.end;
        return new Interval(prev.start,end);
    }

    public static void main(String[] args) {
        // write your code here
        MergingIntervals mi = new MergingIntervals();
        ArrayList<Interval> a = new ArrayList<Interval>();
        a.add(new Interval(8, 10));
        a.add(new Interval(6, 7));
        a.add(new Interval(9, 11));
        a.add(new Interval(14, 15));
        a.add(new Interval(4, 5));
        a.add(new Interval(13, 16));
        Collections.sort(a);

        int i=1;
        Interval prev = a.get(0);
        Interval curr;
        ArrayList<Interval> result = new ArrayList<Interval>();
        while (i < a.size())
        {
            curr = a.get(i);
            if (prev.end >= curr.start)
             prev =  merge(prev,curr);
            else
            {
                result.add(prev);
                prev = curr;
            }
            i++;
        }
        result.add(prev);
        for (Interval t : result){
            System.out.println(t.start + " : " + t.end);
        }
    }
}
