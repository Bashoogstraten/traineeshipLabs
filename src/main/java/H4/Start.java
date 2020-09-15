package H4;

public class Start {
    public static void main(String[] args) {

        while (true) {

            try {

                int k = Hourglass.checkInput(Hourglass.leesInput());
                Hourglass.createHourglass(k);
                break;

            } catch (NumberFormatException e) {
                System.out.println("Je moet een getal invoeren.");

            } catch (Exception e) {
                System.out.println("Je moet een oneven getal invoeren.");
            }
        }
    }
}