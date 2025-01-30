import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * DFS와 BFS
 */
public class Main {

    static boolean[] visited;
    static int[][] arr;
    static int cntNode, cntLine, startNodeNum;
    static final Queue<Integer> queue = new LinkedList<>();
    static final StringBuilder sb = new StringBuilder();

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for(int i = 1; i <= cntNode; i++) {
            if(arr[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start + " ");

            for(int i = 1; i <= cntNode; i++) {
                if(arr[start][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cntNode = Integer.parseInt(st.nextToken());
        cntLine = Integer.parseInt(st.nextToken());
        startNodeNum= Integer.parseInt(st.nextToken());

        arr = new int[cntNode + 1][cntNode + 1];
        visited = new boolean[cntNode + 1];

        for(int i = 0; i < cntLine; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(startNodeNum);
        sb.append("\n");
        visited = new boolean[cntNode + 1];
        bfs(startNodeNum);

        System.out.println(sb);
        br.close();
    }
}
