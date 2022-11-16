package Exo1;

public class D {
    public void localMethod(int i) {
        i++;
        int j = i;
        // declaration de classe dans une methode
        class Locale {
            /*
             * int k = i;
             * 
             * public void increase1() {
             * return ++i;
             * }
             * 
             * 
             * public int increase2() {
             * return ++j;
             * }
             * 
             * 
             * public int increase3() {
             * return ++k;
             * }
             */
        }
        Locale l = new Locale();
        // System.out.println(l.increase3());
    }

    public static void main(String[] args) {
        A a = new A();
        A.StaticA.astat = 4;
        // A.StaticA.nstat = 3;
        A.StaticA sa1 = new A.StaticA();
        // A.StaticA sa2 = A.new StaticA();
        // sa1.nstat = 3;
        // A.InstanceA nsa1 = new A.InstanceA();
        A.InstanceA nsa2 = a.new InstanceA();
        // A.InstanceA nsa3 = new a.InsTanceA();
        // nsa2.i = 3;
        nsa2.method(6);
        // A.B b = a.new B(5);
        D d = new D();
        int i = 2;
        i++;
        d.localMethod(i);
    }
}