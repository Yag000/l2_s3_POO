package exam_2020;

class A {
    protected int x;
    protected int y;

    A(int a) {
        x = a;
    }
}

class B extends A {
    private int z;

    B(int a, int b) {
        super(a);
        z = b;
    }
}