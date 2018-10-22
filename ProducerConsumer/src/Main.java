public class Main {

    public static void main(String[] args) {
        System.out.println("Solving Producer Consumer Problem");
        MyBoundedQueue<Integer> buffer = new MyBoundedQueue<>(10);
        Thread producer = new Producer(buffer, "PRODUCER1");
        Thread consumer1 = new Consumer(buffer,  "CONSUMER1");
        Thread consumer2 = new Consumer(buffer,  "CONSUMER2");
        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
