import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 비밀번호 찾기
 */
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<String, String> mapSite = new HashMap<>();

        // 저장된 사이트 주소의 수
        int n = Integer.parseInt(st.nextToken());
        // 찾으려는 사이트 주소의 수
        int m = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            mapSite.put(st.nextToken(), st.nextToken());
        }

        while (m-- > 1) {
            sb.append(mapSite.get(br.readLine())).append("\n");
        }

        sb.append(mapSite.get(br.readLine()));

        System.out.println(sb);
        br.close();
    }
}
