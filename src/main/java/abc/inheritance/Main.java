package abc.inheritance;

public class Main {
    public static void main(String[] args) {
        CardPayment cardPayment = new CardPayment();
        cardPayment.pay();

       Payment upi =  new UPIPayment();
       upi.pay();

    }
}
