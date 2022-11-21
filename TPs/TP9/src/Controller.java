import java.awt.Color;

public class Controller {
    Model model;
    Vue vue;

    public Controller(Model model, Vue vue) {
        this.model = model;
        this.vue = vue;
    }

    public void sliderMoved() {
        var sliders = vue.getSliders();

        model.setColor(new Color(sliders[0].getValue(), sliders[1].getValue(), sliders[2].getValue()));

        vue.miseAJour();
    }

    public void updateColor(Color c) {
        model.setColor(c);
        vue.miseAJour();
        vue.updateSliders(c);
    }

}
