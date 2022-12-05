import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        Integer[] tableau = new Integer[] { 1, 2, 3, 4, 5 };
        TestIter<Integer> iter = new TestIter<>(tableau);

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("--------------------- Test TabSet ---------------------");

        // Création d'un nouveau TabSet avec une capacité de 5 éléments
        TabSet<String> set1 = new TabSet<>(5);

        // Ajout de quelques éléments au TabSet
        set1.add("A");
        set1.add("B");
        set1.add("C");

        set1.affiche();

        Iterator<String> iter2 = set1.iterator();
        System.out.println("Test de l'itérateur: " + iter2.hasNext());

        // Affichage de la taille actuelle du TabSet
        System.out.println("Taille actuelle du TabSet : " + set1.size()); // Affiche : Taille actuelle du TabSet : 3

        // Vérification si le TabSet contient l'élément "A"
        System.out.println("Contient A : " + set1.contains("A")); // Affiche : Contient A : true

        // Suppression de l'élément "B" du TabSet
        set1.remove("B");

        // Vérification si le TabSet contient toujours l'élément "B"
        System.out.println("Contient B : " + set1.contains("B")); // Affiche : Contient B : false

        // Itération sur les éléments du TabSet
        for (String element : set1) {
            System.out.println(element);
        }
        // Affiche :
        // A
        // C

        System.out.println("--------------------- Test TabSet 2 ---------------------");

        // Création d'un nouveau TabSet avec une capacité de 5 éléments
        TabSet<String> set2 = new TabSet<>(5);

        // Ajout de quelques éléments au TabSet
        set2.add("A");
        set2.add("B");
        set2.add("C");
        set2.add(null);
        set2.add("D");
        set2.add(null);

        // Itération sur les éléments du TabSet
        for (String element : set2) {
            System.out.println(element);
        }
        // Affiche :
        // A
        // B
        // C
        // D

        System.out.println("Size: " + set2.size()); // Affiche : Size: 4

        System.out.println("--------------------- Test TabSet 3 ---------------------");

        // Création d'un nouveau TabSet avec une capacité de 5 éléments
        TabSet<String> set3 = new TabSet<>(5);

        // Ajout de quelques éléments au TabSet
        set3.add("A");
        set3.add("B");
        set3.add("C");

        // Création d'un autre TabSet contenant les éléments "B" et "D"
        TabSet<String> set4 = new TabSet<>(2);
        set4.add("B");
        set4.add("D");

        // Vérification si le TabSet contient tous les éléments de l'autre TabSet
        System.out.println(set3.containsAll(set4)); // Doit renvoyer false

        // Ajout de tous les éléments de l'autre TabSet au TabSet principal
        System.out.println(set3.addAll(set4)); // Doit renvoyer true

        // Vérification si le TabSet contient maintenant tous les éléments de l'autre
        // TabSet
        System.out.println(set3.containsAll(set4)); // Doit renvoyer true

        // Création d'un troisième TabSet contenant les éléments "A" et "C"
        TabSet<String> thirdSet = new TabSet<>(2);
        thirdSet.add("A");
        thirdSet.add("C");

        // Garder seulement les éléments communs entre le TabSet principal et le
        // troisième TabSet
        System.out.println(set3.retainAll(thirdSet)); // Doit renvoyer true

        // Vérification de la taille du TabSet après l'opération de "retain"
        System.out.println(set3.size() == 2); // Doit renvoyer true

        // Suppression de tous les éléments du TabSet
        set3.clear();

        // Vérification que le TabSet est vide après l'appel à la méthode clear()
        System.out.println(set3.isEmpty()); // Doit renvoyer true
    }
}
