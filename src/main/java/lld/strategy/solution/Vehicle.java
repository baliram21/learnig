package lld.strategy.solution;

public class Vehicle {

    private final DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        System.out.println(this.getClass().getSimpleName());
        driveStrategy.drive();
    }
}
