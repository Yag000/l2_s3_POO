public class Test {
    public static void main(String[] args) {
        Integer[] tableau = new Integer[] { 1, 2, 3, 4, 5 };
        TestIter<Integer> iter = new TestIter<>(tableau);

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
