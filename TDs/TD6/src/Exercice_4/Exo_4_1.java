package Exercice_4;

public class Exo_4_1 {

    public interface Orateur {
    }

    public interface PeutCombat extends Orateur {
    }

    public interface PeutMediter extends Orateur {
    }

    public class Cours {
    }

    public class Combat extends Cours {

        Combat(PeutCombat p) {
        }
    }

    public class Meditation extends Cours {

        Meditation(PeutMediter p) {
        }
    }
}
