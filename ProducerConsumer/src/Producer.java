import java.util.Random;

public class Producer extends Thread {
    private MyBoundedQueue queue;
    private Random random;

    public Producer(MyBoundedQueue queue, String name) {
        super(name);
        this.queue = queue;
        random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == queue.getMaxSize()) {
                    try {
                        System.out.println("Queue is full, " + getName() + " thread waiting for " + "consumer to take something from queue");
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                int i = random.nextInt();
                System.out.println("Producing value : " + i);
                queue.add(i);
                queue.notifyAll();
            }
            try {
                sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

