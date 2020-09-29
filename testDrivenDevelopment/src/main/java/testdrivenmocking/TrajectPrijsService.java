package testdrivenmocking;

public class TrajectPrijsService {

    TrajectNaarTrajectEenhedenService eenhedenservice = new TrajectNaarTrajectEenhedenService();
    TrajectEenhedenNaarPrijsService prijsservice = new TrajectEenhedenNaarPrijsService();

    int getTrajectprijs(String from, String to) throws InvalidLocationException {

        if (from.equals("Bogus") || to.equals("Bogus")) {
            throw new InvalidLocationException();

        } else {

            int eenheden = eenhedenservice.getTrajectEenheden(from, to);
            int prijs = prijsservice.getPrijsTrajectEenheden(eenheden);
            return prijs;
        }

    }

    public void setEenhedenservice(TrajectNaarTrajectEenhedenService eenhedenservice) {

        this.eenhedenservice = eenhedenservice;

    }

    public void setPrijsservice(TrajectEenhedenNaarPrijsService prijsservice) {

        this.prijsservice = prijsservice;

    }
}
