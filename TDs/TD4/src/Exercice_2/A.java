package Exercice_2;

public class A {
    public void f(A x) {
        System.out.println("A. f (A) ");
    }

    public void g() {
        f(new A());
    }
}
