import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 큐 - 자료구조
 * 큐 구현 후 원형 큐(front, rear)까지 생각해서 진행해보자.
 * - 큐는 BFS(너비우선탐색)에서 자주 사용된다.
 */
public class Main {

    private static int front = 0;
    private static int rear = -1;
    private static int size = 0;

    private static void push(int[] queue, int val) {
        queue[++rear] = val;
        size++;
    }

    private static int pop(int[] queue) {
        if(front > rear) {
            return -1;
        }

        size--;
        return queue[front++];
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

    private static int front(int[] queue) {
        if(size <= 0) {
            return -1;
        }

        return queue[front];
    }

    private static int back(int[] queue) {
        if(size <= 0) {
            return -1;
        }

        return queue[rear];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int cmd = Integer.parseInt(br.readLine());
        int[] queue = new int[cmd];

        for(int i = 0; i < cmd; i++) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            switch (str) {
                case "push":
                    push(queue, Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop(queue)).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front(queue)).append("\n");
                    break;
                case "back":
                    sb.append(back(queue)).append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
