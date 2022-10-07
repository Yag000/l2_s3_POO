public class Deplacement {
    private int x0, y0, x1, y1;

    public Deplacement(int x0, int y0, int x1, int y1) {
        this.x0 = x0;
        this.x0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public Deplacement(String start, String end, int longeur) {
        this.x0 = start.charAt(0) - 'a';
        this.y0 = longeur - start.charAt(1);
        this.x1 = end.charAt(0) - 'a';
        this.y1 = longeur - end.charAt(1);
    }

    /**
     * Cette fonction renvoie la valeur absolue de la différence entre les
     * coordonnées x0 et x1.
     * 
     * @return La valeur absolue de la différence entre x0 et x1.
     */
    public int distX() {
        return Math.abs(x0 - x1);
    }

    /**
     * Cette fonction renvoie la valeur absolue de la différence entre les
     * coordonnées y des deux
     * points.
     * 
     * @return La valeur absolue de la différence entre les deux coordonnées y.
     */
    public int distY() {
        return Math.abs(y0 - y1);
    }

    /**
     * Il renvoie un caractère qui représente le type de mouvement effectué par la
     * pièce
     * 
     * @return Le type de mouvement de la pièce.
     */
    public char typeDeplacement() {
        if (x0 == x1)
            return 'v';
        if (y0 == y1)
            return 'h';
        if (distX() == distY())
            return 'd';
        if ((distX() == 2 && distY() == 1) ||
                (distY() == 2 && distX() == 1))
            return 'c';
        return 'x';
    }

    /**
     * Il renvoie la distance entre les deux points, en fonction du type de
     * mouvement
     * 
     * @return La distance entre les deux points.
     */
    public int dist() {
        switch (this.typeDeplacement()) {
            case 'v':
                return distX();
            case 'h':
                return distY();
            case 'd':
                return distY();
            default:
                return -1;
        }
    }

    public boolean movesForward(boolean isWhite) {
        if (isWhite)
            return y1 > y0;
        return y1 < y0;
    }

    @Override
    public String toString() {
        return "Deplacement [x0=" + x0 + ", y0=" + y0 + ", x1=" + x1 + ", y1=" + y1 + "]";
    }

    public int getX0() {
        return x0;
    }

    public int getY0() {
        return y0;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

}
