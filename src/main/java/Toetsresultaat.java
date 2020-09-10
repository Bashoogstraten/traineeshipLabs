public class Toetsresultaat {
    public static void main(String[] args) {
        bepaalResultaat(29);
    }

    static String bepaalResultaat (int punten) {
            String resultaat = "onbekend";

            if (punten < 30) {
                resultaat ="onvoldoende";
            } else if (punten < 60) {
                resultaat ="voldoende";
            } else {
                resultaat ="ruim voldoende";
            }

            return resultaat;
    }
}
