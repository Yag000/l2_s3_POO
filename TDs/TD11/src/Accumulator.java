public interface Accumulator<S> {

    void accumulate(S s);

    S read();

    boolean isOver();
}
