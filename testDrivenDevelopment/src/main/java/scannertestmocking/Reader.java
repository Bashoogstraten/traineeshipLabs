package scannertestmocking;

public class Reader {

    ScannerWrapper wrapped = new ScannerWrapper();

    public int getStringLenght(String input) {

        return input.length();
    }

    public String readString() {

        String input = wrapped.read();

        int lenght = getStringLenght(input);
        return "String lenght is: " + lenght;

    }

    public void setScannerWrapper(ScannerWrapper scanner) {

        this.wrapped = scanner;

    }

}
