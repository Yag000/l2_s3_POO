package Exercice_4;

public class Exo_4_2 {

    public interface Membre {
    }

    public interface Orateur extends Membre {
    }

    public interface Eleve extends Membre {
    }

    public interface Apprenti extends Eleve {
    }

    public interface Disciple extends Eleve, PeutCombat {
    }

    public interface Maitre extends Membre, PeutCombat, PeutMediter {
    }

    public interface Initie extends Maitre {
    }

    public interface GrandMaitre extends Maitre {
    }

    public interface PeutCombat extends Orateur {
    }

    public interface PeutMediter extends Orateur {
    }

    public abstract class Combat {

        Combat(PeutCombat p) {
        }
    }

    public class Meditation {

        Meditation(PeutMediter p) {
        }
    }

}
