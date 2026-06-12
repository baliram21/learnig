package lld.strategy.solution;

public class DemoDrive {
    public static void main(String[] args) {
        System.out.println("main class demo drive");

        Vehicle vehicle = new Vehicle(new EVDrive());
        vehicle.drive();

        vehicle = new Vehicle(new SportsDrive());
        vehicle.drive();

        vehicle = new Vehicle(new OffDrive());
        vehicle.drive();
    }
}
