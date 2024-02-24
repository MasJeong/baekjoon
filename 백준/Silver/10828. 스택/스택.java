import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스택 - 자료구조
 */
public class Main {

    private static int pointer = -1;
    private static int size = 0;

    private static void push(int[] stack, int val) {
        stack[++pointer] = val;
        size++;
    }

    private static int pop(int[] stack) {
        if(pointer < 0) {
            return -1;
        }

        size--;
        return stack[pointer--];
    }

    private static int size() {
        return size;
    }

    private static int empty() {
        if(size <= 0) {
            return 1;
        }

        return 0;
    }

    private static int top(int[] stack) {
        if(size <= 0) {
            return -1;
        }

        return stack[size - 1];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int cmd = Integer.parseInt(br.readLine());
        int[] stack = new int[cmd];

        for(int i = 0; i < cmd; i++) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            switch (str) {
                case "push":
                    push(stack, Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop(stack)).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top(stack)).append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
