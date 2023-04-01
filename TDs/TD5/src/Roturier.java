import java.rmi.server.RemoteStub;

import javax.lang.model.util.ElementScanner14;
import javax.management.ObjectName;

public class Roturier extends Personne {

    public Roturier(String nom, int argent, int pdv) {
        super(nom, argent, pdv);
    }

    public Roturier(Personne p) {
        super(p);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Roturier) super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj))
            return true;
        if ((obj instanceof Archer && this instanceof Archer)
                || (obj instanceof Roturier && this instanceof Roturier))
            return ((Personne) obj).getArgent() == ((Personne) this).getArgent()
                    && ((Personne) obj).getNom() == ((Personne) this).getNom()
                    && ((Personne) obj).getPdv() == ((Personne) this).getPdv();

        if ((obj instanceof Fantassin && this instanceof Fantassin))
            return ((Fantassin) obj).getDegats() == ((Fantassin) this).getArgent();
        return false;
    }

}
