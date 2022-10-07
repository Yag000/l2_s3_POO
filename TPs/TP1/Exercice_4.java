import java.util.Random;
import java.util.Scanner; 

public class Exercice_4 {

    public static int question(int maxTentatives) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);

        // Nombre d'erreurs
        int errors = 0;
        // a,b sont les nombres generes au hasard 
        // que l'utilisateur doit multiplier
        int a = rd.nextInt(9) + 1; 
        int b = rd.nextInt(9) + 1;

        System.out.print(a + " * " + b + " = " );
        int answer = sc.nextInt();

        while (answer != a*b && errors < maxTentatives - 1){
            errors ++;
            System.out.print("C'est pas vrai: " + a + " * " + b + " = " );
            answer = sc.nextInt();

        }

        return errors + (answer != a*b? 1: 0);
    }


    public static int evaluation(int n){
        int note = n;

        for (int i = 0; i < n; i++){
            int errors = question(1);
            note += -errors;
        }

        return note;

    }

    public static void main(String[] args) {

        System.out.println("Test question(3)");
        System.out.println(question(3));


        System.out.println("Test evaluation(5)");
        System.out.println("Score: " + evaluation(5));

    }    
}
