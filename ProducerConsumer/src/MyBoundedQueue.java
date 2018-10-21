import java.util.LinkedList;

public class MyBoundedQueue<T> extends LinkedList<T> {

    int max_size = 0;
    public MyBoundedQueue(int maxSize)
    {
       this.max_size = maxSize;
    }

    public int getMaxSize()
    {
        return max_size;
    }
}
