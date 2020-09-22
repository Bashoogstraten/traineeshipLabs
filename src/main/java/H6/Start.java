package H6;

public class Start {
    public static void main(String[] args) {

        Homework hw6 = new Homework();

        long[] row = new long[4];
        row[0] = 1;
        row[1] = 2;
        row[2] = 3;
        row[3] = 4;

        hw6.extendArray(row);
        hw6.printArray(row);
        hw6.multiply(row, 2);

    }

}
