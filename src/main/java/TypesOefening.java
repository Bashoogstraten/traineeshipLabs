public class TypesOefening {

    public void huiswerkOpdrachtDrie(){

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

        //byte b1 = 0b100;

    }
}
