public class Exo1 {

    private static int a = 1;
    private int b = 2;
    private final int c = 3;

    public static void main(String[] args) {
        System.out.println("Hello");
        // écrivez ici, lorsque c’est possible
        // des exemples qui modifient des valeurs de a, b et c

        a = 2;
        new Exo1().b = 3;

    }
}