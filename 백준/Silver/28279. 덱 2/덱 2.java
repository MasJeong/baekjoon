import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 덱 2 - 스택 큐 덱
 */
public class Main {

    private static int[] queue;

    /*
        덱 첫 번째 인덱스(빈 공간)
        - 큐와 동일하게 구현한다.
     */
    private static int front = 0;
    // 큐 마지막 인덱스
    private static int rear = 0;
    // 큐 요소 개수
    private static int size = 0;

    private static void offerFirst(int val) {
        // front는 공백이니까... front에 값 삽입하고 앞으로 1칸 이동한다.
        queue[front] = val;

        front = (front - 1 + queue.length) % queue.length;
        size++;
    }

    private static void offerLast(int val) {
        rear = (rear + 1) % queue.length;
        queue[rear] = val;
        size++;
    }

    private static int pollFirst() {
        if (size <= 0) {
            return -1;
        }

        front = (front + 1) % queue.length;
        int element = queue[front];
        queue[front] = 0;
        size--;

        return element;
    }

    private static int pollLast() {
        if (size <= 0) {
            return -1;
        }

        int element = queue[rear];
        queue[rear] = 0;
        rear = (rear - 1 + queue.length) % queue.length;
        size--;

        return element;
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

    private static int peekFirst() {
        if (size <= 0) {
            return -1;
        }

        return queue[(front + 1) % queue.length];
    }

    private static int peekLast() {
        if (size <= 0) {
            return -1;
        }

        return queue[(rear) % queue.length];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int cmd = Integer.parseInt(br.readLine());
        queue = new int[cmd];

        for(int i = 0; i < cmd; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            switch (num) {
                case 1:
                    offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    sb.append(pollFirst()).append("\n");
                    break;
                case 4:
                    sb.append(pollLast()).append("\n");
                    break;
                case 5:
                    sb.append(size()).append("\n");
                    break;
                case 6:
                    sb.append(empty()).append("\n");
                    break;
                case 7:
                    sb.append(peekFirst()).append("\n");
                    break;
                case 8:
                    sb.append(peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
