public class AbcNumber {
    public int convert(String num) {
        char[] charArray = num.toCharArray();
        int result = 0;
        for (int i = 0; i < charArray.length; i++) {
            result = result * 10 + (charArray[i] - 'a');
        }

        return result;
    }
}
