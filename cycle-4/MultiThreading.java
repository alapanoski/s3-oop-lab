public class MultiThreading implements Runnable {

    private int threadNumber;

    public MultiThreading(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread " + threadNumber + ", iteration " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {

        MultiThreading mt1 = new MultiThreading(1);
        MultiThreading mt2 = new MultiThreading(2);
        MultiThreading mt3 = new MultiThreading(3);

        Thread thread1 = new Thread(mt1);
        Thread thread2 = new Thread(mt2);
        Thread thread3 = new Thread(mt3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}