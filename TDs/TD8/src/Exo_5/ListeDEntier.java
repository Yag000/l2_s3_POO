package Exo_5;

import java.util.LinkedList;

public class ListeDEntier implements BoiteAEntiers {

    LinkedList<Integer> liste;

    public ListeDEntier() {
        liste = new LinkedList<>();
    }

    @Override
    public int lire(int index) {
        return liste.get(index);

    }

    @Override
    public void ajouter(int valeur) {
        liste.add(valeur);
    }

    @Override
    public void vider() {
        liste.clear();
    }

    @Override
    public int nombreDElements() {
        return liste.size();
    }

}
