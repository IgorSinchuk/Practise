public class ColorChain {
    public int count(int N) {
        if (N == 0 || N == 1 || N == 2) return N;
        if (N == 3) return 4;
        return count(N - 1) + count(N - 2) + count(N - 3);
    }

}
