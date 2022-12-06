package utilities;

public abstract class TestFunction {

    public abstract void function();

    public void runTest(String testName) {
        System.out.println();
        System.out.println("-----------\\ Test " + testName + " /-----------");
        System.out.println();
        function();
        System.out.println();
        System.out.println("-------------------------------" + "-".repeat(testName.length()));
    }

}