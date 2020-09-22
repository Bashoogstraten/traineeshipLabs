package H5;

public class Start {
    public static void main(String[] args) {

        Lab lab = new Lab();


        /*
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
        System.out.println(naam);*/

        Fibo fibo = new Fibo();

        //fibo.runFibo(6);

        //fibo.runFibo(4,6);

        fibo.runFibo(1,1,6);


    }

}
