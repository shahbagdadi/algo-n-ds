import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;

public class Main {

    public int maxPoints(Point[] points) {
        if (points.length <= 0) return 0;
        if (points.length <= 2) return points.length;
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<BigDecimal, Integer> hm = new HashMap<BigDecimal, Integer>();
            int samex = 1;
            int samep = 0;
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    if ((points[j].x == points[i].x) && (points[j].y == points[i].y)) {
                        samep++;
                    }
                    if (points[j].x == points[i].x) {
                        samex++;
                        continue;
                    }
                    BigDecimal k = getSlope(points[j],points[i]);
                    // double k = (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);
                    if (hm.containsKey(k)) {
                        hm.put(k, hm.get(k) + 1);
                    } else {
                        hm.put(k, 2);
                    }
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }

    private BigDecimal getSlope(Point a, Point b){
        if(b.x == a.x){
            return BigDecimal.valueOf(Integer.MAX_VALUE);
        }
        return BigDecimal.valueOf(b.y -a.y).divide(BigDecimal.valueOf(b.x - a.x), new MathContext(20));
    }

    public static void main(String[] args) {

        Main m = new Main();
        Point[] ip = {new Point(1, 1),
                new Point(3, 2),
                new Point(5, 3),
                new Point(4, 1),
                new Point(2, 3),
                new Point(1, 4)
        };

        System.out.println(m.maxPoints(ip));
    }
}
