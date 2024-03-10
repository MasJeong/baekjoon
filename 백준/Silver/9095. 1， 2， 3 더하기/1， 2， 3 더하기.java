import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1, 2, 3 더하기 - dp
 */
public class Main {

    private static final Integer[] dp = new Integer[11];

    private static int recur(int num) {
        if (dp[num] == null) {
            dp[num] = recur(num - 1) + recur(num - 2) + recur(num - 3);
        }

        return dp[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (num < 4) {
                sb.append(dp[num]).append("\n");
                continue;
            }

            sb.append(recur(num)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
