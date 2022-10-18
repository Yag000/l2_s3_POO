import java.util.LinkedList;

public class Paragraphe extends ChaineCar {

    LinkedList<Ligne> lignes = new LinkedList<Ligne>();

    public Paragraphe(LinkedList<Ligne> lignes) {
        if (lignes.size() != 0)
            this.lignes = lignes;
    }

    public Paragraphe() {
    }

    public int len() {
        int length = 0;

        for (Ligne l : lignes)
            length += l.len();

        return length;
    }

    public boolean isEmpty() {
        if (lignes.size() == 0)
            return true;
        for (Ligne l : lignes)
            if (!l.isEmpty())
                return false;

        return true;
    }

    public void addChaine(ChaineCar c) {
        if (lignes.size() == 0)
            lignes.add(new Ligne());

        lignes.getLast().addChaine(c);
    }

    @Override
    public String toString() {
        String s = "";

        if (lignes != null) {
            for (ChaineCar c : lignes)
                s += c;
        }
        return s;
    }

}
