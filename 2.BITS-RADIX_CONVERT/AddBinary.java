public class AddBinary {
    String add(String a, String b) {
        if (a == null && b == null) return null;
        if (a == null) return b;
        if (b == null) return a;

        int la = a.length();
        int lb = b.length();
        StringBuilder sum = new StringBuilder();
        int length = la > lb ? la : lb;
        int carry = 0;

        for (int i = 0; i < length; i++) {
            byte a1 = getBit(a, la - i - 1);
            byte b1 = getBit(b, lb - i - 1);
            int add = a1 + b1 + carry;
            sum.append(add % 2);
            carry = add / 2;
        }

        if (carry == 1)
            sum.append("1");

        return sum.reverse().toString();
    }

    private byte getBit(String s, int index) {
        if (index < 0) return 0;
        if (s.charAt(index) == '0') {
            return 0;
        } else
            return 1;
    }
}
