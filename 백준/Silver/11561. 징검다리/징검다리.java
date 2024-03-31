import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 징검다리 - 수학 및 이분탐색
 * 등차수열의 합 (N * (N+1)) / 2
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        // 입력
        while(t-- > 0) {
            long n = Long.parseLong(br.readLine());
            long left = 0;
            long right = Integer.MAX_VALUE;
            long result = 0;

            while (left <= right) {
                long mid = (left + right) >>> 1;
                long sum = (mid * (mid + 1)) / 2;

                if (sum <= n) {
                    result = Math.max(mid, result);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

}
