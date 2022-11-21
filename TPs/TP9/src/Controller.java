public class Controller {
    Model model;
    Vue vue;

    public Controller(Model model, Vue vue) {
        this.model = model;
        this.vue = vue;
    }

    public void sliderMoved() {
        var sliders = vue.getSliders();

        model.setRouge(sliders[0].getValue());
        model.setVert(sliders[1].getValue());
        model.setBleu(sliders[2].getValue());

        vue.miseAJour();
    }

}
