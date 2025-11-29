package org.example.thread.printNum;

public class TaskGenerator implements Runnable {
    private final NumberGenerator numberGenerator;
    private final int result;

    public TaskGenerator(NumberGenerator numberGenerator, int result) {
        this.numberGenerator = numberGenerator;
        this.result = result;
    }

    @Override
    public void run() {
        try {
            numberGenerator.printNum(result);
        } catch (InterruptedException e) {
            // restore interrupt status and exit
            Thread.currentThread().interrupt();
        }
    }
}
