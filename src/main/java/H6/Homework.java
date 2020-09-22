package H6;

public class Homework {
    public long[] longs() {

        long[] row = new long[4];
        row[0] = 1;
        row[1] = 2;
        row[2] = 3;
        row[3] = 4;
        long[] copy = row;
        copy[2]++;

        return copy;

    }

    public long[] extendArray(long[] row) {
        long[] extended = new long[row.length * 2];
        for (int i = 0; i < row.length; i++) {
            extended[i] = row[i];
        }

        for (long n: extended) {
            System.out.print(n + " ");
        }

        System.out.println();

        return extended;

    }

    void multiply(long[] input, int multiplier){

        for (long n: input) {
            System.out.print((n * multiplier) + " ");
        }
        System.out.println();
    }

    public void printArray(long[] print){
        for (long n: print) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

}
