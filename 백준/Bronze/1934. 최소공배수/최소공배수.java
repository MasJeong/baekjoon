import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최소공배수
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int max = Math.max(a, b);
            int temp = 0;

            for (int i = 1; i <= max; i++) {
                if (a % i == 0 && b % i == 0) {
                    temp = i;
                }
            }

            sb.append(a * b / temp).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

}
