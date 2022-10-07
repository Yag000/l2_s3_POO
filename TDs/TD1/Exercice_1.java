public class Personne {
    private String nom;
    private String prenom;
    public int age;
    public Personne(String nom, String prenom, int age){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }
    public void setPrenom(String p){
        this.prenom = p;
    }
    public void anniversaire(){
        this.age ++;
    }
    public String toString(){
        return "Je m'appelle : " + this.prenom
    + " " + this.nom + ". J'ai " + this.age + " ans.";
    }
}

public class Test {
    public static void main(String[] args){
        Personne tony = new Personne("Parker","Tony",29);
        System.out.println(tony);
        Personne mickael = tony;
        mickael.setPrenom("Mickael");
        System.out.println(tony);//équivalent à System.out.println(tony.toString());
        //Voir remarque

        /*
         * 
         * Question 1:
         * 
         * Je m'appelle Tony Parker. J'ai 29 ans
         * Je m'appelle Mickael Parker. J'ai 29 ans
         * 
         * Question 2:
         * 
         * On peur faire le nom public, sinon le code 
         * propose ne amrche pas
         * 
         * Age public makes no sense, should use anniversaire
         * whith a proper getter
         * 
         * Question 3:
         * 
         * Dans cas on aurait put faiere cela 
         * 
         */
    }
}