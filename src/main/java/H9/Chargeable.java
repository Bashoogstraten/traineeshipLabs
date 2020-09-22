package H9;

public interface Chargeable {

    int charge(int amount) throws BatteryCapacityOverflowException;
}
