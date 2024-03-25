import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 프린터 큐 - 큐 TODO 작업중
 */
public class Main {

    private static class Printer {
        int index;
        int priority;

        public Printer(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    private static class PrinterComparator implements Comparator<Printer> {
        @Override
        public int compare(Printer o1, Printer o2) {
            /*
            o1 - o2 > 0
            비교는 첫 번째 인자를 기준으로 함
            위의 경우 양수의 경우 o1이 뒤로 감
            음수의 경우 o1이 앞으로 감
             */
            return Integer.compare(o2.priority, o1.priority);
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            /*
            우선순위 큐는 힙(완전이진트리) 구조
            완전이진트리: 마지막 레벨을 제외하고 모든 레벨이 채워져 있는 형태
             */
            PriorityQueue<Printer> pq = new PriorityQueue<>(100, new PrinterComparator());
            Queue<Printer> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            // 큐 원소 삽입
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Printer(i, priority));
                pq.offer(new Printer(i, priority));
            }

            int count = 1;
            while (!pq.isEmpty()) {
                if (pq.peek().priority == queue.peek().priority) {
                    if (queue.peek().index == m) {
                        sb.append(count).append("\n");
                        break;
                    }

                    // 인쇄
                    pq.poll();
                    queue.poll();
                    count++;
                } else {
                    queue.offer(queue.poll());
                }
            }

            pq.clear();
            queue.clear();
        }

        System.out.println(sb);
        br.close();
    }
}
