package org.example.executer;

public class TriggerEmailForPolicy implements Runnable {

    private Customer customer;
    private int threadNumber;

    public TriggerEmailForPolicy(Customer customer, int threadNumber) {
        this.customer = customer;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        sendEmail(customer);
    }

    public void sendEmail(Customer customer) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hi ").append(customer.getName()).append(", ");
        sb.append("your policy number ").append(customer.getPolicyNumber()).append(" has a due premium. Please pay it before 31 March. ");
        sb.append("Thank You. ");
        sb.append("LIC");
        String message = sb.toString();
        System.out.println("Thread number " + threadNumber + ": Sending email to customer " + customer.getName());
        System.out.println(message);
    }
}
