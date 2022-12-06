public interface AccFunction<S, T> {

    S apply(S acc, S ext, T donnee);
}
