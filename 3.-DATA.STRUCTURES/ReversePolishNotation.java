import java.util.Stack;

public class ReversePolishNotation {

    public static final int ZERO_CODE = 48;

    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        System.out.println(rpn.evaluate("17 2 -"));
    }
    public int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] array  = expression.split(" ");
        for (int i=0; i < array.length;i++) {
            int symbolCode = array[i].codePointAt(0);
            if (symbolCode >= ZERO_CODE){
                stack.push(Integer.parseInt(array[i]));
            } else {
                char code = (char) symbolCode;
                int a = stack.pop();
                int b = stack.pop();
                System.out.println(a+" "+b);
                switch (code){
                    case '+' :
                        stack.push(a+b);
                        break;
                    case '-' :
                        stack.push(b-a);
                        break;
                    case '*' :
                        stack.push(a*b);
                        break;
                    case '/' :
                        stack.push(b/a);
                        break;
                }
            }
        }

        return stack.pop();
    }
}