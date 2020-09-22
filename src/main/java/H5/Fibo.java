package H5;

public class Fibo {

    public int runFibo(int count) {

        return runFibo(1, count);
    }

    public int runFibo(int start, int count) {

        return runFibo(start, start, count);
    }

    public int runFibo(int start1, int start2, int count) {

        int num1 = start1;
        int num2 = start2;

        for (int i = 1; i <= count; i++) {

            System.out.println(num1);

            int sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }

        return num1;

    }

}

