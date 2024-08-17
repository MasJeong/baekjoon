import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 집합 - 비트마스크
 * 향상된 switch는 jdk14부터 적용됨
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 공집합
        int set = 0;
        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();

            int x = 0;
            if(!oper.equals("empty") && !oper.equals("all")) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (oper) {
                case "add":
                    // x가 3인 경우, 0b1000 (2^3)
                    set |= 1 << x;
                    break;
                case "remove":
                    // x가 3인 경우, 0b0000 &= 0b0111 => 0b0000
                    set &= ~(1 << x);
                    break;
                case "check":
                    sb.append((set & 1 << x) != 0 ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    set ^= (1 << x);
                    break;
                case "all":
                    set = (1 << 21) - 1;
                    break;
                case "empty":
                    set = 0;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + oper);
            }
        }

        System.out.println(sb);
        br.close();
    }

}