import java.util.Arrays;
import java.util.Iterator;

import utilities.TestFunction;

public class Test {
    public static void main(String[] args) {
        new TestFunction() {
            @Override
            public void function() {
                Integer[] tableau = new Integer[] { 1, 2, 3, 4, 5 };
                TestIter<Integer> iter = new TestIter<>(tableau);

                while (iter.hasNext()) {
                    System.out.println(iter.next());
                }
            }
        }.runTest("TestIter");

        new TestFunction() {
            @Override
            public void function() {

                TabSet<String> set1 = new TabSet<>();

                // Ajout de quelques éléments au TabSet
                set1.add("A");
                set1.add("B");
                set1.add("C");

                set1.affiche();

                Iterator<String> iter2 = set1.iterator();
                System.out.println("Test de l'itérateur: " + iter2.hasNext()); // Affiche : Test de l'itérateur: true

                System.out.println("Taille actuelle du TabSet : " + set1.size()); // Affiche : Taille actuelle du TabSet
                                                                                  // : 3

                // Vérification si le TabSet contient l'élément "A"
                System.out.println("Contient A : " + set1.contains("A")); // Affiche : Contient A : true
            }
        }.runTest("Add, size et contains");

        new TestFunction() {
            @Override
            public void function() {
                TabSet<String> set1 = new TabSet<>();

                // Ajout de quelques éléments au TabSet
                set1.add("A");
                set1.add("B");
                set1.add("C");

                System.out.println("Avant: ");

                set1.affiche();

                // Suppression de l'élément "B" du TabSet
                set1.remove("B");

                // Vérification si le TabSet contient toujours l'élément "B"
                System.out.println("Contient B : " + set1.contains("B")); // Affiche : Contient B : false

                System.out.println("Après: ");
                set1.affiche(); // Affiche : A C
            }
        }.runTest("Remove");

        new TestFunction() {
            @Override
            public void function() {
                TabSet<String> set2 = new TabSet<>();

                // Ajout de quelques éléments au TabSet
                set2.add("A");
                set2.add("B");
                set2.add("C");
                set2.add(null);
                set2.add("D");
                set2.add(null);

                set2.afficheAll(); // Affiche : A B C D null null null null null null null

                System.out.println("Size: " + set2.size()); // Affiche : Size: 4
            }
        }.runTest("Size avec des null");

        new TestFunction() {
            @Override
            public void function() {
                TabSet<String> set3 = new TabSet<>();

                set3.add("A");
                set3.add("B");
                set3.add("C");

                // Création d'un autre TabSet contenant les éléments "B" et "D"
                TabSet<String> set4 = new TabSet<>();
                set4.add("B");
                set4.add("D");

                // Vérification si le TabSet contient tous les éléments de l'autre TabSet
                System.out.println(set3.containsAll(set4)); // Doit renvoyer false

                // Ajout de tous les éléments de l'autre TabSet au TabSet principal
                System.out.println(set3.addAll(set4)); // Doit renvoyer true
                System.out.println();

                set3.affiche(); // Doit afficher A B C D

                // Vérification si le TabSet contient maintenant tous les éléments de l'autre
                // TabSet
                System.out.println(set3.containsAll(set4)); // Doit renvoyer true

                // Création d'un troisième TabSet contenant les éléments "A" et "C"
                TabSet<String> thirdSet = new TabSet<>();
                thirdSet.add("A");
                thirdSet.add("C");

                // Garder seulement les éléments communs entre le TabSet principal et le
                // troisième TabSet
                System.out.println(set3.retainAll(thirdSet)); // Doit renvoyer true
                System.out.println();
                set3.affiche(); // Doit afficher A C

                // On ajoute a nouveau les éléments de set4
                set3.addAll(set4);
                System.out.println();
                set3.affiche(); // Doit afficher A B C D

                // On supprime les éléments de set4
                set3.removeAll(set4);
                System.out.println();
                set3.affiche(); // Doit afficher A C

                // Vérification de la taille du TabSet après l'opération retain
                System.out.println(set3.size() == 2); // Doit renvoyer true

                // Suppression de tous les éléments du TabSet
                set3.clear();

                // Vérification que le TabSet est vide après l'appel à la méthode clear()
                System.out.println(set3.isEmpty()); // Doit renvoyer true
            }
        }.runTest("containsAll, addAll, retainsAll, removeAll");

        new TestFunction() {
            @Override
            public void function() {
                TabSet<String> tabSet = new TabSet<>();

                tabSet.add("Hello");
                tabSet.add("World");
                tabSet.add("!");

                // Test de la méthode toArray()
                Object[] array = tabSet.toArray();
                System.out.println(Arrays.toString(array)); // [Hello, World, !]

                // Test de la méthode toArray(T[] a) avec un tableau assez grand
                String[] array2 = new String[5];
                String[] array3 = tabSet.toArray(array2);
                System.out.println(Arrays.toString(array3)); // [Hello, World, !, null, null]

                // Test de la méthode toArray(T[] a) avec un tableau trop petit
                String[] array4 = new String[2];
                String[] array5 = tabSet.toArray(array4);
                System.out.println(Arrays.toString(array5)); // [Hello, World, !]
            }
        }.runTest("toArray");

        new TestFunction() {
            @Override
            public void function() {
                TabSet<Integer> ts = new TabSet<>();

                // On ajoute plus d'éléments que la capacité initiale du tableau
                for (int i = 0; i < 15; i++) {
                    ts.add(i);
                }

                // On affiche le contenu du TabSet
                ts.affiche();
            }
        }.runTest("Tableau de taille dynamique");
    }
}
