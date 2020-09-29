package H11;

public class Start {
    public static void main(String[] args) throws Throwable {

        try {
            Person bas = new Person("Bas", 25, Gender.MALE);
            System.out.println(bas.getGreet());
            //bas = null;

            Android terminator = new Android();
            System.out.println(terminator.getGreet());
            terminator.charge(50);
            System.out.println("My energy levels are at: " + terminator.getEnergy());
            System.out.println(terminator.getGreet());

            Employee wageslave = new Employee();
            System.out.println(wageslave.getGreet());

            Teacher aardrijkskunde = new Teacher("Teun");
            System.out.println(aardrijkskunde.getGreet());

            Thread.sleep(1000);
            System.gc();

        } catch (BatteryCapacityOverflowException e) {
            System.out.println("Charge action rejected. Bleep bleep bloop bleep.");
        }

    }
}
