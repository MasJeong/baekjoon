import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 쇠막대기 - 자료구조
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
         * ()(((()())(())()))(()) -> 17
         * (((()(()()))(())()))(()()) -> 24
         */
        Stack<Character> openStack = new Stack<>();
        String s = br.readLine();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openStack.push(ch);
                continue;
            }

            if (ch == ')') {
                openStack.pop();

                // isRazer true
                if (s.charAt(i - 1) == '(') {
                    answer += openStack.size();
                } else {
                    answer++;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
