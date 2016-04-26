public class SumDigits {
    public int sum(int number) {
        int result = 0;
        char[] c = String.valueOf(number).toCharArray();
        for (char  i : c) {
            if (i>'0' & i<='9') {
                result += (i - '0');
            }
        }
        return result;
    }
}