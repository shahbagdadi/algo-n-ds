public class Interval implements Comparable<Interval>
{
    int start;
    int end;
    public Interval(int start, int end)
    {
        this.start = start;
        this.end = end;
    }


    @Override
    public int compareTo(Interval i) {
        if (this.start > i.start)
            return 1;
        else if (this.start < i.start)
            return -1;
        else return 0;
    }
}