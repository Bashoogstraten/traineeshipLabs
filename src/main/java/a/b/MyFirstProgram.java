package a.b;

import java.util.Scanner;

import static java.lang.Math.abs;

public class MyFirstProgram {
    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("Hello World!");
        } else {
            System.out.println("Hello " + args[0]);
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Enter username");
        String userName = in.nextLine();
        System.out.println("Username is: " + userName);

        int PlusTwo = abs(-2);
    }
}
