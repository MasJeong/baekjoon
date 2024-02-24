import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 스택 수열 - 자료구조
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
        StringBuilder sb = new StringBuilder();

        /*
            push, push, push, push, pop, pop, push, push, pop, push, push, pop, pop, pop, pop, pop
            [4, 3, 6, 8, 7, 5, 2, 1]
         */
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int startIdx = 0;

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (top(stack) < num) {
                for(int i = startIdx + 1; i <= num; i++) {
                    push(stack, i);
                    sb.append("+").append("\n");
                }

                startIdx = num;
            }

            if (top(stack) == num) {
                pop(stack);
                sb.append("-").append("\n");
            } else if(top(stack) != num) {
                System.out.println("NO");
                return;
            }
        }


        System.out.println(sb);
        br.close();
    }
}
