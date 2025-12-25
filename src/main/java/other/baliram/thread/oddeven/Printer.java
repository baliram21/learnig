package other.baliram.thread.oddeven;

class Printer {

    int num = 1;
    int limit = 10;

    public Printer(int limit) {
        this.limit = limit;
    }

    public synchronized void oddPrinter() throws InterruptedException {
        while (num <= limit) {
            if (num % 2 == 0) {
                wait();
            } else {
                System.out.println("Odd Thread : " + num);
                num++;
                notifyAll();
                ;
            }
        }
    }

    public synchronized void evenPrinter() throws InterruptedException {
        while (num <= limit) {
            if (num % 2 != 0) {
                wait();
            } else {
                System.out.println("Even Thread : " + num);
                num++;
                notifyAll();
                ;
            }
        }
    }
}
