package H13;

import static java.util.Arrays.copyOf;

public class MyIntCollection {

    private int[] intArray = new int[4];
    private int lenght = 0;

    public MyIntCollection() {

    }

    public MyIntCollection(int[] intArray){
        this.intArray = intArray;
    }

    public int[] getInhoud() {
        return this.intArray;
    }

    public void addInts(int number){
        if(lenght == intArray.length){
            doubleSize();
            this.intArray[lenght] = number;
            lenght++;
        } else {
            this.intArray[lenght] = number;
            lenght++;
        }
    }

    public int[] doubleSize(){
        return intArray = copyOf(intArray, intArray.length * 2);
    }

}
