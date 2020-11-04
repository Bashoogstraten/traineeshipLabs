package H14;

public class House<T extends Human> {

    private T inhoud;

    public T getInhoud(){
        return this.inhoud;
    }

    public T setInhoud(T t){
        this.inhoud = t;
        return this.inhoud;
    }

    @Override
    public String toString(){
        return "This house is owned by [" + inhoud.toString() + "] and it says: [" + inhoud.getGreet() + "].";
    }

}
