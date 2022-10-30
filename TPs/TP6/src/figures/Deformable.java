package figures;

public interface Deformable {

    /**
     * Produit une deformation dans une figure déformable
     * 
     * @param coeffH coefficient de deformation horizontal
     * @param coeffV coefficient de deformation vertical
     */
    Figure deformation(double coeffH, double coeffV);

}
