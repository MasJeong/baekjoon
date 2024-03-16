import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이항 계수1 - 수학(조합론)
 * Binomial Coefficient
 */
public class Main {

    private static Integer[][] dp;

    private static int binomial(int n, int k) {
        if (n == k || k == 0) {
            return dp[n][k] = 1;
        }

        if (dp[n][k] == null) {
            dp[n][k] = binomial(n - 1, k - 1) + binomial(n - 1, k);
        }

        return dp[n][k];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new Integer[n + 1][k + 1];

        System.out.println(binomial(n, k));
        br.close();
    }

}
