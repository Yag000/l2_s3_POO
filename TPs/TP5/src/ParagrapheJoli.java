public class ParagrapheJoli extends Paragraphe {
    private int maxLengthPage;

    public ParagrapheJoli(int maxLengthPage) {
        this.maxLengthPage = maxLengthPage;
    }

    @Override
    public void addChaine(ChaineCar c) {
        if (lignes == null || lignes.size() == 0)
            super.addChaine(c);
        else {
            if (lignes.getLast().len() + c.len() > maxLengthPage)
                lignes.add(new Ligne());

            super.addChaine(c);

        }
    }

}
