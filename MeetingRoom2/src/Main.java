import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public int minMeetingRooms(Interval[] intervals) {

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        PriorityQueue<Interval> rooms = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });

        for (Interval i : intervals) {
            System.out.println("Meeting " + i.start + " end " + i.end);
            if (!rooms.isEmpty()) {
                Interval room = rooms.poll();
                if (room.end <= i.start)
                    room.end = i.end;
                else
                    rooms.offer(i);
                rooms.offer(room);
            } else
                rooms.offer(i);
        }
        return rooms.size();
    }


    public static void main(String[] args) {
        Interval[] meetings = new Interval[]{new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20)};
        Main m = new Main();
        int cnt = m.minMeetingRooms(meetings);
        System.out.println(cnt);
    }
}
