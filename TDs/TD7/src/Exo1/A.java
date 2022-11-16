package Exo1;

public class A {
    private static int h = 5;
    private B x = new B();
    private int i = x.b;

    // classe interne statique
    public static class StaticA {
        public int nstat = h;
        public static int astat = h;

        public void increase() {
            h++;
            // i++;
        }
    }

    // classe interne membre
    private class B {
        private int b = 2;
        private static int bstat = 3;
    }

    // classe interne membre
    public class InstanceA {
        private int i = A.StaticA.astat;
        // private int j = A.StaticA.nstat;
        // public int k = A.x.b;

        public static void staticMethod() {
        }

        public void method(int i) {
            int i1 = this.i;
            int i2 = A.this.i;
            System.out.println(i + " " + i1 + " " + i2);
        }
    }
}