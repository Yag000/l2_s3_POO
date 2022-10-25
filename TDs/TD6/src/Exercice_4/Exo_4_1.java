package Exercice_4;

public class Exo_4_1 {
    // Exo 1

    public interface PeutCombat extends Orateur {
    }

    public interface PeutMediter extends Orateur {
    }

    public class Combat {

        Combat(PeutCombat p) {
        }
    }

    public class Meditation {

        Meditation(PeutMediter p) {
        }
    }

    public interface Orateur {
    }

    // Exo 2

}
