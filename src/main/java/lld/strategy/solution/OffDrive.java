package lld.strategy.solution;

public class OffDrive implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Overdrive capability");
    }
}
