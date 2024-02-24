import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 괄호 - 자료구조
 * - 스택으로 풀기
 */
public class Main {

    private static int pointer = -1;
    private static int size = 0;

    private static StringBuilder sb = new StringBuilder();

    private static void push(char[] stack, char val) {
        stack[++pointer] = val;
        size++;
    }

    private static boolean pop(char[] stack) {
        if(pointer < 0) {
            sb.append("NO").append("\n");
            return true;
        }

        size--;
        pointer--;

        return false;
    }

    private static boolean empty() {
        return size <= 0;
    }

    private static void initStack(char[] stack) {
        stack = new char[50];
        pointer = -1;
        size = 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        char[] stack = new char[50];

        while (t-- > 0) {
            String str = br.readLine();
            boolean popError = false;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c == '(') {
                    push(stack, c);
                } else {
                    popError = pop(stack);
                    if(popError) break;
                }
            }

            if(!popError) {
                if(empty()) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }

            // 스택 초기화
            initStack(stack);
        }

        System.out.println(sb);
        br.close();
    }
}
