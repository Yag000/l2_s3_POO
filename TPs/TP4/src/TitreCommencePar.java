public class TitreCommencePar extends Predicat {

    private char lettre;

    @Override
    public boolean estVrai(Media doc) {
        return doc.getTitre().charAt(0) == lettre;
    }

}
