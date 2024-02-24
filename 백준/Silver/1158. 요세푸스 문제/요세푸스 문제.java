import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요세푸스 - 자료구조(큐)
 * (N, K) - 요세푸스 순열
 */
public class Main {

    private static int[] queue;
    private static int front = -1;
    private static int rear = -1;
    private static int size = 0;

    /**
     * offer: 큐 마지막에 요소를 추가한다.
     * @param val 추가할 요소 값
     */
    private static void offer(int val) {
        rear = (rear + 1) % queue.length;

        queue[rear] = val;
        size++;
    }

    /**
     * poll: 큐의 첫 번째 요소를 삭제하고 삭제 된 요소를 반환한다.
     * @param term 입력값 K
     * @return 큐의 첫 번째 요소
     */
    private static int poll(int term) {
        if (size <= 0) {
            return -1;
        }

        /*
            1 2 3 4 5 6 7
            1 2 '' 4 5 6 7
            1 2 '' 4 5 '' 7
            1 '' '' 4 5 '' 7
            1 '' '' 4 5 '' ''
            1 '' '' 4 '' '' ''
            '' '' '' 4 '' '' ''
            '' '' '' '' '' '' ''
            -> 3 6 2 7 5 1 4
         */
        // 내가 구현한 원형큐는 첫 인덱스를 0(빈공간)부터 시작해서 애를 먹었다.
        int element = 0;
        while (term-- > 0) {
            front = (front + 1) % queue.length;
            element = queue[front];

            if (element == 0) {
                term++;
            }
        }

        queue[front] = 0;
        size--;

        return element;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        queue = new int[n];

        for(int i = 1; i <= n; i++) {
            offer(i);
        }

        sb.append("<");
        while (n-- > 1) {
            sb.append(poll(k)).append(", ");
        }
        sb.append(poll(k)).append(">");

        System.out.println(sb);
        br.close();
    }
}
