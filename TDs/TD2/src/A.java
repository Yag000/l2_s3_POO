public class A {
    public static int a = 3;
    public int b;

    public A(int c) {
        this.b = c;
    }

    public void g() {
        a++;
        b++;
    }

    /*
     * 
     * 3,0
     * 3,0
     * 
     * 4,1
     * 5,1
     * 6,2
     * 
     */
}