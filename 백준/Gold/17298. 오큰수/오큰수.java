import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 오큰수 - 자료구조
 */
public class Main {

    private static int[] stack;
    private static int[] memoStack;
    private static int pointer = -1;
    private static int memoPointer = -1;
    private static int size = 0;
    private static int memoSize = 0;

    private static void push(int val) {
        stack[++pointer] = val;
        size++;
    }

    private static int pop() {
        if(pointer < 0) {
            return -1;
        }

        size--;
        return stack[pointer--];
    }

    private static void memoPush(int val) {
        memoStack[++memoPointer] = val;
        memoSize++;
    }

    private static int memoPop() {
        if(memoPointer < 0) {
            return -1;
        }

        memoSize--;
        return memoStack[memoPointer--];
    }

    private static void initMemo() {
        memoSize++;
        memoPointer = memoSize - 1;
    }

    public static void main(String[] args) throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        stack = new int[n];
        memoStack = new int[n];

        int[] result = new int[n];

        final StringTokenizer st = new StringTokenizer(br.readLine());

        while (n-- > 0) {
            push(Integer.parseInt(st.nextToken()));
        }

        // 첫 번째로 빼는 값은 무조건 -1
        int one = pop();
        memoPush(one);
        result[0] = -1;

        int idx = 1;
        while (size > 0) {
            int a = pop();

            boolean isFind = false;
            while (memoSize > 0) {
                int b = memoPop();
                if (a < b) {
                    result[idx++] = b;
                    initMemo();
                    isFind = true;
                    break;
                }
            }

            if(!isFind) {
                result[idx++] = -1;

                // memo 스택 포인터를 다시 맨 위로 올린다.
                initMemo();
            }

            memoPush(a);
        }

        for (int i = result.length - 1; i >= 1; i--) {
            sb.append(result[i]).append(" ");
        }
        sb.append(result[0]);

        System.out.println(sb);
        br.close();
    }
}
