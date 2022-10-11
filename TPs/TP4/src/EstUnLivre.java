public class EstUnLivre extends Predicat {

    @Override
    public boolean estVrai(Media doc) {
        return doc instanceof Livre;
    }

}
