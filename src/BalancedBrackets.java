import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    private static boolean isBalanced(String expression) {
        char[] expChars = expression.toCharArray();
        Stack<Character> charStack = new Stack<>();
        for (char c : expChars) {
            if (charStack.empty()) {
                charStack.push(c);
            } else if ((c == '}' && charStack.peek() == '{') || (c == ')' && charStack.peek() == '(') || (c == ']' &&
                    charStack.peek() == '[')) {
                charStack.pop();
            } else {
                charStack.push(c);
            }
        }

        return charStack.empty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
