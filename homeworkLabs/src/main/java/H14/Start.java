package H14;

public class Start {
    public static void main(String[] args) throws Throwable {

        try {
            Person test = new Person();
            Person bas = new Person("Bas", 25, Gender.MALE);
//            System.out.println(bas.getGreet());
//
            bas.addHistory("Born in December 1994.");
            bas.addHistory("Lived in Elst in recent years.");
            bas.addHistory("Studying to become Java developer now.");
            bas.addHistory("Got a platinum trophy on AC:Odyssey.");
            bas.addHistory("Got his first Fall Guys win.");
            bas.printHistory(bas.historyArray);
//
//            Human subhuman = test.createSubHuman();
//            System.out.println(subhuman.getGreet());
//
//            Class<Person> personClassReflection = Person.class;
//
//            System.out.println(personClassReflection.getSimpleName() + " has methods: ");
//            Method[] methodsVanPersonClass = personClassReflection.getMethods();
//            for(Method method : methodsVanPersonClass){
//                System.out.println("method = " + method.getName());
//            }
//
//            System.out.println();
//
//            System.out.println(personClassReflection.getSimpleName() + " has annotations: ");
//            Annotation[] annotationsVanPersonClass = personClassReflection.getAnnotations();
//            for (Annotation annotation : annotationsVanPersonClass) {
//                System.out.println("association = " + annotation.toString());
//            }
//
//            System.out.println();
//
//            System.out.println(personClassReflection.getSimpleName() + " has methods with annotations: ");
//            Method[] methodsMetAnnotatieVanPersonClass = personClassReflection.getDeclaredMethods();
//            for(Method declaredmethod : methodsMetAnnotatieVanPersonClass){
//
//                Annotation[] annotationsBijMethoden = declaredmethod.getDeclaredAnnotations();
//                for(Annotation declaredannotation : annotationsBijMethoden){
//                    System.out.println("method = " + declaredmethod + ", with annotation: " + declaredannotation.toString());
//                }
//            }

//            House<Person> hp;
//            //House<String>hs;     not within bound, because <T extends Human>
//
//            hp = new House<>();
//            hp.setInhoud(new Person("Bas", 25, Gender.MALE));
//            System.out.println(hp.toString());












        } catch (Exception e) {
            System.out.println("Charge action rejected. Bleep bleep bloop bleep.");
        }

    }
}
