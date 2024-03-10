import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대공약수와 최소공배수
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 최대공약수
        int max = 0;

        int a = Math.max(n, m);

        for (int i = 1; i <= a; i++) {
            if (n % i == 0 && m % i == 0) {
                max = i;
            }
        }

        // 최대공약수
        sb.append(max).append("\n");
        // 최소공배수 = n * m / 최대공약수
        sb.append(n * m / max);

        System.out.println(sb);

        br.close();
    }

}
