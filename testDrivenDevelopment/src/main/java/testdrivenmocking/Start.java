package testdrivenmocking;

public class Start {
    public static void main(String[] args) throws InvalidLocationException {

        try {
            TrajectPrijsService ritje = new TrajectPrijsService();
            System.out.println(ritje.getTrajectprijs("Arnhem", "Utrecht"));
        } catch (InvalidLocationException e) {
            System.out.println("One of these locations is not a valid location.");
        }

    }
}
