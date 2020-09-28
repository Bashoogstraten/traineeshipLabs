package H7;

public class Start {
    public static void main(String[] args) {

        try {

            Person jan = new Person("Jan", 130);
            System.out.println(jan.getGender());
            jan.setGender(Gender.MALE);
            System.out.println(jan.getGender());
            jan.haveBirthday();
            System.out.println(jan.getAge());
            System.out.println(Person.numberOfPossibleGenders);

        } catch (PersonDiedException e) {
            System.err.println("This person has died!");
        }

    }

}

