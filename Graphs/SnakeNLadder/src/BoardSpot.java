import java.util.ArrayList;

/**
 * Created by sbagdadi on 2/12/18.
 */
public class BoardSpot {
    int pos;
    int dist;
    ArrayList<String> path;
    public BoardSpot(int num)
    {
        this.pos = num;
        path = new ArrayList<String>();
    }
}
