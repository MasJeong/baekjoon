import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 마인크래프트- 브루트 포스
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int MAX_INVEN_SIZE = 64000000;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arrCraft = new int[n * m];

        // 가장 큰 값부터 작은 값까지 반복문을 돌려주기 위한 변수
        int max = -1;
        int min = 257;

        // 입력
        int idx = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                arrCraft[idx++] = input;

                max = Math.max(input, max);
                min = Math.min(input, min);
            }
        }

        /*
        인벤토리가 비어있는 경우에도 가장 높은 땅의 높이부터 땅을 파서
        인벤토리에 넣을 수 있으니 내림차순으로 정렬해서 진행한다.
        2차원 배열로 진행해서 내림차순 정렬하여 진행했지만 완전한 정렬이 되지 않았음
        그냥 1차원 배열로 진행
         */
        // 내림차순 정렬하니까 시간초과가 발생하는데 이해가 잘안된다....
//        Arrays.sort(arrCraft, Collections.reverseOrder());

        int maxHeight = -1;
        int minTime = 64000001 * 2;

        // 땅을 평평하게 만드는 시간이 동일하면 높이가 가장 큰 값을 출력하므로 max 높이부터 반복문 진행
        for (int i = max; i >= min; i--) {
            boolean isFail = false;
            int time = 0;
            int invenCnt = b;

            for(int j = 0; j < n * m; j++) {
                // 땅 블록을 회수해야 하는 경우 (2초)
                if (i < arrCraft[j]) {
                    int addition = arrCraft[j] - i;

                    // 인벤토리 크기보다 회수한 블록의 개수가 많은 경우
                    if (MAX_INVEN_SIZE < invenCnt) {
                        isFail = true;
                        break;
                    }

                    time += addition * 2;
                    invenCnt += addition;
                }
            }

            for(int j = 0; j < n * m; j++) {
                // 인벤토리에서 블록을 꺼내어 땅을 채워야 하는 경우 (1초)
                if (i > arrCraft[j]) {
                    int subtraction = i - arrCraft[j];

                    // 인벤토리 블록 개수가 부족한 경우
                    if (invenCnt < subtraction) {
                        isFail = true;
                        break;
                    }

                    time += subtraction;
                    invenCnt -= subtraction;
                }
            }

            // 시간이 제일 적게 걸리는 경우 시간과 높이를 세팅
            if (!isFail && minTime > time) {
                minTime = time;
                maxHeight = i;
            }
        }

        System.out.println(minTime + " " + maxHeight);
        br.close();
    }
}
