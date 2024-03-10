import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소수 찾기 - 수학
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int primeCnt = 0;
        while(st.hasMoreTokens()) {
            int prime = Integer.parseInt(st.nextToken());

            if(prime < 2) continue;

            // 2부터 자신의 수까지 나머지가 0이 되는 수가 없다면 소수
            int cnt = 0;
            for(int i = 2; i < prime; i++) {
                if(prime % i == 0) {
                    cnt++;
                    break;
                }
            }

            if(cnt == 0) {
                primeCnt++;
            }
        }

        System.out.println(primeCnt);

        br.close();
    }

}
