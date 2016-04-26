public class JoinCharacters {
    public int join(char[] input) {
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            result = result * 10 + (input[i] - '0');
        }
        return result;
    }
}