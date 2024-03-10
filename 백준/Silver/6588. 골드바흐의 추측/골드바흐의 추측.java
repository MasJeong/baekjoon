import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 골드바흐의 추측 - 수학
 */
public class Main {

    static final int MAX_LENGTH = 1000001;
    static boolean[] prime = new boolean[MAX_LENGTH];
    static int[] answer = new int[MAX_LENGTH];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // false: 소수
        prime[0] = prime[1] = true;

        // 에라토스테네스의 체 적용
        for (int i = 2; i <= Math.sqrt(MAX_LENGTH); i++) {
            if (prime[i]) continue;

            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        // 소수이고 홀수만 들어있는 배열 세팅
        for (int i = 3; i < MAX_LENGTH; i++) {
            if (!prime[i] && i % 2 == 1) {
                answer[i] = i;
            }
        }

        while (n != 0) {
            boolean isPass = false;
            int a = 2;
            int start = 2;

            // a 구하기
            for (int i = start; i <= n; i++) {
                if(answer[i] != 0) {
                    a = answer[i];

                    // n - a가 홀수이고 n - a가 소수인 경우
                    if ((n - a) % 2 == 1 && answer[n-a] != 0) {
                        isPass = true;
                        break;
                    }
                }
            }

            if (!isPass) {
                System.out.println("Goldbach's conjecture is wrong.");
                continue;
            }

            sb.append(n).append(" = ").append(a).append(" + ").append(n - a).append("\n");

            n = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
        br.close();
    }

}
