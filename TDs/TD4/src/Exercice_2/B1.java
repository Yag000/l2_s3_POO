package Exercice_2;

public class B1 extends A1 {
    @Override
    public void f(A1 x) {
        System.out.println("B. f (A) ");
    }

    @Override
    public void f(B1 x) {
        System.out.println("B. f (B) ");
    }

    public static void main(String[] args) {
        A1 a = new A1();
        B1 b = new B1();
        A1 c = new B1();
        a.g(); // "A. f (A) "
        b.g(); // "B. f (A) "
        c.g(); // "B. f (A) "
        a.f(a); // "A. f (A) "
        a.f(b); // "A. f (B) "
        a.f(c); // "A. f (A) "
        b.f(a); // "B. f (A) "
        b.f(b); // "B. f (B) "
        b.f(c); // "B. f (A) "
        c.f(a); // "B. f (A) "
        c.f(b); // "B. f (B) "
        c.f(c); // "B. f (A) "
    }
}