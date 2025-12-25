package other.baliram.thread.oddeven;

public class MainOddEven {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer(10);

        Thread t1 = new Thread(()->{
            try {
                printer.evenPrinter();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(()-> {
            try {
                printer.oddPrinter();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
