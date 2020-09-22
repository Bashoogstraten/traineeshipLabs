package H9;

public class Android extends Human implements Chargeable {

    private int energy;
    public static final int MAX_ENERGY = 100;


    @Override
    public int charge(int amount) throws BatteryCapacityOverflowException {
        if((this.energy + amount) <= MAX_ENERGY){
            this.energy =+ amount;
            return this.energy;
        } else {
            throw new BatteryCapacityOverflowException();
        }

    }

    public int getEnergy(){
        return this.energy;
    }

    public String getGreet(){
        return ("I am only half human, but still... My energy level is at: " + this.energy + "%.");
    }

}
