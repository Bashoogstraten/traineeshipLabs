package H10;

public class Start {
    public static void main(String[] args) throws ArgumentOutOfRangeException {

        try{
            RegularCard jantje = new RegularCard(0, "Jantje", 5000);
            GoldCard bas = new GoldCard(1,"Bas", 5000);
            bas.setDiscount(20);

            System.out.println(jantje.pay(500));
            System.out.println(jantje.getCreditBalance());

            System.out.println(bas.pay(500));
            System.out.println(bas.getCreditBalance());

        } catch (ArgumentOutOfRangeException e){
            System.out.println("This discount is out of the allowed range.");
        }


    }
}
