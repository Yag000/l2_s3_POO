public class Pretre extends Personne {

    public Pretre(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return super.toString() + "Je suis un pretre";
    }

}
