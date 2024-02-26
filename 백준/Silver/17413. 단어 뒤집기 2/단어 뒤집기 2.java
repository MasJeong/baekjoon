import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 단어 뒤집기 2 - 자료구조
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<Character> firstStack = new Stack<>();

        String s = br.readLine();

        // 괄호 없는 경우
        if (!s.contains("<")) {
            st = new StringTokenizer(s);
            int cnt = st.countTokens();
            while (st.hasMoreTokens()) {
                String token = st.nextToken();

                for (int i = 0; i < token.length(); i++) {
                    firstStack.push(token.charAt(i));
                }

                for (int i = 0; i < token.length(); i++) {
                    sb.append(firstStack.pop());
                }

                if (--cnt > 0) {
                    sb.append(" ");
                }
            }

            System.out.println(sb);
            br.close();
            return;
        }

        // 처음 여는 꺽새(<)가 나오기 전에 push 되지 않아 애를 먹었다.
//        boolean isClose = false;
        boolean isClose = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '<') {
                while(!firstStack.isEmpty()) {
                    sb.append(firstStack.pop());
                }

                sb.append(ch);
                isClose = false;
            } else if (ch == '>') {
                sb.append(ch);
                isClose = true;
            } else {
                if (isClose) {
                    if (ch == ' ') {
                        while (!firstStack.isEmpty()) {
                            sb.append(firstStack.pop());
                        }

                        sb.append(ch);
                    } else {
                        firstStack.push(ch);
                    }

                } else {
                    sb.append(ch);
                }
            }
        }

        // 모든 순회를 마치고도 요솟값이 존재하면 pop
        if (isClose) {
            while (!firstStack.isEmpty()) {
                sb.append(firstStack.pop());
            }
        }

        System.out.println(sb);
        br.close();
    }
}
