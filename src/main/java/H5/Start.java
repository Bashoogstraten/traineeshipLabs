package H5;

public class Start {
    public static void main(String[] args) {

        Lab lab = new Lab();
        Fibo fibo = new Fibo();

        int antwoordxyz = lab.greatest(8,9);
        System.out.println(antwoordxyz);

        String antwoordLangste = lab.greatest("Long", "Longer");
        System.out.println(antwoordLangste);

        int antwoordGrootste = lab.greatest(1,2,300,4);
        System.out.println(antwoordGrootste);

        int antwoordFactorial = lab.factorial(5);
        System.out.println(antwoordFactorial);

        String naam = "Bas";
        lab.testMethode(naam);
        System.out.println(naam);

        fibo.run(6);

    }

}
