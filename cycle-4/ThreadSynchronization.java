class Table {
    static int i = 0;

    synchronized void printValue() {
        System.out.println(i++);
    }
}

public class ThreadSynchronization implements Runnable {
    @Override
    public void run() {
        Table table = new Table();
        for (int i = 0; i < 5; i++) {
            table.printValue();
        }
    }

    public static void main(String[] args) {
        ThreadSynchronization ts = new ThreadSynchronization();

        Thread thread1 = new Thread(ts);
        Thread thread2 = new Thread(ts);

        thread1.start();
        thread2.start();
    }
}