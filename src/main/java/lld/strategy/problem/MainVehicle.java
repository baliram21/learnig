package lld.strategy.problem;

public class MainVehicle {
    public static void main(String[] args) {
        System.out.println("main method from main vehicle");
        Vehicle vehicle = new Vehicle();
        vehicle.drive();

        vehicle = new SportsVehicle();
        vehicle.drive();

        vehicle = new NormalVehicle();
        vehicle.drive();

    }
}
