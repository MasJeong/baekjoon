import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 원형큐 구현 - 용량을 동적 할당하는 메소드까지 구현한다.
 */
public class Main {

    private static int[] queue;

    // 큐 첫 번째 인덱스(빈 공간)
    private static int front = 0;
    // 큐 마지막 인덱스
    private static int rear = 0;
    // 큐 요소 개수
    private static int size = 0;

    /**
     * queue 용량을 재설정한다(up, down).
     * @param newCapacity 새로운 용량크기
     */
    private static void resize(int newCapacity) {
        int[] newQueue = new int[newCapacity];

        /*
            기존 큐에 존재하던 데이터를 복사한다.
            새로운 큐에는 front가 0이고 첫 번째 인덱스부터 값을 세팅한다.
         */
        for (int i = 1, j = front + 1; i <= size; i++, j++) {
            newQueue[i] = queue[j % queue.length];
        }

        queue = newQueue;

        front = 0;

        /*
            용량이 더 커진 경우에는 1자로 데이터가 나열되었기 때문에 rear = size
            용량이 더 작아진 경우에는 데이터가 없어서 사이즈를 줄인 것.
         */
        rear = size;
    }

    /**
     * offer: 큐 마지막에 요소를 추가한다.
     * @param val 추가할 요소 값
     */
    private static void offer(int val) {
        // 용량이 가득찬 경우 용량을 2배로 동적 할당한다.
        if (front == (rear + 1) % queue.length) {
            resize(queue.length * 2);
        }

        rear = (rear + 1) % queue.length;

        queue[rear] = val;
        size++;
    }

    /**
     * poll: 큐의 첫 번째 요소를 삭제하고 삭제 된 요소를 반환한다.
     * @return 큐의 첫 번째 요소
     */
    private static int poll() {
        if (size <= 0) {
            return -1;
        }

        // 공백(front) 다음 값을 가져온 후 0(or 빈값)으로 초기 세팅한다.
        front = (front + 1) % queue.length;
        int element = queue[front];

        queue[front] = 0;
        size--;

        // 요소 개수가 1/4 미만일 경우 용량(사이즈)를 1/2로 줄인다.
        if(size < (queue.length / 4)) {
            resize(queue.length / 2);
        }

        return element;
    }

    /**
     * 큐의 첫 번째 요소를 삭제한다.
     * @return 삭제된 요소 값
     */
    private static int remove() {
        int element = poll();

        // 원래 queue가 객체 타입이면 null을 체크하지만 int 타입이기 때문에 0으로 체크한다.
        if (element == 0) {
            return -1;
//            throw new NoSuchElementException();
        }

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

    /**
     * peek: 큐의 첫 번째 요소를 반환한다.
     * @return 큐의 첫 번째 요소
     */
    private static int peek() {
        if(size <= 0) {
            return -1;
        }

        return queue[(front + 1) % queue.length];
    }

    private static int front() {
        if(size <= 0) {
            return -1;
        }

        return queue[(front + 1) % queue.length];
    }

    private static int back() {
        if(size <= 0) {
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

            String str = st.nextToken();
            switch (str) {
                case "push":
                    offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(poll()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "peek":
                    sb.append(peek()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
        br.close();
    }
}
