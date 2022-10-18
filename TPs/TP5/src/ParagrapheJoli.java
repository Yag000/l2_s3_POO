public class ParagrapheJoli extends Paragraphe {
    private int maxLengthPage;

    public ParagrapheJoli(int maxLengthPage) {
        this.maxLengthPage = maxLengthPage;
    }

    /**
     * Adds c to the last line if the length of the last line plus the length of c
     * is less or equal to the maxLengthPage, else it creates a new line with te new
     * word
     */
    @Override
    public void addChaine(ChaineCar c) {
        if (lignes.size() == 0) {
            lignes.add(new Ligne(c));
        } else {
            Ligne lastLine = lignes.getLast();
            if (lastLine.len() + c.len() <= maxLengthPage) {
                lastLine.addChaine(c);
            } else {
                lignes.add(new Ligne(c));
            }
        }
    }

    @Override
    public String toString() {
        String s = "";

        if (lignes != null)
            for (Ligne l : lignes)
                s += l.toString() + "\n";

        return s;

    }
}
