import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1로 만들기 - dp
 *
 */
public class Main {

    // 메모이제이션 용도
    private static Integer[] dp;

    private static int recur(int n) {
        if (dp[n] == null) {

            /*
            2와 3으로 모두 나누어 질 수 있는 경우(n % 6 == 0) 생각해야 함.
            1을 더하는 이유는 하위 문제에 대해 1회 더 추가되었다는 의미.
             */
            if (n % 6 == 0) {
//                dp[n] = Math.min(recur(n - 1), Math.min(recur(n / 3), recur(n / 2))) + 1;
                dp[n] = Math.min(Math.min(recur(n / 3), recur(n / 2)), recur(n - 1)) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
            } else {
                dp[n] = recur(n - 1) + 1;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n + 1];

        // n은 1보다 크다.
        dp[0] = dp[1] = 0;

        System.out.println(recur(n));
        br.close();
    }
}
