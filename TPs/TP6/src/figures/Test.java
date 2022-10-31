package figures;

import utilities.TestFunction;

public class Test {
    public static void main(String[] args) {

        new TestFunction() {
            @Override
            public void function() {
                new Carre(1, 2, 3).affiche();
            }
        }.runTest("Carre affiche");

        new TestFunction() {
            @Override
            public void function() {
                new Rectangle(0, 0, 7, 10).affiche();
            }
        }.runTest("Rectangle affiche");

        new TestFunction() {

            @Override
            public void function() {
                new Cercle(4, 1, 10).affiche();
            }

        }.runTest("Cercle affiche");

        new TestFunction() {

            @Override
            public void function() {
                new Ellipse(4, 1, 10, 20).affiche();
            }

        }.runTest("Ellipse affiche");

        new TestFunction() {

            @Override
            public void function() {
                new Triangle(4, 1, 10, 20).affiche();
            }

        }.runTest("Triangle affiche");

        new TestFunction() {
            @Override
            public void function() {
                new Carre(3, 4, 10).deformation(5, 5).affiche();
                new Carre(3, 4, 10).deformation(5, 6).affiche();
            }
        }.runTest("Deformation Carre");

        new TestFunction() {
            @Override
            public void function() {
                new Rectangle(3, 4, 10, 10).deformation(5, 5).affiche();
                new Rectangle(3, 4, 10, 10).deformation(5, 6).affiche();
            }

        }.runTest("Deformation Rectangle");

        new TestFunction() {
            @Override
            public void function() {
                new Cercle(3, 4, 10).deformation(5, 5).affiche();
                new Cercle(3, 4, 10).deformation(5, 6).affiche();
            }

        }.runTest("Deformation Cercle");

        new TestFunction() {
            @Override
            public void function() {
                new Ellipse(3, 4, 10, 10).deformation(5, 5).affiche();
                new Ellipse(3, 4, 10, 10).deformation(5, 6).affiche();
            }

        }.runTest("Deformation Ellipse");

        new TestFunction() {
            @Override
            public void function() {
                new Triangle(3, 4, 10, 10).deformation(5, 5).affiche();
                new Triangle(3, 4, 10, 10).deformation(5, 6).affiche();
            }

        }.runTest("Deformation Triangle");

        new TestFunction() {
            @Override
            public void function() {
                System.out.println(new Cercle(1, 2, 10).estDistantDe(new Triangle(0, 0, 10, 10)));
                System.out.println(new Cercle(0, 0, 10).estDistantDe(new Triangle(0, 0, 10, 10)));
                System.out.println(new Cercle(1, 2, 10).estDistantDe(new Triangle(-1, 100, 10, 10)));
                System.out.println(new Cercle(1, -200, 10).estDistantDe(new Triangle(0, 0, 10, 10)));
            }

        }.runTest("estDistantDe");

        new TestFunction() {
            @Override
            public void function() {
                System.out.println(new Rectangle(0, 0, 10, 15).surface());
                System.out.println(new Carre(0, 0, 10).surface());
                System.out.println(new Cercle(0, 0, 10).surface());
                System.out.println(new Ellipse(0, 0, 10, 15).surface());
                System.out.println(new Triangle(0, 0, 10, 15).surface());
            }

        }.runTest("surface");

        new TestFunction() {
            @Override
            public void function() {
                Rectangle r1 = new Rectangle(0, 0, 0, 0);
                r1.deplacement(0, 0);
                r1.affiche();

                Rectangle r2 = new Rectangle(0, 0, 0, 0);
                r2.deplacement(5, 0);
                r2.affiche();

                Rectangle r3 = new Rectangle(0, 0, 0, 0);
                r3.deplacement(0, 5);
                r3.affiche();

                Rectangle r4 = new Rectangle(1, 2, 0, 0);
                r4.deplacement(-1, -2);
                r4.affiche();
            }

        }.runTest("deplacement");

    }
}
