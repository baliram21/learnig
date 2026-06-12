package abc.inheritance;

public class CardPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("Card Payment");
    }
}
