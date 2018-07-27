import java.util.*;

public class Main {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int room = q.poll();
            visited.add(room);
            for (int i :rooms.get(room))
                if (!visited.contains(i)) q.offer(i);
        }
        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        List<Integer> r0 = new ArrayList<>();
        r0.add(1);
        r0.add(2);
        List<Integer> r1 = new ArrayList<>();
        r1.add(3);
        r1.add(0);
        r1.add(1);
        List<Integer> r2 = new ArrayList<>();
        r2.add(2);
        List<Integer> r3 = new ArrayList<>();
        r3.add(0);
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(r0);
        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        Main m = new Main();
        System.out.println(m.canVisitAllRooms(rooms));

    }
}
