import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 전구 - DP
 */
public class Main {

    static final int MAX_NUM = (1 << 31) -1;
    static int[] lamp;
    static int[][] dp;

    /**
     * 2개 이상의 전구들 간의 최솟값 계산
     */
    static void getMinValue() {
        // 전구 분할 개수
        for (int size = 2; size < dp.length; size++) {
            // 분할되어 나누어진 전구 묶음 개수
            for (int start = 1; start <= dp.length - size; start++) {
                int end = start + size - 1;

                // 현재 전구 묶음의 하위 묶음에 대한 최솟값 찾기
                for (int mid = start; mid < end; mid++) {
                    /*
                    하위 묶음 값 계산
                    - 전구 배열의 묶음 사의 값이 다르면 + 1
                     */
                    int newValue = dp[start][mid] + dp[mid + 1][end] + (lamp[start] != lamp[mid + 1] ? 1 : 0);

                    dp[start][end] = Math.min(newValue, dp[start][end]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int cntInput = n + 1;

        lamp = new int[cntInput];
        int cntNum = 1;

        /*
        1. 전구 색상 입력
        2. 색상 변경 시 인접한 숫자는 한 번에 변경되므로 동일한 숫자는 추가 X
         */
        for(int i = 1; i < cntInput; i++){
            int num = Integer.parseInt(st.nextToken());

            if (lamp[i - 1] == num) {
                cntInput--;
                i--;
                continue;
            }

            cntNum++;
            lamp[i] = num;
        }

        // 3. 인접하지 않은 숫자를 기준으로 숫자 개수만큼 dp 크기 설정
        dp = new int[cntNum][cntNum];

        /*
        4. DP 배열 최댓값으로 초기화
        4-1. 1,1|2,2|3,3|4,4|5,5 0으로 남김
         */
        for (int i = 1; i < dp.length; i++) {
            for (int ii = 1; ii < dp[i].length; ii++) {
                dp[i][ii] = MAX_NUM;
            }
            dp[i][i] = 0;
        }

        getMinValue();

        System.out.println(dp[1][dp[1].length - 1]);
        br.close();
    }


}