package H4;

import java.util.Scanner;

public class Hourglass {

    public static int leesInput() {

        System.out.println("Voer een oneven nummer in: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        int userInt = Integer.parseInt(userInput);

        return userInt;

    }

    public static int checkInput(int k) throws Exception {

        if (k % 2 != 0) {
            System.out.println("Bedankt voor het oneven nummer!");
        } else {
            throw new Exception();
        }
        return k;
    }

    public static void createHourglass(int n) {
        System.out.println("Hieronder wordt de zandloper geprint: ");

        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }

    }

}