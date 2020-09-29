package scannertestmocking;

import java.util.Scanner;

public class ScannerWrapper {

    Scanner scanner = new Scanner(System.in);

    public String read(){

        return scanner.nextLine();

    }

}
