import java.awt.Color;

import javax.swing.JSlider;

public class Controller {
    Model model;
    Vue vue;

    public Controller(Model model, Vue vue) {
        this.model = model;
        this.vue = vue;
    }

    public void sliderMoved() {
        int[] slidersValues = vue.getSlidersValues();

        model.setColor(new Color(slidersValues[0], slidersValues[1], slidersValues[2]));

        vue.miseAJour();
    }

    public void updateColor(Color c) {
        model.setColor(c);
        vue.miseAJour();
        vue.updateSliders(c);
    }

}
