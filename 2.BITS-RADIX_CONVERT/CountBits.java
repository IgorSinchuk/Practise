public class CountBits {
    public int count(int num) {
        String number = Integer.toBinaryString(num);
        int count = 0;
        for (char c : number.toCharArray())
            if (c == '1') count++;

        return count;
    }
}
