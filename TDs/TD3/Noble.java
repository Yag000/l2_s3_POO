public class Noble extends Personne{

    private int maxDette, dette;


    public Noble(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return super.toString() + "Je suis un noble";
    }

    @Override
    public boolean donnerArgent(int montant) {
        return super.donnerArgent(montant - (maxDette - dette));
    }

    
    
}
