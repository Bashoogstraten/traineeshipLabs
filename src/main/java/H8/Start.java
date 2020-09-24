package H8;

public class Start {
    public static void main(String[] args) {

        try {

            Person jan = new Person("Jan", 24, Gender.MALE);
            Person kees = new Person("Jan",25, Gender.MALE);
            Person clara = new Person("Clara", 25, Gender.FEMALE);
            System.out.println(jan.getGender());
            jan.setGender(Gender.MALE);
            System.out.println(jan.getGender());
            jan.haveBirthday();
            System.out.println(jan.getAge());
            System.out.println(Person.numberOfPossibleGenders);

            System.out.println(jan.toString());

            System.out.println(jan.equals(kees));

            System.out.println(jan.hashCode());
            System.out.println(kees.hashCode());
            System.out.println(clara.hashCode());



        } catch (PersonDiedException e) {
            System.err.println("This person has died!");
        }

    }

}

