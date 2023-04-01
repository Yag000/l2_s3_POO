package Exercice_2;

public class Test {
    public static void main(String[] args) {
        // A a = new A(); Class abstraite
        // a.m();
        // a.n();
        // a.p();

        System.out.println("----------\\ Test B b /----------");
        B b = new B();
        b.m(); // I, m
        b.n(); // A, n
        b.p(); // B, p

        System.out.println("----------\\ Test C c /----------");
        C c = new C();
        c.m(); // C, m
        c.n(); // A, n
        c.p(); // B, p
        c.q(); // C, q

        System.out.println("----------\\ Test A b /----------");

        A u = b;
        u.m(); // I, m
        u.n(); // A, n
        u.p(); // B, p

        System.out.println("----------\\ Test A c /----------");

        A v = c;
        v.m(); // C, m
        v.n(); // A, n
        v.p(); // B, p
        // v.q();
    }
}
