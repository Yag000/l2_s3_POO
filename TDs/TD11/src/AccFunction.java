public interface AccFunction<S, T> {

    void apply(S acc, S ext, T donnee);
}
