import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 에디터 - 자료구조
 * 1. stack을 이용하여 push 시 pointer + 1에 값이 있으면 뒤로 1칸씩 옮긴다.
 * - pop 시 pointer부터 size -1까지 앞으로 옮긴다.
 * -> 시간초과.
 * 2. LinkedList 사용
 * - add 또는 remove 시 탐색하는 과정이 너무 길다.
 * -> 시간초과
 * 3. LinkedList 및 ListIterator 사용
 * -> 통과
 * 4. Stack 2개 사용
 * -> 통과
 */
public class _1406_useTwoStack {
    private static final Stack<Character> leftStack = new Stack<>();

    private static final Stack<Character> rightStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n = br.readLine();
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 처음 입력받은 문자열 push
        for (int i = 0; i < n.length(); i++) {
            leftStack.push(n.charAt(i));
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            switch (cmd) {
                case 'L':
                    if (leftStack.isEmpty()) {
                        break;
                    }
                    rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    if (rightStack.isEmpty()) {
                        break;
                    }
                    leftStack.push(rightStack.pop());
                    break;
                case 'B':
                    if (leftStack.isEmpty()) {
                        break;
                    }
                    leftStack.pop();
                    break;
                case 'P':
                    leftStack.push(st.nextToken().charAt(0));
                    break;
            }
        }

        leftStack.forEach(sb::append);

        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
        br.close();
    }
}
