package H14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@MyAnnotation
public class Person extends Human {

    private String firstName;
    private int age;
    private Gender gender;

    ArrayList<String> historyArray = new ArrayList<>();
    private int counter;

    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 130;
    public static final int numberOfPossibleGenders = Gender.values().length;

    @MyAnnotation
    private class HistoryRecord {
        String description;

        public HistoryRecord(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "HistoryRecord: " + description;
        }
    }

    @MyAnnotation2
    public void addHistory(String descr) {
        historyArray.add(descr);

    }

    @MyAnnotation2
    public void printHistory(ArrayList print) {
        for (Object n : print) {

            System.out.print(n + " ");

        }
        System.out.println();
    }

    public Human createSubHuman() {
        return new Human() {
            @Override
            public String getGreet() {
                return ("Sub is the best.");
            }
        };
    }

    public Person() {
        this(" ");

    }

    public Person(String firstName) {
        this(firstName, 0);

    }

    public Person(String firstName, int age) {
        this(firstName, age, Gender.UNKNOWN);
    }

    public Person(String firstName, int age, Gender gender) {
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;

    }

    public String getGreet() {
        return ("Hello, my name is " + this.firstName + ". Nice to meet you!");
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setAge(int age) {
        if (age > MIN_AGE && age < MAX_AGE) {
            this.age = age;
        }
    }

    public int getAge() {
        return this.age;
    }

    @MyAnnotation2
    public void haveBirthday() throws PersonDiedException {
        if (age < MAX_AGE) {
            this.age++;
        } else {
            throw new PersonDiedException();
        }
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {

        return this.gender;
    }

    public void finalize() throws Throwable {
        System.out.println("Finalizer has run.");
        super.finalize();
    }

    @Override
    public String toString(){
        return this.firstName + ", age: " + this.age + ", gender: " + this.gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(firstName, person.firstName) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, age, gender);
    }
}


