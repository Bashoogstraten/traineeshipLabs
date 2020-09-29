package H11;

public interface Chargeable {

    int charge(int amount) throws BatteryCapacityOverflowException;
}
