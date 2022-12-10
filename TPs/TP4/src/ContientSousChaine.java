/**
 * C'est un prédicat qui renvoie vrai si le titre d'un média contient une
 * sous-chaîne donnée
 */
public class ContientSousChaine extends Predicat {
    private String sousChaine;

    public ContientSousChaine(String sousChaine) {
        this.sousChaine = sousChaine;
    }

    @Override
    public boolean estVrai(Media doc) {
        return doc.getTitre().contains(sousChaine);
    }

}
