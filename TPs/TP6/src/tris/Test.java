package tris;

import utilities.TestFunction;

public class Test {

        public static void main(String[] args) {

                new TestFunction() {
                        @Override
                        public void function() {
                                int[] tab1 = { 1, 22, 45, 35214, 21, 42, 4, 14, 2, 6547, 43265, 35, 67, 42, 434, 612, 4,
                                                5, 46, 3, 4, 45654, 8, 52, 4 };

                                Triable t1 = new TabEntiersTriable(tab1);
                                System.out.println("Before: ");
                                System.out.println(t1);

                                System.out.println("");

                                Triable.triBulles(t1);
                                System.out.println("After: ");
                                System.out.println(t1);
                        }
                }.runTest("TabEntiersTriable");

                new TestFunction() {
                        @Override
                        public void function() {
                                boolean[][] tab2 = { { true, false }, { false }, { false, false, true, false },
                                                { true }, { true, true, true, false, false, false, true },
                                                { false, true, true, false, false, true } };

                                Triable t2 = new TriBinaire(tab2);
                                System.out.println("Before: ");
                                System.out.println(t2);

                                System.out.println("");

                                Triable.triBulles(t2);
                                System.out.println("After: ");
                                System.out.println(t2);
                        }
                }.runTest("TriBinaire");

                new TestFunction() {
                        @Override
                        public void function() {
                                String[] tab3 = { "glorfindel", "anarion", "elendil", "isildur", "luthien", "Luthien",
                                                "Elbereth", "varda", "manwe", "Niennor", "tuirn", "tuor",
                                                "Idril Celebrindal", "earendil", "elros", "elrond", "Tar-Minyatur",
                                                "Eru", "Frodo", "Sam", "Bill", "orome", "olorin", "Yavanna", "feanor",
                                                "filgolfin", "finarfin", "galadriel", "Finrod Felagund", "Orodreth",
                                                "Melian", "Thingol", "engwe", "Celeborn", "legolas", "aragorn", "Gimli",
                                                "Gandalf", "Saruman", "grima", "Thengel", "Theoden", "Eomer", "Eol",
                                                "eorl", "Helm", "Denethor", "finguilas", "boromir", "Faramir", "Eowyn",
                                                "Arwen Undómiel", "Elanor", "rose", "Meriadoc", "Peregrin", "Bilbo",
                                                "tar-palatir", "Ecthelion", "turgon", "indis", "Maedhros", "Ulmo",
                                                "Mandos", "nienna", "lorien", "Aule", "Tulkas", "gil-galad", "Beleg",
                                                "min", "hurin", "Arathorn", "arvedui", "melkor", "Morgoth", "Mairon",
                                                "annatar", "Sauron", "Shelob", "ungoliant", "Gothmog", "Ancalagon",
                                                "Glaurung", "Smaug", "scatha", "Khamul", "The Witch-king of Angmar",
                                                "Huan", "hama", "beregond", "Beruthiel", "elwe", "Dior", "elwing",
                                                "cirdan", "Celebrimbor", "Amroth", "Shadowfax", "Asfaloth", "Thorondor",
                                                "Gwaihir", "Beorn", "Olorin", "gloin", "durin", "Thorin", "thrain",
                                                "yavanna Kementári", "Varda Elentári", "Elendil Voronwe", "Ohtar",
                                                "Feanaro", "Gollum", "deagol", "Smeagol", "Elrohir", "Elladan", "smaug",
                                                "Mouth of Sauron", "eye of Sauron", "spiders of Mirkwood", "vaire",
                                                "irmo", "este", "vana", "arien", "nessa", "Tilion", "Pallando",
                                                "Alatar", "Curumo", "Aiwendil", "Radagast", "fangorn", "treebeard",
                                                "Quickbeam", "Carcaroth", "Manwe Sulimo", "Eonwe", "ilmare", "salmar",
                                                "Osse", "uinen", "Tom Bombadil", "Goldberry", "" };

                                Triable t3 = new Dictionnaire(tab3);
                                System.out.println("Before: ");
                                System.out.println(t3);

                                System.out.println("");

                                Triable.triBulles(t3);
                                System.out.println("After: ");
                                System.out.println(t3);

                        }
                }.runTest("Dictionnaire");

        }
}
