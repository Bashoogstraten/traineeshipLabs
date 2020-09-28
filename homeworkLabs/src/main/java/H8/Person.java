package H8;

public class Person {

    private String firstName;
    private int age;
    private Gender gender;

    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 130;
    public static final int numberOfPossibleGenders = Gender.values().length;

    public Person() {

    }

    public Person(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
        this.gender = Gender.UNKNOWN;
    }

    public Person(String firstName, int age, Gender gender) {
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;

    }

    public String toString(){
        return (this.firstName + " (" + this.age + ") is " + this.gender + ".");

    }

    public boolean equals(Person p){

        if (p.age == this.age && p.firstName.equals(this.firstName) && p.gender == this.gender){
            return true;
        } else {
            return false;
        }
    }

    public int hashCode(){
        return this.age * this.firstName.hashCode() * this.gender.hashCode();
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
}


