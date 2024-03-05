import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스택 2
 */
public class Main {

    private static int[] stack;

    private static int pointer = -1;

    private static int size = 0;

    private static void push(int val) {
        stack[++pointer] = val;
        size++;
    }

    private static int pop() {
        if (size == 0) {
            return -1;
        }

        size--;
        return stack[pointer--];
    }

    private static int isEmpty() {
        if (size == 0) {
            return 1;
        }

        return 0;
    }

    private static int top() {
        if (size <= 0) {
            return -1;
        }

        return stack[pointer];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        stack = new int[n];

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            switch (type) {
                case 1:
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    sb.append(pop()).append("\n");
                    break;
                case 3:
                    sb.append(size).append("\n");
                    break;
                case 4:
                    sb.append(isEmpty()).append("\n");
                    break;
                case 5:
                    sb.append(top()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
