import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int recurCount = 0;

    private static int dpCount = 0;

    private static Integer[] dp;

    private static int fibo(int n) {
        if (n == 1 || n == 2) {
            recurCount++;
            return 1;
        }

        return fibo(n - 1) + fibo(n - 2);
    }

    private static void fiboDp(int n) {
        dp = new Integer[n + 1];
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dpCount++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        fibo(N);
        fiboDp(N);

        sb.append(recurCount).append(" ").append(dpCount);
        System.out.println(sb);
    }

}
