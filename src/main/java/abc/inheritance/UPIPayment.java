package abc.inheritance;

public class UPIPayment implements Payment{
    @Override
    public void pay() {
        System.out.println("UPI Payment");
    }

    public void m(){
        System.out.println("upi class m method");
    }
}
