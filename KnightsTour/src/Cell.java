/**
 * Created by sbagdadi on 2/19/18.
 */
public class Cell {
    int r;
    int c;
    int step;
    public Cell(int x, int y, int step)
    {
        r = x;
        c = y;
        this.step = step;
    }

    @Override
    public String toString() {
        return "[" + r + "," + c + "]";
    }
}
