package H5;

import java.util.Arrays;

public class Lab {

    public int greatest(int x, int y){

        if(x > y){
            return x;
        } else return y;
    }

    public String greatest(String x, String y){

        int stringLenghtX = x.length();
        int stringLenghtY = y.length();

        if(stringLenghtX > stringLenghtY){
            return x;
        } else return y;
    }

    public int greatest(int...values){

        int grootste = 0;
        for(int value: values){
            if(value > grootste){
                grootste = value;
            }
        }
        return grootste;

    }

    public int factorial(int n){

        if(n <= 1) return n;
        return n * factorial(n - 1);

    }

    public void testMethode(String s){
        s = s + "1";
        System.out.println(s);

    }
}
