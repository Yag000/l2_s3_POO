package partie2.exercice1;

public class Liste {
    public static void main(String[] args) {
        // Création de la liste du premier type
        java.util.List<String> list1 = new java.util.LinkedList<>();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Entrez des mots (\"fin\" pour terminer) :");
        String input = sc.nextLine();
        while (!input.equals("fin")) {
            list1.add(input);
            input = sc.nextLine();
        }
        sc.close();

        // Création de la liste du second type
        java.awt.List list2 = new java.awt.List();
        for (String s : list1) {
            list2.add(s);
        }

        // Affichage du résultat
        System.out.println("Liste du premier type :");
        System.out.println(list1.toString());
        System.out.println("Liste du second type :");
        System.out.println(list2.toString());
    }
}
