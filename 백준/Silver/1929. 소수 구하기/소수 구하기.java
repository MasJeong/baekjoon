import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소수구하기 - 수학
 * 소수구하는 방법1
 * 루트N 이하의 자연수 중에 나누어 떨어지는 수가 있다면 이는 1 과 N 을 제외한
 * 다른 자연수가 N 의 약수라는 의미이므로 소수가 아니게 되는 것이다.
 * 소수구하는 방법2
 * 에라토스테네스의 체 - k=2 부터 √N 이하까지 반복하여 자연수들 중 k를 제외한 k의 배수들을 제외시킨다
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // true: 소수아님, false: 소수
        boolean[] prime = new boolean[n + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i]) continue;

            for (int j = i * 2; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        for (int i = m; i <= n; i++) {
            if (!prime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }

}
