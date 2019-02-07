import java.util.*;

public class skyline {


    public static void main(String[] args) {
        int[][] input = {{1, 11, 5}, {2, 6, 7}, {3, 13, 9}, {12, 7, 16}, {14, 3, 25},
                {19, 18, 22}, {23, 13, 29}, {24, 4, 28}};
        List<int[]> skyline = getSkyline(input);
        for (int i = 0; i < skyline.size(); i++) {
            int[] points = skyline.get(i);
            System.out.println(points[0] + "," + points[1]);
        }
    }

    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        /*
        Set the start segment as negative height. This does the following when we sort
        1. make sure the start segment comes before the end.
        2. when working with the TreeMap, it is easy to distinguish whether to add or remove a segment.
        3. when the two adjacent building share same start and end x value, the next start segment always come before the end segment due to the negative height.
        */
        // Add all critical points i.e. startx and endx for all the buildings
        for (int[] b : buildings) {
            heights.add(new int[]{b[0], -b[1]}); // add startx & -height
            heights.add(new int[]{b[2], b[1]});  // add endx & height
        }

        // Comparator as a lambda function
        // sort on x , if x is equal sort on height.
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);

        // TreeMap is used instead of PriorityQueue to get O(log(N)) for removal instead of O(N) in PQ
        // setup a TreeMap with reverse natural order comparator i.e Max on top
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());

        // put 0 on top. If no bldgs on skyline this is what we get
        heightMap.put(0, 0);

        // holds max height from previous iteration
        int prevHeight = 0;

        // results linkList
        List<int[]> skyLine = new LinkedList<>();

        for (int[] h : heights) {
            //System.out.println( "X = " + h[0] + " H = " + h[1] );
            // If building start
            if (h[1] < 0) {
                Integer cnt = heightMap.getOrDefault(-h[1],0) +1;  // there could be more than 1 bldg of same height
                heightMap.put(-h[1], cnt);
            } else {
                // handle building end
                Integer cnt = heightMap.get(h[1]);
                if (cnt == 1) {
                    heightMap.remove(h[1]);
                } else {
                    heightMap.put(h[1], cnt - 1);
                }
            }
            // get the tallest building at current x.
            int currHeight = heightMap.firstKey();

            // if tallest at current is different than tallest at previous, record the change in skyline
            if (prevHeight != currHeight) {
                skyLine.add(new int[]{h[0], currHeight});
                prevHeight = currHeight;
            }
        }
        return skyLine;
    }
}
