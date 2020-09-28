package H1;

import java.lang.*;

public class TypesOefening {

    public static void huiswerkOpdrachtDrie() {

        int z = 2;
        int x = z++;
        System.out.println("A: " + x); //omdat ++ na 'z' staat is hij nog niet opgehoogd, dus x = 2
        System.out.println("A: " + z); //'z' zelf is al wel opgehoogd, ondanks dat de ++ erna staat, dus z = 3

        x = ++z;
        System.out.println("B: " + x);//omdat ++ voor 'z' staat is hij al wel opgehoogd, dus x = 4
        System.out.println("B: " + z);//'z' zelf is ook opgehoogd, dus z = 4

        int i = 3;
        int j = i < 3 ? i++ + ++i : ++i >>> 1;
        System.out.println("C: " + j); // 3 + 1 = 4, maar er wordt 1 bit naar rechts geschoven, dus is de uitkomst 2

        byte b1 = 0b1010;
        byte b2 = 0b100;
        System.out.println("D: " + (b1 + b2)); //uitkomst is '14' want 00001010 = '10' en 00000100 = '4'
    }

    public static void dagenLaterOpdracht() {

        int hours = 80;
        int dagenLater = hours / 24;
        int urenover = hours % 24;
        System.out.println(dagenLater);
        System.out.println(urenover);

        int currenttime = 23;
        int newtime = ((currenttime + 80) % 24);

        System.out.println("Het zal " + dagenLater + " dagen en " + urenover + " uren later zijn.");
        System.out.println("Dit betekent dat het " + newtime + " uur zal zijn.");
    }

    public static void clientName() {

        String client1 = new String("Jan");
        String client2 = new String("Piet");
        client2 = client1;
        client2 = "Joris";
        System.out.println(client1); //client1 blijft 'Jan', het is client2 die steeds verandert

    }
}
