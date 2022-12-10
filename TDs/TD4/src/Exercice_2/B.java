package Exercice_2;

public class B extends A {
    @Override
    public void f(A x) {
        System.out.println("B. f (A) ");
    }
    // Surcharge

    public void f(B x) {
        System.out.println("B. f (B) ");
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        A c = new B();
        a.g(); // "A. f (A) "
        b.g(); // "A. f (A) "
        c.g(); // "A. f (A) "
        a.f(a); // "A. f (A) "
        a.f(b); // "A. f (A) "
        a.f(c); // "A. f (A) "
        b.f(a); // "B. f (A) "
        b.f(b); // "B. f (B) "
        b.f(c); // "B. f (A) "
        c.f(a); // "B. f (A) "
        c.f(b); // "B. f (A) "
        c.f(c); // "B. f (A) "
    }
}
