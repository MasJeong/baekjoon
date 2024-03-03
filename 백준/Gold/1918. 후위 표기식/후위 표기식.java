import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 후위 표기식 - 자료구조
 */
public class Main {

    static int priority(char ch) {
        if(ch == '(' || ch == ')') return 0;

        if(ch == '+' || ch == '-') return 1;

        if(ch == '*' || ch == '/') return 2;

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String s = br.readLine();
//        char[] answer = new char[s.length()];

        // 연산자만 스택 사용
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case '*':
                case '/':
                case '-':
                case '+':
                    /*
                    스택에 들어있는 연산자의 우선순위가 같거나 현재 연산자 보다 높은 경우
                    모두 출력한다.
                     */
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
                        sb.append(stack.pop());
                    }

                    stack.push(ch);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    // 열린 괄호가 나올때까지 pop
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    // '(' 제거
                    stack.pop();
                    break;
                // A ~ Z
                default:
                    sb.append(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
        br.close();
    }
}
