package H5;

public class Lab {

    public static void greatest(int x, int y){

        if(x > y){
            System.out.println(x);
        } else System.out.println(y);
    }

    public static void greatest(String x, String y){

        int stringLenghtX = x.length();
        int stringLenghtY = y.length();

        if(stringLenghtX > stringLenghtY){
            System.out.println(x);
        } else System.out.println(y);
    }

    public static void greatest(int...values){

    }
}
