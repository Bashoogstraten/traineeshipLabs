package H13;

import java.util.Arrays;

public class Start {
    public static void main(String[] args) {

        MyIntCollection collection;
        collection = new MyIntCollection();

        collection.addInts(3);
        collection.addInts(4);
        collection.addInts(5);
        collection.addInts(6);
        collection.addInts(7);
        collection.addInts(8);
        System.out.println(Arrays.toString(collection.getInhoud()));



    }
}
