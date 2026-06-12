package lld.strategy.problem;

public class NormalVehicle extends Vehicle{
    @Override
    public void drive() {
        System.out.println(this.getClass().getSimpleName());
        System.out.println("Normal vehicle drive");
    }
}
