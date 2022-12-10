package Exercice_2;

public class A1 {
    public void f(A1 x) {
        System.out.println("A. f (A) ");
    }

    // Surcharge
    public void f(B1 x) {
        System.out.println("A. f (B) ");
    }

    public void g() {
        f(new A1());
    }
}