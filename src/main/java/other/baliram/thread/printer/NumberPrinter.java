package other.baliram.thread.printer;

public class NumberPrinter {
    int num = 1;
    int limit = 20;
    int turn = 0;

    public synchronized void print(int tId) {
        while (num <= limit) {
            while (turn != tId) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (num <= limit) {
                System.out.println(Thread.currentThread().getName() + " -> " + num++);
                //num++;
                turn = (turn + 1) % 3;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        NumberPrinter printer = new NumberPrinter();

        Thread t1 = new Thread(()-> printer.print(0), "Thread-1");
        Thread t2 = new Thread(()-> printer.print(1), "Thread-2");
        Thread t3 = new Thread(()-> printer.print(2), "Thread-3");


        t1.start();
        t2.start();
        t3.start();

        /*t1.join();
        t2.join();
        t3.join();*/
    }

}
