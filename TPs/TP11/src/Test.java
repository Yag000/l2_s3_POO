public class Test {
    public static void main(String[] args) {
        Integer[] tableau = new Integer[] { 1, 2, 3, 4, 5 };
        TestIter<Integer> iter = new TestIter<>(tableau);

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("--------------------- Test 2 ---------------------");

        Integer[] tableau2 = new Integer[] { 1, 2, 3, null, 4, 5 };
        TestIter<Integer> iter2 = new TestIter<>(tableau2);

        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
    }
}
