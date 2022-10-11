public class EstUnLivre extends Predicat {

    @Override
    public boolean estVrai(Media doc) {
        // TODO Auto-generated method stub
        return doc instanceof Livre;
    }

}
