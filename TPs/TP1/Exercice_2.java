public class Exercice_2 {
    
    public static void affiche(int t[]){
        for(int i : t) System.out.print(i + " ");
        System.out.println();
    }


    public static int[] multiplication(int t1[],int t2[]){
        int n = Math.max(t1.length, t2.length);
        int[] t3 = new int[n];

        for (int i = 0; i < n; i++){
            if (i >= t1.length) t3[i] = t2[i];
            else t3[i] = i < t2.length ? t2[i]*t1[i] : t1[i];
        }

        return t3;
    }

    public static int [] split(int t []){

        String all_digits = "";
        for (int i : t) all_digits += String.valueOf(i);

        int[] result = new int[all_digits.length()];
        for (int i = 0; i < all_digits.length(); i++){
            result[i] = Character.getNumericValue(all_digits.charAt(i));
        }

        return result;
    }
 
    public static void main(String[] args) {
    // Exercice 1
    int[] t = {1,2,3,4,5,6};
    affiche(t);

    // Exercice 2
    int[] t2 = {1,2,3,4,5,6};
    int[] t3 = {1,2};
    int[] t4 = {1,2,5,6};

    affiche(multiplication(t2,t3));
    // 1 2 3 4 5 6
    affiche(multiplication(t3,t4));
    // 1 4 5 6
    affiche(multiplication(t2,t4));
    // 1 4 15 24 5 6


    // Exercice 4
    int[] t5 = {1,6542,5,5346};
    int[] t6 = {1,24,555,6};
    int[] t7 = {};
    affiche(split(t5));
    // 1 6 5 4 2 5 5 3 4 6
    affiche(split(t6));
    // 1 2 4 5 5 5 6
    affiche(split(t7));
    // Rien
    }   
}
