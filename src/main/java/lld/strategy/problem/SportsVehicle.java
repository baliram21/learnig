package lld.strategy.problem;

public class SportsVehicle extends Vehicle{
    @Override
    public void drive() {
        System.out.println(this.getClass().getSimpleName());
        System.out.println("sports vehicle drive");
    }
}
