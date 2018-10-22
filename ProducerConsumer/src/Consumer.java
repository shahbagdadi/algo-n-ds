import java.util.Random;

public class Consumer extends Thread {
    private MyBoundedQueue<Integer> queue;
    Random rand;

    public Consumer(MyBoundedQueue<Integer> queue, String name) {
        super(name);
        this.queue = queue;
        rand = new Random();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty," + getName() + " thread is waiting" + " for producer thread to put something in queue");
                    try {
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("Consuming value : " + queue.remove());
                queue.notifyAll();
            }
            try {
                sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

