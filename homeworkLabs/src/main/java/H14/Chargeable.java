package H14;

public interface Chargeable {

    int charge(int amount) throws BatteryCapacityOverflowException;
}
