import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 도키도키 간식드리미 - 스택 큐 덱
 */
public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        final StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 1;
        final Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());

            if (input > cnt) {
                while (!stack.isEmpty() && stack.peek() == cnt) {
                    stack.pop();
                    cnt++;
                }

                stack.push(input);
            } else {
                cnt++;
            }
        }

        while (!stack.isEmpty() && stack.peek() == cnt) {
            stack.pop();
            cnt++;
        }

        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }

        br.close();
    }
}
