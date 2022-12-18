package Exo_2;

class Exo2 {
    class CallF extends Exception {
    }

    class CallG extends Exception {
    }

    class CallH extends CallF {
    }

    public void f() throws CallF {
        throw new CallF();
    }

    public void g() throws CallG {
        throw new CallG();
    }

    public void h() throws CallF, CallH {
        throw new CallH();
    }

    public void skip() throws CallF, CallG, CallH {
    }

    public static void main(String[] args) {
        Exo2 ex = new Exo2();

        try {
            ex.f();
            ex.g();
        } catch (CallF e) {
            System.out.println(" Catch f ( ) "); //
        } catch (CallG e) {
            System.out.println(" Catch g ( ) ");
        }

        try {
            ex.f();
            ex.g();
        } catch (CallG e) {
            System.out.println(" Catch g ( ) ");
        } catch (CallF e) {
            System.out.println(" Catch f ( ) "); //
        }

        try {
            ex.g();
            ex.f();
        } catch (CallF e) {
            System.out.println(" Catch f ( ) ");
        } catch (CallG e) {
            System.out.println(" Catch g ( ) "); //
        }

        try {
            ex.h();
        } catch (CallF e) {
            System.out.println(" Catch f ( ) "); //
        }
        //
        // catch (CallH e) {
        // System.out.println(" Catch h ( ) ");
        // }

        try {
            ex.h();
        } catch (CallH e) {
            System.out.println(" Catch h ( ) "); //
        } catch (CallF e) {
            System.out.println(" Catch f ( ) ");
        }

        try {
            ex.skip();
        } catch (CallF e) {
            System.out.println(" Catch f ( ) ");
        } catch (CallG e) {
            System.out.println(" Catch g ( ) ");
        } finally {
            System.out.println(" Finally "); //
        }

        try {
            ex.f();
        } catch (CallF e) {
            System.out.println(" Catch f ( ) "); //
            // ex.g(); Unhandled exception
        } finally {
            System.out.println(" Finally "); //
        }

        try {
            // ex.f(); Unhandled exception
        } finally {
            System.out.println(" Finally "); //
            // ex.g(); Unhandled exception
        }
    }
}
