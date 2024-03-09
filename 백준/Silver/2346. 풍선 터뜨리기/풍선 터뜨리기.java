import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 풍선 터뜨리기 - 스택 큐 덱
 */
public class Main {

    static class NumAndValue {
        int value;
        int index;

        public NumAndValue(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<NumAndValue> deque = new ArrayDeque<>();

        sb.append(1).append(" ");
        int num = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            deque.offerLast(new NumAndValue(input, i + 1));
        }

        /*
        3 2 1 -3 -1
        1 4 5 3 2
        2 2 2 2
        1 3 2 4
        2. deque를 사용하지 않고 배열을 앞뒤로 돌린다. num % n
         */
        for (int i = 1; i < n; i++) {
            if (num > 0) {
                int temp = num;
                while (temp-- > 1 && !deque.isEmpty()) {
                    deque.offerLast(deque.pollFirst());
                }

                NumAndValue numAndValue = deque.pollFirst();
                num = numAndValue.value;
                sb.append(numAndValue.index).append(" ");
            } else {
                int temp = num;
                while (temp++ < -1 && !deque.isEmpty()) {
                    deque.offerFirst(deque.pollLast());
                }

                NumAndValue numAndValue = deque.pollLast();
                num = numAndValue.value;
                sb.append(numAndValue.index).append(" ");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
