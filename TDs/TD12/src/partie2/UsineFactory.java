package partie2;

public class UsineFactory {

    boolean debugMode = false;

    Usine createUsine() {
        if (debugMode)
            return new UsineProxy();
        else
            return new MonUsine();
    }

    void setDebugMode(boolean b) {
        this.debugMode = b;
    }

}
